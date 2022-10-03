package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Payment")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Payment")
public class Payment {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "typePay")
    private String typePay;

    public Payment(){

    }

    public Payment(int id, String typePay){
        this.id = id;
        this.typePay = typePay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTypePay() {
        return typePay;
    }

    public void setTypePay(String typePay) {
        this.typePay = typePay;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", typePay='" + typePay + '\'' +
                '}';
    }
}
