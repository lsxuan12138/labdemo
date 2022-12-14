package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.Store;
import com.example.labdemo.vo.store.StoreHouseDetailVo;
import com.example.labdemo.vo.store.StoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 20:23
 */
@Mapper
public interface StoreDao extends BaseMapper<Store> {
    public List<StoreVo> selectAllVo();
    public StoreHouseDetailVo selectDetailVo( Long id);

    BigDecimal computePurchaseAmounts(@Param("beginDate") Date beginDate,@Param("endDate") Date endDate);

    BigDecimal computeStoreAmounts();
}
