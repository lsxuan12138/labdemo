package com.school.service;

import com.school.entity.User;

public interface UserService {
    User findByUsername(String username);
}
