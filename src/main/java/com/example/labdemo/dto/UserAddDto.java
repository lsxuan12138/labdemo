package com.example.labdemo.dto;

import com.example.labdemo.domain.User;
import com.example.labdemo.util.BCPEUtils;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-12 20:43
 */
public class UserAddDto {
    private String username;
    private String password;
    private Long role;

    public UserAddDto() {
    }

    public UserAddDto(String username, String password, Long role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
    public User toUser(){
        User user = new User();
        user.setName(username);
        user.setAccount(username);
        user.setPassword(BCPEUtils.encode(password));
        user.setRoleId(role);
        return user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRole() {
        return role;
    }

    public void setRole(Long role) {
        this.role = role;
    }
    public void setRole(String role) {
        this.role = Long.parseLong(role);
    }

    @Override
    public String toString() {
        return "UserAddDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
