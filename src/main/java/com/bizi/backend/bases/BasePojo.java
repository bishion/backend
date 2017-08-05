package com.bizi.backend.bases;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Getter
@Setter
public abstract class BasePojo {
    private Integer id;
    private String creator;
    private String modifier;
    private Date createTime;
    private Date modifyTime;
    private Integer validFlag;
    private String remark;
    private String operator;
}
