package com.school.service.impl;

import com.school.dao.AreaDao;
import com.school.dao.ProductDao;
import com.school.entity.Area;
import com.school.entity.Product;
import com.school.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> queryProduct() {
        System.out.println("打印出product来看看");
        System.out.println(productDao.queryProduct().get(0).getId());
        System.out.println("打印出product来看看");
        return productDao.queryProduct(); }

    @Override
    public Product findByName(String name) {return productDao.findByName(name); }

    @Transactional
    @Override
    public int insertProduct(Product product) {
        if(product.getName()!=null&&!"".equals(product.getName())){
            product.setCreateTime(new Date());
            try {
                int result=productDao.insertProduct(product);
                if (result>0){
                    return 1;
                }else {
                    throw  new RuntimeException("插入失败");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入取余信息失败失败"+e.getMessage());
            }
        }else {
            throw  new RuntimeException("插入的值有空的");
        }
        /*  return areaDao.insertArea(area);*/
    }

    @Override
    public int updateProduct(Product product) {return productDao.updateProduct(product);}

    @Override
    public int deleteProduct(int id) { return productDao.deleteProduct(id);
    }
}
