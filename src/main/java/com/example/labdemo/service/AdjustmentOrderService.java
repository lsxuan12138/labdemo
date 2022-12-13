package com.example.labdemo.service;

import com.example.labdemo.domain.AdjustmentOrder;
import com.example.labdemo.dto.AdjustmentUpdateDto;
import com.example.labdemo.vo.adjustment.AdjustmentDetailVo;
import com.example.labdemo.vo.adjustment.AdjustmentVo;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 16:03
 */
public interface AdjustmentOrderService {
    /**
     * 通过id获取调货单
     * @param id
     * @return
     */
    AdjustmentOrder selectById(Long id);

    /**
     * 获取所有调货单基本信息
     * @return
     */
    List<AdjustmentVo> getAllVo();

    /**
     * 创建新调货单
     * @param srcId 源仓库id
     * @param destId 目的仓库id
     * @return
     */
    AdjustmentVo add(Long srcId,Long destId);

    /**
     * 获取调货单细节信息
     * @param id 调货单id
     * @return
     */
    AdjustmentDetailVo getDetail(Long id);

    /**
     * 更新调货单信息
     * @param adjustmentUpdateDto 封装请求
     */
    void update(AdjustmentUpdateDto adjustmentUpdateDto);

    /**
     * 审核调货单
     * @param id 调货单id
     * @param stage 目标stage
     */
    void audit(Long id,String stage);
}
