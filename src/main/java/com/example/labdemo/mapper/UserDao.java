package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.User;
import com.example.labdemo.vo.statics.SalesmanStatisticVo;
import com.example.labdemo.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserDao extends BaseMapper<User> {

    List<String>  findPermissionsByUserId(Long id);

    List<UserVo> selectAllUserVo();

    List<SalesmanStatisticVo> selectStaticsVo();
}
