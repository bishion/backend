package com.bizi.backend.bases;

import java.util.Collections;
import java.util.List;

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
