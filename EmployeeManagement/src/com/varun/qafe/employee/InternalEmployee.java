package com.varun.qafe.employee;

public class InternalEmployee extends Employee {

	InternalEmployee (String name,String role,String bankCode)
	{
		 super(name, role, bankCode,"Internal");
	}
	public int generateSalary()
	{
		
		super.setPerhour(40);
		return super.generateSalary();
	}
}
