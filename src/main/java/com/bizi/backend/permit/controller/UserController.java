package com.bizi.backend.permit.controller;

import com.bizi.backend.bases.BaseAssert;
import com.bizi.backend.bases.BaseExpMsgEnum;
import com.bizi.backend.bases.BaseResult;
import com.bizi.backend.bases.PageDTO;
import com.bizi.backend.framework.BaseController;
import com.bizi.backend.permit.cond.SysUserCond;
import com.bizi.backend.permit.pojo.SysUser;
import com.bizi.backend.permit.service.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * Created by guofangbi on 2017/7/30.
 */
@RestController
@RequestMapping("/user/")
public class UserController extends BaseController {
    @Resource
    private SysUserService sysUserService;

    @RequestMapping("login.json")
    public SysUser login(String loginName,String password){
        BaseAssert.isTrue(StringUtils.isAnyBlank(loginName,password), BaseExpMsgEnum.BASE_PARAM_ERROR);
        sysUserService.login(loginName,password);

        return new SysUser();
    }
    @RequestMapping("query.json")
    public PageDTO<SysUser> query(SysUserCond cond){
        return sysUserService.query(cond);
    }

    @RequestMapping("update.json")
    public BaseResult<Void> update(@Valid  SysUser sysUser){
        BaseAssert.isTrue(sysUser.getId() == null,BaseExpMsgEnum.BASE_ID_NULL);
        sysUserService.update(sysUser);
        return buildSuccess();
    }
    @RequestMapping("create.json")
    public BaseResult<Void> create(@Valid SysUser sysUser){
        BaseAssert.isTrue(StringUtils.isBlank(sysUser.getPassword())||sysUser.getId()==null,BaseExpMsgEnum.BASE_PARAM_ERROR);
        sysUserService.create(sysUser);
        return buildSuccess();
    }
    @RequestMapping("delete.json")
    public BaseResult<Void> delete(int id){
        BaseAssert.isTrue(id == 0,BaseExpMsgEnum.BASE_PARAM_ERROR);
        sysUserService.delete(id,getLoginName());
        return buildSuccess();
    }
}
