package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.SaleNoteItem;
import com.example.labdemo.vo.SaleNoteItemVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SaleNoteItemDao extends BaseMapper<SaleNoteItem> {

    public List<SaleNoteItemVo> getItems(Long id);
}
