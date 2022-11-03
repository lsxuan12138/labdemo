package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.domain.Client;
import com.example.labdemo.domain.Product;
import com.example.labdemo.mapper.ClientDao;
import com.example.labdemo.service.ClientService;
import com.example.labdemo.util.BaseException;
import com.example.labdemo.util.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;
    @Override
    public List<Client> getAll() {
        List<Client> list = new ArrayList<>();
        try {
            list = clientDao.selectList(null);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return list;
    }

    @Override
    public int deleteById(Long id) {
        int ret = clientDao.deleteById(id);
        if (ret != 1) throw new RuntimeException();
        return ret;
    }

    @Override
    public Client add(String name, String type) throws BaseException {
        type = changeType(type);
        if(!clientDao.selectList(new QueryWrapper<Client>().eq("name",name)).isEmpty()){
            throw new BaseException(ResultEnum.CLIENT_NAME_IS_REPEATED);
        }
        Client client = new Client(name,type);
        if(clientDao.insert(client)<=0){
            throw new BaseException(ResultEnum.CLIENT_INSERT_ERROR);
        }
        return clientDao.selectOne(new QueryWrapper<Client>().eq("name",name));
    }

    @Override
    public List<Client> find(String key) throws BaseException {
        List<Client> clients = null;
        try {
            QueryWrapper<Client> wrapper = new QueryWrapper<>();
            wrapper.clear();
            wrapper.like("name", key);
            clients = clientDao.selectList(wrapper);

        } catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
        return clients;
    }

    @Override
    public void update(Long id, String name, String type) throws BaseException {
        Client client = new Client();
        client.setId(id);
        client.setName(name);
        client.setType(changeType(type));
        try {
            clientDao.updateById(client);
        }catch (Exception e) {
            throw new BaseException(e.getMessage());
        }
    }

    private static final Map<String,String> TYPE_MAP;
    static {
        TYPE_MAP = new HashMap<>();
        TYPE_MAP.put("0","固定客户");
        TYPE_MAP.put("1","零售客户");
    }
    private static String changeType(String type){
        return TYPE_MAP.get(type);

    }

}
