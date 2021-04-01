package sample;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/myjoinsdb?serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root1";
    private static final String SELECT1 = "select PN.name, PN.number, PI.place from PhoneNumber PN\n" +
            "\t\tleft join personalinformation PI\n" +
            "        on PN.phone_id = PI.personal_id\n" +
            "        group by PN.name;";
    private static final String SELECT2 = "select PN.name, PN.number from phonenumber PN\n" +
            "\t\tright join personalinformation PI\n" +
            "\t\ton pi.personal_id = PN.phone_id\n" +
            "        where pi.marriaged = false\n" +
            "        group by PN.name;\n";
    private static final String SELECT3 = "select PN.name, Pn.number, Pi.age from phonenumber PN\n" +
            "\t\tright join personalinformation PI\n" +
            "        on pi.personal_id = pn.phone_id\n" +
            "        right join positions pos\n" +
            "        on pi.personal_id = pos.position_id\n" +
            "        where pos.position = \"Manager\"\n" +
            "        group by Pn.name;";



    public static void main(String[] args) {
        registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(SELECT1);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("PN.name");
                String number =  resultSet.getString("PN.number");
                String place = resultSet.getString("PI.place");
                System.out.println(name + " "+ number + " "+ place);
            }
            System.out.println("------------------");
            statement = connection.prepareStatement(SELECT2);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("PN.name");
                String number =  resultSet.getString("PN.number");
                System.out.println(name + " " + number);
            }

            System.out.println("-----------------");
            statement = connection.prepareStatement(SELECT3);

            resultSet = statement.executeQuery();

            while (resultSet.next()){
                String name = resultSet.getString("PN.name");
                String number =  resultSet.getString("PN.number");
                int age = resultSet.getInt("PI.age");
                System.out.println(name + " " + number + "" + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void registerDriver(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
