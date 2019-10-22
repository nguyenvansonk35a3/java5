package edu.nguyenvanson.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable {

    @Id
    private String idDepartment;
    private String nameDeprtment;

    public Department() {
    }

    public Department(String idDepartment, String nameDeprtment) {
        this.idDepartment = idDepartment;
        this.nameDeprtment = nameDeprtment;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDeprtment() {
        return nameDeprtment;
    }

    public void setNameDeprtment(String nameDeprtment) {
        this.nameDeprtment = nameDeprtment;
    }

}
