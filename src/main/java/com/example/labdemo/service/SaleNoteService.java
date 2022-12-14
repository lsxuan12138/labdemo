package com.example.labdemo.service;

import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.dto.SaleNoteDetailDto;
import com.example.labdemo.vo.salenote.SaleNoteDetailVo;
import com.example.labdemo.vo.salenote.SaleNoteVo;

import java.util.List;

public interface SaleNoteService {

//    public List<SaleNote> getAll();
//
    public SaleNote selectById(Long id);
    /**
     * 获取所有销售单基础信息
     * @return
     */
    public List<SaleNoteVo> getAllVo();
//
//    public List<SaleNoteVo> find(String keyword);
//

    /**
     * 新建销售单
     * @param clientId 客户id
     * @param storeHouseId 仓库id
     * @return
     */
    public SaleNoteVo add(Long clientId,Long storeHouseId);

    /**
     * 获取销售单detail
     * @param id 销售单id
     * @return
     */
    public SaleNoteDetailVo getDetail(Long id);

    /**
     * 更新销售单
     * @param saleNoteDetailDto
     */
    public void update(SaleNoteDetailDto saleNoteDetailDto);

    /**
     * 审核销售单
     * @param id
     * @param stage
     */
    public void audio(Long id,  String stage) ;

    /**
     * 销售单收款
     * @param id
     * @param stage
     */
    public void collectMoney(Long id,  String stage);

    /**
     * 销售单整单退货
     * @param id
     * @param stage
     */
    public void returnGoods(Long id,  String stage);
}
