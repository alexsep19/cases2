package shu.cases2.server.rest;

import static shu.cases2.server.rest.api.IRestApiMediaType.JSON_UTF8;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXB;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import shu.cases2.shared.domain.TextBox;
import static javax.ws.rs.core.MediaType.*;

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
	
//	@POST
//    @Consumes(MULTIPART_FORM_DATA)
//    @Produces(JSON_UTF8)
//    public void setTextBox(@FormDataParam("json") InputStream is, @FormDataParam("json") FormDataContentDisposition header) {
//        System.out.println("Processing file # " + header.getFileName());
//        TextBox entity = JAXB.unmarshal(is, TextBox.class);
//        System.out.println("textBox = " + textBox.getName());
////        return Response.ok(entity).build();
//    }
	
//	@POST
//	@Path("/{param}")
//	@Consumes(JSON_UTF8)
//	@Produces(JSON_UTF8)
//	public Response setTextBox(@PathParam("param") TextBox textBox){
////		this.textBox = textBox;
////		System.out.println("textBox = " + textBox.isCheckbox() + " " + textBox.getName() + " " + textBox.getBirthday());
//		System.out.println("textBox = " + textBox.getName());
//		return Response.status(200).build();
//	}
}
