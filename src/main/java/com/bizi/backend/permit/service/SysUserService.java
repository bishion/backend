package com.bizi.backend.permit.service;

import com.bizi.backend.bases.BaseConst;
import com.bizi.backend.bases.BaseException;
import com.bizi.backend.bases.BaseExpMsgEnum;
import com.bizi.backend.bases.PageDTO;
import com.bizi.backend.permit.cond.SysUserCond;
import com.bizi.backend.permit.dao.SysUserDao;
import com.bizi.backend.permit.pojo.SysUser;
import com.bizi.backend.utils.SecurityUtil;
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

    public PageDTO<SysUser> query(SysUserCond sysUserCond){
        int total = sysUserDao.count(sysUserCond);
        if(total>0){
            return new PageDTO<>(total,sysUserDao.query(sysUserCond));
        }
        return new PageDTO<>();
    }


    public void update(SysUser sysUser) {
        sysUserDao.update(sysUser);
    }
    public void insert(SysUser sysUser) {
        sysUser.setPassword(SecurityUtil.md5Enc(BaseConst.ORIGINAL_PASSWORD));
        sysUserDao.insert(sysUser);
    }

    public void delete(int id,String operator) {
        sysUserDao.delete(id,operator);
    }
}
