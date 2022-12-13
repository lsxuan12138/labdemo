package com.example.labdemo.dto;

import java.util.List;

public class SaleNoteDetailDto {
    private Long id;
    private String stage;
    private List<SaleNoteItemDto> items;

    public SaleNoteDetailDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<SaleNoteItemDto> getItems() {
        return items;
    }

    public void setItems(List<SaleNoteItemDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "SaleNoteDetailDto{" +
                "id=" + id +
                ", stage='" + stage + '\'' +
                ", items=" + items +
                '}';
    }
}
