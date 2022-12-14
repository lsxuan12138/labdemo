package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.StoreItem;
import com.example.labdemo.vo.store.StoreItemDetailVo;
import com.example.labdemo.vo.store.StoreItemVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 21:08
 */
@Mapper
public interface StoreItemDao extends BaseMapper<StoreItem> {
    List<StoreItemVo> getAllStoreItem();

    List<StoreItemVo> getStoreVoById( Long id);

    public List<StoreItemDetailVo> getAllStoreItemDetail(@Param("type") String type);
}
