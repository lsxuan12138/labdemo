package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.SaleNoteConstants;
import com.example.labdemo.domain.Client;
import com.example.labdemo.domain.Product;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.domain.SaleNoteItem;
import com.example.labdemo.mapper.*;
import com.example.labdemo.service.StatisticsService;
import com.example.labdemo.vo.statistic.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-13 20:26
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    ClientDao clientDao;
    @Autowired
    UserDao userDao;
    @Autowired
    SaleNoteDao saleNoteDao;
    @Autowired
    SaleNoteItemDao saleNoteItemDao;
    @Autowired
    ProductDao productDao;
    @Override
    public List<SalesmanStatisticsVo> selectSalesmanStaticsVo(){
        List<SalesmanStatisticsVo> list = userDao.selectStaticsVo();
        for (SalesmanStatisticsVo vo:
             list) {
            Long userId = vo.getId();
            QueryWrapper<SaleNote> saleNoteQueryWrapper = new QueryWrapper<>();
            saleNoteQueryWrapper.eq("create_by",userId);
            saleNoteQueryWrapper.eq("stage", SaleNoteConstants.STAGE_TO_BE_PAID).or().eq("stage",SaleNoteConstants.STAGE_HAVE_PAID);
            List<SaleNote> saleNotes = saleNoteDao.selectList(saleNoteQueryWrapper);

            BigDecimal saleAmount = new BigDecimal(0);
            for (SaleNote saleNote:
                 saleNotes) {
                saleAmount = saleAmount.add(saleNote.getReceivedPayment());
            }
            vo.setSaleAmount(saleAmount);
            vo.setSaleQuantity((long) saleNotes.size());
            vo.setClientQuantity(saleNoteDao.countClientByUserId(userId));
            BigDecimal performance = new BigDecimal(0);
            performance = performance.add(vo.getSaleAmount().multiply(new BigDecimal("0.7")));
            performance = performance.add(new BigDecimal(vo.getSaleQuantity()).multiply(new BigDecimal("0.2")));
            performance = performance.add(new BigDecimal(vo.getClientQuantity()).multiply(new BigDecimal("0.1")));
            vo.setPerformance(performance);
        }
        return list;
    }
    @Override
    public List<ClientStatisticsVo> selectClientStaticsVo(){
        List<ClientStatisticsVo> list = clientDao.selectStaticsVo();
        for (ClientStatisticsVo vo:
             list) {
            Long clientId = vo.getId();
            QueryWrapper<SaleNote> saleNoteQueryWrapper = new QueryWrapper<>();
            saleNoteQueryWrapper.eq("client_id",clientId);
            saleNoteQueryWrapper.eq("stage", SaleNoteConstants.STAGE_TO_BE_PAID).or().eq("stage",SaleNoteConstants.STAGE_HAVE_PAID);
            List<SaleNote> saleNotes = saleNoteDao.selectList(saleNoteQueryWrapper);

            vo.setSaleQuantity((long) saleNotes.size());
            Long productQuantity = 0L;
            BigDecimal saleAmount = new BigDecimal(0);
            for (SaleNote saleNote:
                    saleNotes) {
                saleAmount = saleAmount.add(saleNote.getReceivedPayment());

                QueryWrapper<SaleNoteItem> itemQueryWrapper = new QueryWrapper<>();
                itemQueryWrapper.eq("sale_note_id",saleNote.getId());
                List<SaleNoteItem> items= saleNoteItemDao.selectList(itemQueryWrapper);
                for (SaleNoteItem item:
                     items) {
                    productQuantity+=item.getQuantity();
                }
            }
            vo.setAmount(saleAmount);
            vo.setProductQuantity(productQuantity);
        }
        return list;
    }
    @Override
    public List<ProductStatisticsVo> selectProductStatisticsVo(){
        List<ProductStatisticsVo> list = new ArrayList<>();
        List<Product> products = productDao.selectList(null);
        for (Product product:
             products) {
            ProductStatisticsVo vo = new ProductStatisticsVo();
            vo.setProperties(product);
            vo.setBuyQuantity(productDao.countBuyQuantity(product.getId()));
            vo.setSaleQuantity(productDao.countSaleQuantity(product.getId()));
            vo.setClientQuantity(productDao.countClientQuantity(product.getId()));

            BigDecimal amount = new BigDecimal(0);
            List<ProductWithPriceAndQuantityVo> productWithPriceAndQuantityVos = productDao.selectProductWithPriceAndQuantityVo(product.getId());
            for (ProductWithPriceAndQuantityVo p:
                    productWithPriceAndQuantityVos) {
                amount = amount.add(p.getPrice().multiply(new BigDecimal(p.getQuantity())));
            }
            vo.setAmount(amount);
        }
        return list;
    }
    @Override
    public List<ClientPaymentStatisticsVo> selectClientPaymentStatisticsVos(){
        List<Client> clients = clientDao.selectList(null);
        List<ClientPaymentStatisticsVo> list = new ArrayList<>();
        for (Client client:
             clients) {
            ClientPaymentStatisticsVo vo = new ClientPaymentStatisticsVo();
            vo.setProperties(client);

            QueryWrapper<SaleNote> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("client_id",client.getId());
            queryWrapper.eq("stage", SaleNoteConstants.STAGE_TO_BE_PAID).or().eq("stage",SaleNoteConstants.STAGE_HAVE_PAID);
            List<SaleNote> saleNotes = saleNoteDao.selectList(queryWrapper);
            BigDecimal receivedPayment = new BigDecimal(0);
            BigDecimal price = new BigDecimal(0);
            for (SaleNote note:
                 saleNotes) {
                price = price.add(note.getPrice());
                receivedPayment = receivedPayment.add(note.getReceivedPayment());
            }
            vo.setReceivedPayment(receivedPayment);
            vo.setUnreceivedPayment(price.subtract(receivedPayment));
        }
        return list;
    }
    @Override
    public List<BigDecimal[]> selectBusinessStatisticsVo(){
        return null;
    }
}
