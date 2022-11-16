package com.example.labdemo.dto;

import com.example.labdemo.domain.Store;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-16 13:25
 */
public class StoreAddDto {
    private String name;
    private String remark;
    private String owner;

    public StoreAddDto() {
    }
    public Store toStore(Long ownerId){
        Store store = new Store();
        store.setName(name);
        store.setRemark(remark);
        store.setOwnerId(ownerId);
        return store;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
