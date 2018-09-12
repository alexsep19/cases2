package shu.cases2.server.rest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import shu.cases2.shared.domain.NameValue;

@Path("values")
public class Values {

	Map<String, NameValue> database;
	public Values() {
		database = new HashMap<String, NameValue>();
		NameValue item1 = new NameValue("1", "афыавфыыва"); 
		NameValue item2 = new NameValue("2", "2222222222");
		database.put(item1.getName(), item1 );
		database.put(item2.getName(), item2 );
	}
	
	@GET
	@Produces("application/json")
	public Collection<NameValue> get() {
	    return database.values();
	}
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	public NameValue getHello(@PathParam("name") String name) {
	    return database.get(name);
	}
}
