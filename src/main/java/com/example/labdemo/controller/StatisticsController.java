package com.example.labdemo.controller;

import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.StatisticsService;
import com.example.labdemo.vo.statistic.BusinessStatisticsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

/**
 * TODO
 *
 * @author: lsxuan
 * @email: 1146887979@qq.com
 * @create: 2022-12-13 19:30
 */
@Controller
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;
    @GetMapping("/user/sale")
    @PreAuthorize("hasAuthority('statistics:read')")
    public ModelAndView salesmanStatistic(){
        ModelAndView modelAndView = new ModelAndView("user_sale");
        modelAndView.getModelMap().addAttribute("salespersons",statisticsService.selectSalesmanStaticsVo());
        return modelAndView;
    }
    @GetMapping("/saleNote/client")
    @PreAuthorize("hasAuthority('statistics:read')")
    public ModelAndView clientStatistic(){
        ModelAndView modelAndView = new ModelAndView("sale_note_client");
        modelAndView.getModelMap().addAttribute("clients",statisticsService.selectClientStaticsVo());
        return modelAndView;
    }
    @GetMapping("/saleNote/product")
    @PreAuthorize("hasAuthority('statistics:read')")
    public ModelAndView productStatistic(){
        ModelAndView modelAndView = new ModelAndView("sale_note_product");
        modelAndView.getModelMap().addAttribute("products",statisticsService.selectProductStatisticsVo());
        return modelAndView;
    }
    @GetMapping("/saleNote/receive")
    @PreAuthorize("hasAuthority('statistics:read')")
    public ModelAndView clientPaymentStatistic(){
        ModelAndView modelAndView = new ModelAndView("sale_note_receive");
        modelAndView.getModelMap().addAttribute("clients",statisticsService.selectClientPaymentStatisticsVos());
        return modelAndView;
    }
    @GetMapping("/company")
    @PreAuthorize("hasAuthority('statistics:read')")
    public ModelAndView businessStatistics(){
        ModelAndView modelAndView = new ModelAndView("company");
        BusinessStatisticsVo vo = statisticsService.selectBusinessStatisticsVo();
        ModelMap map = modelAndView.getModelMap();
        map.addAttribute("purchaseAmounts",vo.getPurchaseAmounts());
        map.addAttribute("saleAmounts",vo.getSaleAmounts());
        map.addAttribute("profits",vo.getProfits());
        map.addAttribute("storeAmounts",vo.getStoreAmounts());
        return modelAndView;
    }
}
