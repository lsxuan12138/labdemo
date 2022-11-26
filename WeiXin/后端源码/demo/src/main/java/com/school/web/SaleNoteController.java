package com.school.web;


import com.school.entity.SaleNote;
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
        SaleNote saleNote=service.findById(id);
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

    @RequestMapping(value = "/waitList",method = RequestMethod.GET)
    public Map<String,Object> waitList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNote> saleNoteList=service.waitList();
        modelMap.put("waitList",saleNoteList);
        return  modelMap;
    }

    @RequestMapping(value = "/checkList",method = RequestMethod.GET)
    public Map<String,Object> checkList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNote> saleNoteList=service.checkList();
        modelMap.put("checkList",saleNoteList);
        return  modelMap;
    }

    @RequestMapping(value = "/chargeList",method = RequestMethod.GET)
    public Map<String,Object> chargeList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNote> saleNoteList=service.chargeList();
        modelMap.put("chargeList",saleNoteList);
        return  modelMap;
    }

    @RequestMapping(value = "/refundList",method = RequestMethod.GET)
    public Map<String,Object> refundList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<SaleNote> saleNoteList=service.refundList();
        modelMap.put("refundList",saleNoteList);
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

    @RequestMapping(value = "/submitSaleNote",method = RequestMethod.POST)
    public Map<String,Object>  submitSaleNote(@RequestBody SaleNote saleNote){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.submitSaleNote(saleNote));
        return  modelMap;
    }

    @RequestMapping(value = "/checkSaleNote",method = RequestMethod.POST)
    public Map<String,Object>  checkSaleNote(@RequestBody SaleNote saleNote){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.checkSaleNote(saleNote));
        return  modelMap;
    }

    @RequestMapping(value = "/chargeSaleNote",method = RequestMethod.POST)
    public Map<String,Object>  chargeSaleNote(@RequestBody SaleNote saleNote){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.chargeSaleNote(saleNote));
        return  modelMap;
    }

    @RequestMapping(value = "/refundSaleNote",method = RequestMethod.POST)
    public Map<String,Object>  refundSaleNote(@RequestBody SaleNote saleNote){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.refundSaleNote(saleNote));
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
