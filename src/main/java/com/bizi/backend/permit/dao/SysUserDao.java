package com.bizi.backend.permit.dao;

import com.bizi.backend.permit.cond.SysUserCond;
import com.bizi.backend.permit.pojo.SysUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by guofangbi on 2017/7/29.
 */
public interface SysUserDao {

    List<SysUser> query(SysUserCond cond);

    @Select("Select * from sys_user where login_name=#{loginName} and password=#{password} and valid_flag=1")
    SysUser login(@Param("loginName") String loginName, @Param("password") String password);
}
