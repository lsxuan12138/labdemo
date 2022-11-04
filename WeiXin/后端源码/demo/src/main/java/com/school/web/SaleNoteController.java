package com.school.web;


import com.school.entity.Area;
import com.school.entity.SaleNote;
import com.school.service.AreaService;
import com.school.service.SaleNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salenote")
public class SaleNoteController {
    @Autowired
    private SaleNoteService service;
    @RequestMapping(value = "/listsalenote",method = RequestMethod.GET)
    public Map<String,Object> getSaleNoteList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNote> saleNoteList=service.querySaleNote();
        modelMap.put("saleNoteList",saleNoteList);
        return  modelMap;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Map<String,Object>  findById(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        SaleNote  saleNote=service.findById(id);
        modelMap.put("saleNote",saleNote);
        return  modelMap;
    }

    @RequestMapping(value = "/findByClientId",method = RequestMethod.GET)
    public Map<String,Object>  findByClientId(Integer clientId){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNote>  saleNoteList = service.findByClientId(clientId);
        modelMap.put("saleNoteList",saleNoteList);
        return  modelMap;
    }

    @RequestMapping(value = "/addSaleNote",method = RequestMethod.POST)
    public Map<String,Object>  addSaleNote(@RequestBody SaleNote saleNote){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertSaleNote(saleNote));
        return  modelMap;
    }


    @RequestMapping(value = "/updateSaleNote",method = RequestMethod.POST)
    public Map<String,Object>  updateSaleNote(@RequestBody SaleNote saleNote){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.updateSaleNote(saleNote));
        return  modelMap;
    }
    //删除地区信息
    @RequestMapping(value = "/deleteSaleNote",method = RequestMethod.GET)
    public Map<String,Object>  deleteSaleNote(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteSaleNote(id));
        return  modelMap;
    }
}
