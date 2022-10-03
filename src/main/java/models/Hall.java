package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hall")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Hall")
public class Hall {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "address")
    private String address;
    @XmlElement(name = "capacity")
    private int capacity;
    @XmlElement(name = "country")
    private Country country;

    public Hall(){

    }
    public Hall( String name, String address, int capacity, Country country){
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.country = country;
    }

    public Hall(int id, String name, String address, int capacity, Country country){
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.country = country;
    }

    public Hall(int id, String name, Country country){
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Hall{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                ", country=" + country +
                '}';
    }
}
