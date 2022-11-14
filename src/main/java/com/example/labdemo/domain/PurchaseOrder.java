package com.example.labdemo.domain;

import com.example.labdemo.constants.PurchaseOrderConstants;

import java.util.Date;

/**
 * PurchaseOrder
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:12
 */
public class PurchaseOrder {
    private Long id;

    private Long storeId;
    private String stage;
    private Long createBy;
    private Date createTime;

    public PurchaseOrder() {
    }
    public PurchaseOrder(Long storeId,Long createBy){
        this.storeId = storeId;
        this.stage = PurchaseOrderConstants.STAGE_TO_BE_EDITED;
        this.createBy = createBy;
        this.createTime = new Date();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
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