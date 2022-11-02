package com.school.web;


import com.school.entity.Area;
import com.school.entity.User;
import com.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService service;

    @RequestMapping(value = "/findbyusername",method = RequestMethod.GET)
    public Map<String,Object> findByUsername(String username){
        Map<String,Object> modelMap=new HashMap<>();
        User user=service.findByUsername(username);
        modelMap.put("user",user);
        return  modelMap;
    }
}
