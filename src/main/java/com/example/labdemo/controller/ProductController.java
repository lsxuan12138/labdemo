package com.example.labdemo.controller;


import com.example.labdemo.domain.Product;
import com.example.labdemo.dto.ProductAddDto;
import com.example.labdemo.dto.ProductUpdateDto;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.ProductService;
import com.example.labdemo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    StoreService storeService;

    @PreAuthorize("hasAuthority('product:select')")
    @GetMapping("/product/all")
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("products_overview");
        ModelMap modelMap = modelAndView.getModelMap();
        List<Product> products = productService.getAllProduct();
        modelMap.addAttribute("products", products);
        return modelAndView;
    }
//    @PostMapping("/purchase")
//    @ResponseBody
//    public ResultResponse purchaseProduct(@RequestParam("id") String idStr, @RequestParam("quantity") String quantityStr) {
//        int ret = 0;
//        try {
//            Long id = Long.parseLong(idStr);
//            Long quantity = Long.parseLong(quantityStr);
//            ret = productService.purchaseProduct(id, quantity);
//
//        } catch (NumberFormatException e) {
//            return new Result(ResultEnum.NUMBER_FORMAT_ERROR);
//        } catch (Exception e) {
//            return new Result(ResultEnum.SEVER_INTERVAL_ERROR);
//        }
//        return new Result(ret);
//    }
//
//    @PostMapping("/findInStore")
//    public ModelAndView findInStore(@ModelAttribute("searchInfo") SearchDto searchDto) {
//        ModelAndView modelAndView = new ModelAndView("store_manage");
//        List<Product> products = null;
//        try {
//            products = productService.find(searchDto.getKey());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ModelMap modelMap = modelAndView.getModelMap();
//        modelMap.addAttribute("searchInfo",new SearchDto(""));
//        modelMap.addAttribute("products", products);
//        modelAndView.getModelMap().addAttribute("keyword",searchDto.getKey());
//        return modelAndView;
//    }
//    @PostMapping("/find")
//    public ModelAndView find(@ModelAttribute("searchInfo") SearchDto searchDto) {
//        ModelAndView modelAndView = new ModelAndView("products_overview");
//        List<Product> products = null;
//        try {
//            products = productService.find(searchDto.getKey());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ModelMap modelMap = modelAndView.getModelMap();
//        modelMap.addAttribute("searchInfo",new SearchDto(""));
//        modelMap.addAttribute("products", products);
//        modelAndView.getModelMap().addAttribute("keyword",searchDto.getKey());
//        return modelAndView;
//    }

    /**
     * 添加product
     * @param productAddDto 封装请求
     * @return 添加的product
     */
    @PreAuthorize("hasAuthority('product:insert')")
    @PostMapping("/product/add")
    @ResponseBody
    public ResultResponse add(@RequestBody ProductAddDto productAddDto){
        return ResultResponse.success(productService.add(productAddDto));
    }

    /**
     * 删除product
     * @param id 货品id
     * @return
     */
    @PreAuthorize("hasAuthority('product:delete')")
    @PostMapping("/product/delete")
    @ResponseBody
    public ResultResponse delete(@RequestParam("id")Long id){
        productService.deleteById(id);
        return ResultResponse.success();
    }

    /**
     * 更新产品信息
     * @param productUpdateDto 封装请求
     * @return 更新后的信息
     * @throws BaseException
     */
    @PreAuthorize("hasAuthority('product:update')")
    @PostMapping("/product/update")
    @ResponseBody
    public ResultResponse update(@RequestBody ProductUpdateDto productUpdateDto) throws BaseException {
        productService.update(productUpdateDto);
        return  ResultResponse.success();
    }
}