package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.Client;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientDao extends BaseMapper<Client> {

}
