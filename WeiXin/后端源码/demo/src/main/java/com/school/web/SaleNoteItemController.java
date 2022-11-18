package com.school.web;

import com.school.entity.SaleNoteItem;
import com.school.service.SaleNoteItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salenoteitem")
public class SaleNoteItemController {
    @Autowired
    private SaleNoteItemService service;

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Map<String,Object> findById(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        SaleNoteItem saleNoteItem=service.findById(id);
        modelMap.put("saleNoteItem",saleNoteItem);
        return  modelMap;
    }

    @RequestMapping(value = "/findBySaleNoteId",method = RequestMethod.GET)
    public Map<String,Object>  findBySaleNoteId(Integer saleNoteId){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNoteItem> saleNoteItemList = service.findBySaleNoteId(saleNoteId);
        modelMap.put("saleNoteItemList",saleNoteItemList);
        return  modelMap;
    }
    @RequestMapping(value = "/addSaleNoteItem",method = RequestMethod.POST)
    public Map<String,Object>  addSaleNoteItem(@RequestBody SaleNoteItem saleNoteItem){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertSaleNoteItem(saleNoteItem));
        return  modelMap;
    }
    @RequestMapping(value = "/updateSaleNoteItem",method = RequestMethod.POST)
    public Map<String,Object>  updateSaleNoteItem(@RequestBody SaleNoteItem saleNoteItem){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.updateSaleNoteItem(saleNoteItem));
        return  modelMap;
    }
    @RequestMapping(value = "/deleteSaleNoteItem",method = RequestMethod.GET)
    public Map<String,Object>  deleteSaleNoteItem(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteSaleNoteItem(id));
        return  modelMap;
    }
}
