package shu.cases2.server.rpc;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import gwt.material.design.client.data.loader.LoadResult;
import shu.cases2.client.rpc.RpcService;
import shu.cases2.shared.Person;
import shu.cases2.shared.domain.LoadPage;

public class PersonServiceImp extends RemoteServiceServlet implements RpcService{
	List<Person> persons;
	
	public PersonServiceImp() {
		int rowIndex = 1;
        persons = new ArrayList<>();
        for(int k = 1; k <= 10; k++){
            // Generate 100 rows
            for(int i = 1; i <= 10; i++, rowIndex++){
            	persons.add(new Person(i, "Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i,"Category " + k));
            }
        }	}

//	@Override
//	public LoadResult<Person> getPersons(int offset, int limit) {
//		return new LoadResult<Person>( persons.subList(offset, offset + limit), offset, persons.size());
//	}

	@Override
	public LoadPage<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return new LoadPage<Person>(persons, 0, persons.size());
	}

}
