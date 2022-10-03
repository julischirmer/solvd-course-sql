package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "RoleStaff")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("RoleStaff")
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
        return "RoleStaff{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
