package models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

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

    public Country() {

    }

    public Country(int id, String name) {
        this.id = id;
        this.description = name;
    }

    public static Builder builder() {
        return new Country().new Builder();
    }

    @JsonGetter("id")
    public int getId() {
        return id;
    }

    @JsonSetter("id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonGetter("description")
    public String getDescription() {
        return description;
    }

    @JsonSetter("description")
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

    public class Builder {
        private Builder() {
        }

        public Builder withId(int id) {
            Country.this.id = id;
            return this;
        }

        public Builder withDesc(String name) {
            Country.this.description = name;
            return this;
        }

        public Country build() {
            return Country.this;
        }
    }
}
