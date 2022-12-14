package com.school.entity;

public class User {

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() { return roleId; }
    public void setRoleId(Integer roleId) { this.roleId = roleId; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    private Integer id;
    private String name;
    private String account;
    private String password;
    private Integer roleId;
}
