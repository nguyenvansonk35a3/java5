package edu.nguyenvanson.domain;

public class Department {

    private String idDepartment;
    private String nameDepartment;

    public Department() {
    }

    public Department(String idDepartment, String nameDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    public String getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(String idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

}
