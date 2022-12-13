package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.SaleNoteConstants;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.domain.SaleNoteItem;
import com.example.labdemo.mapper.ClientDao;
import com.example.labdemo.mapper.SaleNoteDao;
import com.example.labdemo.mapper.SaleNoteItemDao;
import com.example.labdemo.mapper.UserDao;
import com.example.labdemo.service.StatisticsService;
import com.example.labdemo.vo.statics.ClientStaticsVo;
import com.example.labdemo.vo.statics.SalesmanStatisticVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    @Override
    public List<SalesmanStatisticVo> selectSalesmanStaticsVo(){
        List<SalesmanStatisticVo> list = userDao.selectStaticsVo();
        for (SalesmanStatisticVo vo:
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
    public List<ClientStaticsVo> selectClientStaticsVo(){
        List<ClientStaticsVo> list = clientDao.selectStaticsVo();
        for (ClientStaticsVo vo:
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
}
