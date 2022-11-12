package com.example.labdemo.domain;

import java.util.Date;

public class AdjustmentOrder {
    private Long id;
    private String name;
    private String stage;
    private Long srcStoreId;
    private Long destStoreId;
    private Long createBy;
    private Date createTime;

    public AdjustmentOrder() {
        this.createTime = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public Long getSrcStoreId() {
        return srcStoreId;
    }

    public void setSrcStoreId(Long srcStoreId) {
        this.srcStoreId = srcStoreId;
    }

    public Long getDestStoreId() {
        return destStoreId;
    }

    public void setDestStoreId(Long destStoreId) {
        this.destStoreId = destStoreId;
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
