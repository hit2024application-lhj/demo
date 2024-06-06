package org.example.myapp.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Created by rayfoo@qq.com Luna on 2020/4/13 0:44
 */
public class PageResult implements Serializable {
    //总记录数
    private Integer total;
    //当前页内容
    private List rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public PageResult(Integer total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PageResult that = (PageResult) o;
        return Objects.equals(total, that.total) && Objects.equals(rows, that.rows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, rows);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", total=").append(total);
        sb.append(", rows=").append(rows);
        sb.append("]");
        return sb.toString();
    }
}
