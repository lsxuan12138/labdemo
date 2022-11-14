package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.AdjustmentOrder;
import com.example.labdemo.vo.AdjustmentDetailVo;
import com.example.labdemo.vo.AdjustmentItemVo;
import com.example.labdemo.vo.AdjustmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 15:48
 */
@Mapper
public interface AdjustmentOrderDao extends BaseMapper<AdjustmentOrder> {
    List<AdjustmentVo> getAllVo();

    AdjustmentVo getVoById(@Param("id") Long id);

    AdjustmentDetailVo getDetailVo(@Param("id") Long id);
    List<AdjustmentItemVo> getItemsById(@Param("id") Long id);


}
