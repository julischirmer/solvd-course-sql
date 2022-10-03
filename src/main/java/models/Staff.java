package models;

import com.fasterxml.jackson.annotation.JsonRootName;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Staff")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("Staff")
public class Staff {
    @XmlElement(name = "id")
    private int id;
    @XmlElement(name = "documentNo")
    private int documentNo;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "lastName")
    private String lastName;
    @XmlElement(name = "roleStaff")
    private RoleStaff roleStaff;

    public Staff(){

    }
    public Staff(int id,int documentNo,String name, String lastName, RoleStaff roleStaff){
        this.id = id;
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
        this.roleStaff = roleStaff;
    }

    public Staff(int documentNo,String name, String lastName, RoleStaff roleStaff){
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;
        this.roleStaff = roleStaff;
    }

    public Staff(int id, int documentNo,String name, String lastName){
        this.id = id;
        this.documentNo = documentNo;
        this.name = name;
        this.lastName = lastName;;
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

    public RoleStaff getRoleStaff() {
        return roleStaff;
    }

    public void setRoleStaff(RoleStaff roleStaff) {
        this.roleStaff = roleStaff;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", documentNo=" + documentNo +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roleStaff=" + roleStaff +
                '}';
    }
}
