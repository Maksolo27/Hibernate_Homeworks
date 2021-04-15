import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by maxim on 15.04.2021.
 */
@XmlRootElement(name = "candy")
public class Candy {

    private int calorificValue;

    private String name;

    private String type;

    public Candy(int calorificValue, String name, String type) {
        this.calorificValue = calorificValue;
        this.name = name;
        this.type = type;
    }
    public Candy(){

    }

    public int getCalorificValue() {
        return calorificValue;
    }
    @XmlElement(name = "calorific_value")
    public void setCalorificValue(int calorificValue) {
        this.calorificValue = calorificValue;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    @XmlElement
    public void setType(String type) {
        this.type = type;
    }
}
