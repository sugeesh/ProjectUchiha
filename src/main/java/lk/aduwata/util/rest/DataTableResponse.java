
package lk.aduwata.util.rest;

import java.util.List;

/**
 * This class is for wrapping the REST Responses for sending to frontend.
 *
 * @author Sugeesh Chandraweera
 */

public class DataTableResponse<T> {

    private long totalEntries;
    private int totalPages;
    private int currentPage;
    private List<T> dataRows;

    public long getTotalEntries() {
        return totalEntries;
    }

    public void setTotalEntries(long totalEntries) {
        this.totalEntries = totalEntries;
    }

    public List<T> getDataRows() {
        return dataRows;
    }

    public void setDataRows(List<T> dataRows) {
        this.dataRows = dataRows;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
