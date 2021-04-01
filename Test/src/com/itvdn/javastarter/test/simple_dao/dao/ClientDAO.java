package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public interface ClientDAO {

    List<Client> getAll();

    int insert(Client client);

    int delete(Client client);

    Client getById(int id);

}
