package com.example.labdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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
    @GetMapping("/")
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
        return new ModelAndView("库存管理");
    }
    @GetMapping("/getSellNotes")
    public ModelAndView getSellNotes(){
        return new ModelAndView("销售业务管理");
    }
}