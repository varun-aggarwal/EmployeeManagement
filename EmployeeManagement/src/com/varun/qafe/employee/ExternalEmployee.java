package com.varun.qafe.employee;

public class ExternalEmployee extends Employee {

	 ExternalEmployee (String name,String role,String bankCode)
	{
		
		 super(name, role, bankCode, "External");
	}
	 
	 public int generateSalary()
		{
			
			super.setPerhour(80);
			return super.generateSalary();
		}
}
