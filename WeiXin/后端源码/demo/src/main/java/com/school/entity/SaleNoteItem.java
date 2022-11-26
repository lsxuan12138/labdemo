package com.school.entity;

public class SaleNoteItem {
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleNoteId() {
        return saleNoteId;
    }
    public void setSaleNoteId(Integer saleNoteId) { this.saleNoteId = saleNoteId; }

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Integer id;
    public Integer saleNoteId;
    public Integer productId;
    public Integer quantity;
}
