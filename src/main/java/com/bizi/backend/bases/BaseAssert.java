package com.bizi.backend.bases;

/**
 * Created by guofangbi on 2017/7/30.
 */
public class BaseAssert {
    public static void isTrue(boolean result,BaseExpMsgEnum expMsgEnum){
        if(result){
            throw new BaseException(expMsgEnum);
        }
    }
}
