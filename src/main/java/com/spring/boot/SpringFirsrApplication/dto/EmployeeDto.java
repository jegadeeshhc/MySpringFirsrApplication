package com.spring.boot.SpringFirsrApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

   public String name;
   public String role;
   public double salary;
   public String email;

//   public EmployeeDto(String name,String role,double salary,String email){
//       this.name=name;
//       this.role=role;
//       this.salary=salary;
//       this.email=email;
//   }



}
