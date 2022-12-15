package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.*;
import com.example.labdemo.dto.ProductAddDto;
import com.example.labdemo.dto.ProductUpdateDto;
import com.example.labdemo.mapper.*;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.service.AdjustmentOrderService;
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
    @Autowired
    SaleNoteItemDao saleNoteItemDao;
    @Autowired
    StoreItemDao storeItemDao;
    @Autowired
    AdjustmentOrderItemDao adjustmentOrderItemDao;
    @Autowired
    PurchaseOrderItemDao purchaseOrderItemDao;
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
        Product product = productDao.selectById(id);
        if(product==null)throw new BaseException(BaseExceptionEnum.PRODUCT_NOT_EXIST);

        QueryWrapper<StoreItem> storeItemQueryWrapper = new QueryWrapper<>();
        storeItemQueryWrapper.eq("product_id",id);
        storeItemQueryWrapper.gt("quantity",0);
        List<StoreItem> storeItems = storeItemDao.selectList(storeItemQueryWrapper);
        if(!storeItems.isEmpty()){
            throw new BaseException(BaseExceptionEnum.PRODUCT_CANT_DELETE_TWO);
        }
        QueryWrapper<SaleNoteItem> saleNoteItemQueryWrapper = new QueryWrapper<>();
        saleNoteItemQueryWrapper.eq("product_id",id);
        List<SaleNoteItem> saleNoteItems = saleNoteItemDao.selectList(saleNoteItemQueryWrapper);

        QueryWrapper<AdjustmentOrderItem> adjustmentOrderItemQueryWrapper = new QueryWrapper<>();
        adjustmentOrderItemQueryWrapper.eq("product_id",id);
        List<AdjustmentOrderItem> adjustmentOrderItems = adjustmentOrderItemDao.selectList(adjustmentOrderItemQueryWrapper);

        QueryWrapper<PurchaseOrderItem> purchaseOrderItemQueryWrapper = new QueryWrapper<>();
        purchaseOrderItemQueryWrapper.eq("product_id",id);
        List<PurchaseOrderItem> purchaseOrderItems = purchaseOrderItemDao.selectList(purchaseOrderItemQueryWrapper);

        if(!saleNoteItems.isEmpty()||!adjustmentOrderItems.isEmpty()||!purchaseOrderItems.isEmpty()){
            throw new BaseException(BaseExceptionEnum.PRODUCT_CANT_DELETE);
        }
        if(productDao.deleteById(id)<=0)throw new BaseException(BaseExceptionEnum.PRODUCT_DELETE_ERROR);
    }

    @Override
    public void update(ProductUpdateDto productUpdateDto) throws BaseException {
        if(productDao.updateById(productUpdateDto.toProduct())<=0){
            throw new BaseException(BaseExceptionEnum.PRODUCT_UPDATE_ERROR);
        }
    }
}
