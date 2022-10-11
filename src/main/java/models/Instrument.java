package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Instrument")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Instrument")
public class Instrument {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "name")
    private String name;

    public Instrument() {

    }

    public Instrument(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Builder builder() {
        return new Instrument().new Builder();
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

    @Override
    public String toString() {
        return "Instrument{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public class Builder {
        private Builder() {
        }

        public Builder withId(int id) {
            Instrument.this.id = id;
            return this;
        }

        public Builder withName(String name) {
            Instrument.this.name = name;
            return this;
        }

        public Instrument build() {
            return Instrument.this;
        }

    }
}
