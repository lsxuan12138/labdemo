package com.example.labdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.labdemo.constants.ClientConstants;
import com.example.labdemo.domain.Client;
import com.example.labdemo.domain.SaleNote;
import com.example.labdemo.mapper.ClientDao;
import com.example.labdemo.mapper.SaleNoteDao;
import com.example.labdemo.result.BaseException;
import com.example.labdemo.result.BaseExceptionEnum;
import com.example.labdemo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.labdemo.constants.ClientConstants.changeType;

@Service("clientService")
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientDao clientDao;
    @Autowired
    SaleNoteDao saleNoteDao;
    @Override
    public List<Client> getAll() {
        return clientDao.selectList(null);
    }

    @Override
    public void deleteById(Long id) {
        Client client = clientDao.selectById(id);
        if(client==null)throw new BaseException(BaseExceptionEnum.CLIENT_NOT_EXIST);
        QueryWrapper<SaleNote> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("client_id",id);
        List<SaleNote> saleNotes = saleNoteDao.selectList(queryWrapper);
        if(!saleNotes.isEmpty()){
            throw new BaseException(BaseExceptionEnum.CLIENT_CANT_DELETE);
        }
        if(clientDao.deleteById(id)<=0) throw new BaseException(BaseExceptionEnum.CLIENT_DELETE_ERROR);
    }

    @Override
    public Client add(String name, String type) {
        type = changeType(type);
        if (type==null)type=ClientConstants.TYPE_RETAILS;
        Client client = new Client(name,type);
        clientDao.insert(client);
        return client;
    }

//    @Override
//    public List<Client> find(String key) throws BaseException {
//        List<Client> clients = null;
//        try {
//            QueryWrapper<Client> wrapper = new QueryWrapper<>();
//            wrapper.clear();
//            wrapper.like("name", key);
//            clients = clientDao.selectList(wrapper);
//
//        } catch (Exception e) {
//            throw new BaseException(e.getMessage());
//        }
//        return clients;
//    }
//
    @Override
    public void update(Long id, String name, String type) throws BaseException {
        Client client = new Client(id,name,changeType(type));
        if(clientDao.updateById(client)<=0)throw new BaseException();
    }

    @Override
    public List<Client> getWholesales() {
        QueryWrapper<Client> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type", ClientConstants.TYPE_WHOLESALES);
        return clientDao.selectList(queryWrapper);
    }

    @Override
    public List<Client> getRetails() {
        QueryWrapper<Client> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("type",ClientConstants.TYPE_RETAILS);
        return clientDao.selectList(queryWrapper);
    }
}
