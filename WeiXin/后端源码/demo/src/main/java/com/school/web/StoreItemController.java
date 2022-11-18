package com.school.web;


import com.school.entity.Product;
import com.school.entity.SaleNoteItem;
import com.school.entity.StoreItem;
import com.school.service.SaleNoteItemService;
import com.school.service.StoreItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/storeitem")
public class StoreItemController {
    @Autowired
    private StoreItemService service;

    @RequestMapping(value = "/liststoreitem",method = RequestMethod.GET)
    public Map<String,Object> getStoreItemList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<StoreItem> storeItemList=service.queryStoreItem();
        modelMap.put("storeItemList",storeItemList);
        return  modelMap;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Map<String,Object> findById(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        StoreItem storeItem=service.findById(id);
        modelMap.put("storeItem",storeItem);
        return  modelMap;
    }
    @RequestMapping(value = "/findByStoreId",method = RequestMethod.GET)
    public Map<String,Object>  findByStoreId(Integer storeId){
        Map<String,Object> modelMap=new HashMap<>();
        List<StoreItem> storeItemList = service.findByStoreId(storeId);
        modelMap.put("storeItemList",storeItemList);
        return  modelMap;
    }
    @RequestMapping(value = "/addStoreItem",method = RequestMethod.POST)
    public Map<String,Object>  addStoreItem(@RequestBody StoreItem storeItem){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertStoreItem(storeItem));
        return  modelMap;
    }
    @RequestMapping(value = "/updateStoreItem",method = RequestMethod.POST)
    public Map<String,Object>  updateStoreItem(@RequestBody StoreItem storeItem){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.updateStoreItem(storeItem));
        return  modelMap;
    }
    @RequestMapping(value = "/deleteStoreItem",method = RequestMethod.GET)
    public Map<String,Object>  deleteStoreItem(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteStoreItem(id));
        return  modelMap;
    }
    @RequestMapping(value = "/sub",method = RequestMethod.GET)
    public Map<String,Object>  sub(Integer id,Integer num){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.subStoreItem(id,num));
        return  modelMap;
    }
    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Map<String,Object>  add(Integer id,Integer num){
        Map<String,Object> modelMap=new HashMap<>();
        System.out.println(id);
        System.out.println(num);
        modelMap.put("success",service.addStoreItem(id,num));
        return  modelMap;
    }
}
