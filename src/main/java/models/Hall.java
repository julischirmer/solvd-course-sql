package models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Hall")
@XmlAccessorType(XmlAccessType.FIELD)

@JsonRootName("Hall")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
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

    public Hall() {

    }

    public Hall(String name, String address, int capacity, Country country) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.country = country;
    }

    public Hall(int id, String name, String address, int capacity, Country country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.country = country;
    }

    public Hall(int id, String name, Country country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonSetter("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("address")
    public String getAddress() {
        return address;
    }

    @JsonSetter("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonGetter("capacity")
    public int getCapacity() {
        return capacity;
    }

    @JsonSetter("capacity")
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @JsonGetter("country")
    public Country getCountry() {
        return country;
    }

    @JsonSetter("country")
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
