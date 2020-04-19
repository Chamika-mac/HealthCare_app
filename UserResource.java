package api;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.UserModel;

import controller.UserController;

public class UserResource {
	@POST
	@Path("User")
	public String saveUser(UserModel obj) throws Exception {
		UserController.getInstance().save(obj);
		return "User Saved";
	}
	
}
