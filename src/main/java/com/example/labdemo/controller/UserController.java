package com.example.labdemo.controller;

import com.example.labdemo.domain.Role;
import com.example.labdemo.dto.UserAddDto;
import com.example.labdemo.dto.UserChangeInfoDto;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.RoleService;
import com.example.labdemo.service.UserService;
import com.example.labdemo.vo.UserCtrlVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    @Autowired
    private RoleService roleService;

    /**
     * 首页
     * @return 首页
     */
    @GetMapping("/index")
    public ModelAndView start(){
        return new ModelAndView("index");
    }

    /**
     * 登录页面
     * @return 登录页面
     */
    @GetMapping("/user/login")
    public ModelAndView loginView(){
        return new ModelAndView("login");
    }

    /**
     * 登录请求
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @PostMapping("/user/loginPost")
    @ResponseBody
    public ResultResponse login(@RequestParam("username")String username,@RequestParam("password")String password){
        return userService.login(username,password);
    }

    /**
     * 注册页面
     * @return 注册页面
     */
    @GetMapping("/user/register")
    public ModelAndView register(){
        ModelAndView modelAndView = new ModelAndView("register");
        List<Role> roles = roleService.getAll();
        modelAndView.getModelMap().addAttribute("roles",roles);
        return modelAndView;
    }

    /**
     * 注册请求
     * @param userAddDto 封装请求
     * @return
     */
    @PostMapping("/user/adduser")
    @ResponseBody
    public ResultResponse adduser(@RequestBody UserAddDto userAddDto){
        userService.adduser(userAddDto);
        return ResultResponse.success();
    }

    /**
     * 退出登录
     * @return
     */
    @PostMapping("/user/quit")
    @ResponseBody
    public ResultResponse logout(){
        return userService.logout();
    }
    @PreAuthorize("hasAuthority('user:edit')")
    @GetMapping("/user/control")
    public ModelAndView controlUser(){
        ModelAndView modelAndView = new ModelAndView("user_active");
        List<UserCtrlVo> users = userService.selectAllUserVo();
        modelAndView.getModelMap().addAttribute("users",users);
        return modelAndView;
    }
    @PreAuthorize("hasAuthority('user:edit')")
    @PostMapping("/user/active")
    public ResultResponse activeUser(@RequestParam("id") Long id){
        userService.activeUser(id);
        return ResultResponse.success();
    }
    @GetMapping("/user/now")
    public ModelAndView userInfo(){
        ModelAndView modelAndView = new ModelAndView("user_now");
        modelAndView.getModelMap().addAttribute("user",userService.getUserInfo());
        return modelAndView;
    }
    @PostMapping("/user/changeUser")
    @ResponseBody
    public ResultResponse changeUserInfo(@RequestBody UserChangeInfoDto dto){
        userService.changeUserInfo(dto);
        return ResultResponse.success();
    }

}
