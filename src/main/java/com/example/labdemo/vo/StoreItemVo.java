package com.example.labdemo.vo;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 21:02
 */
public class StoreItemVo {
    private Long id;
    private String name;
    private String remark;
    private Long quantity;

    public StoreItemVo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setId(String id) {
        this.id = Long.parseLong(id);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
    public void setQuantity(String quantity) {
        this.quantity = Long.parseLong(quantity);
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
