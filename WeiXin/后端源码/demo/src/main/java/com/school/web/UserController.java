package com.school.web;


import com.school.entity.User;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/listuser",method = RequestMethod.GET)
    public Map<String,Object> getUserList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<User> userList=service.queryUser();
        modelMap.put("userList",userList);
        return  modelMap;
    }

    @RequestMapping(value = "/findbyid",method = RequestMethod.GET)
    public Map<String,Object> findById(int id){
        Map<String,Object> modelMap=new HashMap<>();
        User user=service.findById(id);
        modelMap.put("user",user);
        return  modelMap;
    }

    @RequestMapping(value = "/findbyname",method = RequestMethod.GET)
    public Map<String,Object> findByName(String name){
        Map<String,Object> modelMap=new HashMap<>();
        List<User> userList=service.findByName(name);
        modelMap.put("userList",userList);
        return  modelMap;
    }
    @RequestMapping(value = "/findbyaccount",method = RequestMethod.GET)
    public Map<String,Object> findByAccount(String account){
        Map<String,Object> modelMap=new HashMap<>();
        User user=service.findByAccount(account);
        modelMap.put("user",user);
        return  modelMap;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Map<String,Object>  addUser(@RequestBody User user){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertUser(user));
        return  modelMap;
    }


    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public Map<String,Object>  updateUser(@RequestBody User user){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.updateUser(user));
        return  modelMap;
    }
    //删除地区信息
    @RequestMapping(value = "/deleteUser",method = RequestMethod.GET)
    public Map<String,Object>  deleteUser(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteUser(id));
        return  modelMap;
    }

}
