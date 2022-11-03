package com.example.labdemo.controller;


import com.example.labdemo.domain.Product;
import com.example.labdemo.dto.SearchDto;
import com.example.labdemo.service.ProductService;
import com.example.labdemo.util.Result;
import com.example.labdemo.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/all")
    public ModelAndView getStore() {
        ModelAndView modelAndView = new ModelAndView("store_manage");

        ModelMap modelMap = modelAndView.getModelMap();

        List<Product> products = null;
        try {
            products = productService.getAllProduct();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SearchDto searchInfo = new SearchDto("");
        modelMap.addAttribute("searchInfo",searchInfo);
        modelMap.addAttribute("products", products);
        modelAndView.getModelMap().addAttribute("keyword","商品信息");
        return modelAndView;
    }

    @PostMapping("/purchase")
    @ResponseBody
    public Result purchaseProduct(@RequestParam("id") String idStr, @RequestParam("quantity") String quantityStr) {
        int ret = 0;
        try {
            Long id = Long.parseLong(idStr);
            Long quantity = Long.parseLong(quantityStr);
            ret = productService.purchaseProduct(id, quantity);

        } catch (NumberFormatException e) {
            return new Result(ResultEnum.NUMBER_FORMAT_ERROR);
        } catch (Exception e) {
            return new Result(ResultEnum.SEVER_INTERVAL_ERROR);
        }
        return new Result(ret);
    }

    @PostMapping("/find")
    public ModelAndView find(@ModelAttribute("searchInfo") SearchDto searchDto) {
        ModelAndView modelAndView = new ModelAndView("store_manage");
        List<Product> products = null;
        try {
            products = productService.find(searchDto.getKey());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("searchInfo",new SearchDto(""));
        modelMap.addAttribute("products", products);
        modelAndView.getModelMap().addAttribute("keyword",searchDto.getKey());
        return modelAndView;
    }
}