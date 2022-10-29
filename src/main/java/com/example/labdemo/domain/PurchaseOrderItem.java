package com.example.labdemo.domain;

/**
 * PurchaseOrderItem
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:14
 */
public class PurchaseOrderItem {
    private Long id;
    private Long purchaseOrderId;
    private Long productId;
    private Long quantity;

    public PurchaseOrderItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(Long purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
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