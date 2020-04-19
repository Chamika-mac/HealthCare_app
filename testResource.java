package api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/testResource")
public class testResource {
	@GET 
    @Produces("text/plain")
    public String getIt() {
		//message to test
        return "Hi User!";
    }

}
