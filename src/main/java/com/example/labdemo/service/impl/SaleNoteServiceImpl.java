package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.ClientConstants;
import com.example.labdemo.constants.SaleNoteConstants;
import com.example.labdemo.domain.*;
import com.example.labdemo.dto.SaleNoteDetailDto;
import com.example.labdemo.dto.SaleNoteItemDto;
import com.example.labdemo.mapper.*;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.security.LoginUser;
import com.example.labdemo.service.SaleNoteService;
import com.example.labdemo.vo.salenote.SaleNoteDetailVo;
import com.example.labdemo.vo.salenote.SaleNoteItemVo;
import com.example.labdemo.vo.salenote.SaleNoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

import static com.example.labdemo.constants.SaleNoteConstants.stageCompare;

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
    @Autowired
    private StoreItemDao storeItemDao;

    @Override
    public SaleNote selectById(Long id) {
        return saleNoteDao.selectById(id);
    }

    //    @Override
//    public List<SaleNote> getAll() {
//        List<SaleNote> saleNotes = null;
//        saleNotes= saleNoteDao.selectList(null);
//        return saleNotes;
//    }
//
    @Override
    public List<SaleNoteVo> getAllVo() {
        return saleNoteDao.selectAllSaleNoteVo();
    }
//
//    @Override
//    public List<SaleNoteVo> find(String keyword) {
//        return saleNoteDao.find(keyword);
//    }
//
    @Override
    public SaleNoteVo add(Long clientId,Long storeHouseId) {
        LoginUser loginUser = (LoginUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long createBy = loginUser.getUser().getId();
        SaleNote saleNoteTemp = new SaleNote(clientId,storeHouseId,createBy);
        saleNoteDao.insert(saleNoteTemp);
        return saleNoteDao.selectVoById(saleNoteTemp.getId());
    }

    @Override
    public SaleNoteDetailVo getDetail(Long id) {
        SaleNoteDetailVo detailVo = new SaleNoteDetailVo();

        SaleNoteVo saleNoteVo = saleNoteDao.selectVoById(id);
        SaleNote saleNote = saleNoteDao.selectById(id);
        Client client = clientDao.selectById(saleNote.getClientId());
        List<SaleNoteItemVo> saleNoteItemVos = saleNoteItemDao.getItems(id, client==null? ClientConstants.TYPE_RETAILS:client.getType());

        detailVo.setId(id);
        detailVo.setClientName(saleNoteVo.getClientName());
        detailVo.setClientType(client==null? ClientConstants.TYPE_RETAILS:client.getType());
        detailVo.setStage(saleNoteVo.getStage());
        detailVo.setCost(saleNote.getCost());
        detailVo.setPrice(saleNote.getPrice());
        detailVo.setProfit(saleNote.getPrice().subtract(saleNote.getCost()));
        detailVo.setReceivedPayment(saleNote.getReceivedPayment());
        detailVo.setItems(saleNoteItemVos);

        return detailVo;
    }

    @Override
    public void update(SaleNoteDetailDto saleNoteDetailDto) {
        String stage = saleNoteDetailDto.getStage();
        Long id = saleNoteDetailDto.getId();
        if(!SaleNoteConstants.STAGE_TO_BE_AUDITED.equals(stage)&&!SaleNoteConstants.STAGE_TO_BE_EDITED.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        SaleNote saleNote = saleNoteDao.selectById(id);
        QueryWrapper<SaleNoteItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("sale_note_id",id);
        saleNoteItemDao.delete(queryWrapper);
        for (SaleNoteItemDto item:
                saleNoteDetailDto.getItems()) {
            SaleNoteItem saleNoteItem = item.toSaleNoteItem();
            saleNoteItem.setSaleNoteId(id);
            saleNoteItemDao.insert(saleNoteItem);
        }
        saleNote.setStage(SaleNoteConstants.STAGE_TO_BE_AUDITED);
        saleNoteDao.updateById(saleNote);
    }

    @Override
    public void audio(Long id, String stage) {
        SaleNote saleNote = saleNoteDao.selectById(id);
        Long storeId = saleNote.getStoreId();
        if(!SaleNoteConstants.STAGE_TO_BE_PAID.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        if(stageCompare(saleNote.getStage(),SaleNoteConstants.STAGE_TO_BE_PAID)){
            saleNote.setStage(SaleNoteConstants.STAGE_TO_BE_PAID);
        }else {
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        Client client = clientDao.selectById(saleNote.getClientId());
        BigDecimal cost = new BigDecimal(0);
        BigDecimal price = new BigDecimal(0);
        List<SaleNoteItemVo> saleNoteItemVos = saleNoteItemDao.getItems(id,client==null? ClientConstants.TYPE_RETAILS:client.getType());
        for (SaleNoteItemVo vo:
             saleNoteItemVos) {
            QueryWrapper<StoreItem> itemQueryWrapper = new QueryWrapper<>();
            itemQueryWrapper.eq("store_id",storeId);
            itemQueryWrapper.eq("product_id",vo.getId());
            StoreItem storeItem = storeItemDao.selectOne(itemQueryWrapper);
            if(storeItem==null||storeItem.getQuantity()<vo.getQuantity()){
                throw new BaseException(BaseExceptionEnum.PRODUCT_IS_NOT_ENOUGH);
            }
            storeItem.setQuantity(storeItem.getQuantity()- vo.getQuantity());
            storeItemDao.updateById(storeItem);
            cost=cost.add(vo.getCost().multiply(new BigDecimal(vo.getQuantity())));
            price=price.add(vo.getPrice().multiply(new BigDecimal(vo.getQuantity())));
        }
        saleNote.setCost(cost);
        saleNote.setPrice(price);
        saleNote.setReceivedPayment(new BigDecimal(0));
        saleNoteDao.updateById(saleNote);
    }

    @Override
    public void collectMoney(Long id, String stage) throws BaseException {
        if(!SaleNoteConstants.STAGE_HAVE_PAID.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        SaleNote saleNote = saleNoteDao.selectById(id);
        if(stageCompare(saleNote.getStage(),SaleNoteConstants.STAGE_HAVE_PAID)){
            saleNote.setStage(SaleNoteConstants.STAGE_HAVE_PAID);
        }else {
            throw new BaseException(BaseExceptionEnum.SALE_NOTE_STAGE_ERROR);
        }
        saleNote.setReceivedPayment(saleNote.getPrice());
        saleNoteDao.updateById(saleNote);
    }

    @Override
    public void returnGoods(Long id, String stage) throws BaseException {
        if(!SaleNoteConstants.STAGE_HAVE_REFUNDED.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        SaleNote saleNote = saleNoteDao.selectById(id);
        Long storeId = saleNote.getStoreId();
        if(stageCompare(saleNote.getStage(),SaleNoteConstants.STAGE_HAVE_REFUNDED)&&stageCompare(SaleNoteConstants.STAGE_TO_BE_PAID, saleNote.getStage())){
            saleNote.setStage(SaleNoteConstants.STAGE_HAVE_REFUNDED);
        }else {
            throw new BaseException(BaseExceptionEnum.SALE_NOTE_STAGE_ERROR);
        }
        Client client = clientDao.selectById(saleNote.getClientId());
        List<SaleNoteItemVo> saleNoteItemVos = saleNoteItemDao.getItems(id, client==null? ClientConstants.TYPE_RETAILS:client.getType());
        for (SaleNoteItemVo vo:
                saleNoteItemVos) {
            QueryWrapper<StoreItem> itemQueryWrapper = new QueryWrapper<>();
            itemQueryWrapper.eq("store_id",storeId);
            itemQueryWrapper.eq("product_id",vo.getId());
            StoreItem storeItem = storeItemDao.selectOne(itemQueryWrapper);
            storeItem.setQuantity(storeItem.getQuantity()+ vo.getQuantity());
            storeItemDao.updateById(storeItem);
        }
        saleNote.setReceivedPayment(new BigDecimal(0));
        saleNoteDao.updateById(saleNote);
    }
}
