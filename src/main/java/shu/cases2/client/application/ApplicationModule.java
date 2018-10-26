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

import shu.cases2.client.application.about.AboutModule;
import shu.cases2.client.application.component.ComponentModule;
import shu.cases2.client.application.table.TableModule;
import shu.cases2.client.application.tablenopage.TableModuleNP;

import org.fusesource.restygwt.client.Defaults;

import com.google.gwt.core.client.GWT;
//import shu.cases2.client.application.home.HomeModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new AboutModule());
        install(new ComponentModule());
        install(new TableModule());
        install(new TableModuleNP());
        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class,
                ApplicationPresenter.MyProxy.class);
    }
    
}
