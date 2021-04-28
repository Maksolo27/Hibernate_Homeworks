import impl.Toyota;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by maxim on 28.04.2021.
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("contex.xml");
        Toyota toyota = (Toyota) applicationContext.getBean("toyota");
        toyota.drive();
    }
}
