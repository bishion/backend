package com.bizi.backend.bases;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by guofangbi on 2017/7/30.
 */
@Getter
@Setter
public class BaseException extends RuntimeException {
    private String expMsg;
    private String expCode;


    public BaseException(BaseExpMsgEnum expMsgEnum){
        this.expCode = expMsgEnum.getCode();
        this.expMsg = expMsgEnum.getMessage();
    }

}
