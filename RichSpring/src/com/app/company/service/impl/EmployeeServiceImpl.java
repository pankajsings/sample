package com.app.company.service.impl;

import java.io.Serializable;
import java.util.List;

import com.app.company.dao.EmployeeDao;
import com.app.company.entity.Employee;
import com.app.company.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService, Serializable{
	EmployeeDao employeeDao;
	private static final long serialVersionUID = 1L;
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.createEmployee(employee);
	}

	@Override
	public void deleteEmployee(long empId) {
		// TODO Auto-generated method stub
		employeeDao.deleteEmployee(empId);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.updateEmployee(employee);
	}

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee loadEmployee(long empId) {
		return employeeDao.loadEmployee(empId);
		
	}

	@Override
	public  List<Employee> loadAllEmployee() {
		// TODO Auto-generated method stub
		return employeeDao.loadAllEmployee();
	}

	@Override
	public List<Employee> loadEmployeeByCriteria(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.loadEmployeeByCriteria(employee);
	}

	

}
