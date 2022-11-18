package com.example.labdemo.service.impl;

import com.example.labdemo.domain.Role;
import com.example.labdemo.mapper.RoleDao;
import com.example.labdemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-16 21:25
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> getAll() {
        return roleDao.selectList(null);
    }
}
