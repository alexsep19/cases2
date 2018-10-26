package shu.cases2.client.application.table;

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
import shu.cases2.client.rest.PersonClient;
import shu.cases2.client.rpc.RpcService;
import shu.cases2.client.rpc.RpcServiceAsync;
import shu.cases2.shared.Person;

public class TableView  extends ViewImpl implements TablePresenter.MyView {

		public interface Binder extends UiBinder<Widget, TableView> {
	    }
		
//        PersonClient client = GWT.create(PersonClient.class);
//		PersonServiceAsync svc = GWT.create(PersonService.class);
		
		@UiField
	    MaterialDataTable<Person> table;
	    private PageDataSource<Person> dataSource = new PageDataSource<Person>();
	    
		private MaterialDataPager<Person> pager = new MaterialDataPager<Person>(){
			protected void doLoad(int offset, int limit) {
//				svc.getPersons(offset, limit, new AsyncCallback<LoadResult<Person>>(){
//					@Override
//					public void onFailure(Throwable exception) {
//						GWT.log("Load failure", exception);
//					}
//
//					@Override
//					public void onSuccess(LoadResult<Person> loadResult) {
//						((PageDataSource<Person>)getDataSource()).setData(loadResult.getData());
//		                setOffset(loadResult.getOffset());
//		                totalRows = loadResult.getTotalLength();
//		                table.setVisibleRange(loadResult.getOffset(), loadResult.getData().size());
//		                table.loaded(loadResult.getOffset(), loadResult.getData());
//		                updateUi();
//					}
//					
//				});
				
//                client.getPersons( offset, limit, new MethodCallback<LoadResult<Person>>(){
//
//					@Override
//					public void onFailure(Method method, Throwable exception) {
//						GWT.log("Load failure", exception);
//					}
//
//					@Override
//					public void onSuccess(Method method, LoadResult<Person> loadResult) {
//						((PageDataSource<Person>)getDataSource()).setData(loadResult.getData());
//		                setOffset(loadResult.getOffset());
//		                totalRows = loadResult.getTotalLength();
//		                table.setVisibleRange(loadResult.getOffset(), loadResult.getData().size());
//		                table.loaded(loadResult.getOffset(), loadResult.getData());
//		                updateUi();
//					}
//                });	        		

//		        dataSource.load(new LoadConfig<>(offset, limit, table.getView().getSortContext(),
//		                table.getView().getOpenCategories()), new LoadCallback<Person>() {
//		            @Override
//		            public void onSuccess(LoadResult<Person> loadResult) {
//		                setOffset(loadResult.getOffset());
//		                totalRows = loadResult.getTotalLength();
//		                table.setVisibleRange(loadResult.getOffset(), loadResult.getData().size());
//		                table.loaded(loadResult.getOffset(), loadResult.getData());
//		                updateUi();
//		            }
//
//		            @Override
//		            public void onFailure(Throwable caught) {
//		                GWT.log("Load failure", caught);
//		                //TODO: What we need to do on failure? May be clear table?
//		            }
//
//		        });
		}};
	    
	    @Inject
	    TableView(Binder uiBinder) {
	        initWidget(uiBinder.createAndBindUi(this));
	        
	        // Generate 20 categories
//	        int rowIndex = 1;
//	        List<Person> people = new ArrayList<>();
//	        for(int k = 1; k <= 10; k++){
//	            // Generate 100 rows
//	            for(int i = 1; i <= 10; i++, rowIndex++){
//	                people.add(new Person(i, "Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i,"Category " + k));
//	            }
//	        }

//	        dataSource = new PageDataSource<Person>(){
//	        	@Override
//	        	public LoadResult<Person> loadData(LoadConfig<Person> loadConfig){
//                    client.getPersons(loadConfig.getOffset(), loadConfig.getLimit(), new MethodCallback<LoadResult<Person>>(){
//
//						@Override
//						public void onFailure(Method method, Throwable exception) {
//							// TODO Auto-generated method stub
//							
//						}
//
//						@Override
//						public void onSuccess(Method method, LoadResult<Person> response) {
//							// TODO Auto-generated method stub
//							
//						}
//                    	
//                    });	        		
//	        	
////	        		setData(loadConfig.);
//	        		return new LoadResult(data, loadConfig.getOffset(), 0);
//	        		}
//	        };
//	        dataSource.add(0, people);

	        pager.setTable(table);
	        pager.setDataSource(dataSource);
//	        pager.setRowCountOptions(5, 10, 15, 20); 
//	        pager.getPageSelection().setLabel("Стр");

//	        table.setTitle("Таблица");
	        table.add(pager);
//	        table.setTotalRows(6000);
//	        table.setVisibleRange(1, 15);
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
	        
	        table.addColumnSortHandler(event -> {
	            GWT.log("Sorted: " + event.getSortContext().getSortDir() + ", columnIndex: " + event.getColumnIndex());
	            table.getView().refresh();
	        });
	        
	        table.addRowDoubleClickHandler(event -> {
	            // GWT.log("Row Double Clicked: " + model.getId() + ", x:" + mouseEvent.getPageX() + ", y: " + mouseEvent.getPageY());
	            Window.alert("Row Double Clicked: " + event.getModel().getId());
	        });

	    }
}
