package shu.cases2.client.application.tablenopage;

import gwt.material.design.client.ui.MaterialTextBox;

public class EditField<T> {
	private MaterialTextBox materialTextBox = new MaterialTextBox();
	
	public EditField() {
	}

	public void setField(T model){};
	
	public void getField(T model){};

	public Object getFieldValue(){return getMaterialTextBox().getValue();};
	public void setFieldValue(String value){getMaterialTextBox().setValue(value);};
	public void setFocusField(){getMaterialTextBox().setFocus(true);};
	
	public MaterialTextBox getMaterialTextBox() {
		return materialTextBox;
	}

	public void setMaterialTextBox(MaterialTextBox materialTextBox) {
		this.materialTextBox = materialTextBox;
	}

}
