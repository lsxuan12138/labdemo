package com.example.labdemo.vo.statistic;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-13 20:19
 */
public class SalesmanStatisticsVo {
    private Long id;
    private String name;
    private Long saleQuantity;
    private Long clientQuantity;
    private BigDecimal saleAmount;
    private BigDecimal performance;

    public SalesmanStatisticsVo() {
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

    public BigDecimal getSaleAmount() {
        return saleAmount;
    }

    public void setSaleAmount(BigDecimal saleAmount) {
        this.saleAmount = saleAmount;
    }

    public BigDecimal getPerformance() {
        return performance;
    }

    public void setPerformance(BigDecimal performance) {
        this.performance = performance;
    }
}
