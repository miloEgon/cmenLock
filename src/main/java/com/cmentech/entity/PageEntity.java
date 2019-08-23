package com.cmentech.entity;


public class PageEntity {

    private Integer pageSize;

    private Integer pageNum;

    private String authKey;

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public String getAuthKey() {
        return authKey;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = null == pageSize ? 10 : pageSize;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = null == pageNum ? 1 : pageNum;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }
}
