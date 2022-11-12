package com.example.labdemo.dto;

import com.example.labdemo.domain.Product;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-11 21:34
 */
public class ProductUpdateDto {
    private Long id;
    private String name;
    private String remark;
    private BigDecimal purchasePrice;
    private BigDecimal wholesalePrice;
    private BigDecimal retailPrice;

    public Product toProduct(){
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setRemark(remark);
        product.setPurchasePrice(purchasePrice);
        product.setWholesalePrice(wholesalePrice);
        product.setRetailPrice(retailPrice);
        return product;
    }
    public ProductUpdateDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
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
