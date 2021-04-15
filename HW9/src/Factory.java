import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by maxim on 15.04.2021.
 */
@XmlRootElement(name = "factory")
public class Factory {

    @XmlElement(name = "candy")
    private List<Candy> candies = new ArrayList<>();

    public void add(Candy candy){
        candies.add(candy);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(candies.toArray());
    }
}
