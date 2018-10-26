package shu.cases2.client.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import gwt.material.design.client.data.loader.LoadResult;
import shu.cases2.shared.Person;
import shu.cases2.shared.domain.LoadPage;

@RemoteServiceRelativePath("rpcservlet")
public interface RpcService extends RemoteService{

//	LoadResult<Person> getPersons( int offset, int limit);
	
	LoadPage<Person> getAllPersons();
}
