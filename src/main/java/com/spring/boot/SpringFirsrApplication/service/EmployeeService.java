package com.spring.boot.SpringFirsrApplication.service;

import com.spring.boot.SpringFirsrApplication.dto.EmployeeDto; 
import com.spring.boot.SpringFirsrApplication.model.Employee;
import com.spring.boot.SpringFirsrApplication.repository.EmployeeRepositiry;
import com.spring.boot.SpringFirsrApplication.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepositiry repo;

    private EmployeeDto dto;

    public List<Employee> getAllEmployeeDetails(){
        try {
            List<Employee> employees = repo.findAll();
            return employees;
        }catch (Exception exception){
            return null;
        }
    }


    public Employee getEmployeeById(int id){
        try {
            Employee employee = repo.findById(id).get();
            
            return employee;
        }catch (Exception exception){
            return null;
        }
    }


    public CommonResponse<Employee> createEmployee(Employee employee){
        try {
            repo.save(employee);
            return new CommonResponse(true,"Employee Created successFully",employee,null);
        }catch(Exception exception){
            return new CommonResponse(false,"Employee Not Created",null,"Error");
        }
    }


    public CommonResponse<Employee> updateEmployeeById(int id, Employee newemployee){
        try {
            Employee employee = repo.findById(id).get();
            employee.setName(newemployee.getName());
            employee.setSalary(newemployee.getSalary());
            employee.setRole(newemployee.getRole());
            repo.save(employee);
            return new CommonResponse<Employee>(true,"Employee Updated successFully",newemployee,null);
        }catch(Exception exception){
            return new CommonResponse<Employee>(false,"Employee Created UnsuccessFully",null,null);
        }
    }


    public CommonResponse<Employee> deleteEmployeeBYId(int id) {
        try {
            repo.deleteById(id);
//            new CommonResponse<Employee>();
            return new CommonResponse(true, "Employee Delete successFully", null,null);
        } catch (Exception exception) {
            return new CommonResponse(false, "Employee Delete UnsuccessFully", null, null);
        }
    }


}
