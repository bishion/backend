package com.bizi.backend.bases;

import lombok.Getter;
import lombok.Setter;

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
}
