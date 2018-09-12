package shu.cases2.client.application.component;

import org.fusesource.restygwt.client.Defaults;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;

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
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialTextBox;
import gwt.material.design.client.ui.MaterialToast;
import shu.cases2.client.rest.RestClient;
import shu.cases2.client.rest.ValueClient;
import shu.cases2.shared.domain.NameValue;

public class ComponentView extends ViewImpl implements ComponentPresenter.MyView {

	public interface Binder extends UiBinder<Widget, ComponentView> {
    }
    @UiField MaterialButton btnLoad, btnReset;
    @UiField MaterialCheckBox cbCheckBox, cbTextBox;
    @UiField MaterialTextBox txName;
    
    
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
        Defaults.setServiceRoot(GWT.getHostPageBaseURL());
        ValueClient client = GWT.create(ValueClient.class);
    	client.getValues("1", new MethodCallback<NameValue>(){

			@Override
			public void onFailure(Method method, Throwable exception) {
				
			}
			@Override
			public void onSuccess(Method method, NameValue response) {
				txName.setValue(response.getValue());
			}
    	} );
    }
    
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
