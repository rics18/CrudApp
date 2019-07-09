package com.example.jdbcTemplate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void createEmployee(Employee model) {
		int update = jdbcTemplate.update("INSERT INTO employees(first_name,last_name,email_address) VALUES(?,?,?)",
				model.getFirstName(), model.getLastName(), model.getEmailId());
		if (update > 0)
			System.out.println("Employee is created...");
	}

	public List<Employee> fetchEmployee() {
		String SQL = "SELECT * FROM employees";
		return jdbcTemplate.query(SQL, new AppRowMapper());
	}

	public void deleteEmployee(int id) {
		String SQL = "DELETE from employees WHERE id = " + id;
		jdbcTemplate.execute(SQL);
	}

	public void editEmployee(Employee model) {
		int update = jdbcTemplate.update(
				"UPDATE employees set first_name = ?, last_name = ?, email_address = ? WHERE id = ?",
				model.getFirstName(), model.getLastName(), model.getEmailId(), model.getId());
		if (update > 0)
			System.out.println("Employee is updated...");
	}
}
