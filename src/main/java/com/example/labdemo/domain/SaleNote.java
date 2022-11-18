package com.example.labdemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.labdemo.constants.SaleNoteConstants;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SaleNote
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:17
 */
@TableName("t_sale_note")
public class SaleNote {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long storeId;
    private Long clientId;
    private String stage;

    private BigDecimal cost;
    private BigDecimal price;
    private BigDecimal receivedPayment;
    private Long createBy;
    private Date createTime;

    public SaleNote() {
    }

    public SaleNote(Long clientId,Long storeHouseId,Long createBy){
        this.storeId = storeHouseId;
        this.clientId = clientId;
        this.stage = SaleNoteConstants.STAGE_TO_BE_EDITED;
        this.cost = new BigDecimal(0);
        this.price = new BigDecimal(0);
        this.receivedPayment = new BigDecimal(0);
        this.createBy =createBy;
        this.createTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getReceivedPayment() {
        return receivedPayment;
    }

    public void setReceivedPayment(BigDecimal receivedPayment) {
        this.receivedPayment = receivedPayment;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}