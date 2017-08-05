package com.bizi.backend.bases;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class PageDTO<T> extends BaseResult{
    // 分页专用
    private List<T> rows = Collections.EMPTY_LIST;
    private int total;

    public PageDTO(int total,List<T> rows){
        super();
        this.total = total;
        this.rows = rows;
    }
    public PageDTO(){
        super();
    }
}
