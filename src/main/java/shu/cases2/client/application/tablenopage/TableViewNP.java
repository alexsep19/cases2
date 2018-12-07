package shu.cases2.client.application.tablenopage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.data.ListDataSource;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.data.loader.LoadCallback;
import gwt.material.design.client.data.loader.LoadConfig;
import gwt.material.design.client.data.loader.LoadResult;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import gwt.material.design.client.ui.pager.MaterialDataPager;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.Column;
import gwt.material.design.client.ui.table.cell.TextColumn;
import shu.cases2.client.application.table.tools.PageDataSource;
import shu.cases2.client.application.tablenopage.tools.CustomRenderer;
import shu.cases2.client.application.tablenopage.tools.PersonRowFactory;
import shu.cases2.client.application.tablenopage.wintools.ApproveDialog;
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
    
		EditWindow<Person> editWindow = new EditWindow<Person>("560px", "180px"){
		   @Override
		   public void saveModel(Person person, AsyncCallback<List<Person>> asyncCallback){
			   svc.savePerson( person, asyncCallback);
		   } 
		   public void fillTable(List<Person> loadPage){
			   table.setRowData(0, loadPage);
		   }
		};
		
	    @Inject
	    TableViewNP(Binder uiBinder) {
	        initWidget(uiBinder.createAndBindUi(this));

	        table.setRowFactory(new PersonRowFactory());
	        table.setRenderer(new CustomRenderer<>());

	        table.getTableTitle().setText("Таблица без страниц");
	        
	        TextColumn tcFirstName = new TextColumn<Person>() {
	            @Override
	            public Comparator<? super RowComponent<Person>> sortComparator() {
	                return (o1, o2) -> o1.getData().getFirstName().compareToIgnoreCase(o2.getData().getFirstName());
	            }
	            @Override
	            public String getValue(Person object) {
	                return object.getFirstName();
	            }
	        };
	        table.addColumn( tcFirstName, "First Name");
	        editWindow.addField( tcFirstName, new EditField<Person>(){
	        	@Override
	        	public void setField(Person model){
//	        		getMaterialTextBox().setFocus(true);
//	        		getMaterialTextBox().setValue(model.getFirstName());
	        		setFocusField();
	        		setFieldValue(model.getFirstName());
	        	};
	        	@Override
	        	public void getField(Person model){
	        		model.setFirstName((String)getFieldValue());
	        	}
	        }, 20);
	        
	        TextColumn tcLastName = new TextColumn<Person>() {
	            @Override
	            public Comparator<? super RowComponent<Person>> sortComparator() {
	                return (o1, o2) -> o1.getData().getLastName().compareToIgnoreCase(o2.getData().getLastName());
	            }
	            @Override
	            public String getValue(Person object) {
	                return object.getLastName();
	            }
	        }; 
	        table.addColumn( tcLastName, "Last Name");
	        editWindow.addField( tcLastName, new EditField<Person>(){
	        	@Override
	        	public void setField(Person model){
	        		setFieldValue(model.getLastName());
//	        		getMaterialTextBox().setValue(model.getLastName());
	        	};
	        	@Override
	        	public void getField(Person model){
	        		model.setLastName((String)getFieldValue());
	        	}
	        }, 20);

	        TextColumn tcPhone = new TextColumn<Person>() {
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
	        };
	        table.addColumn( tcPhone, "Phone");
	        editWindow.addField( tcPhone, new EditField<Person>(){
	        	@Override
	        	public void setField(Person model){
	        		setFieldValue(model.getPhone());
	        	}
	        	@Override
	        	public void getField(Person model){
	        		model.setPhone((String)getFieldValue());
	        	}
	        }, 20);
	        
//	        table.setVisibleRange(0, 10);
	        refreshTable();
	        
	        table.addColumnSortHandler(event -> {
	            GWT.log("Sorted: " + event.getSortContext().getSortDir() + ", columnIndex: " + event.getColumnIndex());
	            table.getView().refresh();
	        });

	        table.addRowDoubleClickHandler(event -> {
//	            Window.alert("Row Double Clicked: " + event.getModel().getId());
	            editWindow.setTitle("Редактировать");
	            editWindow.setValues(event.getModel());
//	            editWindow.setValues(table.getSelectedRowModels(true).get(0));
//	            MaterialTextBox tb = new MaterialTextBox();
//	            tb.setFieldType(FieldType.FILLED);
//	            tb.setLabel("поле 1");
//	            tb.setMaxLength(20);
//	            tb.setValue("валюе");
//	            mr.add(tb);
//	            mp.add(mr);
//	            editRecWindow.add(mp);
	            editWindow.open();
	        });
	        
	        Panel panel = table.getScaffolding().getToolPanel();
	        MaterialIcon addIcon = new MaterialIcon(IconType.ADD);
	        addIcon.setWaves(WavesType.LIGHT);
	        addIcon.setCircle(true);
	        addIcon.addClickHandler(event ->{
	        	editWindow.setTitle("Создать");
	        	editWindow.setValues(new Person(0,"","","",""));
	        	editWindow.open();
	        });
	        
	        MaterialIcon delIcon = new MaterialIcon(IconType.DELETE);
	        delIcon.setWaves(WavesType.LIGHT);
	        delIcon.setCircle(true);
	        delIcon.addClickHandler(event ->{
	        	if (table.getSelectedRowModels(true).size() != 1) {
	        		MaterialToast.fireToast("Необходимо выбрать 1 запись");
//	        		Window.alert("Необходимо выбрать 1 запись");
	        		return;
	        	}
	        	ApproveDialog approveDialog = new ApproveDialog("Удалить запись?"){
	        		@Override
	        		public void processApprove(){
		        		svc.delPerson( table.getSelectedRowModels(true).get(0), new AsyncCallback<List<Person>>(){
		        			@Override
		        			public void onFailure(Throwable exception) {
		        				Window.alert("Load failure" + exception);
		        			}
		        			@Override
		        			public void onSuccess(List<Person> loadPage) {
					    	table.setRowData(0, loadPage);
//					    	table.getView().setRedraw(true); 
//					    	 table.getView().refresh();
		        			}
		        		});
	        		};
	        	}; 
//	        	if (approveDialog.isApproved()){
//	        		svc.delPerson( table.getSelectedRowModels(true).get(0), new AsyncCallback<List<Person>>(){
//	        			@Override
//	        			public void onFailure(Throwable exception) {
//	        				Window.alert("Load failure" + exception);
//	        			}
//	        			@Override
//	        			public void onSuccess(List<Person> loadPage) {
//				    	table.setRowData(0, loadPage);
////				    	table.getView().setRedraw(true); 
////				    	 table.getView().refresh();
//	        			}
//	        		});
//	        	}
//	        	Window.alert("table.getSelectedRowModels(true) = " + 
//	        		table.getSelectedRowModels(true).get(0));
	        });
	        panel.add(addIcon);
	        panel.add(delIcon);
	    }
	    
	    private void refreshTable(){
			svc.getPersons(new AsyncCallback<List<Person>>(){
			@Override
			public void onFailure(Throwable exception) {
				Window.alert("Load failure" + exception);
			}
			@Override
			public void onSuccess(List<Person> loadPage) {
		    	table.setRowData(0, loadPage);
//		    	table.getView().setRedraw(true); 
//		    	 table.getView().refresh();
			}
		});

	    }
}
