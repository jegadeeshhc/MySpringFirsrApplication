package com.spring.boot.SpringFirsrApplication.controller;


import com.spring.boot.SpringFirsrApplication.model.Employee;
import com.spring.boot.SpringFirsrApplication.repository.EmployeeRepositiry;
import com.spring.boot.SpringFirsrApplication.response.CommonResponse;
import com.spring.boot.SpringFirsrApplication.service.EmployeeService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CrudController {

    @Autowired
   private EmployeeService service ;

    @Autowired
    private EmployeeRepositiry repo;

    @GetMapping("/getallemployees")
    public List<Employee> getAllEmployeeDetails(){
//        List<Employee> employees = repo.findAll();
//        return employees;
        return service.getAllEmployeeDetails();
    }

    @GetMapping("getbyid/{id}")
    public Employee getEmployeeById(@PathVariable int id){
//
            return service.getEmployeeById(id);
//        Employee employee = repo.findById(id).get();
//        return employee;
    }

    @PostMapping("/createemployee")
    public CommonResponse<Employee> createEmployee(@RequestBody Employee employee){
       return service.createEmployee(employee);
    }

    @PutMapping("updateemployee/{id}")
    public CommonResponse<Employee> updateEmployeeById(@PathVariable int id,@RequestBody Employee newemployee){
       return  service.updateEmployeeById(id,newemployee);
    }

    @DeleteMapping("Deleteemployee/{id}")
    public CommonResponse<Employee> deleteEmployeeBYId(@PathVariable int id){
        return service.deleteEmployeeBYId(id);
    }

}
