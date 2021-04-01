package sample;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Main{

    private static final String URL = "jdbc:mysql://localhost:3306/personal?serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root1";


    private static  String INSERT_NEW = "";
    private static  String DELETE = "";
    private static  String SELECT = "";

    public static void main(String[] args) {
        Test test = new Test();
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;


        try(FileReader reader = new FileReader("C:\\Users\\maxim\\IdeaProjects\\jdbs\\HW1\\src\\INSERT_NEW"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                INSERT_NEW += (char)c;
            }

        }

        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        try(FileReader reader = new FileReader("C:\\Users\\maxim\\IdeaProjects\\jdbs\\HW1\\src\\DELETE"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                DELETE += (char)c;
            }

        }        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        try(FileReader reader = new FileReader("C:\\Users\\maxim\\IdeaProjects\\jdbs\\HW1\\src\\SELECT"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                SELECT += (char)c;
            }

        }        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();
            statement.execute("DROP table emploe");
            statement.execute("create table emploe(" + "name varchar(100));");


            preparedStatement = connection.prepareStatement(INSERT_NEW);
            preparedStatement.setString(1, "name5" );
            preparedStatement.execute();

            preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setString(1,"name76");
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
