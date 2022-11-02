package com.school.web;


import com.school.entity.Area;
import com.school.entity.Product;
import com.school.service.AreaService;
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
        System.out.println("打印........1");
        Map<String,Object> modelMap=new HashMap<>();
        System.out.println("打印........2");
        List<Product> productList=service.queryProduct();
        System.out.println("打印........3");
        modelMap.put("productList",productList);
        System.out.println("打印!!!!!!!");
        System.out.print(modelMap.keySet());
        System.out.println("一下");
        return  modelMap;
    }

    @RequestMapping(value = "/findByName",method = RequestMethod.GET)
    public Map<String,Object>  findByName(String name){
        Map<String,Object> modelMap=new HashMap<>();
        Product  product=service.findByName(name);
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
