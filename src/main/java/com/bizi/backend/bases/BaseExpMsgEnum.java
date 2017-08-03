package com.bizi.backend.bases;

/**
 * Created by guofangbi on 2017/7/30.
 */
public enum BaseExpMsgEnum {
    LOGIN_INFO_ERROR("LOGIN001","用户名或密码错误"),
    BASE_ID_NULL("BASE002","ID不能为空"),
    BASE_PARAM_ERROR("BASE001","参数中有空值");

    private String code;
    private String message;

    BaseExpMsgEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
}
