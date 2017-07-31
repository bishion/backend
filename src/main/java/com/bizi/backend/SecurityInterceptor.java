package com.bizi.backend;

import com.alibaba.fastjson.JSON;


import com.bizi.backend.bases.BaseConst;
import com.bizi.backend.bases.BaseResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by guo on 16-10-5.
 */
public class SecurityInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object loginInfo = request.getSession().getAttribute(BaseConst.SESSION_LOGIN_INFO);
        if(loginInfo != null ){
            return true;
        }
        BaseResult<Void> result = new BaseResult(false,"您还未登陆!");

        response.getOutputStream().write(JSON.toJSONString(result).getBytes());
        response.setStatus(HttpStatus.OK.value());
        return false;
    }
}