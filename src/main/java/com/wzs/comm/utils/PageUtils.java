package com.wzs.comm.utils;

public class PageUtils {
    private int pageNow;//当前页码
    private int total;//总记录数
    private int pageTotal;//总页数
    private int offset;//每页的第一条记录，在数据库中的下标，默认是0
    private int pageSize=5;//每页显示几条记录
    private StringBuffer sqlWhere;//sql语句片段

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
        //计算对应的偏移量
        this.offset = (pageNow - 1) * pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
        //计算总页数
        if (total % pageSize == 0) {
            this.pageTotal = total / pageSize;
        } else {
            this.pageTotal = total / pageSize + 1;
        }
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public StringBuffer getSqlWhere() {
        return sqlWhere;
    }

    public void setSqlWhere(StringBuffer sqlWhere) {
        this.sqlWhere = sqlWhere;
    }
}
