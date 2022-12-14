package com.example.labdemo.vo.adjustment;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 15:44
 */
public class AdjustmentVo {
    private Long id;
    private String stage;
    private String srcStoreHouse;
    private String destStoreHouse;
    private String creator;
    private Date createTime;

    public AdjustmentVo() {
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreateTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
