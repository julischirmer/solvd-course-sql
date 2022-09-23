package models;

public class Staff {
    private int id;
    private int document_no;
    private String name;
    private String lastName;
    private RoleStaff roleStaff;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDocument_no() {
        return document_no;
    }

    public void setDocument_no(int document_no) {
        this.document_no = document_no;
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
}
