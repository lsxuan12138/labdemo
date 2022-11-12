package com.example.labdemo.controller;

import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-11 20:21
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user/login")
    @ResponseBody
    public ResultResponse login(@RequestParam("username")String username,@RequestParam("password")String password){
        //return loginServcie.login(user);
        return userService.login(username,password);
    }
    @PreAuthorize("hasAnyAuthority('client:insert')")
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
