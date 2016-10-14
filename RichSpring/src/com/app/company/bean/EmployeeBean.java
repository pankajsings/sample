package com.app.company.bean;

import java.io.Serializable;
import java.util.List;

import com.app.company.entity.Department;
import com.app.company.entity.Employee;
import com.app.company.service.EmployeeService;
import com.app.company.service.impl.EmployeeServiceImpl;
import com.example.customer.model.Customer;



public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	EmployeeService employeeService;
	private String name;
	private String age;
	private String lang;
	
		
	public String getLang() {
		return "Java";
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
		
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
	public String addEmployee(){
		 
		Employee e = new Employee();
		e.setName(getName());
		e.setAge(getAge());
		Department d = new Department(1,"Software Development"); 
		e.setDepartment(d);
		employeeService.createEmployee(e);
		 
		clearForm();
		 
		return "employeeList";
	}
	
	public String showEmployee(){
		 
			 
		return "employeeList";
	}
	
	public String back(){
		 
		 System.err.println("@@ Back called @@@");
		return "back";
	}
	private void clearForm(){
		setName("");
		setAge("");
	} 
}
