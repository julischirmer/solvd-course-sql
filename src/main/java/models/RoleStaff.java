package models;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RoleStaff")
@XmlAccessorType(XmlAccessType.FIELD)

@JsonRootName("RoleStaff")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RoleStaff {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "roleDescription")
    private String description;

    public RoleStaff(){

    }
    public RoleStaff(int id, String description){
        this.id = id;
        this.description = description;
    }
    @JsonGetter("id")
    public int getId() {
        return id;
    }
    @JsonSetter("id")
    public void setId(int id) {
        this.id = id;
    }
    @JsonGetter("roleDescription")
    public String getDescription() {
        return description;
    }
    @JsonSetter("roleDescription")
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoleStaff{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
