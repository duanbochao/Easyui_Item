package com.model;

import java.util.List;

/**
 * @author duanbochao
 * @creat 2019/7/20
 */
public class GridData {
    private Integer total;
    private List<?> rows;

    public GridData() {
    }

    public GridData(Integer total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
