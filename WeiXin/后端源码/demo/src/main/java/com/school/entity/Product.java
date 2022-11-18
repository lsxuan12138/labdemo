package com.school.entity;

import java.util.Date;

public class Product {
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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

    public Double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getWholesalePrice() {
        return wholesalePrice;
    }
    public void setWholesalePrice(Double wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public Double getRetailPrice() {
        return retailPrice;
    }
    public void setRetailPrice(Double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public java.sql.Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(java.sql.Date createTime) {
        this.createTime =  createTime;
    }


    public Integer id;
    public String name;
    public String remark;
    public Double purchasePrice;
    public Double wholesalePrice;
    public Double retailPrice;
    public java.sql.Date createTime;
}
