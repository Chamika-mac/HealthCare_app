package com.paf.newProject.HealthCare.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.newProject.HealthCare.service.DoctorService;

@Path("/doctor")
public class DoctorController {

	DoctorService doctorService = new DoctorService();

	// Test function
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String testing() {

		return "Test Function is working";

	}

	// Create Doctor
	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_HTML)
	public String createDoctor(

			@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@FormParam("idNumber") String idNumber, @FormParam("registrationID") String registrationID,
			@FormParam("totalAppointment") String totalAppointment, @FormParam("username") String username,
			@FormParam("password") String password

	) {

		return doctorService.createDoctor(firstName, lastName, idNumber, registrationID, totalAppointment, username,
				password);

	}

	// Find User by identity number
	@GET
	@Path("/id/{idNumber}")
	public String getDoctorById(@PathParam("idNumber") String idNumber) {

		return doctorService.getDoctorById(idNumber);
	}

	// Delete User from database
	@DELETE
	@Path("/delete/{idNumber}")
	public String deleteDoctor(@PathParam("idNumber") String idNumber) {

		return doctorService.deleteDoctor(idNumber);
	}

	// Get Doctor count
	@GET
	@Path("/count")
	public String getDoctorCount() {

		return doctorService.getDoctorCount();
	}

}
