package com.bizi.backend.permit.pojo;

import com.bizi.backend.bases.BasePojo;
import lombok.Data;
import org.apache.ibatis.annotations.Results;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Results(id="sysUserMap")
@Data
public class SysUser extends BasePojo{
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "登录名不能为空")
    private String loginName;
    private String password;
}
