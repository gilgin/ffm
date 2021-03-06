package com.family.financial.management.model;

/**
 * Created by zhangyiping on 2017/10/14.
 */
public class ConditionForm {
    private String fromDate;
    private String toDate;
    private String maxAccount;
    private String minAccount;
    private String types;
    private String pageNum;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getMaxAccount() {
        return maxAccount;
    }

    public void setMaxAccount(String maxAccount) {
        this.maxAccount = maxAccount;
    }

    public String getMinAccount() {
        return minAccount;
    }

    public void setMinAccount(String minAccount) {
        this.minAccount = minAccount;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }
}
