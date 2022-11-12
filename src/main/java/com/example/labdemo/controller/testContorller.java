package com.example.labdemo.controller;

import com.example.labdemo.domain.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-10-29 16:33
 */
@RestController
public class testContorller
{
    @PreAuthorize("hasAnyAuthority('user:read')")
    @PostMapping("/index")
    public ModelAndView start(){
        return new ModelAndView("index");
    }

    @GetMapping("/getClients")
    public ModelAndView getClients(){
        return new ModelAndView("client_info_overview");
    }
    @GetMapping("/getProducts")
    public ModelAndView getProducts(){
        return new ModelAndView("products_overview");
    }
    @GetMapping("/getStore")
    public ModelAndView getStore(){
        ModelAndView modelAndView = new ModelAndView("store_manage");

        ModelMap modelMap = modelAndView.getModelMap();

        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setId(1L);
        product1.setName("测试数据1");
        products.add(product1);
        Product product2 = new Product();
        product2.setId(2L);
        product2.setName("测试数据2");

        products.add(product2);
        modelMap.addAttribute("products",products);
        return modelAndView;
    }
    @GetMapping("/getSellNotes")
    public ModelAndView getSellNotes(){
        return new ModelAndView("sale_note_manage");
    }

    @GetMapping("/getOrderDetail")
    public ModelAndView getOrderDetail(){
        return new ModelAndView("order_details");
    }
}