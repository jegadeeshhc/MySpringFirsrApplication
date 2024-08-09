package com.spring.boot.SpringFirsrApplication.repository;

import com.spring.boot.SpringFirsrApplication.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepositiry extends JpaRepository<Employee,Integer> {

    Optional<Employee> findByEmail(String email);
}
