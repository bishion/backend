package com.bizi.backend.audit;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by guo on 16-11-6.
 */
public class ClientInfoFilter implements Filter {
    @Autowired
    private LoginInfoResolver loginInfoResolver;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            final ClientInfo clientInfo = new ClientInfo((HttpServletRequest)servletRequest);
            ClientInfoHolder.setClientInfo(clientInfo);
            filterChain.doFilter(servletRequest,servletResponse);
        }finally {
            ClientInfoHolder.clear();
        }
    }

    @Override
    public void destroy() {

    }
}
