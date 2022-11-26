package com.school.service;

import com.school.entity.User;

import java.util.List;

public interface UserService {
    List<User> queryUser();
    List<User> findByName(String name);
    User findById(int id);
    User findByAccount(String account);
    int insertUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
