package com.example.labdemo.service;

import com.example.labdemo.domain.Store;
import com.example.labdemo.vo.StoreHouseDetailVo;
import com.example.labdemo.vo.StoreItemVo;
import com.example.labdemo.vo.StoreVo;

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
     * @param owner
     * @return
     */
    public StoreVo addStore(String owner);

    /**
     * 获取全部库存（所有仓库库存总和）
     * @return
     */
    public List<StoreItemVo> getAllStoreItem();

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
}
