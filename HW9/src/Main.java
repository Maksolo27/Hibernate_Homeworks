import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        Factory factory = new Factory();
        factory.add(new Candy(120, "Milka", "Chocolate"));
        factory.add(new Candy(60, "Korovka", "Caramel"));

        try {
            File file = new File("C:\\Users\\maxim\\IdeaProjects\\jdbs\\HW9\\src\\candies.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Factory.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(factory, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }
}
