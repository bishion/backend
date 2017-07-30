package com.bizi.backend.permit.pojo;

import com.bizi.backend.bases.BasePojo;
import lombok.Data;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Data
public class SysUser extends BasePojo{
    private String username;
    private String loginName;
    private String password;
}
