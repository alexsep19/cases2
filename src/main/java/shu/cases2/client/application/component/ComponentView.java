package shu.cases2.client.application.component;

import java.util.Date;
import java.util.Optional;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2016 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */


import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.constants.ButtonType;
import gwt.material.design.client.constants.DialogType;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialDatePicker;
import gwt.material.design.client.ui.MaterialDialog;
import gwt.material.design.client.ui.MaterialDialogContent;
import gwt.material.design.client.ui.MaterialDialogFooter;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialTitle;
import gwt.material.design.client.ui.MaterialToast;
import shu.cases2.client.rest.TextBoxClient;
import shu.cases2.client.rest.ValueClient;
import shu.cases2.shared.domain.NameValue;
import shu.cases2.shared.domain.TextBox;

public class ComponentView extends ViewImpl implements ComponentPresenter.MyView {

	public interface Binder extends UiBinder<Widget, ComponentView> {
    }
    @UiField MaterialButton btnLoad, btnSave;
    @UiField MaterialCheckBox cbCheckBox, cbTextBox;
    @UiField MaterialTextBox txName;
    @UiField MaterialDatePicker dpDate;
//    @UiField MaterialDialog dialogBottomSheet;
    
    @Inject
    ComponentView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        cbCheckBox.setValue(false);
        cbTextBox.setValue(false);
        enableTextBox(cbTextBox.getValue());
        enableCheckBox(cbCheckBox.getValue());
    }
    
    @UiHandler("btnLoad")
    void handlerBtnLoad(ClickEvent e) {
        TextBoxClient client = GWT.create(TextBoxClient.class);
    	client.getTextBox(new MethodCallback<TextBox>(){

			@Override
			public void onFailure(Method method, Throwable exception) {
//				MaterialModal m = new MaterialModal(){
//					
//				};
				MaterialToast.fireToast(exception.getMessage());
//				mmErr.open();
			}
			@Override
			public void onSuccess(Method method, TextBox response) {
				final MaterialDialog md = new MaterialDialog();
				md.setType(DialogType.FIXED_FOOTER);
				md.setDismissible(true);
				md.setInDuration(100);
				md.setOutDuration(100);
				MaterialDialogContent mc = new MaterialDialogContent();
				MaterialTitle mt = new MaterialTitle("title Успешно", "Пропустить");
				mc.add(mt);
				MaterialDialogFooter mdf = new MaterialDialogFooter();
				MaterialButton mb = new MaterialButton("Закрыть"); 
				mb.setType(ButtonType.FLAT);
				mb.addClickHandler(new ClickHandler(){
					@Override
					public void onClick(ClickEvent event){
					  md.close(true);
					}
				});
				mdf.add(mb);
				md.add(mc);
				md.add(mdf);
//				md.setTitle("rrrrrrrrrrrrrr");
				RootPanel.get().add(md);
				md.open();
//				dialogBottomSheet.open();
								
				txName.setValue(response.getName());
				cbCheckBox.setValue(response.isCheckbox());
				enableCheckBox(cbCheckBox.getValue());
				dpDate.setValue(response.getBirthday());
			}
    	} );
    }
    
//    @UiHandler("btnCloseBottomSheetDialog")
//    void closeFullScreen(ClickEvent e) {
//    	dialogBottomSheet.close();
//    }
    
//    @UiHandler("btnSave")
//    void handlerBtnSave(ClickEvent e) {
//        TextBoxClient client = GWT.create(TextBoxClient.class);
//    	client.setTextBox(new TextBox(true, "fffff", new Date()), new MethodCallback<Void>(){
////    	client.setTextBox(txName.getValue()==null || txName.getValue()==""? "NULL": txName.getValue(), new MethodCallback<Void>(){
//			@Override
//			public void onFailure(Method method, Throwable exception) {
//				MaterialToast.fireToast(exception.getMessage());
//				String ret = "";
//				for(StackTraceElement it: exception.getStackTrace()){
//					ret += it + "\n";
//				}
//				MaterialToast.fireToast(ret);
//			}
//			@Override
//			public void onSuccess(Method method, Void response) {
//				MaterialToast.fireToast("Success Post");
//				
//			}
//    	} );
//    }

    
    @UiHandler("cbTextBox")
    void onClickTextBox(ClickEvent e) {
        enableTextBox(cbTextBox.getValue());
    }

    @UiHandler("cbCheckBox")
    void onClickCheckBox(ClickEvent e) {
    	enableCheckBox(cbCheckBox.getValue());
    }

    void enableTextBox(boolean flag){
    	txName.setEnabled(flag);
    }
    void enableCheckBox(boolean flag){
    	cbTextBox.setEnabled(flag);
    }
}
