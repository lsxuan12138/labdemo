package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.ClientConstants;
import com.example.labdemo.domain.Client;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.domain.Store;
import com.example.labdemo.domain.User;
import com.example.labdemo.mapper.*;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    private ClientDao clientDao;

    @Override
    public List<StoreVo> selectAllVo(){
        return storeDao.selectAllVo();
    }
    @Override
    public StoreVo addStore(String owner) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",owner);
        User user = userDao.selectOne(queryWrapper);
        if(user==null)throw new BaseException(BaseExceptionEnum.USER_NO_EXIST);
        Store store = new Store();
        store.setName("未命名");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        store.setRemark("创建于"+format.format(new Date()));
        store.setOwnerId(user.getId());
        storeDao.insert(store);
        StoreVo vo = new StoreVo(store);
        vo.setOwner(owner);
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
}