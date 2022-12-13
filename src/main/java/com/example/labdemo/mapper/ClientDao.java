package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.Client;
import com.example.labdemo.vo.statics.ClientStaticsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientDao extends BaseMapper<Client> {
    List<ClientStaticsVo> selectStaticsVo();
}
