package com.school.service;

import com.school.entity.StoreItem;

import java.util.List;

public interface StoreItemService {

    List<StoreItem> queryStoreItem();
    StoreItem findById(int id);
    List<StoreItem> findByStoreId(int storeId);
    int insertStoreItem(StoreItem storeItem);
    int updateStoreItem(StoreItem storeItem);
    int deleteStoreItem(int id);
    int subStoreItem(int id,int num);
    int addStoreItem(int id,int num);
}
