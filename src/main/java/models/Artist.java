package models;

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Artist")
@XmlAccessorType(XmlAccessType.FIELD)

@JsonRootName("Artist")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Artist {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "country")
    private Country country;

    public Artist() {

    }

    public Artist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Artist(int id, String name, Country country) {
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

    @JsonGetter("country")
    public Country getCountry() {
        return country;
    }

    @JsonSetter("country")
    public void setCountry(Country country) {
        this.country = country;
    }

    public static Builder builder() {
        return new Artist().new Builder();
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(int id) {
            Artist.this.id = id;
            return this;
        }

        public Builder withName(String name) {
            Artist.this.name = name;
            return this;
        }

        public Builder withCountry(Country country) {
            Artist.this.country = country;
            return this;
        }

        public Artist build() {
            return Artist.this;
        }
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
