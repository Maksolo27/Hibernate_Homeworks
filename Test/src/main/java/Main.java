import bojo.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by maxim on 03.04.2021.
 */
public class Main {
    public static void main(String[] args) {
        Person person = new Person();

        person.setId(1);
        person.setName("Alex");
        person.setAge(25);
        person.setMarriaged(false);

        Configuration configuration = new Configuration();

        SessionFactory factory = configuration
                .configure("new_file.xml")
                .buildSessionFactory();

        Session session = factory.openSession();

        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();

        session.close();
        factory.close();
    }
}
