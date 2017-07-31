package com.bizi.backend.bases;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

/**
 * Created by guofangbi on 2017/7/30.
 */
@Setter
@Getter
public class BaseResult<T> {
    private boolean success = false;
    private String message;
    private T value;
    public BaseResult(T value){
        this.success = true;
        this.value = value;
    }
    public BaseResult(boolean success,String message){
        this.message = message;
    }
    // 分页专用
    private List<T> rows = Collections.EMPTY_LIST;
    private int total = 0;

    public BaseResult(List<T> rows){
        this.success = true;
        this.rows = rows;
    }
}
