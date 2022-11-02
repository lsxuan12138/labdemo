package com.school.dao;

import com.school.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> queryProduct();
    Product findByName(String name);
    int insertProduct(Product product);
    int updateProduct(Product product);
    int deleteProduct(int id);
}
