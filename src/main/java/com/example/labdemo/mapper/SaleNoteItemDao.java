package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.SaleNoteItem;
import com.example.labdemo.vo.salenote.SaleNoteItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SaleNoteItemDao extends BaseMapper<SaleNoteItem> {

    public List<SaleNoteItemVo> getItems(@Param("id") long id,@Param("type") String type);
}
