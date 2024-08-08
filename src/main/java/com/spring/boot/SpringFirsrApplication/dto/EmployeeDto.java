package com.spring.boot.SpringFirsrApplication.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDto {

   public int id;
   public String name;
   public String role;
   public String email;

   public void setId(int id){
      this.id=id;
   }

   public int getId(){
      return id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }



//   public EmployeeDto(String name,String role,double salary,String email){
//       this.name=name;
//       this.role=role;
//       this.salary=salary;
//       this.email=email;
//   }



}
