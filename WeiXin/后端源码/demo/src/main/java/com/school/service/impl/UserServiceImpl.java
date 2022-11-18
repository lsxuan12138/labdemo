package com.school.service.impl;


import com.school.dao.UserDao;
import com.school.entity.User;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;


    @Override
    public List<User> queryUser() { return userDao.queryUser(); }

    @Override
    public List<User> findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User findById(int id) { return userDao.findById(id);}

    @Override
    public User findByAccount(String account) { return userDao.findByAccount(account); }

    @Override
    public int insertUser(User user) {
        if(user.getAccount()!=null&&!"".equals(user.getAccount())){
            try {
                int result=userDao.insertUser(user);
                if (result>0){
                    return 1;
                }else {
                    throw  new RuntimeException("插入失败");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入信息失败"+e.getMessage());
            }
        }else {
            throw  new RuntimeException("插入的值有空的");
        }
        /*  return areaDao.insertArea(area);*/
    }

    @Override
    public int updateUser(User user) { return userDao.updateUser(user);}

    @Override
    public int deleteUser(int id) { return userDao.deleteUser(id); }
}
