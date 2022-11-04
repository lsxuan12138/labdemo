package com.example.labdemo.dto;

public class SaleNoteItemDto {
    private Long id;
    private Long quantity;

    public SaleNoteItemDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "SaleNoteItemDto{" +
                "id=" + id +
                ", quantity=" + quantity +
                '}';
    }
}
