package shu.cases2.client.application.tablenopage;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TableModuleNP extends AbstractPresenterModule {
	    @Override
	    protected void configure() {
	        bindPresenter(TablePresenterNP.class, TablePresenterNP.MyView.class, TableViewNP.class, TablePresenterNP.MyProxy.class);
	    }
}
