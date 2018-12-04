package shu.cases2.client.application.tablenopage;

import gwt.material.design.client.ui.MaterialTextBox;

public class EditField<T> {
	private MaterialTextBox materialTextBox = new MaterialTextBox();
	
	public EditField() {
	}

	public void setField(T model){};
	
	public Object getField(){return getMaterialTextBox().getValue();};

	public MaterialTextBox getMaterialTextBox() {
		return materialTextBox;
	}

	public void setMaterialTextBox(MaterialTextBox materialTextBox) {
		this.materialTextBox = materialTextBox;
	}

}
