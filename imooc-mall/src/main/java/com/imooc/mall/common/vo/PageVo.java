package com.imooc.mall.common.vo;

import java.util.List;

/**
 * @author sjs
 * @date 2020/11/12 22:30
 */
public class PageVo<T> {
    private int pageSize;
    private int pageNum;
    private int total;
    private List<T> list;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
