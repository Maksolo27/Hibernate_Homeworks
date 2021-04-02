package com.itvdn.javastarter.test.simple_dao.dao;

import com.itvdn.javastarter.test.simple_dao.entity.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


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
        PreparedStatement statement = null;

        connection = getConnection();

        try {
            statement = connection.prepareStatement("Insert into clients(name, age, phone) VALUES(?,?,?)");

            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

            statement.execute();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnaectionAndStatement(connection, statement);
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
        Client client = new Client();
        Connection connection = null;
        PreparedStatement statement = null;

        connection = getConnection();

        try {
            statement = connection.prepareStatement("SELECT  c.name, c.age, c.phone from clients as c WHERE c.id = ?");

            statement.setInt(1, id);

            ResultSet resultSet =  statement.executeQuery();
            if(resultSet.next()){
                String name = resultSet.getString("c.name");
                int age = resultSet.getInt("c.age");
                String phone = resultSet.getString("c.phone");
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                return client;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnaectionAndStatement(connection, statement);
        }

        return client;
    }

}
