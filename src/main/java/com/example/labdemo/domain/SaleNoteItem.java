package com.example.labdemo.domain;

/**
 * SaleNoteItem
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:20
 */
public class SaleNoteItem {
    private Long id;
    private Long saleNoteId;
    private Long productId;
    private Long quantity;

    public SaleNoteItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSaleNoteId() {
        return saleNoteId;
    }

    public void setSaleNoteId(Long saleNoteId) {
        this.saleNoteId = saleNoteId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}