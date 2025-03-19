package com.ems.EmployeeProject.repository;

import com.ems.EmployeeProject.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employee,Integer> {
}
