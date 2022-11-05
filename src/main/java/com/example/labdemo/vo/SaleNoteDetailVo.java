package com.example.labdemo.vo;

import com.example.labdemo.domain.SaleNoteItem;

import java.util.List;

public class SaleNoteDetailVo {
    private Long id;
    private String clientName;
    private String stage;
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

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<SaleNoteItemVo> getItems() {
        return items;
    }

    public void setItems(List<SaleNoteItemVo> items) {
        this.items = items;
    }
}
