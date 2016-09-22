package com.app.company.entity;

public class Employee {
	
	private long empId;
	private String name;
	private String age;
	private Department department;
	
	public Employee()
	{
		
	}
	public Employee(long empId,String name,String age,Department department)
	{
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.department = department;
	}
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
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
	
}
