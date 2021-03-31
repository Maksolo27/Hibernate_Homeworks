package sample;

/**
 * Created by maxim on 31.03.2021.
 */
public class Test {
    Test(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
