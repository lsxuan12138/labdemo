package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.Product;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.domain.SaleNoteItem;
import com.example.labdemo.dto.SaleNoteDetailDto;
import com.example.labdemo.dto.SaleNoteItemDto;
import com.example.labdemo.mapper.ClientDao;
import com.example.labdemo.mapper.ProductDao;
import com.example.labdemo.mapper.SaleNoteDao;
import com.example.labdemo.mapper.SaleNoteItemDao;
import com.example.labdemo.service.SaleNoteService;
import com.example.labdemo.vo.SaleNoteDetailVo;
import com.example.labdemo.vo.SaleNoteItemVo;
import com.example.labdemo.vo.SaleNoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service("saleNoteService")
public class SaleNoteServiceImpl implements SaleNoteService {
    @Autowired
    private SaleNoteDao saleNoteDao;
    @Autowired
    private SaleNoteItemDao saleNoteItemDao;
    @Autowired
    private ClientDao clientDao;
    @Autowired
    private ProductDao productDao;

    @Override
    public List<SaleNote> getAll() {
        List<SaleNote> saleNotes = null;
        saleNotes= saleNoteDao.selectList(null);
        return saleNotes;
    }

    @Override
    public List<SaleNoteVo> getAllVo() {
        List<SaleNoteVo> saleNotes = null;
        saleNotes= saleNoteDao.selectAllSaleNoteVo();
        return saleNotes;
    }

    @Override
    public List<SaleNoteVo> find(String keyword) {
        return saleNoteDao.find(keyword);
    }

    @Override
    public SaleNoteVo add(Long clientId) {
        SaleNote saleNoteTemp = new SaleNote();
//        saleNoteTemp.setTotalPrice(new BigDecimal(0.0));
//        saleNoteTemp.setClientId(clientId);
//        saleNoteTemp.setCreateBy("default");
        Date createTime = new Date();
        saleNoteTemp.setCreateTime(createTime);
        saleNoteTemp.setStage("未编辑");
        saleNoteDao.insert(saleNoteTemp);
        SaleNoteVo vo = new SaleNoteVo();
        vo.setId(saleNoteTemp.getId());
        vo.setStage(saleNoteTemp.getStage());
        vo.setClientName(clientDao.selectById(clientId).getName());
        return vo;
    }

    @Override
    public SaleNoteDetailVo getDetail(Long id) {
        SaleNoteDetailVo detailVo = new SaleNoteDetailVo();

        SaleNoteVo saleNoteVo = saleNoteDao.selectVoById(id);
        List<SaleNoteItemVo> saleNoteItemVos = saleNoteItemDao.getItems(id);

        detailVo.setId(id);
        detailVo.setClientName(saleNoteVo.getClientName());
        detailVo.setStage(saleNoteVo.getStage());
        detailVo.setItems(saleNoteItemVos);

        return detailVo;
    }

    @Override
    public void update(SaleNoteDetailDto saleNoteDetailDto) {
        Long id = saleNoteDetailDto.getId();
        SaleNote saleNote = saleNoteDao.selectById(id);
        BigDecimal total = new BigDecimal(0);
        QueryWrapper<SaleNoteItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sale_note_id",id);
        saleNoteItemDao.delete(queryWrapper);
        for (SaleNoteItemDto item:
                saleNoteDetailDto.getItems()) {
            SaleNoteItem saleNoteItem = new SaleNoteItem();
            saleNoteItem.setSaleNoteId(id);
            saleNoteItem.setQuantity(item.getQuantity());
            saleNoteItem.setProductId(item.getId());
            //total.add(productDao.selectById(item.getId()).getSellPrice().multiply(new BigDecimal(item.getQuantity())));
            saleNoteItemDao.insert(saleNoteItem);
        }
        //saleNote.setTotalPrice(total);
        saleNote.setStage("待审核");
        saleNoteDao.updateById(saleNote);
    }

    @Override
    public void audio(Long id, String stage) throws BaseException {
        SaleNote saleNote = saleNoteDao.selectById(id);
        if(stageCompare(saleNote.getStage(),stage)){
            saleNote.setStage("待付款");

        }else {
            throw new BaseException(ResultEnum.SALE_NOTE_STAGE_ERROR);
        }
        saleNoteDao.updateById(saleNote);
        List<SaleNoteItemVo> saleNoteItemVos = saleNoteItemDao.getItems(id);
        for (SaleNoteItemVo vo:
             saleNoteItemVos) {
            Product product = productDao.selectById(vo.getId());
            //Long currentQuantity = product.getQuantity();
//            if(currentQuantity<vo.getQuantity()){
//                throw new BaseException(ResultEnum.PRODUCT_IS_NOT_ENOUGH);
//            }else {
//                product.setQuantity(currentQuantity-vo.getQuantity());
//            }
            productDao.updateById(product);
        }

    }

    @Override
    public void collectMoney(Long id, String stage) throws BaseException {
        SaleNote saleNote = saleNoteDao.selectById(id);
        if(stageCompare(saleNote.getStage(),stage)){
            saleNote.setStage("已付款");
        }else {
            throw new BaseException(ResultEnum.SALE_NOTE_STAGE_ERROR);
        }
        saleNoteDao.updateById(saleNote);
    }

    @Override
    public void returnGoods(Long id, String stage) throws BaseException {
        SaleNote saleNote = saleNoteDao.selectById(id);
        if(stageCompare(saleNote.getStage(),stage)){
            saleNote.setStage("已退款");
        }else {
            throw new BaseException(ResultEnum.SALE_NOTE_STAGE_ERROR);
        }
        saleNoteDao.updateById(saleNote);
        List<SaleNoteItemVo> saleNoteItemVos = saleNoteItemDao.getItems(id);
        for (SaleNoteItemVo vo:
                saleNoteItemVos) {
            Product product = productDao.selectById(vo.getId());
//            Long currentQuantity = product.getQuantity();
//            product.setQuantity(currentQuantity+vo.getQuantity());
            productDao.updateById(product);
        }
    }

    private static final Map<String,Integer> STAGE_MAP;
    static {
        STAGE_MAP = new HashMap<>();
        STAGE_MAP.put("未编辑",1);
        STAGE_MAP.put("待审核",2);
        STAGE_MAP.put("待付款",3);
        STAGE_MAP.put("已付款",4);
        STAGE_MAP.put("已退款",5);
    }
    private static boolean stageCompare(String currStage,String targetStage){
        return STAGE_MAP.get(currStage)<STAGE_MAP.get(targetStage);
    }
}
