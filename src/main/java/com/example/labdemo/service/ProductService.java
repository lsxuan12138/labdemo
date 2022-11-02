package com.example.labdemo.service;

import com.example.labdemo.domain.Product;
import com.example.labdemo.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public int purchaseProduct(Long id,Long quantity);

    public List<Product> getAllProduct();

    public List<Product> find(String key);
}
