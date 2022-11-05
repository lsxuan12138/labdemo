package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.Client;
import com.example.labdemo.domain.Product;
import com.example.labdemo.mapper.ProductDao;
import com.example.labdemo.service.ProductService;
import com.example.labdemo.util.BaseException;
import com.example.labdemo.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
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

    @Override
    public void add(String name, BigDecimal cost, BigDecimal price) throws BaseException {
        Product product = new Product();
        product.setName(name);
        product.setQuantity(0L);
        product.setSellPrice(price);
        product.setPurchasePrice(cost);
        product.setCreateTime(new Date());

        int ret = productDao.insert(product);

        if(ret<=0)throw new BaseException(ResultEnum.PRODUCT_INSERT_ERROR);
    }
    @Override
    public int deleteById(Long id) throws BaseException {
        int ret = productDao.deleteById(id);
        if (ret != 1) throw new BaseException(ResultEnum.PRODUCT_DELETE_ERROR);
        return ret;
    }

    @Override
    public void update(Long id, String name, BigDecimal cost, BigDecimal price) throws BaseException {
        Product old = productDao.selectById(id);
        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setQuantity(old.getQuantity());
        product.setSellPrice(price);
        product.setPurchasePrice(cost);
        product.setCreateTime(old.getCreateTime());
        try {
            productDao.updateById(product);
        }catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }
}
