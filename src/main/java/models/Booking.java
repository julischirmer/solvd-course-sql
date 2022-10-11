package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Booking")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Booking")
public class Booking {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "dateBook")
    private String dateBook;
    @XmlElement(name = "customer")
    private Customer customer;
    @XmlElement(name = "payment")
    private Payment payment;

    public Booking() {

    }

    public Booking(int id, String dateBook, Customer customer, Payment payment) {
        this.id = id;
        this.dateBook = dateBook;
        this.customer = customer;
        this.payment = payment;
    }

    public Booking(String dateBook, Customer customer, Payment payment) {
        this.dateBook = dateBook;
        this.customer = customer;
        this.payment = payment;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateBook() {
        return dateBook;
    }

    public void setDateBook(String dateBook) {
        this.dateBook = dateBook;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", dateBook='" + dateBook + '\'' +
                ", customer=" + customer +
                ", payment=" + payment +
                '}';
    }
}
