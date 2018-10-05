package shu.cases2.client.application.table;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialDialog;
import gwt.material.design.client.ui.MaterialTextBox;

public class TableView  extends ViewImpl implements TablePresenter.MyView {

		public interface Binder extends UiBinder<Widget, TableView> {
	    }
//	    @UiField MaterialButton btnLoad, btnSave;
//	    @UiField MaterialCheckBox cbCheckBox, cbTextBox;
//	    @UiField MaterialTextBox txName;
//	    @UiField MaterialDatePicker dpDate;
//	    @UiField MaterialDialog dialogBottomSheet;
	    
	    @Inject
	    TableView(Binder uiBinder) {
	        initWidget(uiBinder.createAndBindUi(this));
//	        cbCheckBox.setValue(false);
//	        cbTextBox.setValue(false);
//	        enableTextBox(cbTextBox.getValue());
//	        enableCheckBox(cbCheckBox.getValue());
	    }
}
