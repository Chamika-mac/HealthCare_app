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

import com.paf.newProject.HealthCare.service.PharmacyService;

@Path("/pharmacy")
public class PharmacyController {

	PharmacyService pharmacyService = new PharmacyService();

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
	public String createPharmacy(

			@FormParam("pharmacyId") String pharmacyId, @FormParam("pharmacyName") String pharmacyName,
			@FormParam("address") String address, @FormParam("telephone") String telephone

	) {

		return pharmacyService.createPharmacy(pharmacyId, pharmacyName, address, telephone);

	}

	// Find Pharmacy by id
	@GET
	@Path("/id/{pharmacyId}")
	public String getPharmacyById(@PathParam("pharmacyId") String pharmacyId) {

		return pharmacyService.getPharmacyById(pharmacyId);
	}

	// Find Pharmacy by name
	@GET
	@Path("/name/{pharmacyName}")
	public String getPharmacyByName(@PathParam("pharmacyName") String pharmacyName) {

		return pharmacyService.getPharmacyByName(pharmacyName);
	}

	// Get Pharmacy count
	@GET
	@Path("/count")
	public String getPharmacyCount() {

		return pharmacyService.getPharmacyCount();
	}

	// Update Administrator details
	@PUT
	@Path("/update/{pharmacyId}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePharmacy(@PathParam("pharmacyId") String pharmacyId,
			@FormParam("pharmacyName") String pharmacyName, @FormParam("address") String address,
			@FormParam("telephone") String telephone) {

		return pharmacyService.updatePharmacy(pharmacyId, pharmacyName, address, telephone);
	}

	// Delete Pharmacy
	@DELETE
	@Path("/delete/{pharmacyId}")
	public String deleteAdmin(@PathParam("pharmacyId") String pharmacyId) {

		return pharmacyService.deletePharmacy(pharmacyId);
	}

}
