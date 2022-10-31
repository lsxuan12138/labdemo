package com.school.web;

import com.school.entity.Area;
import com.school.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService service;
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    public Map<String,Object> getAreaList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<Area> areaList=service.queryArea();
        modelMap.put("areaList",areaList);
        return  modelMap;
    }

    @RequestMapping(value = "/findById",method = RequestMethod.GET)
    public Map<String,Object>  findById(Integer areaId){
        Map<String,Object> modelMap=new HashMap<>();
        Area  area=service.findByAreaId(areaId);
        modelMap.put("area",area);
        return  modelMap;
    }

    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    public Map<String,Object>  addArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertArea(area));
        return  modelMap;
    }


    @RequestMapping(value = "/updateArea",method = RequestMethod.POST)
    public Map<String,Object>  updateArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.updateArea(area));
        return  modelMap;
    }
    //删除地区信息
    @RequestMapping(value = "/deleteArea",method = RequestMethod.GET)
    public Map<String,Object>  deleteArea(Integer areaId){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteArea(areaId));
        return  modelMap;
    }
}
