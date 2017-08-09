package com.bizi.backend.framework;

import com.bizi.backend.bases.BaseResult;
import com.bizi.backend.permit.pojo.SysUser;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class BaseController {
    @Resource
    private HttpServletRequest request;

    protected void setSession(String key, Object obj) {
        this.getSession().setAttribute(key, obj);
    }

    public static HttpSession getSession(HttpServletRequest request) {
        return request.getSession();
    }

    public HttpSession getSession() {
        return request.getSession();
    }

    protected String getLoginName() {
        return getLoginUser(getSession()).getLoginName();
    }

    public static String getLoginName(HttpServletRequest request) {
        return getLoginUser(getSession(request)).getLoginName();
    }

    private static SysUser getLoginUser(HttpSession session) {
//        SysUser sysUser = (SysUser) session.getAttribute(BaseConst.SESSION_LOGIN_INFO)
        SysUser sysUser = new SysUser();// TODO: 测试用,免登录
        sysUser.setLoginName("system");
        sysUser.setUsername("管理员");
        return sysUser;
    }

    protected BaseResult buildSuccess() {
        return new BaseResult();
    }

    protected BaseResult buildFail(String message) {
        return new BaseResult(message);
    }

    protected String getRequestIp() {
        return getRequestIp(request);
    }

    protected String getRequestIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}
