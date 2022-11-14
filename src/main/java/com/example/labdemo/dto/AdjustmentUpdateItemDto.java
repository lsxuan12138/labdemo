package com.example.labdemo.dto;

import com.example.labdemo.domain.AdjustmentOrderItem;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 18:04
 */
public class AdjustmentUpdateItemDto {
    private Long id;
    private Long quantity;

    public AdjustmentUpdateItemDto() {
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
    public AdjustmentOrderItem toAdjustmentUpdateItem(){
        AdjustmentOrderItem temp = new AdjustmentOrderItem();
        temp.setProductId(id);
        temp.setQuantity(quantity);
        return temp;
    }
}
