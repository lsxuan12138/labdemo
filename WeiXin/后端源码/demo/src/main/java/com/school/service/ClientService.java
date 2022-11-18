package com.school.service;

import com.school.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client> queryClient();
    List<Client> findByName(String name);
    Client findById(int id);
    int insertClient(Client client);
    int updateClient(Client client);
    int deleteClient(int id);
}
