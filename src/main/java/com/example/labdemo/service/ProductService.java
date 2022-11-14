package com.example.labdemo.service;

import com.example.labdemo.domain.Product;
import com.example.labdemo.dto.ProductAddDto;
import com.example.labdemo.dto.ProductUpdateDto;
import com.example.labdemo.result.BaseException;

import java.math.BigDecimal;
import java.util.List;


public interface ProductService {

//    public int purchaseProduct(Long id, Long quantity);
//

    /**
     * 获取所有产品信息
     * @return
     */
    public List<Product> getAllProduct();
//
//    public List<Product> find(String key);

    /**
     * 增加产品
     * @param productAddDto 封装产品信息
     * @return
     * @throws BaseException
     */
    public Product add(ProductAddDto productAddDto) throws BaseException;

    /**
     * 删除产品
     * @param id 产品id
     * @throws BaseException
     */
    public void deleteById(Long id) throws BaseException;

    /**
     * 更新产品信息
     * @param productUpdateDto 封装产品信息
     * @throws BaseException
     */
    public void update(ProductUpdateDto productUpdateDto) throws BaseException;
}
