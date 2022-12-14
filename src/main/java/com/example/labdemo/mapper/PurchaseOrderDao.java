package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.PurchaseOrder;
import com.example.labdemo.vo.purchase.PurchaseDetailVo;
import com.example.labdemo.vo.purchase.PurchaseItemVo;
import com.example.labdemo.vo.purchase.PurchaseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-14 19:01
 */
@Mapper
public interface PurchaseOrderDao extends BaseMapper<PurchaseOrder> {

    List<PurchaseVo> getAllVo();

    PurchaseVo getVoById(Long id);

    PurchaseDetailVo getDetailById(Long id);

    List<PurchaseItemVo> getItemVoById(Long id);
}
