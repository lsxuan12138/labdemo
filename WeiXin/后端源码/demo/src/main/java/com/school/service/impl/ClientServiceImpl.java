package com.school.service.impl;

import com.school.dao.ClientDao;
import com.school.entity.Client;
import com.school.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private ClientDao clientDao;

    @Override
    public List<Client> queryClient() {
        return clientDao.queryClient();
    }

    @Override
    public List<Client> findByName(String name) {
        return clientDao.findByName(name);
    }

    @Override
    public Client findById(int id) {
        return clientDao.findById(id);
    }

    @Override
    public int insertClient(Client client) {
        //if(client.getId()!=null&&!"".equals(client.getId())){
            try {
                int result=clientDao.insertClient(client);
                if (result>0){
                    return 1;
                }else {
                    throw  new RuntimeException("插入失败");
                }
            }catch (Exception e){
                throw  new RuntimeException("插入信息失败"+e.getMessage());
            }
        //}else {
        //    throw  new RuntimeException("插入的值有空的");
        // }
    }

    @Override
    public int updateClient(Client client) {
        return clientDao.updateClient(client);
    }

    @Override
    public int deleteClient(int id) {
        return clientDao.deleteClient(id);
    }
}
