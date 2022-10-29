package com.example.labdemo.domain;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Product
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:07
 */
public class Product {
    private Long id;
    private String name;
    private Long quantity;
    private BigDecimal purchasePrice;
    private BigDecimal sellPrice;
    private Date createTime;

    public Product() {
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

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}