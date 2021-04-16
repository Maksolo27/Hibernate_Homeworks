import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) {


        try {
            File file = new File("C:\\Users\\maxim\\IdeaProjects\\jdbs\\HW10\\src\\tariff.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Tariff.class);
            Unmarshaller unmarshaller =  jaxbContext.createUnmarshaller();
            Tariff tariff1 = (Tariff) unmarshaller.unmarshal(file);
            System.out.println(tariff1.toString());
            System.out.println(tariff1.getParameters().isCustomNumber() == false);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
