package com.bizi.backend.bases;

import com.fasterxml.jackson.annotation.JsonFormat;
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
//    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private Date modifyTime;
    private Integer validFlag;
    private String remark;
    private String operator;
}
