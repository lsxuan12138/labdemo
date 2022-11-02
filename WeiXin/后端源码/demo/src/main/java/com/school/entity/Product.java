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


    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }
    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime =  createTime;
    }


    public Integer id;
    public String name;
    public Integer quantity;
    public Double purchasePrice;
    public Double sellPrice;
    public Date createTime;
}
