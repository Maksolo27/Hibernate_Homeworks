package com.itvdn.javastarter.test.simple_dao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao {

    protected void closeConnaectionAndStatement(Connection connection, Statement statement) {
        if (connection != null && statement != null) {

            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    protected Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DAOFactory.URL, DAOFactory.USERNAME, DAOFactory.PASSWORD);
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
