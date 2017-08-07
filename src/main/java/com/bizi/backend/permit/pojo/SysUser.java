package com.bizi.backend.permit.pojo;

import com.bizi.backend.bases.BasePojo;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Data
public class SysUser extends BasePojo{
    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "登录名不能为空")
    private String loginName;
    private String password;
}
