package com.bizi.backend.audit;

import com.bizi.audit.resolver.LoginInfoResolver;
import com.bizi.backend.bases.BaseConst;
import com.bizi.backend.permit.pojo.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class BackendLoginInfoResolver implements LoginInfoResolver{
    @Resource
    private HttpServletRequest httpServletRequest;
    @Override
    public String getLoginName() {
        SysUser sysUser = (SysUser) httpServletRequest.getSession().getAttribute(BaseConst.SESSION_LOGIN_INFO);
        if(sysUser == null){
            return "未登陆";
        }
        return sysUser.getLoginName();
    }
}
