package com.example.labdemo.vo.statistic;

import com.example.labdemo.domain.Product;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-14 12:47
 */
public class ProductStatisticsVo {
    private Long id;
    private String name;
    private String remark;
    private Long buyQuantity;
    private Long saleQuantity;
    private Long clientQuantity;
    private BigDecimal amount;

    public ProductStatisticsVo() {
    }

    public Long getId() {
        return id;
    }
    public void setProperties(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.remark = product.getRemark();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(Long buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public Long getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(Long saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    public Long getClientQuantity() {
        return clientQuantity;
    }

    public void setClientQuantity(Long clientQuantity) {
        this.clientQuantity = clientQuantity;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
