package com.example.labdemo.service;

import com.example.labdemo.dto.StoreAddDto;
import com.example.labdemo.vo.store.StoreHouseDetailVo;
import com.example.labdemo.vo.store.StoreItemDetailVo;
import com.example.labdemo.vo.store.StoreItemVo;
import com.example.labdemo.vo.store.StoreVo;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 20:22
 */
public interface StoreService {
    /**
     * 获取全部仓库基础信息
     * @return
     */
    public List<StoreVo> selectAllVo();

    /**
     * 新建仓库
     * @param storeAddDto
     * @return
     */
    public StoreVo addStore(StoreAddDto storeAddDto);

    /**
     * 获取全部库存（所有仓库库存总和）
     * @return
     */
    public List<StoreItemVo> getAllStoreItem();
    /**
     * 获取全部库存详细信息（所有仓库库存总和）（用于销售单填写）
     * @param id 销售单id
     * @return
     */
    public List<StoreItemDetailVo> getAllStoreItemDetail(Long id);

    /**
     * 获取仓库库存
     * @param id
     * @return
     */
    public List<StoreItemVo> getStoreItemById(Long id);

    /**
     * 获取仓库detail
     * @param id
     * @return
     */
    public StoreHouseDetailVo selectDetailVo(Long id);

    void deleteStore(Long id);
}
