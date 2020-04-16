package com.rest.api;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.rest.model.HospitalModel;

import controller.HospitalController;

@Path("hospitalResources")
public class HospitalResource {

	@GET
	@Path("hospitals")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<HospitalModel> getAllHospital() throws Exception {		
		return HospitalController.getInstance().searchAll();
	}
	
	@GET
	@Path("hospital/{hospitalId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public HospitalModel getHospital(@PathParam("hospitalId") int hospitalId) throws Exception {		
		return HospitalController.getInstance().search(hospitalId);
	}
	
	@POST
	@Path("hospital")
	public String saveHospital(HospitalModel obj) throws Exception {
		HospitalController.getInstance().save(obj);
		return "Hospital Saved";
	}
	
	@PUT
	@Path("hospital")
	public String updateHospital(HospitalModel obj) throws Exception {
		HospitalController.getInstance().update(obj);
		return "Hospital Updated";
	}
	
	@DELETE
	@Path("hospital/{hospitalId}")
	public String deleteHospital(@PathParam("hospitalId") int hospitalId) throws Exception {
		HospitalModel obj = new HospitalModel();
		obj.setHospitalId(hospitalId);
		HospitalController.getInstance().delete(obj);
		return "Hospital Deleted";
	}
	
}
