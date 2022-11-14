package com.example.labdemo.service;

import com.example.labdemo.domain.Client;
import com.example.labdemo.result.BaseException;

import java.util.List;

public interface ClientService {
    /**
     * 获取所有批发用户信息
     * @return
     */
    List<Client> getWholesales();
    /**
     * 获取所有零售 用户信息
     * @return
     */
    List<Client> getRetails();
    /**
     * 获取所有用户信息
     * @return
     */
    public List<Client> getAll();

    /**
     * 删除用户
     * @param id
     */
    public void deleteById(Long id);

    /**
     * 创建用户
     * @param name 用户名字
     * @param type 用户种类
     * @return
     */
    public Client add(String name,String type);
//
//    public List<Client> find(String key) throws BaseException;

    /**
     * 更新用户信息
     * @param id 用户id
     * @param name 用户姓名
     * @param type 用户种类
     */
    public void update(Long id,String name,String type);
}
