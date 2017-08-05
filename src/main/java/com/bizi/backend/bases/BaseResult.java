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
public class BaseResult {
    private boolean success;
    private String message;
    public BaseResult(){
        this.success = true;
    }
    public BaseResult(String message){
        this.success = false;
        this.message = message;
    }
    public BaseResult(boolean success,String message){
        this.success = success;
        this.message = message;
    }

}
