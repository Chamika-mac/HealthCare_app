package com.PAFAssignment.HealthCare2.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.PAFAssignment.HealthCare2.service.AdminService;

@Path("/admin")
public class AdminController {

	AdminService adminService = new AdminService();
	
	//Test function
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String testing() {
		
		return "Test Function is working";
		
	}

	// Insert data
	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_HTML)
	public String createAdmin(
			
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("idNumber") String idNumber,
			@FormParam("adminRole") String adminRole,
			@FormParam("username") String username,
			@FormParam("password") String password
			
			) {
		
		String output = adminService.createAdmin(firstName, lastName, idNumber, adminRole, username, password);
		return output;
		
	}

}
