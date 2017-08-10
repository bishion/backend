package com.bizi.backend.audit;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by guo on 16-11-6.
 */

public class ClientInfo {
    private final String serverIp;
    private final String clientIp;

    private ClientInfo(String serverIp, String clientIp) {
        this.serverIp = serverIp==null?"unknown":serverIp;
        this.clientIp = clientIp==null?"unknown":clientIp;
    }
    public ClientInfo(HttpServletRequest request){

        this(request.getLocalAddr(),request.getRemoteAddr());
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getClientIp() {
        return clientIp;
    }
}
