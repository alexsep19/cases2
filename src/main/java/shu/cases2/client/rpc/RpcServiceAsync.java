package shu.cases2.client.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import gwt.material.design.client.data.loader.LoadResult;
import shu.cases2.shared.Person;
import shu.cases2.shared.domain.LoadPage;

public interface RpcServiceAsync {
//	void getPersons( int offset, int limit,  AsyncCallback<LoadResult<Person>> asyncCallback);
	void getAllPersons(AsyncCallback<LoadPage<Person>> asyncCallback);
	
	void getPersons(AsyncCallback<List<Person>> asyncCallback); 
	void savePerson(Person person, AsyncCallback<List<Person>> asyncCallback);
	void delPerson(Person person, AsyncCallback<List<Person>> asyncCallback);
}
