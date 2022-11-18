package com.example.labdemo.dto;

import com.example.labdemo.domain.AdjustmentOrderItem;
import com.example.labdemo.domain.PurchaseOrderItem;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 20:27
 */
public class PurchaseUpdateItemDto {
    private Long id;
    private Long quantity;

    public PurchaseUpdateItemDto() {
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
    public PurchaseOrderItem toPurchaseUpdateItem(){
        PurchaseOrderItem temp = new PurchaseOrderItem();
        temp.setProductId(id);
        temp.setQuantity(quantity);
        return temp;
    }
}
