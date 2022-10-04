package models;

import com.fasterxml.jackson.annotation.JsonRootName;
import dao.CountryDAO;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Country")
@XmlAccessorType(XmlAccessType.FIELD)

@JsonRootName("Country")

public class Country {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "description")
    private String description;

    public Country(){

    }
    public Country(int id, String name){
        this.id = id;
        this.description = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
