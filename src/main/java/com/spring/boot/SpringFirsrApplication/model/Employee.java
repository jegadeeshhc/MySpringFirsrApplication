package com.spring.boot.SpringFirsrApplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Data
@Entity
@Table(name = "employees")
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "enployee_name")
    private String name;
    @Column(name = "employe_salary")
    private double salary;
    @Column(name = "employee_role")
    private String role;
    @Column(name = "employee_emil",unique = true)
    private String email;
    @Column(name= "employee_phone_number",unique = true)
    private Long phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getRole(){
        return role;
    }

    public  void setRole(String role){
        this.role=role;
    }

    public  double getSalary(){
        return  salary;
    }

    public void  setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setPhoneNumber(Long phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    public Long getPhoneNumber(){
        return phoneNumber;
    }

}
