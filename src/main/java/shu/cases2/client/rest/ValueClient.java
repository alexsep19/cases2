package shu.cases2.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import shu.cases2.shared.domain.NameValue;

@Path("/api/values")
public interface ValueClient extends RestService{

	@GET
    public void getValues( MethodCallback<List<NameValue>> callback);
	  
	@GET
	@Path("/{name}")
	public void getValues(@PathParam("name") String name, MethodCallback<NameValue> callback);
}
