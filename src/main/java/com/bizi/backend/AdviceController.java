package com.bizi.backend;

import com.bizi.backend.bases.BaseException;
import com.bizi.backend.bases.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class AdviceController {
    @ExceptionHandler(BaseException.class)
    @ResponseBody
    public BaseResult handleBaseException(BaseException e){
        return new BaseResult(e.getExpMsg());
    }
   /* @ExceptionHandler(Exception.class)
    @ResponseBody
    public BaseResult handleException(Exception e){
        log.error("出现异常",e);
        return new BaseResult("未知异常,请联系管理员!");
    }*/
}
