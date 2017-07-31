package com.bizi.backend.permit.controller;

import com.bizi.backend.bases.BaseAssert;
import com.bizi.backend.bases.BaseExpMsgEnum;
import com.bizi.backend.bases.BaseResult;
import com.bizi.backend.permit.cond.SysUserCond;
import com.bizi.backend.permit.dao.SysUserDao;
import com.bizi.backend.permit.pojo.SysUser;
import com.bizi.backend.permit.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by guofangbi on 2017/7/30.
 */
@RestController
@RequestMapping("/user/")
public class UserController extends BaseController{
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/login.json")
    public SysUser login(String loginName,String password){
        BaseAssert.isTrue(StringUtils.isAnyBlank(loginName,password), BaseExpMsgEnum.BASE_PARAM_ERROR);
        sysUserService.login(loginName,password);

        return new SysUser();
    }
    @RequestMapping("query.json")
    public BaseResult<SysUser> query(SysUserCond cond){
        List<SysUser> list = new ArrayList<>(1);
        SysUser sysUser = new SysUser();
        sysUser.setLoginName("bizi");
        sysUser.setUsername("bizi");
        list.add(sysUser);
        BaseResult<SysUser> result = new BaseResult(list);
        result.setTotal(1);
        result.setRows(list);
        return result;
    }
}
