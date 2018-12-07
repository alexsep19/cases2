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
//		int rowIndex = 1;
        persons = new ArrayList<>();
        for(int i = 1; i <= 50; i++){
        	persons.add(new Person(i, "Field " + i, "Field " + i, "Field " + i, "No " + i,"Category " + i));
        }
        
//        for(int k = 1; k <= 10; k++){
//            // Generate 100 rows
//            for(int i = 1; i <= 10; i++, rowIndex++){
//            	persons.add(new Person(i, "Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i,"Category " + k));
//            }
//        }	
    }

//	@Override
//	public LoadResult<Person> getPersons(int offset, int limit) {
//		return new LoadResult<Person>( persons.subList(offset, offset + limit), offset, persons.size());
//	}

	public LoadPage<Person> getAllPersons() {
		return new LoadPage<Person>(persons, 0, persons.size());
	}

	public List<Person> getPersons() {
		return persons;
	}

	public List<Person> savePerson(Person person){
		if (person.getId() == 0){
			person.setId(persons.size() + 1);
			persons.add(person);
		}else{
			persons.set(getIndexById(person.getId()), person);
		}
//		renumPerson();
		return persons;
	}
	
	public List<Person> delPerson(Person person){
		persons.remove(getIndexById(person.getId()));
//		renumPerson();
		return persons;
	}
	
	private int getIndexById(int id){
		for(int i = 0; i < persons.size(); i++ ){
		  if (persons.get(i).getId() == id) return i;
		}
		return -1;
	}
	
//	private void renumPerson(){
//		for(int i = 0; i < persons.size(); i++){
//		   Person p = persons.get(i);
//		   p.setId( i + 1 );
//		   persons.set(i, p);
//		}
//	}
}
