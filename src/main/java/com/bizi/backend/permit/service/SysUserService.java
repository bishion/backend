package com.bizi.backend.permit.service;

import com.bizi.backend.bases.BaseException;
import com.bizi.backend.bases.BaseExpMsgEnum;
import com.bizi.backend.permit.dao.SysUserDao;
import com.bizi.backend.permit.pojo.SysUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by guofangbi on 2017/7/30.
 */
@Service
public class SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    public SysUser login(String loginName,String password){
        SysUser sysUser = sysUserDao.login(loginName,password);
        if(sysUser == null){
            throw new BaseException(BaseExpMsgEnum.LOGIN_INFO_ERROR);
        }
        return sysUser;
    }
}
