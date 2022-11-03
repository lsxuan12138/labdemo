package com.example.labdemo.service;

import com.example.labdemo.domain.Product;
import com.example.labdemo.util.BaseException;
import com.example.labdemo.util.Result;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;


public interface ProductService {

    public int purchaseProduct(Long id,Long quantity);

    public List<Product> getAllProduct();

    public List<Product> find(String key);

    public void add(String name, BigDecimal cost,BigDecimal price) throws BaseException;

    public int deleteById(Long id)throws BaseException;

    public void update(Long id,String name,BigDecimal cost,BigDecimal price) throws BaseException;
}
