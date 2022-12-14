package com.example.labdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labdemo.domain.Product;
import com.example.labdemo.vo.statistic.ProductWithPriceAndQuantityVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface ProductDao extends BaseMapper<Product> {
    long countBuyQuantity(@Param("id") Long productId);

    long countSaleQuantity(@Param("id") Long productId);

    long countClientQuantity(@Param("id") Long productId);
    List<ProductWithPriceAndQuantityVo> selectProductWithPriceAndQuantityVo(@Param("id") Long productId);
}
