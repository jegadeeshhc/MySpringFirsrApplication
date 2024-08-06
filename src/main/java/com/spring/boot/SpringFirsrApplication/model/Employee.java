package com.spring.boot.SpringFirsrApplication.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@Entity
@Table(name = "employees")
@Getter
@Setter
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
    @Column(name = "employee_emil")
    private String email;

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
}
