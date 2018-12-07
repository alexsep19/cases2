package shu.cases2.client.application.tablenopage;

import java.util.ArrayList;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

import org.apache.tools.ant.taskdefs.Typedef;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;

import gwt.material.design.addins.client.window.MaterialWindow;
import gwt.material.design.client.constants.ButtonSize;
import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.FieldType;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialPanel;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.table.cell.Column;
import gwt.material.design.client.ui.table.cell.TextColumn;
import shu.cases2.client.application.tablenopage.wintools.ButtonRow;
import shu.cases2.shared.Person;

public class EditWindow<T> extends MaterialWindow{
    MaterialPanel materialPanel = new MaterialPanel();
    MaterialRow materialRow = new MaterialRow();
    MaterialRow materialRowButton = new MaterialRow();
    List<EditField<T>> editFields = new ArrayList<EditField<T>>();
    String allFieldWidth;
    T model;
	
	public EditWindow(String maxWidth, String fieldWidth) {
		this.allFieldWidth = fieldWidth;
		setOverlay(true);
		materialRow.setMarginLeft(10);
		materialRow.setMarginBottom(0);
		materialPanel.add(new ButtonRow(new ClickHandler(){
			@Override
			public void onClick(ClickEvent event) {
				saveModel(getValues(), new AsyncCallback<List<T>>(){
						@Override
						public void onFailure(Throwable exception) {
							Window.alert("Load failure" + exception);
							close();
						}
						@Override
						public void onSuccess(List<T> loadPage) {
							fillTable(loadPage);
//					    	table.setRowData(0, loadPage);
//					    	table.getView().setRedraw(true); 
//					    	 table.getView().refresh();
					    	close();
						}
					}
                 );
			} },
			new ClickHandler(){
				@Override
				public void onClick(ClickEvent event) {
					close();
				}
			}));
		materialPanel.add(materialRow);
        add(materialPanel);
		
        setMaxWidth(maxWidth);
        addKeyDownHandler(new KeyDownHandler(){
			@Override
			public void onKeyDown(KeyDownEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ESCAPE) {
					close();
				}
			} });
	}
	
	public void addField(Column column, EditField<T> editField, int maxLength){
		if (column instanceof TextColumn){
			editField.getMaterialTextBox().setFieldType(FieldType.FILLED);
			editField.getMaterialTextBox().setLabel(column.getName());
			editField.getMaterialTextBox().setMaxWidth(allFieldWidth);
			editField.getMaterialTextBox().setGrid("s12");
        	if (maxLength > 0)
        		editField.getMaterialTextBox().setMaxLength(maxLength);
        	materialRow.add(editField.getMaterialTextBox());
			editFields.add(editField);
		}
	}
	
	public void setValues(T model){
		this.model = model;
		for(EditField<T> editField : editFields){
			editField.setField(model);
		}
	}
	
	public T getValues(){
		for(EditField<T> editField : editFields){
			editField.getField(model);
		}
		return model;
	}
	
	public void saveModel(T model, AsyncCallback<List<T>> asyncCallback){}
	public void fillTable(List<T> loadPage){}
	
//	@Override
//	public void close(){
//		saveChanges();
//		super.close();
//	}
	
//	void saveChanges(){
//		
//	}

}
