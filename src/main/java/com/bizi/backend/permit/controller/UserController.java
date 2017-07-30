package com.bizi.backend.permit.controller;

import com.bizi.backend.bases.BaseAssert;
import com.bizi.backend.bases.BaseExpMsgEnum;
import com.bizi.backend.permit.dao.SysUserDao;
import com.bizi.backend.permit.pojo.SysUser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by guofangbi on 2017/7/30.
 */
@RestController
public class UserController {
    @Resource
    private SysUserDao sysUserDao;

    @RequestMapping("/login")
    public SysUser login(String loginName,String password){
        BaseAssert.isTrue(StringUtils.isAnyBlank(loginName,password), BaseExpMsgEnum.BASE_PARAM_ERROR);
        sysUserDao.login(loginName,password);

        return null;
    }
}
