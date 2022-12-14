package com.example.labdemo.vo.statistic;

import java.math.BigDecimal;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-14 20:23
 */
public class BusinessStatisticsVo {
    //storeAmounts
    private String storeAmounts;
    //进货金额
    private List<BigDecimal> purchaseAmounts;
    //销售金额
    private List<BigDecimal> saleAmounts;
    //盈利金额
    private List<BigDecimal> profits;

    public BusinessStatisticsVo() {
    }

    public String getStoreAmounts() {
        return storeAmounts;
    }

    public void setStoreAmounts(String storeAmounts) {
        this.storeAmounts = storeAmounts;
    }

    public List<BigDecimal> getPurchaseAmounts() {
        return purchaseAmounts;
    }

    public void setPurchaseAmounts(List<BigDecimal> purchaseAmounts) {
        this.purchaseAmounts = purchaseAmounts;
    }

    public List<BigDecimal> getSaleAmounts() {
        return saleAmounts;
    }

    public void setSaleAmounts(List<BigDecimal> saleAmounts) {
        this.saleAmounts = saleAmounts;
    }

    public List<BigDecimal> getProfits() {
        return profits;
    }

    public void setProfits(List<BigDecimal> profits) {
        this.profits = profits;
    }
}
