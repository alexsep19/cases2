package shu.cases2.server.rest.api;

import java.util.ArrayList;
import gwt.material.design.client.data.DataView;

public class LoadResult<T> {

    private final ArrayList<T> data;
    private final int offset;
    private final int totalLength;
    private final boolean cacheData;

    public LoadResult(ArrayList<T> data, int offset, int totalLength) {
        this(data, offset, totalLength, true);
    }

    public LoadResult(ArrayList<T> data, int offset, int totalLength, boolean cacheData) {
        this.data = data;
        this.offset = offset;
        this.totalLength = totalLength;
        this.cacheData = cacheData;
    }

    /**
     * Return result data.
     */
    public ArrayList<T> getData() {
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
