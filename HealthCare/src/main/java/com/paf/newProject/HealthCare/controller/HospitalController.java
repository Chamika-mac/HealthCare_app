package com.paf.newProject.HealthCare.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.newProject.HealthCare.service.HospitalService;

@Path("/hospital")
public class HospitalController {

	HospitalService hospitalService = new HospitalService();

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

			@FormParam("hospitalName") String hospitalName, @FormParam("hospitalId") String hospitalId,
			@FormParam("hospitalAddress") String hospitalAddress,
			@FormParam("hospitalTelephone") String hospitalTelephone,
			@FormParam("numOfAppointments") String numOfAppointments, @FormParam("numOfDoctors") String numOfDoctors

	) {

		String output = hospitalService.createHospital(hospitalName, hospitalId, hospitalAddress, hospitalTelephone,
				numOfAppointments, numOfDoctors);
		return output;
	}

	// Find Hospital by hospital id
	@GET
	@Path("/id/{hospitalId}")
	public String getHospitalById(@PathParam("hospitalId") String hospitalId) {

		return hospitalService.getHospitalById(hospitalId);
	}

	// Delete Hospital
	@DELETE
	@Path("/delete/{hospitalId}")
	public String deleteDoctor(@PathParam("hospitalId") String hospitalId) {

		return hospitalService.deleteHospital(hospitalId);
	}

	// Get Hospital count
	@GET
	@Path("/count")
	public String getDoctorCount() {

		return hospitalService.getHospitalCount();
	}
}
