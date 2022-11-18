package com.example.labdemo.dto;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 18:03
 */
public class AdjustmentUpdateDto {
    private Long id;
    private String stage;
    private List<AdjustmentUpdateItemDto> items;

    public AdjustmentUpdateDto() {
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

    public List<AdjustmentUpdateItemDto> getItems() {
        return items;
    }

    public void setItems(List<AdjustmentUpdateItemDto> items) {
        this.items = items;
    }
}
