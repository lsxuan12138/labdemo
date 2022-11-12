package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserDao extends BaseMapper<User> {

    List<String>  findPermissionsByUserId(@Param("userId") Long id);
}
