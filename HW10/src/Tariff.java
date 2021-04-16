import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by maxim on 16.04.2021.
 */
@XmlRootElement(name = "Tariff")
public class Tariff {

    private String name;
    private String operatorName;
    private int payroll;
    private CallPrices callPrices;
    private int smsPrice;
    private Parameters parameters;

    public Tariff(){

    }

    public Tariff(String name, String operatorName, int payroll, CallPrices callPrices, int smsPrice, Parameters parameters) {
        this.name = name;
        this.operatorName = operatorName;
        this.payroll = payroll;
        this.callPrices = callPrices;
        this.smsPrice = smsPrice;
        this.parameters = parameters;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getOperatorName() {
        return operatorName;
    }
    @XmlElement(name = "Operator_name")
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getPayroll() {
        return payroll;
    }

    @XmlElement
    public void setPayroll(int payroll) {
        this.payroll = payroll;
    }


    public CallPrices getCallPrices() {
        return callPrices;
    }
    @XmlElement(name = "call_prices")
    public void setCallPrices(CallPrices callPrices) {
        this.callPrices = callPrices;
    }

    public int getSmsPrice() {
        return smsPrice;
    }
    @XmlElement(name = "sms_price")
    public void setSmsPrice(int smsPrice) {
        this.smsPrice = smsPrice;
    }

    public Parameters getParameters() {
        return parameters;
    }

    @XmlElement
    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Tariff{" +
                "name='" + name + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", payroll=" + payroll +
                ", callPrices=" + callPrices.toString() +
                ", smsPrice=" + smsPrice +
                ", parameters=" + parameters.toString() +
                '}';
    }
}
