package com.example.labdemo.vo.store;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 21:46
 */
public class StoreHouseDetailVo {
    private Long id;
    private String name;
    private String remark;
    private String owner;
    private List<StoreItemVo> items;

    public StoreHouseDetailVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
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

    public List<StoreItemVo> getItems() {
        return items;
    }

    public void setItems(List<StoreItemVo> items) {
        this.items = items;
    }
}
