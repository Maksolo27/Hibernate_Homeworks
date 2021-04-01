package com.itvdn.javastarter.test.simple_dao;

import com.itvdn.javastarter.test.simple_dao.dao.CarDAO;
import com.itvdn.javastarter.test.simple_dao.dao.ClientDAO;
import com.itvdn.javastarter.test.simple_dao.dao.DAOFactory;
import com.itvdn.javastarter.test.simple_dao.dao.IDAOFactory;
import com.itvdn.javastarter.test.simple_dao.entity.Car;
import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.util.List;

/**
 * Created by Asus on 31.01.2018.
 */
public class Main {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        CarDAO carDAO = factory.getCarDAO();
        ClientDAO clientDAO = factory.getClientDAO();

//        Car car = carDAO.getById(3);
//
//       // for (Car car : cars) {
//            System.out.println(car.getId() +  " "  + car.getMark() + " " + car.getModel() + " " + car.getPrice());
//        //}
//
//        carDAO.updatePrice(50000, car);
/*
        Client client = clientDAO.getById(4);

        client.setAge(4);
        client.setName("Sergew");
        client.setPhone("67765655445");

        int add = clientDAO.delete(client);
        System.out.println(add);*/

        List<Client> clients = clientDAO.getAll();
        for (Client client: clients) {
            System.out.println(client.getId() + " " + client.getName() + " "
            + " " + client.getAge() + " " + client.getPhone());
        }



    }

}
