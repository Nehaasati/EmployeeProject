package com.ems.EmployeeProject.service;

import com.ems.EmployeeProject.model.Employee;
import com.ems.EmployeeProject.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeRepository repository;

    public List<Employee> getAllEmployees() { return repository.findAll(); }
    public Optional<Employee> getEmployeeById(Integer id) { return repository.findById(id); }
    public Employee saveEmployee(Employee employee) { return repository.save(employee); }
    public void deleteEmployee(Integer id) { repository.deleteById(id); }
}
