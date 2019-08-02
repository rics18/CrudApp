package com.example.crud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.dao.CrudDAO;
import com.example.crud.models.Employee;
import com.example.crud.service.CrudService;

@Service
public class CrudServiceImpl implements CrudService{

	@Autowired
	CrudDAO crudDAO;

	@Override
	public void createEmployee(Employee employee) {
		crudDAO.createEmployee(employee);
	}

	@Override
	public List<Employee> fetchEmployee() {
		return crudDAO.fetchEmployee();
	}

	@Override
	public void deleteEmployee(int id) {
		crudDAO.deleteEmployee(id);
	}

	@Override
	public void editEmployee(Employee employee) {
		crudDAO.editEmployee(employee);
	}

	@Override
	public String display() {
		return crudDAO.display();
	}

	@Override
	public Employee fetchEmployeeById() {
		return crudDAO.fetchEmployeeById();
	}
	
}
