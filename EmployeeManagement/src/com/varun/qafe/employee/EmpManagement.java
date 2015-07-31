package com.varun.qafe.employee;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

@Path(EmpManagement.BASE_PATH)
public class EmpManagement extends Application {

	static final String BASE_PATH = "/employee";

	static final String CREATE_EMP_PATH = "/create";

	static final String CHECK_EMP_PATH = "/checkemployee";
	
	static final String GEN_EMP_SALARY_PATH = "/genSalary";

	static List<Object> listOfEmployess = new ArrayList<Object>();

	@POST
	@Path(CREATE_EMP_PATH)
	@Produces("text/plain")
	public Response createEmployee(@QueryParam("name") String name, @QueryParam("role") String role,
			@QueryParam("emptype") String emptype, @QueryParam("bankAccountNumber") String bankAccountNumber) {
		Gson gson = new Gson();

		if (emptype.equals("Internal")) {
			listOfEmployess.add(new InternalEmployee(name, role, bankAccountNumber));

		} else if (emptype.equals("External")) {
			listOfEmployess.add(new ExternalEmployee(name, role, bankAccountNumber));
		}

		String jsonresults = gson.toJson(Employee.listOfEmployess);
		return Response.status(200).entity(jsonresults).header("Access-Control-Allow-Origin", "*").build();

	}

	@POST
	@Path(CHECK_EMP_PATH)
	@Produces("text/plain")
	public Response checkEmployee(@QueryParam("empID") int empID) {
		String response = "false";
		Object e = listOfEmployess.get(empID);
		if (e instanceof InternalEmployee) {
			//response = "True : ";
			response = InternalEmployee.class.getName() + "";
		}
		if (e instanceof ExternalEmployee) {
			//response = "True : ";
			response = ExternalEmployee.class.getName() + "";
		}

		return Response.status(200).entity(response).header("Access-Control-Allow-Origin", "*").build();

	}
	@POST
	@Path(GEN_EMP_SALARY_PATH)
	@Produces("text/plain")
	public Response generateEmployeeSalary(@QueryParam("empID") int empID) {
		String response = "0";
		Object e = listOfEmployess.get(empID);
		if (e instanceof InternalEmployee) {
			//response = "True : ";
			response = ((InternalEmployee)e).generateSalary()+"";
		}
		if (e instanceof ExternalEmployee) {
			//response = "True : ";
			response = ((ExternalEmployee)e).generateSalary()+"";
		}

		return Response.status(200).entity(response).header("Access-Control-Allow-Origin", "*").build();

	}
}
