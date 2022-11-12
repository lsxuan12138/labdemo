package com.example.labdemo.service;

import com.example.labdemo.result.ResultResponse;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-12 13:31
 */
public interface UserService {
    public ResultResponse login(String username,String password);
    public ResultResponse logout();

}
