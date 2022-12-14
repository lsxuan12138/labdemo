package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.ClientConstants;
import com.example.labdemo.domain.*;
import com.example.labdemo.dto.StoreAddDto;
import com.example.labdemo.mapper.*;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.vo.store.StoreHouseDetailVo;
import com.example.labdemo.vo.store.StoreItemDetailVo;
import com.example.labdemo.vo.store.StoreItemVo;
import com.example.labdemo.vo.store.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 20:22
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreDao storeDao;
    @Autowired
    private StoreItemDao storeItemDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private SaleNoteDao saleNoteDao;
    @Autowired
    private AdjustmentOrderDao adjustmentOrderDao;
    @Autowired
    private PurchaseOrderDao purchaseOrderDao;
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<StoreVo> selectAllVo(){
        return storeDao.selectAllVo();
    }
    @Override
    public StoreVo addStore(StoreAddDto storeAddDto) {
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("name",storeAddDto.getOwner());
//        User user = userDao.selectOne(queryWrapper);
//        if(user==null)throw new BaseException(BaseExceptionEnum.USER_NO_EXIST);
        Store store = storeAddDto.toStore();
        storeDao.insert(store);
        StoreVo vo = new StoreVo(store);
        User user = userDao.selectById(storeAddDto.getOwner());
        if(user==null)throw new BaseException(BaseExceptionEnum.USER_NO_EXIST);
        vo.setOwner(user.getName());
        return vo;
    }
    @Override
    public List<StoreItemVo> getAllStoreItem(){
        return storeItemDao.getAllStoreItem();
    }

    @Override
    public List<StoreItemDetailVo> getAllStoreItemDetail(Long id) {
        SaleNote saleNote = saleNoteDao.selectById(id);
        Client client = clientDao.selectById(saleNote.getClientId());
        return storeItemDao.getAllStoreItemDetail( client==null? ClientConstants.TYPE_RETAILS:client.getType());
    }

    @Override
    public List<StoreItemVo> getStoreItemById(Long id) {
        return storeItemDao.getStoreVoById(id);
    }

    @Override
    public StoreHouseDetailVo selectDetailVo(Long id){
        StoreHouseDetailVo storeHouseDetailVo = storeDao.selectDetailVo(id);
        List<StoreItemVo> items = storeItemDao.getStoreVoById(id);
        storeHouseDetailVo.setItems(items);
        return storeHouseDetailVo;
    }

    @Override
    public void deleteStore(Long id) {
        Store store = storeDao.selectById(id);
        if(store==null)throw new BaseException(BaseExceptionEnum.STORE_NOT_EXIST);

        QueryWrapper<StoreItem> storeItemQueryWrapper = new QueryWrapper<>();
        storeItemQueryWrapper.eq("store_id",id);
        storeItemQueryWrapper.gt("quantity",0);
        List<StoreItem> storeItems = storeItemDao.selectList(storeItemQueryWrapper);

        if(!storeItems.isEmpty()){
            throw new BaseException(BaseExceptionEnum.STORE_NOT_EMPTY);
        }

        QueryWrapper<SaleNote> saleNoteQueryWrapper = new QueryWrapper<>();
        saleNoteQueryWrapper.eq("store_id",id);
        List<SaleNote> saleNotes = saleNoteDao.selectList(saleNoteQueryWrapper);

        QueryWrapper<PurchaseOrder> purchaseOrderQueryWrapper = new QueryWrapper<>();
        purchaseOrderQueryWrapper.eq("store_id",id);
        List<PurchaseOrder> purchaseOrders = purchaseOrderDao.selectList(purchaseOrderQueryWrapper);

        QueryWrapper<AdjustmentOrder> adjustmentOrderQueryWrapper = new QueryWrapper<>();
        adjustmentOrderQueryWrapper.eq("store_id",id);
        List<AdjustmentOrder> adjustmentOrders = adjustmentOrderDao.selectList(adjustmentOrderQueryWrapper);

        if(!saleNotes.isEmpty()||!purchaseOrders.isEmpty()||!adjustmentOrders.isEmpty()){
            throw new BaseException(BaseExceptionEnum.STORE_CANT_DELETE);
        }
        QueryWrapper<StoreItem> storeItemQueryWrapper1 = new QueryWrapper<>();
        storeItemQueryWrapper1.eq("store_id",id);
        storeItemDao.delete(storeItemQueryWrapper1);

        storeDao.deleteById(id);

    }
}
