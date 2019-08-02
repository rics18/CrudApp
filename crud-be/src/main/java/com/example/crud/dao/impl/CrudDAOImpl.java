package com.example.crud.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.crud.dao.CrudDAO;
import com.example.crud.models.Employee;
import com.example.crud.rowmapper.AppRowMapper;

@Repository
public class CrudDAOImpl implements CrudDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void createEmployee(Employee employee) {
		int update = jdbcTemplate.update("INSERT INTO employees(first_name,last_name,email_address) VALUES(?,?,?)",
				employee.getFirstName(), employee.getLastName(), employee.getEmailAddress());
		if (update > 0)
			System.out.println("Employee is created...");
	}

	@Override
	public List<Employee> fetchEmployee() {
		String SQL = "SELECT * FROM employees";

		return jdbcTemplate.query(SQL, new BeanPropertyRowMapper(Employee.class));
		// return jdbcTemplate.query(SQL, new AppRowMapper());
	}

	@Override
	public void deleteEmployee(int id) {
		String SQL = "DELETE from employees WHERE id = " + id;
		jdbcTemplate.execute(SQL);
	}

	@Override
	public void editEmployee(Employee model) {
		int update = jdbcTemplate.update(
				"UPDATE employees set first_name = ?, last_name = ?, email_address = ? WHERE id = ?",
				model.getFirstName(), model.getLastName(), model.getEmailAddress(), model.getId());
		if (update > 0)
			System.out.println("Employee is updated...");
	}

	@Override
	public String display() {
		return "Hello";
	}

	@Override
	public Employee fetchEmployeeById() {
		String sql = "SELECT * FROM employees WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { 8 }, new BeanPropertyRowMapper<>(Employee.class));
	}
}
