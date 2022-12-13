package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.AdjustmentOrderConstants;
import com.example.labdemo.domain.AdjustmentOrder;
import com.example.labdemo.domain.AdjustmentOrderItem;
import com.example.labdemo.domain.StoreItem;
import com.example.labdemo.dto.AdjustmentUpdateDto;
import com.example.labdemo.dto.AdjustmentUpdateItemDto;
import com.example.labdemo.mapper.AdjustmentOrderDao;
import com.example.labdemo.mapper.AdjustmentOrderItemDao;
import com.example.labdemo.mapper.StoreItemDao;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.security.LoginUser;
import com.example.labdemo.service.AdjustmentOrderService;
import com.example.labdemo.vo.adjustment.AdjustmentDetailVo;
import com.example.labdemo.vo.adjustment.AdjustmentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 16:04
 */
@Service
public class AdjustmentOrderServiceImpl implements AdjustmentOrderService {
    @Autowired
    private AdjustmentOrderDao adjustmentOrderDao;
    @Autowired
    private AdjustmentOrderItemDao adjustmentOrderItemDao;
    @Autowired
    private StoreItemDao storeItemDao;
    @Override
    public AdjustmentOrder selectById(Long id){
        return adjustmentOrderDao.selectById(id);
    }

    @Override
    public List<AdjustmentVo> getAllVo(){
        return adjustmentOrderDao.getAllVo();
    }

    @Override
    public AdjustmentVo add(Long srcId, Long destId) {
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long createBy = loginUser.getUser().getId();
        AdjustmentOrder adjustmentOrder = new AdjustmentOrder(srcId,destId,createBy);
        adjustmentOrderDao.insert(adjustmentOrder);
        return adjustmentOrderDao.getVoById(adjustmentOrder.getId());
    }
    @Override
    public AdjustmentDetailVo getDetail(Long id){
        AdjustmentDetailVo detailVo = adjustmentOrderDao.getDetailVo(id);
        detailVo.setItems(adjustmentOrderDao.getItemsById(id));
        return detailVo;
    }

    @Override
    public void update(AdjustmentUpdateDto adjustmentUpdateDto) {
        String stage = adjustmentUpdateDto.getStage();
        Long id = adjustmentUpdateDto.getId();
        if(!AdjustmentOrderConstants.STAGE_TO_BE_AUDITED.equals(stage)&&!AdjustmentOrderConstants.STAGE_TO_BE_EDITED.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        QueryWrapper<AdjustmentOrderItem> deleteWrapper = new QueryWrapper<>();
        deleteWrapper.eq("order_id",adjustmentUpdateDto.getId());
        adjustmentOrderItemDao.delete(deleteWrapper);
        for (AdjustmentUpdateItemDto item:
                adjustmentUpdateDto.getItems()) {
            AdjustmentOrderItem temp = item.toAdjustmentUpdateItem();
            temp.setOrderId(id);
            adjustmentOrderItemDao.insert(temp);
        }
        AdjustmentOrder old = adjustmentOrderDao.selectById(id);
        old.setStage(AdjustmentOrderConstants.STAGE_TO_BE_AUDITED);
        adjustmentOrderDao.updateById(old);
    }

    @Override
    public void audit(Long id, String stage) {
        if(!AdjustmentOrderConstants.STAGE_HAVE_AUDITED.equals(stage)){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        AdjustmentOrder order = adjustmentOrderDao.selectById(id);
        if(!AdjustmentOrderConstants.STAGE_TO_BE_AUDITED.equals(order.getStage())&&!AdjustmentOrderConstants.STAGE_TO_BE_EDITED.equals(order.getStage())){
            throw new BaseException(BaseExceptionEnum.STAGE_ERROR);
        }
        Long targetId = order.getDestStoreId();
        Long srcId = order.getSrcStoreId();
        QueryWrapper<AdjustmentOrderItem> selectWrapper = new QueryWrapper<>();
        selectWrapper.eq("order_id",id);
        List<AdjustmentOrderItem> items = adjustmentOrderItemDao.selectList(selectWrapper);
        for (AdjustmentOrderItem item:
             items) {
            Long productId = item.getProductId();
            QueryWrapper<StoreItem> srcStoreItemQueryWrapper = new QueryWrapper<>();
            srcStoreItemQueryWrapper.eq("store_id",srcId);
            srcStoreItemQueryWrapper.eq("product_id",productId);
            StoreItem srcStoreItem = storeItemDao.selectOne(srcStoreItemQueryWrapper);
            if(srcStoreItem.getProductId()< item.getQuantity()){
                throw new BaseException(BaseExceptionEnum.PRODUCT_IS_NOT_ENOUGH);
            }
            srcStoreItem.setQuantity(srcStoreItem.getProductId()- item.getQuantity());
            storeItemDao.updateById(srcStoreItem);
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
        order.setStage(AdjustmentOrderConstants.STAGE_HAVE_AUDITED);
        adjustmentOrderDao.updateById(order);
    }
}
