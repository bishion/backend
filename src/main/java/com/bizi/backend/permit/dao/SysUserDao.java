package com.bizi.backend.permit.dao;

import com.bizi.backend.permit.cond.SysUserCond;
import com.bizi.backend.permit.pojo.SysUser;

import java.util.List;

/**
 * Created by guofangbi on 2017/7/29.
 */
public interface SysUserDao {

    List<SysUser> query(SysUserCond cond);
}
