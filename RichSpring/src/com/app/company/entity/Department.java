package com.app.company.entity;

import java.util.List;

public class Department {
	private long deptId;
	private String name;
	
	public Department()
	{
		
	}
	
	public Department(long deptId, String name) {
		
		this.deptId = deptId;
		this.name = name;
		
	}

	public long getDeptId() {
		return deptId;
	}
	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
