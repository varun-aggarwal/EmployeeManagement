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

@Path(MassHireFire.BASE_PATH)
public class MassHireFire extends Application {

	static final String BASE_PATH = "/garbageCollection";

	static final String HIRE_EMP_PATH = "/hire";

	static final String FIRE_EMP_PATH = "/fire";
	
	static final String CHECK_RESOURCES = "/checkResources";
	
	static List<Object> listOfEmployess = new ArrayList<Object>();

	@POST
	@Path(HIRE_EMP_PATH)
	@Produces("text/plain")
	public Response createEmployee(@QueryParam("noOfEmplyees") long noOfEmplyees) {
		Employee e = null;
		for(int i = 0;i<noOfEmplyees;i++) {
			e = new Employee();
			listOfEmployess.add(e);
		}
		
		return Response.status(200).entity(noOfEmplyees+" employees created").header("Access-Control-Allow-Origin", "*").build();

	}

	@POST
	@Path(FIRE_EMP_PATH)
	@Produces("text/plain")
	public Response checkEmployee(@QueryParam("noOffireEmplyees") int noOffireEmplyees) {
		
		String response="";
		Runtime rt = Runtime.getRuntime();
		boolean startfiring = false;
		if(noOffireEmplyees > listOfEmployess.size())
		{
			response = "You cannot fire more people then the number of employee in organisation.";
		}
		else if(noOffireEmplyees == listOfEmployess.size())
		{
			response = "You cannot fire yourself.";
		}
		else
		{
			startfiring=true;
		}
		if(startfiring == true)
		{
		for(int i = 0;i<noOffireEmplyees;i++) {
			listOfEmployess.remove(i);
		}
		}
		rt.gc();
		return Response.status(200).entity(noOffireEmplyees+" employees have been fired").header("Access-Control-Allow-Origin", "*").build();

	}
	@POST
	@Path(CHECK_RESOURCES)
	@Produces("text/plain")
	public Response generateEmployeeSalary(@QueryParam("name") String name) {
		Runtime rt = Runtime.getRuntime();
		return Response.status(200).entity((rt.totalMemory()-rt.freeMemory())+ "~" + (rt.freeMemory())).header("Access-Control-Allow-Origin", "*").build();

	}
}
