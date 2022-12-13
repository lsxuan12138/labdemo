package com.example.labdemo.service;

import com.example.labdemo.dto.PurchaseUpdateDto;
import com.example.labdemo.vo.purchase.PurchaseDetailVo;
import com.example.labdemo.vo.purchase.PurchaseVo;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 19:11
 */
public interface PurchaseOrderService {
    /**
     * 获取所有进货单基础信息
     * @return
     */
    List<PurchaseVo> getAllVo();

    /**
     * 创建进货单
     * @param storeId 仓库id
     * @return
     */
    PurchaseVo add(Long storeId);

    /**
     * 获取进货单detail信息
     * @param id 进货单id
     * @return
     */
    PurchaseDetailVo getDetail(Long id);

    /**
     * 更新进货单信息
     * @param purchaseUpdateDto
     */
    void update(PurchaseUpdateDto purchaseUpdateDto);

    /**
     * 审核进货单
     * @param id
     * @param stage
     */
    void audit(Long id, String stage);
}
