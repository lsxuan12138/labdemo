package com.example.labdemo.vo.salenote;

import java.math.BigDecimal;
import java.util.List;

public class SaleNoteDetailVo {
    private Long id;
    private String clientName;
    private String clientType;
    private String stage;
    private BigDecimal cost;
    private BigDecimal price;
    private BigDecimal profit;

    private BigDecimal receivedPayment;
    private List<SaleNoteItemVo> items;

    public SaleNoteDetailVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getReceivedPayment() {
        return receivedPayment;
    }

    public void setReceivedPayment(BigDecimal receivedPayment) {
        this.receivedPayment = receivedPayment;
    }

    public List<SaleNoteItemVo> getItems() {
        return items;
    }

    public void setItems(List<SaleNoteItemVo> items) {
        this.items = items;
    }
}
