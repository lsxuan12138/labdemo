package com.example.labdemo.dto;

import com.example.labdemo.domain.Product;

import java.math.BigDecimal;
import java.util.Date;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-11 22:36
 */
public class ProductAddDto {
    private String name;
    private String remark;
    private BigDecimal purchasePrice;
    private BigDecimal wholesalePrice;
    private BigDecimal retailPrice;

    public Product toProduct(){
        Product product = new Product();
        product.setName(name);
        product.setRemark(remark);
        product.setPurchasePrice(purchasePrice);
        product.setWholesalePrice(wholesalePrice);
        product.setRetailPrice(retailPrice);
        product.setCreateTime(new Date());
        return product;
    }
    public ProductAddDto() {
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }
    public void setPurchasePrice(String purchasePrice) {
        this.purchasePrice = BigDecimal.valueOf(Double.parseDouble(purchasePrice));
    }
    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }
    public void setWholesalePrice(String wholesalePrice) {
        this.wholesalePrice = BigDecimal.valueOf(Double.parseDouble(wholesalePrice));
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public void setRetailPrice(String retailPrice) {
        this.retailPrice = BigDecimal.valueOf(Double.parseDouble(retailPrice));
    }
}
