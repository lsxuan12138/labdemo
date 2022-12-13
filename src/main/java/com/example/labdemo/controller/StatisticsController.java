package com.example.labdemo.controller;

import com.example.labdemo.result.ResultResponse;
import com.example.labdemo.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView salesmanStatistic(){
        ModelAndView modelAndView = new ModelAndView("user_sale");
        modelAndView.getModelMap().addAttribute("salespersons",statisticsService.selectSalesmanStaticsVo());
        return modelAndView;
    }
    @GetMapping("/saleNote/client")
    public ModelAndView clientStatistic(){
        ModelAndView modelAndView = new ModelAndView("sale_note_client");
        modelAndView.getModelMap().addAttribute("clients",statisticsService.selectClientStaticsVo());
        return modelAndView;
    }


}
