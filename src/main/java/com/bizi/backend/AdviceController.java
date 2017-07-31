package com.bizi.backend;

import com.bizi.backend.bases.BaseException;
import com.bizi.backend.bases.BaseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {
    @ExceptionHandler(BaseException.class)
    public BaseResult<Void> handleBaseException(BaseException e){
        return new BaseResult(false, e.getExpMsg());
    }
    @ExceptionHandler(Exception.class)
    public BaseResult<Void> handleException(Exception e){
        return new BaseResult(false, "未知异常,请联系管理员!");
    }
}
