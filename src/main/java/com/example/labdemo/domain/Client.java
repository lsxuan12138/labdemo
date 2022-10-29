package com.example.labdemo.domain;

/**
 * Client
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 15:11
 */
public class Client {
    private Long id;
    private String name;

    public Client() {
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
}