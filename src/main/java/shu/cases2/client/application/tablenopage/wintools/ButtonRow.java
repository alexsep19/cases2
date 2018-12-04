package shu.cases2.client.application.tablenopage.wintools;

import com.google.gwt.event.dom.client.ClickHandler;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.constants.IconType;
import gwt.material.design.client.constants.TextAlign;
import gwt.material.design.client.constants.WavesType;
import gwt.material.design.client.ui.MaterialIcon;
import gwt.material.design.client.ui.MaterialRow;

public class ButtonRow extends MaterialRow{
	MaterialIcon butSave = new MaterialIcon();
	MaterialIcon butCancel = new MaterialIcon();

	public ButtonRow(ClickHandler saveClickHandler, ClickHandler closeClickHandler) {
		setMarginBottom(0);
		setTextAlign(TextAlign.RIGHT);
		
		butSave.setIconType(IconType.SAVE);
		butSave.setIconColor(Color.GREEN);
		butSave.setWaves(WavesType.DEFAULT);
		butSave.setCircle(true);
		butSave.setTitle("Сохранить");
		butSave.addClickHandler(saveClickHandler);
		
		butCancel.setIconType(IconType.CANCEL);
		butCancel.setIconColor(Color.RED);
		butCancel.setWaves(WavesType.DEFAULT);
		butCancel.setCircle(true);
		butCancel.setTitle("Отменить");
		butCancel.addClickHandler(closeClickHandler);

		add(butSave);
		add(butCancel);
	}

}
