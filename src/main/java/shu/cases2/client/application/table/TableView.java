package shu.cases2.client.application.table;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.HideOn;
import gwt.material.design.client.data.ListDataSource;
import gwt.material.design.client.data.component.RowComponent;
import gwt.material.design.client.ui.pager.MaterialDataPager;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.TextColumn;

public class TableView  extends ViewImpl implements TablePresenter.MyView {

		public interface Binder extends UiBinder<Widget, TableView> {
	    }
		@UiField
	    MaterialDataTable<Person> table;
		private MaterialDataPager<Person> pager = new MaterialDataPager<>();

	    private ListDataSource<Person> dataSource;
	    
	    @Inject
	    TableView(Binder uiBinder) {
	        initWidget(uiBinder.createAndBindUi(this));
	        
	        // Generate 20 categories
	        int rowIndex = 1;
	        List<Person> people = new ArrayList<>();
	        for(int k = 1; k <= 10; k++){
	            // Generate 100 rows
	            for(int i = 1; i <= 10; i++, rowIndex++){
	                people.add(new Person(i, "Field " + rowIndex, "Field " + i, "Field " + rowIndex, "No " + i,"Category " + k));
	            }
	        }

	        dataSource = new ListDataSource<>();
	        dataSource.add(0, people);

	        pager.setTable(table);
	        pager.setDataSource(dataSource);

	        table.setVisibleRange(1, 10);
	        table.add(pager);
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
