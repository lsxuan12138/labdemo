package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 19:55
 */
@Mapper
public interface RoleDao extends BaseMapper<Role> {
}
