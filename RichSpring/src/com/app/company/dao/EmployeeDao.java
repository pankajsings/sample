package com.app.company.dao;

import java.util.List;

import com.app.company.entity.Employee;

public interface EmployeeDao {
	public Employee createEmployee(Employee employee);
	public void persistEmployee(Employee employee);
	public Employee updateEmployee(Employee employee);
	void deleteEmployee(Employee employee);
	void deleteEmployee(long empId);
	public Employee loadEmployee(long empId);
	public  List<Employee> loadAllEmployee();
	public List<Employee> loadEmployeeByCriteria(Employee employee);
}
