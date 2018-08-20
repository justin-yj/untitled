package com.lw.data.entity;

/**
 * @author sunping
 * @create 2017/9/14
 */
public class Page {
    private Integer pageNo=1;
    private Integer dataCount;

    private Integer pageCount;
    private Integer pageSize = 10;
    public void init(int dataCount) {
        this.dataCount = dataCount;
        this.pageCount =(int)Math.ceil (dataCount*1.0d/pageSize);
    }
    public void init(int pageNo, int dataCount) {
        this.pageNo = pageNo;
        this.dataCount = dataCount;
        this.pageCount = (int)Math.ceil (dataCount*1.0d/pageSize);
    }

    public void init(int pageNo, int dataCount, int pageSize) {
        this.pageNo = pageNo;
        this.dataCount = dataCount;
        this.pageSize = pageSize;
        this.pageCount = (int)Math.ceil (dataCount*1.0d/pageSize);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getDataCount() {
        return dataCount;
    }

    public void setDataCount(Integer dataCount) {
        this.dataCount = dataCount;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
