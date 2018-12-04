/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2018 GwtMaterialDesign
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
package shu.cases2.client.application;

import javax.inject.Inject;
import javax.ws.rs.client.Client;

import org.fusesource.restygwt.client.Defaults;
//import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialNavBrand;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }
    
    @UiField HTMLPanel content;

	@UiField
	MaterialNavBrand title;
    
    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        
        bindSlot(ApplicationPresenter.SLOT_MAIN, content);
        setupResty();

    }
    @Override
    public void setPageTitle(String title) {
        this.title.setText(title);
//        this.description.setText(description);
//        this.link = link;
//        this.specification = specification;

//        if (link.isEmpty()) {
//            chipJava.setVisible(false);
//            chipXml.setVisible(false);
//        } else {
//            chipJava.setVisible(true);
//            chipXml.setVisible(true);
//        }
//
//        if (specification.isEmpty()) {
//            chipSpecification.setVisible(false);
//        } else {
//            chipSpecification.setVisible(true);
//        }

//        new MaterialAnimation().transition(Transition.BOUNCEINLEFT).animate(this.title);
//        new MaterialAnimation().transition(Transition.BOUNCEINLEFT).animate(this.description);
    }
    
    private void setupResty(){
//    	final ClientConfig clientConfig = new ClientConfig();
//        clientConfig.register(MultiPartFeature.class);
//        Client client = ClientFactory.newClient(clientConfig);
        
//        Defaults.setServiceRoot(GWT.getHostPageBaseURL());
//        Defaults.setServiceRoot(GWT.getModuleBaseURL()); 
//        Defaults.setDateFormat(null);
    }

}
