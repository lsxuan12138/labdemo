package com.example.labdemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.labdemo.constants.AdjustmentOrderConstants;

import java.util.Date;
@TableName("t_adjustment_order")
public class AdjustmentOrder {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String stage;
    private Long srcStoreId;
    private Long destStoreId;
    private Long createBy;
    private Date createTime;

    public AdjustmentOrder() {
    }

    public AdjustmentOrder(Long srcStoreId,Long destStoreId,Long createBy){
        this.stage = AdjustmentOrderConstants.STAGE_TO_BE_EDITED;
        this.srcStoreId = srcStoreId;
        this.destStoreId = destStoreId;
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
