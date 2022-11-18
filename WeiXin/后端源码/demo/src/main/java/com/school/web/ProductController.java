package com.school.web;


import com.school.entity.Product;
import com.school.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService service;
    @RequestMapping(value = "/listproduct",method = RequestMethod.GET)
    public Map<String,Object> getProductList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<Product> productList=service.queryProduct();
        modelMap.put("productList",productList);
        return  modelMap;
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    public Map<String,Object>  findByName(String name){
        Map<String,Object> modelMap=new HashMap<>();
        List<Product> productList = service.findByName(name);
        modelMap.put("productList",productList);
        return  modelMap;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Map<String,Object>  findById(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        Product product = service.findById(id);
        modelMap.put("product",product);
        return  modelMap;
    }

    @RequestMapping(value = "/addProduct",method = RequestMethod.POST)
    public Map<String,Object>  addProduct(@RequestBody Product product){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertProduct(product));
        return  modelMap;
    }


    @RequestMapping(value = "/updateProduct",method = RequestMethod.POST)
    public Map<String,Object>  updateProduct(@RequestBody Product product){
        Map<String,Object> modelMap=new HashMap<>();
        System.out.println("零售价格"+product.getRetailPrice());
        System.out.println("批发价格"+product.getWholesalePrice());
        modelMap.put("success",service.updateProduct(product));
        return  modelMap;
    }
    //删除地区信息
    @RequestMapping(value = "/deleteProduct",method = RequestMethod.GET)
    public Map<String,Object>  deleteProduct(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteProduct(id));
        return  modelMap;
    }
}
