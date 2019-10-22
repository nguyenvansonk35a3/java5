package edu.nguyenvanson.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "staffs")
public class Staff implements Serializable {

    @Id
    private String idStaff;
    private String nameStaff;
    private String gender;
    private String birthday;
    private String phone;
    private String email;
    private String salary;
    private String note;

    @ManyToOne
    @JoinColumn(name = "idDepartment")
    private Department department;

    public Staff() {
    }
    
    public Staff( String idStaff){
        this.idStaff = idStaff;
    }
    public Staff(String idStaff, String nameStaff, String gender, String birthday, String phone, String email, String salary, String note, Department department) {
        this.idStaff = idStaff;
        this.nameStaff = nameStaff;
        this.gender = gender;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
        this.note = note;
        this.department = department;
    }

    public String getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(String idStaff) {
        this.idStaff = idStaff;
    }

    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

}
