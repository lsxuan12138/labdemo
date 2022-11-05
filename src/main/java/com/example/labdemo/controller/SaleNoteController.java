package com.example.labdemo.controller;

import com.example.labdemo.domain.Client;
import com.example.labdemo.domain.Product;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.dto.SaleNoteDetailDto;
import com.example.labdemo.service.ClientService;
import com.example.labdemo.service.ProductService;
import com.example.labdemo.service.SaleNoteService;
import com.example.labdemo.util.BaseException;
import com.example.labdemo.util.Result;
import com.example.labdemo.vo.SaleNoteDetailVo;
import com.example.labdemo.vo.SaleNoteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/saleNote")
public class SaleNoteController {
    @Autowired
    private SaleNoteService saleNoteService;
    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ModelAndView getAll() {
        System.out.println("-----请求----");
        ModelAndView modelAndView = new ModelAndView("sale_note_manage");

        List<SaleNoteVo> saleNotes = saleNoteService.getAllVo();
        List<Client> clients = clientService.getAll();
        System.out.println("-----获取数据----");
        modelAndView.getModelMap().addAttribute("clients", clients);
        modelAndView.getModelMap().addAttribute("saleNotes", saleNotes);
        return modelAndView;
    }
    @PostMapping("/find")
    @ResponseBody
    public Result find(@RequestParam("keyword") String keyword){
        System.out.println("-------请求-------");
        List<SaleNoteVo> saleNoteVos = saleNoteService.find(keyword);
        System.out.println(saleNoteVos);
        return new Result(saleNoteVos);
    }
    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestParam("clientId")String clientIdStr){
        SaleNoteVo saleNoteVo = null;
        Long clientId  = Long.parseLong(clientIdStr);
        saleNoteVo = saleNoteService.add(clientId);
        return new Result(saleNoteVo);
    }

    @GetMapping("/detail")
    public ModelAndView getDetail(@RequestParam("id")String idStr){
        Long id = Long.parseLong(idStr);
        List<Product> productList = productService.getAllProduct();
        SaleNoteDetailVo detail = saleNoteService.getDetail(id);
        ModelAndView modelAndView = new ModelAndView("order_details");
        modelAndView.getModelMap().addAttribute("productList",productList);
        modelAndView.getModelMap().addAttribute("detail",detail);
        return modelAndView;
    }
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestBody SaleNoteDetailDto saleNoteDetailDto){
        saleNoteService.update(saleNoteDetailDto);
        return new Result();
    }

    @PostMapping("/audit")
    @ResponseBody
    public Result audit(@RequestParam("id")Long id,@RequestParam("stage") String stage){
        try {
            saleNoteService.audio(id,stage);
        } catch (BaseException e) {
            return new Result(e);
        }
        return new Result();
    }
    @PostMapping("/collectMoney")
    @ResponseBody
    public Result collectMoney(@RequestParam("id")Long id,@RequestParam("stage") String stage){
        try {
            saleNoteService.collectMoney(id,stage);
        } catch (BaseException e) {
            return new Result(e);
        }
        return new Result();
    }
    @PostMapping("/returnGoods")
    @ResponseBody
    public Result returnGoods(@RequestParam("id")Long id,@RequestParam("stage") String stage){
        try {
            saleNoteService.returnGoods(id,stage);
        } catch (BaseException e) {
            return new Result(e);
        }
        return new Result();
    }
}
