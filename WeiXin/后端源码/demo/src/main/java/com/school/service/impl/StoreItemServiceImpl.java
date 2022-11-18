package com.school.service.impl;

import com.school.dao.SaleNoteItemDao;
import com.school.dao.StoreItemDao;
import com.school.entity.StoreItem;
import com.school.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreItemServiceImpl implements StoreItemService {

    @Autowired
    private StoreItemDao storeItemDao;

    @Override
    public List<StoreItem> queryStoreItem() {
        return storeItemDao.queryStoreItem();
    }
    @Override
    public StoreItem findById(int id) {
        return storeItemDao.findById(id);
    }

    @Override
    public List<StoreItem> findByStoreId(int storeId) {
        return storeItemDao.findByStoreId(storeId);
    }

    @Override
    public int insertStoreItem(StoreItem storeItem) {
        if(storeItem.getId()!=null&&!"".equals(storeItem.getId())){
            try {
                int result=storeItemDao.insertStoreItem(storeItem);
                if (result>0){
                    return 1;
                }else {
                    throw  new RuntimeException("插入失败");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入取余信息失败失败"+e.getMessage());
            }
        }else {
            throw  new RuntimeException("插入的值有空的");
        }
        /*  return areaDao.insertArea(area);*/
    }

    @Override
    public int updateStoreItem(StoreItem storeItem) {
        return storeItemDao.updateStoreItem(storeItem);
    }

    @Override
    public int deleteStoreItem(int id) {
        return storeItemDao.deleteStoreItem(id);
    }

    @Override
    public int subStoreItem(int id,int num) {
        StoreItem newStoreItem = storeItemDao.findById(id);
        int newquantity = newStoreItem.getQuantity()-num;
        newStoreItem.setQuantity(newquantity);
        return storeItemDao.updateStoreItem(newStoreItem);
    }

    @Override
    public int addStoreItem(int id ,int num) {
        StoreItem newStoreItem = storeItemDao.findById(id);
        int newquantity = newStoreItem.getQuantity()+num;
        newStoreItem.setQuantity(newquantity);
        return storeItemDao.updateStoreItem(newStoreItem);
    }
}
