package com.bizi.backend.permit.controller;

import com.bizi.backend.bases.BaseAssert;
import com.bizi.backend.bases.BaseExpMsgEnum;
import com.bizi.backend.bases.BasePage;
import com.bizi.backend.bases.BaseResult;
import com.bizi.backend.permit.cond.SysUserCond;
import com.bizi.backend.permit.dao.SysUserDao;
import com.bizi.backend.permit.pojo.SysUser;
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
public class UserController {
    @Resource
    private SysUserDao sysUserDao;

    @RequestMapping("/login")
    public SysUser login(String loginName,String password){
        BaseAssert.isTrue(StringUtils.isAnyBlank(loginName,password), BaseExpMsgEnum.BASE_PARAM_ERROR);
        sysUserDao.login(loginName,password);

        return null;
    }
    @RequestMapping("query.json")
    public BasePage<List<SysUser>> query(SysUserCond cond){
        List<SysUser> list = new ArrayList<>(1);
        list.add(new SysUser());
        BasePage<List<SysUser>> result = new BasePage<>();
        result.setTotal(1);
        result.setRows(list);
        return result;
    }
}
