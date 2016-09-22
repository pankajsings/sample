package com.app.company.service;

import java.util.List;

import com.app.company.entity.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public void deleteEmployee(long empId);
	public Employee updateEmployee(Employee employee);
	public Employee loadEmployee(long empId);
	public  List<Employee> loadAllEmployee();
	public List<Employee> loadEmployeeByCriteria(Employee employee);
}
