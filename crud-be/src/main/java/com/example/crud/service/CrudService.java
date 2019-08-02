package com.example.crud.service;

import java.util.List;

import com.example.crud.models.Employee;


public interface CrudService {

	public void createEmployee(Employee employee);

	public List<Employee> fetchEmployee();

	public void deleteEmployee(int id);

	public void editEmployee(Employee employee);

	public String display();

	public Employee fetchEmployeeById();

}
