package shu.cases2.client.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import shu.cases2.shared.domain.TextBox;

@Path("/rest/textform")
public interface TextBoxClient extends RestService{
	
	@GET
	public void getTextBox(MethodCallback<TextBox> callback);
	
	@POST
	@Path("/{param}")
	public void setTextBox(@PathParam("param") TextBox textBox,  MethodCallback<Void> callback);
}
