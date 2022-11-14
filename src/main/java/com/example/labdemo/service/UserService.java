package com.example.labdemo.service;

import com.example.labdemo.domain.User;
import com.example.labdemo.result.ResultResponse;


import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-12 13:31
 */
public interface UserService {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public ResultResponse login(String username,String password);

    /**
     * 用户推出登录
     * @return
     */
    public ResultResponse logout();

    /**
     * 获取指定角色用户
     * @param role
     * @return
     */
    List<User> selectByRole(String role);
}
