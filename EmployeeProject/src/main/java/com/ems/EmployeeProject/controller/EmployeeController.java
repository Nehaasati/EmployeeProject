package com.ems.EmployeeProject.controller;

import com.ems.EmployeeProject.exception.ResourceNotFoundEception;
import com.ems.EmployeeProject.model.Employee;
import com.ems.EmployeeProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<Employee> getAllEmployees() { return service.getAllEmployees(); }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return service.getEmployeeById(id).orElseThrow(() -> new ResourceNotFoundEception("Employee not found"));
    }


  //build create employee RestApi
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) { return service.saveEmployee(employee); }


    //build update employee Restapi
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Integer id, @RequestBody Employee employee) {
        Employee existingEmployee = service.getEmployeeById(id).orElseThrow(() -> new ResourceNotFoundEception("Employee not found"));
        existingEmployee.setName(employee.getName());
        existingEmployee.setDepartment(employee.getDepartment());
        return service.saveEmployee(existingEmployee);
    }

    // build delete employee Restapi

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id) { service.deleteEmployee(id); }
}

