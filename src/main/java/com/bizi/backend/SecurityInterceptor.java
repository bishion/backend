package com.bizi.backend;

import com.alibaba.fastjson.JSON;


import com.alibaba.fastjson.serializer.SerializerFeature;
import com.bizi.backend.bases.BaseConst;
import com.bizi.backend.bases.BaseResult;
import com.bizi.backend.bases.PageDTO;
import com.bizi.backend.permit.pojo.SysUser;
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

//        Object sysUser = request.getSession().getAttribute(BaseConst.SESSION_LOGIN_INFO);
        SysUser sysUser = new SysUser();// TODO: 测试用,免登录
        sysUser.setLoginName("system");
        sysUser.setUsername("管理员");
        if(sysUser != null ){
            return true;
        }
        PageDTO<Void> result = new PageDTO();
        result.setSuccess(false);
        result.setMessage("登录超时,请刷新后重试!");

        response.getOutputStream().write(JSON.toJSONString(result).getBytes());
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(HttpStatus.OK.value());
        return false;
    }
}