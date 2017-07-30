package com.bizi.backend.permit.cond;

import com.bizi.backend.bases.BaseCond;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Getter
@Setter
public class SysUserCond extends BaseCond {
    private String username;
    private String password;
    private String loginName;
    private String validFlag;
}
