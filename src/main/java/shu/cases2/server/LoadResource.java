package shu.cases2.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("component1")
public class LoadResource {

	public LoadResource() {
	}

	@GET
	@Produces("application/json")
	public String getFieldValue(){
		return "FieldVal";
	}
}
