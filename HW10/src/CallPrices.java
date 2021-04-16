import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by maxim on 16.04.2021.
 */
@XmlRootElement
public class CallPrices {

    private int insideNet;
    private int outsideNet;
    private int stationary;

    public int getInsideNet() {
        return insideNet;
    }

    @XmlElement(name = "inside_net")
    public void setInsideNet(int insideNet) {
        this.insideNet = insideNet;
    }

    public int getOutsideNet() {
        return outsideNet;
    }

    @XmlElement(name = "outside_net")
    public void setOutsideNet(int outsideNet) {
        this.outsideNet = outsideNet;
    }

    public int getStationary() {
        return stationary;
    }
    @XmlElement
    public void setStationary(int stationary) {
        this.stationary = stationary;
    }

    @Override
    public String toString() {
        return "CallPrices{" +
                "insideNet=" + insideNet +
                ", outsideNet=" + outsideNet +
                ", stationary=" + stationary +
                '}';
    }
}
