package com.bizi.backend.bases;


/**
 * Created by guofangbi on 2017/7/29.
 */
public abstract class BaseCond {
    private String operator;
    private int start=0;
    private int limit=20;

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
