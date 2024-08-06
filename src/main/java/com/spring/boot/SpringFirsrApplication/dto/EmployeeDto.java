package com.spring.boot.SpringFirsrApplication.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmployeeDto {

   public String name;
   public String role;
   public double salary;

   public EmployeeDto(String name,String role,double salary){
       this.name=name;
       this.role=role;
       this.salary=salary;
   }



}
