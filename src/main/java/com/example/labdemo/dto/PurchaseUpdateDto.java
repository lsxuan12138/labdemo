package com.example.labdemo.dto;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 20:26
 */
public class PurchaseUpdateDto {
    private Long id;
    private String stage;
    private List<PurchaseUpdateItemDto> items;

    public PurchaseUpdateDto() {
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

    public List<PurchaseUpdateItemDto> getItems() {
        return items;
    }

    public void setItems(List<PurchaseUpdateItemDto> items) {
        this.items = items;
    }
}
