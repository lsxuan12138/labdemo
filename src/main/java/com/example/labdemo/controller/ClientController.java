package com.example.labdemo.controller;

import com.example.labdemo.domain.Client;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    /**
     * 获取所有批发客户
     * @return 批发客户overview页面
     */
    @PreAuthorize("hasAnyAuthority('client:select')")
    @GetMapping("/wholesales")
    public ModelAndView getWholesales(){
        ModelAndView modelAndView = new ModelAndView("client_info_overview_wholesale");
        modelAndView.getModelMap().addAttribute("wholesales",clientService.getWholesales());
        return modelAndView;
    }
    /**
     * 获取所有零售客户
     * @return 批发客户overview页面
     */
    @PreAuthorize("hasAnyAuthority('client:select')")
    @GetMapping("/retails")
    public ModelAndView getRetails(){
        ModelAndView modelAndView = new ModelAndView("client_info_overview_retail");
        modelAndView.getModelMap().addAttribute("retails",clientService.getRetails());
        return modelAndView;
    }

    /**
     * 所有客户
     * @return 所有客户overview页面
     */
    @PreAuthorize("hasAnyAuthority('client:select')")
    @GetMapping("/all")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("client_info_overview_all");
        List<Client> clientList = clientService.getAll();
        modelAndView.getModelMap().addAttribute("clientList",clientList);
        return modelAndView;
    }

    /**
     * 删除客户
     * @param id 用户id
     * @return
     */
    @PreAuthorize("hasAnyAuthority('client:delete')")
    @PostMapping("/delete")
    @ResponseBody
    public ResultResponse delete(@RequestParam("id")Long id){
        clientService.deleteById(id);
        return ResultResponse.success();
    }

    /**
     * 添加客户
     * @param name 名字
     * @param type 种类0/1
     * @return
     */
    @PreAuthorize("hasAnyAuthority('client:insert')")
    @PostMapping("/add")
    @ResponseBody
    public ResultResponse add(@RequestParam("name")String name,@RequestParam("type")String type){
        return ResultResponse.success(clientService.add(name,type));
    }

    /**
     * 更新客户信息
     * @param id 用户id
     * @param name 名称
     * @param type 种类
     * @return
     */
    @PreAuthorize("hasAnyAuthority('client:update')")
    @PostMapping("/update")
    @ResponseBody
    public ResultResponse update(@RequestParam("id")Long id,@RequestParam("name")String name,@RequestParam("type")String type){
        clientService.update(id,name,type);
        return ResultResponse.success();
    }
}
