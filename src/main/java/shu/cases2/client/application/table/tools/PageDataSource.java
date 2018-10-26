package shu.cases2.client.application.table.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import gwt.material.design.client.data.DataSource;
import gwt.material.design.client.data.ListDataSource;
import gwt.material.design.client.data.loader.LoadCallback;
import gwt.material.design.client.data.loader.LoadConfig;
import gwt.material.design.client.data.loader.LoadResult;

public class PageDataSource<T> implements DataSource<T> {
	private Logger logger = Logger.getLogger(ListDataSource.class.getName());
	private List<T> data;

	public PageDataSource() {
        data = new ArrayList<>();
    }

	@Override
	public void load(LoadConfig<T> loadConfig, LoadCallback<T> callback) {
		try {
//            int size = loadConfig.getOffset() + loadConfig.getLimit();
//            if(size > data.size()){
//                size = data.size();
//            }
//            final List<T> subList = size == 0 ? new ArrayList<>() : data.subList(loadConfig.getOffset(), size);
//            callback.onSuccess(new LoadResult<T>(subList, loadConfig.getOffset(), data.size(), cacheData()));
//            callback.onSuccess(loadData(loadConfig));
        } catch (IndexOutOfBoundsException ex) {
            // Silently ignore index out of bounds exceptions
            logger.log(Level.FINE, "ListDataSource threw index out of bounds.", ex);
            callback.onFailure(ex);
        }
	}

//	protected LoadResult<T> loadData(LoadConfig<T> loadConfig){return new LoadResult(data, loadConfig.getOffset(), 0, true);}
	
	public boolean cacheData() {
        return true;
    }
	
	@Override
	public boolean useRemoteSort() {
		return false;
	}

    public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
