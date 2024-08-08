package com.spring.boot.SpringFirsrApplication.service;

import com.spring.boot.SpringFirsrApplication.dto.EmployeeDto; 
import com.spring.boot.SpringFirsrApplication.model.Employee;
import com.spring.boot.SpringFirsrApplication.repository.EmployeeRepositiry;
import com.spring.boot.SpringFirsrApplication.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.hibernate.type.descriptor.jdbc.ObjectNullAsBinaryTypeJdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepositiry repo;

    public CommonResponse<List<EmployeeDto>> getAllEmployeeDetails(){
        try {
            List<Employee> employees = repo.findAll();
            List<EmployeeDto> employeeDto = new ArrayList<EmployeeDto>();
            for(Employee emp : employees){
                EmployeeDto dto =new EmployeeDto();
                dto.setId(emp.getId());
                dto.setName(emp.getName());
                dto.setEmail(emp.getEmail());
                dto.setRole(emp.getRole());
                employeeDto.add(dto);
            }
            return new CommonResponse<List<EmployeeDto>>(true,"All Employee details are fetched ",employeeDto,null);
        }catch (Exception exception){
            System.out.println("The Exception is ::"+exception);
            return new CommonResponse(false,"All Employees details are not fetched ",null,"ERROR");
        }
    }


    public CommonResponse<EmployeeDto> getEmployeeById(int id){
        try {
            Optional<Employee> myobj = repo.findById(id);
            System.out.println(" Employeee --->>>> "+myobj);
            if(myobj.isPresent()) {
                Employee employee = myobj.get();
                EmployeeDto dto = new EmployeeDto();
                dto.setRole(employee.getRole());
                dto.setName(employee.getName());
                dto.setEmail(employee.getEmail());
                dto.setId(employee.getId());
                return new CommonResponse<EmployeeDto>(true,"Employee Details Fetched in this id "+id ,dto,null);
            }else{
                return new CommonResponse(true,"Employee id "+id+" is invalid",null,null);
            }
        }catch (Exception exception){
            System.out.println("The Exception is ::"+exception);
            return new CommonResponse(false,"Employee Details is not fetched",null,"ERROR");
        }
    }


    public CommonResponse<Employee> createEmployee(Employee employee){
        try {
            Employee emp = repo.save(employee);
            return new CommonResponse<Employee>(true,"Employee Created successFully",emp,null);
        }catch(Exception exception){
            System.out.println("The Exception is ::"+exception);
            return new CommonResponse(false,"Employee Not Created",null,"Error");
        }
    }


    public CommonResponse<EmployeeDto> updateEmployeeById(int id, Employee newemployee){
        try {
            //Employee employee = repo.findById(id).get();
            Optional<Employee> myobj = repo.findById(id);
            System.out.println(" Employeee --->>>> "+myobj);
            if(myobj.isPresent()) {
                Employee employee = myobj.get();
                employee.setSalary(newemployee.getSalary());
                employee.setRole(newemployee.getRole());
                employee.setEmail(newemployee.getEmail());
                employee.setPhoneNumber(newemployee.getPhoneNumber());
                repo.save(employee);
                EmployeeDto dto =new EmployeeDto();
                dto.setRole(employee.getRole());
                dto.setName(employee.getName());
                dto.setEmail(employee.getEmail());
                dto.setId(employee.getId());
                return new CommonResponse<EmployeeDto>(true, "Employee Updated successFully", dto, null);
            }else {
                return new CommonResponse(true, "Employee id "+id+" is invalid", null, null);
            }
        }catch(Exception exception){
            System.out.println("The Exception is ::"+exception);
            return new CommonResponse(false,"Employee Updated UnsuccessFully",null,"ERROR");
        }
    }


    public CommonResponse deleteEmployeeBYId(int id) {
        try {
           // Employee employee = repo.findById(id).get();
            Optional<Employee> myobj = repo.findById(id);
            System.out.println(" Employeee --->>>> "+myobj);
            if(myobj.isPresent()) {
                repo.deleteById(id);
                return new CommonResponse(true, "Employee Details Delete successFully", null,null);
            }else{
                return new CommonResponse(true, "Employee id "+id+" is invalid", null,null);
            }
        } catch (Exception exception) {
            System.out.println("The Exception is ::"+exception);
            return new CommonResponse(false, "Employee Details Delete UnsuccessFully", null, "ERROR");
        }
    }


}
