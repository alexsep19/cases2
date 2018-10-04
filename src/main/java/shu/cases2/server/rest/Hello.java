package shu.cases2.server.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import static shu.cases2.server.rest.api.IRestApiMediaType.TEXT_UTF8;

@Path("/")
public class Hello {

	public Hello() {
		// TODO Auto-generated constructor stub
	}

	@GET
	@Path("/hello")
	@Produces(TEXT_UTF8)
	public String getHello(){
		return "Hellol!";
	}
}
