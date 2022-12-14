package com.example.labdemo.vo.statistic;

import com.example.labdemo.domain.Client;

import java.math.BigDecimal;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-14 14:30
 */
public class ClientPaymentStatisticsVo {
    private Long id;
    private String name;
    private String type;
    private BigDecimal receivedPayment;
    private BigDecimal unreceivedPayment;

    public void setProperties(Client client){
        this.id = client.getId();
        this.name = client.getName();
        this.type = client.getType();
    }
    public ClientPaymentStatisticsVo() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getReceivedPayment() {
        return receivedPayment;
    }

    public void setReceivedPayment(BigDecimal receivedPayment) {
        this.receivedPayment = receivedPayment;
    }

    public BigDecimal getUnreceivedPayment() {
        return unreceivedPayment;
    }

    public void setUnreceivedPayment(BigDecimal unreceivedPayment) {
        this.unreceivedPayment = unreceivedPayment;
    }
}
