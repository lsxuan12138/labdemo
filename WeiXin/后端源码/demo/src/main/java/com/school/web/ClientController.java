package com.school.web;

import com.school.entity.Client;
import com.school.entity.User;
import com.school.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService service;

    @RequestMapping(value = "/listclient",method = RequestMethod.GET)
    public Map<String,Object> getClientList(){
        Map<String,Object> modelMap=new HashMap<>();
        List<Client> clientList=service.queryClient();
        modelMap.put("clientList",clientList);
        return  modelMap;
    }

    @RequestMapping(value = "/findbyname",method = RequestMethod.GET)
    public Map<String,Object> findByName(String name){
        Map<String,Object> modelMap=new HashMap<>();
        List<Client> clientList=service.findByName(name);
        modelMap.put("clientList",clientList);
        return  modelMap;
    }

    @RequestMapping(value = "/findbyid",method = RequestMethod.GET)
    public Map<String,Object> findById(int id){
        Map<String,Object> modelMap=new HashMap<>();
        Client client=service.findById(id);
        modelMap.put("client",client);
        return  modelMap;
    }

    @RequestMapping(value = "/addClient",method = RequestMethod.POST)
    public Map<String,Object>  addClient(@RequestBody Client client){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.insertClient(client));
        return  modelMap;
    }


    @RequestMapping(value = "/updateClient",method = RequestMethod.POST)
    public Map<String,Object>  updateClient(@RequestBody Client client){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.updateClient(client));
        return  modelMap;
    }
    //删除地区信息
    @RequestMapping(value = "/deleteClient",method = RequestMethod.GET)
    public Map<String,Object>  deleteClient(Integer id){
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",service.deleteClient(id));
        return  modelMap;
    }
}
