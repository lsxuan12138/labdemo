package com.example.labdemo.controller;

import com.example.labdemo.constants.UserContants;
import com.example.labdemo.domain.User;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.service.UserService;
import com.example.labdemo.vo.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-11-13 19:42
 */
@Controller

public class StoreController {
    @Autowired
    UserService userService;
    @Autowired
    StoreService storeService;

    /**
     *仓库overview页面
     * @return 仓库overview页面
     */
    @GetMapping("product/storeHouse")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView("storehouse");
        List<User> owners = userService.selectByRole(UserContants.ROLE_OWNER);
        List<StoreVo> storeVos = storeService.selectAllVo();
        modelAndView.getModelMap().addAttribute("users",owners);
        modelAndView.getModelMap().addAttribute("storehouses",storeVos);
        return modelAndView;
    }

    /**
     * 新建仓库
     * @param owner
     * @return
     */
    @PostMapping("product/storeHouseAdd")
    public ResultResponse addStore(@RequestBody String owner){
        return ResultResponse.success(storeService.addStore(owner));
    }

    /**
     * 全部库存界面（所有仓库总库存）
     * @return 全部库存界面
     */
    @GetMapping("/product/store")
    public ModelAndView getStore() {
        ModelAndView modelAndView = new ModelAndView("store_manage");
        ModelMap modelMap = modelAndView.getModelMap();
        modelMap.addAttribute("products",storeService.getAllStoreItem());
        return modelAndView;
    }

    /**
     * 某仓库库存
     * @param id 仓库id
     * @return
     */
    @GetMapping("/product/storeHouseDetails")
    public ModelAndView storeDetail(@PathParam("id") Long id){
        ModelAndView modelAndView = new ModelAndView("storehouse_details");
        modelAndView.getModelMap().addAttribute("storeHouseDetails",storeService.selectDetailVo(id));
        return modelAndView;
    }
}
