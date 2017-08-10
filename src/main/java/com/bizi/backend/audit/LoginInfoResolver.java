package com.bizi.backend.audit;

import javax.servlet.http.HttpServletRequest;

public interface LoginInfoResolver {
    String getLoginName(HttpServletRequest request);
}
