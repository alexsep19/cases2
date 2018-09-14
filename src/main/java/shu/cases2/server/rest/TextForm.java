package shu.cases2.server.rest;

import static shu.cases2.server.rest.api.IRestApiMediaType.JSON_UTF8;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gwt.junit.client.WithProperties.Property;

import shu.cases2.shared.domain.TextBox;

@Path("textform")
public class TextForm {
	TextBox textBox;
	
	public TextForm() {
		Date date = null;
		try {
			date = new SimpleDateFormat("dd.MM.yyyy").parse("10.09.2018");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		textBox = new TextBox(true, "Фафа", date);
//		textBox = new TextBox(true, "Фафа");
	}
	
	@GET
	@Produces(JSON_UTF8)
	public TextBox getTextBox() {
	    return textBox;
	}
	
	@POST
	@Path("/{param}")
	@Consumes(JSON_UTF8)
	@Produces(JSON_UTF8)
	public void setTextBox(@PathParam("param") TextBox textBox){
		this.textBox = textBox;
		System.out.println("textBox = " + textBox.isCheckbox() + " " + textBox.getName() + " " + textBox.getBirthday());
	}
}
