package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.AdjustmentOrder;
import com.example.labdemo.vo.adjustment.AdjustmentDetailVo;
import com.example.labdemo.vo.adjustment.AdjustmentItemVo;
import com.example.labdemo.vo.adjustment.AdjustmentVo;
import org.apache.ibatis.annotations.Mapper;

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

    AdjustmentVo getVoById( Long id);

    AdjustmentDetailVo getDetailVo(Long id);
    List<AdjustmentItemVo> getItemsById(Long id);


}
