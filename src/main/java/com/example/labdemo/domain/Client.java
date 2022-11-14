package com.example.labdemo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * Client
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:11
 */
@TableName("t_client")
public class Client {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String type;
    public Client() {
    }

    public Client(String name, String type) {
        this.name = name;
        this.type = type;
    }
    public Client(Long id, String name, String type){
        this.id=id;
        this.name=name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}