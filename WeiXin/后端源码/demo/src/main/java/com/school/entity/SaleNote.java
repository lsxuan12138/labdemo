package com.school.entity;

import java.sql.Date;

public class SaleNote {
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStoreId() {
        return storeId;
    }
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getClientId() {
        return clientId;
    }
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getCost() {
        return cost;
    }
    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getReceivedPayment() {
        return receivedPayment;
    }
    public void setReceivedPayment(Double receivedPayment) {
        this.receivedPayment = receivedPayment;
    }

    public String getStage() {
        return stage;
    }
    public void setAreaName(String stage) {
        this.stage = stage;
    }

    public Integer getCreateBy() {
        return createBy;
    }
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public java.sql.Date getCreateTime() { return createTime; }
    public void setCreateTime(java.sql.Date createTime) { this.createTime =  createTime; }

    public Integer id;
    public Integer storeId;
    public Integer clientId;
    public Double price;
    public String stage;
    public Double cost;
    public Double receivedPayment;
    public Integer createBy;
    public java.sql.Date createTime;

}
