package com.example.crud.dao;

import java.util.List;

import com.example.crud.models.Employee;


public interface CrudDAO {

	public void createEmployee(Employee employee);

	public List<Employee> fetchEmployee();

	public void deleteEmployee(int id);

	public void editEmployee(Employee employee);

	public String display();

	public Employee fetchEmployeeById();

}
