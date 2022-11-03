package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.Product;
import com.example.labdemo.mapper.ProductDao;
import com.example.labdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public int purchaseProduct(Long id, Long quantity) {
        int ret;
        try {
            Product product = productDao.selectById(id);
            product.setQuantity(product.getQuantity() + quantity);
            ret = productDao.updateById(product);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        if (ret != 1) throw new RuntimeException();
        return ret;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = null;
        try {
            products = productDao.selectList(null);

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return products;
    }

    @Override
    public List<Product> find(String key) {
        List<Product> products = null;
        try {
            QueryWrapper<Product> wrapper = new QueryWrapper<>();
            wrapper.clear();
            wrapper.like("name", key);
            products = productDao.selectList(wrapper);

        } catch (Exception e) {
            throw new RuntimeException();
        }
        return products;
    }


}
