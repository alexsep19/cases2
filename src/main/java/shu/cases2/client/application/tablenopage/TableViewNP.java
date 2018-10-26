package shu.cases2.client.application.tablenopage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.data.ListDataSource;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.data.loader.LoadCallback;
import gwt.material.design.client.data.loader.LoadConfig;
import gwt.material.design.client.data.loader.LoadResult;
import gwt.material.design.client.ui.pager.MaterialDataPager;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.TextColumn;
import shu.cases2.client.application.table.tools.PageDataSource;
import shu.cases2.client.application.tablenopage.tools.CustomRenderer;
import shu.cases2.client.application.tablenopage.tools.PersonRowFactory;
import shu.cases2.client.rest.PersonClient;
import shu.cases2.client.rpc.RpcService;
import shu.cases2.client.rpc.RpcServiceAsync;
import shu.cases2.shared.Person;
import shu.cases2.shared.domain.LoadPage;

public class TableViewNP  extends ViewImpl implements TablePresenterNP.MyView {

		public interface Binder extends UiBinder<Widget, TableViewNP> {
	    }
		
//        PersonClient client = GWT.create(PersonClient.class);
		RpcServiceAsync svc = GWT.create(RpcService.class);
		
		@UiField
	    MaterialDataTable<Person> table;
    
	    @Inject
	    TableViewNP(Binder uiBinder) {
	        initWidget(uiBinder.createAndBindUi(this));

	        table.setRowFactory(new PersonRowFactory());
	        table.setRenderer(new CustomRenderer<>());
	        
	        table.addColumn(new TextColumn<Person>() {
	            @Override
	            public Comparator<? super RowComponent<Person>> sortComparator() {
	                return (o1, o2) -> o1.getData().getFirstName().compareToIgnoreCase(o2.getData().getFirstName());
	            }
	            @Override
	            public String getValue(Person object) {
	                return object.getFirstName();
	            }
	        }, "First Name");
	        
	        table.addColumn(new TextColumn<Person>() {
	            @Override
	            public Comparator<? super RowComponent<Person>> sortComparator() {
	                return (o1, o2) -> o1.getData().getLastName().compareToIgnoreCase(o2.getData().getLastName());
	            }
	            @Override
	            public String getValue(Person object) {
	                return object.getLastName();
	            }
	        }, "Last Name");

	        table.addColumn(new TextColumn<Person>() {
	            @Override
	            public boolean numeric() {
	                return true;
	            }
	            @Override
	            public HideOn hideOn() {
	                return HideOn.HIDE_ON_MED_DOWN;
	            }
	            @Override
	            public Comparator<? super RowComponent<Person>> sortComparator() {
	                return (o1, o2) -> o1.getData().getPhone().compareToIgnoreCase(o2.getData().getPhone());
	            }
	            @Override
	            public String getValue(Person object) {
	                return object.getPhone();
	            }
	        }, "Phone");
	        
//	        table.setVisibleRange(0, 10);
	        refreshTable();
	        
	        table.addColumnSortHandler(event -> {
	            GWT.log("Sorted: " + event.getSortContext().getSortDir() + ", columnIndex: " + event.getColumnIndex());
	            table.getView().refresh();
	        });
	        
	        table.addRowDoubleClickHandler(event -> {
	            // GWT.log("Row Double Clicked: " + model.getId() + ", x:" + mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
	            Window.alert("Row Double Clicked: " + event.getModel().getId());
	        });

	    }
	    
	    private void refreshTable(){
			svc.getAllPersons(new AsyncCallback<LoadPage<Person>>(){
			@Override
			public void onFailure(Throwable exception) {
				GWT.log("Load failure", exception);
			}

			@Override
			public void onSuccess(LoadPage<Person> loadPage) {
		    	table.setRowData(0, loadPage.getData());
			}
		});

	    }
}
