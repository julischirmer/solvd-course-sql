package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Customer")
public class Customer {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "documentNo")
    private int documentNo;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "birthday")
    private String birthday;
    @XmlElement(name = "email")
    private String email;

    public Customer() {

    }

    public Customer(int documentNo, String name, String lastName, String address, String birthday, String email) {
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public Customer(int id, int documentNo, String name, String lastName, String address, String birthday, String email) {
        this.id = id;
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public Customer(int id, int documentNo, String name, String lastName) {
        this.id = id;
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocumentNo() {
        return documentNo;
    }

    public void setDocumentNo(int documentNo) {
        this.documentNo = documentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", documentNo=" + documentNo +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
