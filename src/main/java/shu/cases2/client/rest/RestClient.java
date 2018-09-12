package shu.cases2.client.rest;

import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;

@Path("/api/component1")
public interface RestClient {

	public String getFieldValue(MethodCallback<String> callback);
}
