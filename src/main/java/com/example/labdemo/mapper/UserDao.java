package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.User;
import com.example.labdemo.vo.UserInfoVo;
import com.example.labdemo.vo.statistic.SalesmanStatisticsVo;
import com.example.labdemo.vo.UserCtrlVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserDao extends BaseMapper<User> {

    List<String>  findPermissionsByUserId(Long id);

    List<UserCtrlVo> selectAllUserVo();

    UserInfoVo selectUserInfoById(@Param("id") Long id);

    List<SalesmanStatisticsVo> selectStaticsVo();
}
