package com.app.company.bean;

import java.io.Serializable;
import java.util.List;

import com.app.company.entity.Employee;
import com.app.company.service.EmployeeService;

public class EmployeeListBean  implements Serializable{
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService;
	private String name;
	private String age;
	
	
	public EmployeeService getEmployeeService() {
		return employeeService;
	}
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public List<Employee> getEmployeeList(){
		return employeeService.loadAllEmployee();
	}
	public String back(){
		 
		 System.err.println("@@ Back called @@@");
		return "back";
	}
}
