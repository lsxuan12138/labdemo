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
//    public List<Product> getAllProduct();
//
//    public List<Product> find(String key);

    public Product add(ProductAddDto productAddDto) throws BaseException;

//    public int deleteById(Long id) throws BaseException;

    public void update(ProductUpdateDto productUpdateDto) throws BaseException;
}
