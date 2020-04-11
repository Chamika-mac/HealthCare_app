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

import com.rest.model.AppointmentModel;

import controller.AppointmentController;

@Path("appointmentResources")
public class AppointmentResource {
	
	@POST
	@Path("appointment")
	public String saveAppintment(AppointmentModel obj) throws Exception {
		AppointmentController.getInstance().save(obj);
		return "Appointement Saved";
	}
	
}
