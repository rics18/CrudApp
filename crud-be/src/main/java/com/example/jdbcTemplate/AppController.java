package com.example.jdbcTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RestController
public class AppController {

	@Autowired
	private AppDAO appDAO;

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE").allowedOrigins("*")
						.allowedHeaders("*");
			}
		};
	}

	@RequestMapping(path = "/create")
	@PostMapping
	private void createEmployee(@RequestBody Employee employee) {
		employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setEmailId(employee.getEmailId());
		appDAO.createEmployee(employee);
	}

	@RequestMapping(path = "/employees")
	@GetMapping
	private List<Employee> fetchEmployee() {
		return appDAO.fetchEmployee();
	}

	@RequestMapping(path = "/delete/{id}")
	@DeleteMapping
	private void deleteEmployee(@PathVariable("id") int id) {
		System.out.println("Id: " + id);
		appDAO.deleteEmployee(id);
	}

	@RequestMapping(path = "/update")
	@PostMapping
	private void editEmployee(@RequestBody Employee employee) {
		System.out.println("saaasafssfs");
		employee.setId(employee.getId());
		employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setEmailId(employee.getEmailId());
		appDAO.editEmployee(employee);
	}

}
