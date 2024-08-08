package com.spring.boot.SpringFirsrApplication.controller;


import com.spring.boot.SpringFirsrApplication.dto.EmployeeDto;
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

    @GetMapping("/getallemployees")
    public CommonResponse<List<EmployeeDto>> getAllEmployeeDetails(){
        return service.getAllEmployeeDetails();
    }

    @GetMapping("getbyid/{id}")
    public CommonResponse<EmployeeDto> getEmployeeById(@PathVariable int id){
            return service.getEmployeeById(id);
    }

    @PostMapping("/createemployee")
    public CommonResponse<Employee>  createEmployee(@RequestBody Employee employee){
       return service.createEmployee(employee);
    }

    @PutMapping("updateemployee/{id}")
    public CommonResponse<EmployeeDto> updateEmployeeById(@PathVariable int id,@RequestBody Employee newemployee){
       return  service.updateEmployeeById(id,newemployee);
    }

    @DeleteMapping("Deleteemployee/{id}")
    public CommonResponse deleteEmployeeBYId(@PathVariable int id){
        return service.deleteEmployeeBYId(id);
    }

}
