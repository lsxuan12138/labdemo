//package com.example.labdemo.controller;
//
//import com.example.labdemo.domain.Client;
//import com.example.labdemo.dto.SearchDto;
//import com.example.labdemo.service.ClientService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/client")
//public class ClientController {
//    @Autowired
//    ClientService clientService;
//    @GetMapping("/all")
//    public ModelAndView getAll(){
//        ModelAndView modelAndView = new ModelAndView("client_info_overview");
//        List<Client> clientList = clientService.getAll();
//        SearchDto searchInfo = new SearchDto("");
//        modelAndView.getModelMap().addAttribute("searchInfo",searchInfo);
//        modelAndView.getModelMap().addAttribute("clientList",clientList);
//        modelAndView.getModelMap().addAttribute("keyword","客户信息");
//        return modelAndView;
//    }
//    @PostMapping("/delete")
//    @ResponseBody
//    public Result delete(@RequestParam("id")String idStr){
//        int ret =0;
//        try {
//            Long id = Long.parseLong(idStr);
//            ret=clientService.deleteById(id);
//        }catch (NumberFormatException e) {
//            return new Result(ResultEnum.NUMBER_FORMAT_ERROR);
//        } catch (Exception e) {
//            return new Result(ResultEnum.SEVER_INTERVAL_ERROR);
//        }
//        return new Result(ret);
//    }
//    @PostMapping("/add")
//    @ResponseBody
//    public Result add(@RequestParam("name")String name,@RequestParam("type")String type){
//        Client ret = null;
//        try {
//            ret = clientService.add(name,type);
//        } catch (BaseException e) {
//            return new Result(e);
//        }
//        return new Result(ret);
//    }
//    @PostMapping("/find")
//    public ModelAndView find(@ModelAttribute("searchInfo") SearchDto searchDto) {
//        ModelAndView modelAndView = new ModelAndView("client_info_overview");
//        List<Client> clients = null;
//        try {
//            clients = clientService.find(searchDto.getKey());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        ModelMap modelMap = modelAndView.getModelMap();
//        modelMap.addAttribute("searchInfo",new SearchDto(""));
//        modelMap.addAttribute("clientList",clients);
//        modelAndView.getModelMap().addAttribute("keyword",searchDto.getKey());
//        return modelAndView;
//    }
//    @PostMapping("/update")
//    @ResponseBody
//    public Result update(@RequestParam("id")String idStr,@RequestParam("name")String name,@RequestParam("type")String type){
//        try {
//            Long id = Long.parseLong(idStr);
//            clientService.update(id,name,type);
//        } catch (BaseException e) {
//            return new Result(e);
//        }
//        return new Result();
//    }
//}
