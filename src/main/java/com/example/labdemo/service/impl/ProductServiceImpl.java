package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.Product;
import com.example.labdemo.dto.ProductAddDto;
import com.example.labdemo.dto.ProductUpdateDto;
import com.example.labdemo.mapper.ProductDao;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

//    @Override
//    public int purchaseProduct(Long id, Long quantity) {
//        int ret;
//        try {
//            Product product = productDao.selectById(id);
////            product.setQuantity(product.getQuantity() + quantity);
//            ret = productDao.updateById(product);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException();
//        }
//        if (ret != 1) throw new RuntimeException();
//        return ret;
//    }
//
    @Override
    public List<Product> getAllProduct() {
        return productDao.selectList(null);
    }
//
//    @Override
//    public List<Product> find(String key) {
//        List<Product> products = null;
//        try {
//            QueryWrapper<Product> wrapper = new QueryWrapper<>();
//            wrapper.clear();
//            wrapper.like("name", key);
//            products = productDao.selectList(wrapper);
//
//        } catch (Exception e) {
//            throw new RuntimeException();
//        }
//        return products;
//    }

    @Override
    public Product add(ProductAddDto productAddDto) throws BaseException {
        Product product = productAddDto.toProduct();
        if(productDao.insert(product)<=0)throw new BaseException(BaseExceptionEnum.PRODUCT_INSERT_ERROR);
        return product;
    }
    @Override
    public void deleteById(Long id) throws BaseException {
        if(productDao.deleteById(id)<=0)throw new BaseException();
    }

    @Override
    public void update(ProductUpdateDto productUpdateDto) throws BaseException {
        if(productDao.updateById(productUpdateDto.toProduct())<=0){
            throw new BaseException(BaseExceptionEnum.PRODUCT_UPDATE_ERROR);
        }
    }
}
