package com.example.labdemo.vo;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 19:57
 */
public class PurchaseDetailVo {
    private Long id;
    private String storeName;
    private String stage;
    private List<PurchaseItemVo> items;

    public PurchaseDetailVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<PurchaseItemVo> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItemVo> items) {
        this.items = items;
    }
}
