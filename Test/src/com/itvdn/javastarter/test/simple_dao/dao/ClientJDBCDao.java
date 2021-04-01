package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 29.10.2020.
 */
public class ClientJDBCDao extends AbstractDao implements ClientDAO {

    @Override
    public List<Client> getAll() {
        List<Client> clientList = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("SELECT c.id, c.name, c.age, c.phone FROM clients as c ");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("c.id");
                String name = resultSet.getString("c.name");
                int age = resultSet.getInt("c.age");
                String phone = resultSet.getString("c.phone");
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                clientList.add(client);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnaectionAndStatement(connection, preparedStatement);
        }
        return clientList;
    }

    @Override
    public int insert(Client client) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

            preparedStatement.setString(1, client.getName());
            preparedStatement.setInt(2, client.getAge());
            preparedStatement.setString(3, client.getPhone());

            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnaectionAndStatement(connection, preparedStatement);
        }

        return 0;
    }

    @Override
    public int delete(Client client) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE id = ?");

            preparedStatement.setLong(1, client.getId());


            return preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            closeConnaectionAndStatement(connection, preparedStatement);
        }

        return 0;
    }

    @Override
    public Client getById(int id) {
        return null;
    }

}
