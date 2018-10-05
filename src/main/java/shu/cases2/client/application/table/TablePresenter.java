package shu.cases2.client.application.table;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import shu.cases2.client.application.ApplicationPresenter;
import shu.cases2.client.event.SetPageTitleEvent;
import shu.cases2.client.place.NameTokens;

public class TablePresenter extends Presenter<TablePresenter.MyView, TablePresenter.MyProxy> {
    public interface MyView extends View {
    }

    @ProxyStandard
    @NameToken(NameTokens.table)
    public interface MyProxy extends ProxyPlace<TablePresenter> {
    }

    @Inject
    TablePresenter(EventBus eventBus, MyView view, MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }

    @Override
    protected void onReveal() {
        super.onReveal();
        SetPageTitleEvent.fire(NameTokens.table/*, "", "", ""*/, this);
    }
}
