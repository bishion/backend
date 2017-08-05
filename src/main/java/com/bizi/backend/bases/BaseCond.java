package com.bizi.backend.bases;


import lombok.Getter;
import lombok.Setter;

/**
 * Created by guofangbi on 2017/7/29.
 */
@Getter
@Setter
public abstract class BaseCond {
    private int start=0;
    private int limit=20;
    private String startDate;
    private String endDate;
}
