package com.ems.EmployeeProject;

import com.ems.EmployeeProject.model.Employee;
import com.ems.EmployeeProject.repository.EmployeRepository;
import com.ems.EmployeeProject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeProjectApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
	}

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setName("Nitu");
		employee.setDepartment("Electronics");

		employee.setName("Anita");
		employee.setDepartment("computerScience");



		// Save to the database
		employeRepository.save(employee);
	}


}
