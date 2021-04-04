import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by maxim on 04.04.2021.
 */
public class Main {
    public static void main(String[] args) {

        Animal tiger = new Animal();

        tiger.setId(1);
        tiger.setKindOfAnimal("Tiger");
        tiger.setAge(8);
        tiger.setTail(true);

        Configuration configuration = new Configuration();

        SessionFactory factory = configuration.configure().buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(tiger);
        session.getTransaction().commit();

        factory.close();
        session.close();


    }
}
