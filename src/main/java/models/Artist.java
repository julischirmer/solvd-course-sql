package models;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Artist")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Artist")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Artist {
    @XmlElement(name = "id")
    @JsonProperty("id")
    private int id;
    @XmlElement(name = "name")
    @JsonProperty("name")
    private String name;
    @XmlElement(name = "Country")
    @JsonProperty("Country")
    private Country country;

    public Artist(){

    }

    public Artist(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Artist(int id, String name,Country country){
        this.id = id;
        this.name = name;
        this.country = country;
    }




    @JsonGetter("artistId")
    public int getId() {
        return id;
    }

    @JsonSetter("artistId")
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                '}';
    }
}
