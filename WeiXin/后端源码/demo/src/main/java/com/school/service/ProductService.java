package com.school.service;

import com.school.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> queryProduct();
    Product findById(Integer id);
    List<Product> findByName(String name);
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(int id);
}
