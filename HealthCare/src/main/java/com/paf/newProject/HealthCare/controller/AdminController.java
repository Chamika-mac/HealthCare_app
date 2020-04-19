package com.paf.newProject.HealthCare.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.newProject.HealthCare.service.AdminService;

@Path("/admin")
public class AdminController {

	AdminService adminService = new AdminService();

	// Test function
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

			@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@FormParam("idNumber") String idNumber, @FormParam("adminRole") String adminRole,
			@FormParam("username") String username, @FormParam("password") String password

	) {
		System.out.println(firstName);

		String output = adminService.createAdmin(firstName, lastName, idNumber, adminRole, username, password);
		return output;

	}

	// Find Administrator by id
	@GET
	@Path("/id/{adminId}")
	public String getAdminById(@PathParam("adminId") String adminId) {

		return adminService.getAdminById(adminId);
	}

	// Find Administrator by name
	@GET
	@Path("/name/{firstName}")
	public String getAdminByName(@PathParam("firstName") String firstName) {

		return adminService.getAdminByName(firstName);
	}

	// Get Administrator count
	@GET
	@Path("/count")
	public String getAdminCount() {

		return adminService.getAdminCount();
	}

	// Update Administrator details
	@PUT
	@Path("/update/{idNumber}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateAdmin(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@PathParam("idNumber") String idNumber, @FormParam("adminRole") String adminRole,
			@FormParam("username") String username, @FormParam("password") String password) {

		System.out.println(firstName);

		String output = adminService.updateAdmin(firstName, lastName, idNumber, adminRole, username, password);
		return output;
	}

	// Delete Administrator
	@DELETE
	@Path("/delete/{idNumber}")
	public String deleteAdmin(@PathParam("idNumber") String idNumber) {

		return adminService.deleteAdmin(idNumber);
	}

}
