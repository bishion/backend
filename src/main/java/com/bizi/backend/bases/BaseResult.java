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
    private boolean success;
    private String message;
    private T value;
    public BaseResult(){
        this.success = true;
    }
    public BaseResult(T value){
        this.success = true;
        this.value = value;
    }
    public BaseResult(boolean success,String message){
        this.success = success;
        this.message = message;
    }

}
