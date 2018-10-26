package shu.cases2.shared.domain;

import java.io.Serializable;
import java.util.List;

import gwt.material.design.client.data.DataView;

public class LoadPage<T> implements Serializable{
	    private List<T> data;
	    private int offset;
	    private int totalLength;
	    private boolean cacheData;

		public LoadPage() {}
		
	    public LoadPage(List<T> data, int offset, int totalLength) {
	        this(data, offset, totalLength, true);
	    }

	    public LoadPage(List<T> data, int offset, int totalLength, boolean cacheData) {
	        this.data = data;
	        this.offset = offset;
	        this.totalLength = totalLength;
	        this.cacheData = cacheData;
	    }

	    /**
	     * Return result data.
	     */
	    public List<T> getData() {
	        return data;
	    }

	    /**
	     * Return actual offset of the result. In most cases equals requested offset.
	     */
	    public int getOffset() {
	        return offset;
	    }

	    /**
	     * Return total length of the data.
	     * <br/>
	     * <ul>
	     *  <li>For non-paging requests equals size of the data.</li>
	     *  <li>For paging requests should equals total number of records</li>
	     * </ul>
	     */
	    public int getTotalLength() {
	        return totalLength;
	    }

	    /**
	     * Should we cache the data, retrieved, it is worth noting that not all
	     * {@link DataView} implementations will cache data.
	     * @return true by default.
	     */
	    public boolean isCacheData() {
	        return cacheData;
	    }
}
