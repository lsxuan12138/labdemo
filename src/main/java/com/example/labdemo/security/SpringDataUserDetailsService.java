package com.example.labdemo.security;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.User;
import com.example.labdemo.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpringDataUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //将来连接数据库根据账号查询用户信息
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("account", username);
        User user = userDao.selectOne(userWrapper);
        if (user == null) {
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }

        //根据用户的id查询用户的权限
        List<String> permissions = userDao.findPermissionsByUserId(user.getId());
        return new LoginUser(user, permissions);
    }
}
