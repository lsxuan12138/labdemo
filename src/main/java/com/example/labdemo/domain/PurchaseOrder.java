package com.example.labdemo.domain;

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
    private String stage;
    private String createBy;
    private Date createTime;

    public PurchaseOrder() {
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

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}