package shu.cases2.server.rest;

import static shu.cases2.server.rest.api.IRestApiMediaType.JSON_UTF8;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import shu.cases2.server.rest.api.LoadResult;
import shu.cases2.shared.Person;

@Path("person")
public class PersonRest {
	ArrayList<Person> persons;
	
	public PersonRest() {
		int rowIndex = 1;
        persons = new ArrayList<>();
        for(int k = 1; k <= 10; k++){
            // Generate 100 rows
            for(int i = 1; i <= 10; i++, rowIndex++){
            	persons.add(new Person(i, "Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i,"Category " + k));
            }
        }
	}
	
	@GET
	@Path("{offset}/{limit}")
	@Produces(JSON_UTF8)
	public LoadResult<Person> getPersons(@PathParam("offset") int offset, @PathParam("limit") int limit) {
	    return new LoadResult<Person>( (ArrayList<Person>) persons.subList(offset, offset + limit), offset, persons.size());
	}

}
