package com.rest.api;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.rest.model.DoctorModel;
import controller.DoctorController;

@Path("doctorResources")
public class DoctorResource {
	
	@GET
	@Path("doctors")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public List<DoctorModel> getAlldoctor() throws Exception {		
		return DoctorController.getInstance().searchAll();
	}
	
	@GET
	@Path("doctor/{doctorId}")
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DoctorModel getDoctor(@PathParam("doctorId") int doctorId) throws Exception {		
		return DoctorController.getInstance().search(doctorId);
	}
	
	@POST
	@Path("doctor")
	public String saveDoctor(DoctorModel obj) throws Exception {
		DoctorController.getInstance().save(obj);
		return "Doctor Saved";
	}
	
	@PUT
	@Path("doctor")
	public String updateDoctor(DoctorModel obj) throws Exception {
		DoctorController.getInstance().update(obj);
		return "Doctor Updated";
	}
	
	@DELETE
	@Path("doctor/{doctorId}")
	public String deleteAppintment(@PathParam("doctorId") int doctorId) throws Exception {
		DoctorModel obj = new DoctorModel();
		obj.setdoctorId(doctorId);
		DoctorController.getInstance().delete(obj);
		return "Doctor Deleted";
	}

}
