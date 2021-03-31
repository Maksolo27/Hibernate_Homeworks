package sample;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main{

    private static final String URL = "jdbc:mysql://localhost:3306/personal?serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root1";
    private static final String INSERT_NEW = "INSERT INTO emploe(name) " + " VALUE(?)";
    private static final String DELETE = "DELETE FROM emploe WHERE name = ?  ?";
    private static final String SELECT = "SELECT * FROM emploe";

    public static void main(String[] args) {
        Test test = new Test();
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
/*            statement.execute("DROP table emploe");*/
/*            statement.execute("create table emploe(" + "name varchar(100));");*/


            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, "name4" );
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(SELECT);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString(1);
                System.out.println(name);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
         finally {
            try {
                connection.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



}
}
