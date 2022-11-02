package com.school.dao;

import com.school.entity.Area;
import com.school.entity.User;

public interface UserDao {
    User findByUsername(String username);
}
