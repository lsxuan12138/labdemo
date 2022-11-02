package com.school.entity;

public class SaleNoteItem {
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSale_note_id() {
        return sale_note_id;
    }
    public void setSale_note_id(Integer sale_note_id) { this.sale_note_id = sale_note_id; }

    public Integer getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Integer product_id) { this.product_id = product_id; }

    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Integer id;
    public Integer sale_note_id;
    public Integer product_id;
    public Integer quantity;
}
