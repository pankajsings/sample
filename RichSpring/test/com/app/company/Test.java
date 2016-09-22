package com.app.company;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.app.company.entity.Employee;
import com.app.company.service.EmployeeService;
import com.app.company.service.impl.EmployeeServiceImpl;

public class Test {
	public static void main(String args[])
	{
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/spring-context.xml");
		EmployeeService e = (EmployeeService) context.getBean("employeeService");
		
		// Load All Employees
		List<Employee> empList = e.loadEmployeeByCriteria(new Employee());
		Iterator itr = empList.iterator();
		
		while(itr.hasNext())
		{
			Employee emp = (Employee) itr.next();
			System.err.println(emp.getEmpId()+" , "+emp.getName()+" , "+emp.getDepartment().getName());
		}
		
		// Get employee of id 
		
		Employee emp = e.loadEmployee(2);
		System.err.println(emp);
		System.err.println(emp.getEmpId()+" , "+emp.getName()+" , "+emp.getDepartment().getName());
		
		
		/*
		emp.setName("Emp2");
		emp.setAge("35");
		Employee e3 = (Employee)e.updateEmployee(emp);
		System.err.println(e3.getEmpId()+" , "+e3.getName()+" , "+e3.getAge()+" , "+e3.getDepartment().getName());*/
		
		
		// Add new Employee
		Employee e4 = new Employee();
		e4.setName("Emp5");
		e4.setAge("35");
		e4.setDepartment(emp.getDepartment());
		e4 = e.createEmployee(e4);
		System.err.println(e4.getEmpId()+" , "+e4.getName()+" , "+e4.getAge()+" , "+e4.getDepartment().getName());
		
	}
}
