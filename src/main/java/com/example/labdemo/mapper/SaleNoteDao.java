package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.vo.SaleNoteVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SaleNoteDao extends BaseMapper<SaleNote> {

    public List<SaleNoteVo> selectAllSaleNoteVo();

//    public List<SaleNoteVo> find(@Param("key")String key);

    public SaleNoteVo selectVoById(Long id);
}
