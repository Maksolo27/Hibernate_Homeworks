import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by maxim on 16.04.2021.
 */
@XmlRootElement
public class Parameters {

    private boolean customNumber;
    private int tarification;
    private int payForTariff;

    public boolean isCustomNumber() {
        return customNumber;
    }

    @XmlElement(name = "custom_number")
    public void setCustomNumber(boolean customNumber) {
        this.customNumber = customNumber;
    }

    public int getTarification() {
        return tarification;
    }
    @XmlElement()
    public void setTarification(int tarification) {
        this.tarification = tarification;
    }

    public int getPayForTariff() {
        return payForTariff;
    }
    @XmlElement(name = "pay_for_tariff")
    public void setPayForTariff(int payForTariff) {
        this.payForTariff = payForTariff;
    }

    @Override
    public String toString() {
        return "Parameters{" +
                "customNumber=" + customNumber +
                ", tarification=" + tarification +
                ", payForTariff=" + payForTariff +
                '}';
    }
}
