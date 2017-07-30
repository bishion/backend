package com.bizi.backend.bases;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BasePage<T> {
    private int total;
    private T rows;
}
