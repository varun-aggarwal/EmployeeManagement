package com.varun.qafe.employee;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private String name;
	private String role;
	private String bankCode;
	private int perhour;
	static int count;
	private String empType;
	static List<Employee> listOfEmployess = new ArrayList<Employee>();
	Employee()
	{
		super();
	}
	
	Employee(String name,String role,String bankCode,String empType)
	{
		
		this.name=name;
		this.role=role;
		this.bankCode=bankCode;
		this.empType=empType;
		count=count+1;
		listOfEmployess.add(this);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getBankCode() {
		return bankCode;
	}
	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public int getPerhour() {
		return perhour;
	}
	public void setPerhour(int perhour) {
		this.perhour = perhour;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}
	
	public int generateSalary()
	{
		return perhour*40*22;
		
	}
	
}
