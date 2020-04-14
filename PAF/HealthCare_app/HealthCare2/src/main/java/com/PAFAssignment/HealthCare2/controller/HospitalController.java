package com.PAFAssignment.HealthCare2.controller;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.PAFAssignment.HealthCare2.service.HospitalService;

@Path("/hospital")
public class HospitalController {

	HospitalService hospitalService = new HospitalService();
	
	//Test function
	@GET
	@Path("/hst")
	@Produces(MediaType.TEXT_HTML)
	public String testing() {
		
		return "Hospital Test Function is working";
		
	}

	// Insert data
	@POST
	@Path("/register")
	@Produces(MediaType.TEXT_HTML)
	public String registerHospital(
			
			@FormParam("hospitalName") String hospitalName,
			@FormParam("hospitalId") String hospitalId,
			@FormParam("hospitalAddress") String hospitalAddress,
			@FormParam("phoneNo") String phoneNo,
			@FormParam("doctorDetails") String doctorDetails,
			@FormParam("AppointmentDetails") String AppointmentDetails,
			@FormParam("userName") String userName,
			@FormParam("password") String password
			
			) {
		
		String output = hospitalService.registerHospital(hospitalName, hospitalId, hospitalAddress, phoneNo, doctorDetails, AppointmentDetails, userName, password);
		return output;
		
	}

}
