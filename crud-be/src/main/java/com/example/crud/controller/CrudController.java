package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.crud.exceptionHandler.EmployeeNotfoundException;
import com.example.crud.models.Employee;
import com.example.crud.models.User;
import com.example.crud.service.CrudService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CrudController {

	@Autowired
	CrudService crudService;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/*").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

	@PostMapping("/create")
	private void createEmployee(@RequestBody Employee employee) {
		if (employee == null)
			throw new EmployeeNotfoundException();
		crudService.createEmployee(employee);
	}

	@GetMapping("/employees")
	private List<Employee> fetchEmployee() {
		return crudService.fetchEmployee();
	}

	@DeleteMapping("/delete/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		crudService.deleteEmployee(id);
	}

	@PutMapping("/update")
	private void editEmployee(@RequestBody Employee employee) {
		crudService.editEmployee(employee);
	}

	@GetMapping("/hello")
	private String display() {
		return crudService.display();
	}

	@GetMapping("/employee")
	private Employee fetchEmployeeById() {
		return crudService.fetchEmployeeById();
	}

	@PostMapping("/login")
	private void login(@RequestBody User user) {
		System.out.println("user: " + user.toString());
	}

}
