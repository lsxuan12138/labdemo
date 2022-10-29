package com.example.labdemo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * SaleNote
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:17
 */
public class SaleNote {
    private Long id;
    private Long clientId;
    private BigDecimal totalPrice;
    private String stage;
    private String createBy;
    private Date createTime;

    public SaleNote() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
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