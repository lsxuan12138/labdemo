package com.school.dao;

import com.school.entity.Client;
import com.school.entity.User;

import java.util.List;

public interface ClientDao {
    List<Client> queryClient();
    List<Client> findByName(String name);
    Client findById(int id);
    int insertClient(Client client);
    int updateClient(Client client);
    int deleteClient(int id);
}
