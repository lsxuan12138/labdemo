package com.example.labdemo.controller;

import com.example.labdemo.constants.UserContants;
import com.example.labdemo.domain.User;
import com.example.labdemo.dto.StoreAddDto;
import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.StoreService;
import com.example.labdemo.service.UserService;
import com.example.labdemo.vo.store.StoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAuthority('store:read')")
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
     * @param storeAddDto
     * @return
     */
    @PreAuthorize("hasAuthority('store:insert')")
    @PostMapping("product/storeHouseAdd")
    @ResponseBody
    public ResultResponse addStore(@RequestBody StoreAddDto storeAddDto){
        return ResultResponse.success(storeService.addStore(storeAddDto));
    }

    /**
     * 全部库存界面（所有仓库总库存）
     * @return 全部库存界面
     */
    @PreAuthorize("hasAuthority('store:read')")
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
    @PreAuthorize("hasAuthority('store:read')")
    @GetMapping("/product/storeHouseDetails")
    public ModelAndView storeDetail(@PathParam("id") Long id){
        ModelAndView modelAndView = new ModelAndView("storehouse_details");
        modelAndView.getModelMap().addAttribute("storeHouseDetails",storeService.selectDetailVo(id));
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('store:delete')")
    @PostMapping("/product/storeHouseDelete")
    @ResponseBody
    public ResultResponse storeDelete(@RequestParam Long id){
        storeService.deleteStore(id);
        return ResultResponse.success();
    }
}
