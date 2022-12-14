package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.PurchaseOrderConstants;
import com.example.labdemo.domain.*;
import com.example.labdemo.dto.PurchaseUpdateDto;
import com.example.labdemo.dto.PurchaseUpdateItemDto;
import com.example.labdemo.mapper.PurchaseOrderDao;
import com.example.labdemo.mapper.PurchaseOrderItemDao;
import com.example.labdemo.mapper.StoreItemDao;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.security.LoginUser;
import com.example.labdemo.service.PurchaseOrderService;
import com.example.labdemo.vo.purchase.PurchaseDetailVo;
import com.example.labdemo.vo.purchase.PurchaseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 19:11
 */
@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    private PurchaseOrderDao purchaseOrderDao;
    @Autowired
    private PurchaseOrderItemDao purchaseOrderItemDao;
    @Autowired
    private StoreItemDao storeItemDao;

    @Override
    public List<PurchaseVo> getAllVo(){
        return purchaseOrderDao.getAllVo();
    }

    @Override
    public PurchaseVo add(Long storeId){
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long createBy = loginUser.getUser().getId();
        PurchaseOrder order = new PurchaseOrder(storeId,createBy);
        purchaseOrderDao.insert(order);
        return purchaseOrderDao.getVoById(order.getId());
    }
    @Override
    public PurchaseDetailVo getDetail(Long id){
        PurchaseDetailVo vo = purchaseOrderDao.getDetailById(id);
        vo.setItems(purchaseOrderDao.getItemVoById(id));
        return vo;
    }
    @Override
    public void update(PurchaseUpdateDto purchaseUpdateDto) {
        String stage = purchaseUpdateDto.getStage();
        Long id = purchaseUpdateDto.getId();
        if(!PurchaseOrderConstants.STAGE_TO_BE_AUDITED.equals(stage)&&!PurchaseOrderConstants.STAGE_TO_BE_EDITED.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        QueryWrapper<PurchaseOrderItem> deleteWrapper = new QueryWrapper<>();
        deleteWrapper.eq("purchase_order_id",purchaseUpdateDto.getId());
        purchaseOrderItemDao.delete(deleteWrapper);
        for (PurchaseUpdateItemDto item:
                purchaseUpdateDto.getItems()) {
            PurchaseOrderItem temp = item.toPurchaseUpdateItem();
            temp.setPurchaseOrderId(id);
            purchaseOrderItemDao.insert(temp);
        }
        PurchaseOrder old = purchaseOrderDao.selectById(id);
        old.setStage(PurchaseOrderConstants.STAGE_TO_BE_AUDITED);
        purchaseOrderDao.updateById(old);
    }

    @Override
    public void audit(Long id, String stage) {
        if(!PurchaseOrderConstants.STAGE_HAVE_AUDITED.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        PurchaseOrder order = purchaseOrderDao.selectById(id);
        if(!PurchaseOrderConstants.STAGE_TO_BE_AUDITED.equals(order.getStage())&&!PurchaseOrderConstants.STAGE_TO_BE_EDITED.equals(order.getStage())){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        Long targetId = order.getStoreId();
        QueryWrapper<PurchaseOrderItem> selectWrapper = new QueryWrapper<>();
        selectWrapper.eq("purchase_order_id",id);
        List<PurchaseOrderItem> items = purchaseOrderItemDao.selectList(selectWrapper);
        for (PurchaseOrderItem item:
                items) {
            Long productId = item.getProductId();
            QueryWrapper<StoreItem> destStoreItemQueryWrapper = new QueryWrapper<>();
            destStoreItemQueryWrapper.eq("store_id",targetId);
            destStoreItemQueryWrapper.eq("product_id",productId);
            StoreItem destStoreItem = storeItemDao.selectOne(destStoreItemQueryWrapper);
            if(destStoreItem==null){
                destStoreItem = new StoreItem(targetId,productId, item.getQuantity());
                storeItemDao.insert(destStoreItem);
            }else {
                destStoreItem.setQuantity(destStoreItem.getQuantity()+ item.getQuantity());
                storeItemDao.updateById(destStoreItem);
            }
            storeItemDao.updateById(destStoreItem);
        }
        order.setStage(PurchaseOrderConstants.STAGE_HAVE_AUDITED);
        purchaseOrderDao.updateById(order);
    }
}
