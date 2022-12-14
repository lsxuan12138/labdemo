package com.example.labdemo.vo.adjustment;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 17:06
 */
public class AdjustmentDetailVo {
    private Long id;
    private String stage;
    private String srcStoreHouse;
    private String destStoreHouse;
    private List<AdjustmentItemVo> items;
    public AdjustmentDetailVo() {
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

    public String getSrcStoreHouse() {
        return srcStoreHouse;
    }

    public void setSrcStoreHouse(String srcStoreHouse) {
        this.srcStoreHouse = srcStoreHouse;
    }

    public String getDestStoreHouse() {
        return destStoreHouse;
    }

    public void setDestStoreHouse(String destStoreHouse) {
        this.destStoreHouse = destStoreHouse;
    }

    public List<AdjustmentItemVo> getItems() {
        return items;
    }

    public void setItems(List<AdjustmentItemVo> items) {
        this.items = items;
    }
}
