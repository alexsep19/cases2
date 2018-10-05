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

import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ContentSlot;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.NavigationEvent;
import com.gwtplatform.mvp.client.proxy.NavigationHandler;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentHandler;

import shu.cases2.client.event.SetPageTitleEvent;

public class ApplicationPresenter
        extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> 
        implements SetPageTitleEvent.SetPageTitleHandler{
    interface MyView extends View {
		void setPageTitle(String title);
    }

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

//    @ContentSlot
//    public static final GwtEvent.Type<RevealContentHandler<?>> SLOT_MAIN = new GwtEvent.Type<>();
    public static final NestedSlot SLOT_MAIN = new NestedSlot();
    
    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.Root);
    }
    
    @Override
    protected void onBind() {
        super.onBind();
        addRegisteredHandler(SetPageTitleEvent.TYPE, this);
    }
    
//    @Override
//    public void onNavigation(NavigationEvent navigationEvent) {
//        Window.scrollTo(0, 0);
//    }

    @Override
    public void onSetPageTitle(SetPageTitleEvent event) {
        getView().setPageTitle(event.getTitle());
    }

}
