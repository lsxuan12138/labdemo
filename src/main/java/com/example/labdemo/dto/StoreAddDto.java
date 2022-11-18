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
    private Long owner;

    public StoreAddDto() {
    }
    public Store toStore(){
        Store store = new Store();
        store.setName(name);
        store.setRemark(remark);
        store.setOwnerId(owner);
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

    public Long getOwner() {
        return owner;
    }

    public void setOwner(Long owner) {
        this.owner = owner;
    }
}
