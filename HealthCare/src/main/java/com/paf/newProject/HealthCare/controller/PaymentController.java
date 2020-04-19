package com.paf.newProject.HealthCare.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.paf.newProject.HealthCare.service.PaymentService;

@Path("/payment")
public class PaymentController {

	PaymentService paymentService = new PaymentService();

	// Test function
	@GET
	@Path("/test")
	@Produces(MediaType.TEXT_HTML)
	public String testing() {

		return "Test Function is working";

	}

	// Create transaction
	@POST
	@Path("/create")
	@Produces(MediaType.TEXT_HTML)
	public String createPayment(

			@FormParam("transactionId") String transactionId, @FormParam("paymentMethod") String paymentMethod,
			@FormParam("userId") String userId, @FormParam("totalAmount") String totalAmount

	) {

		return paymentService.createPayment(transactionId, paymentMethod, userId, totalAmount);
	}

	// Find Hospital by hospital id
	@GET
	@Path("/id/{transactionId}")
	public String getPaymentById(@PathParam("transactionId") String transactionId) {

		return paymentService.getPaymentById(transactionId);
	}

	// Delete Hospital
	@DELETE
	@Path("/delete/{transactionId}")
	public String deletePayment(@PathParam("transactionId") String transactionId) {

		return paymentService.deletePayment(transactionId);
	}

	// Get Hospital count
	@GET
	@Path("/count")
	public String getPaymentCount() {

		return paymentService.getPaymentCount();
	}
}
