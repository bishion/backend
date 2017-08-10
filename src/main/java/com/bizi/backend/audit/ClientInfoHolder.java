package com.bizi.backend.audit;

/**
 * Created by guo on 16-11-6.
 */
public class ClientInfoHolder {
    private static final ThreadLocal<ClientInfo> clientInfoHolder = new ThreadLocal<>();

    public static void setClientInfo(final ClientInfo clientInfo){
        clientInfoHolder.set(clientInfo);
    }
    public static ClientInfo getClientInfo(){
        return clientInfoHolder.get();
    }
    public static void clear(){
        clientInfoHolder.remove();
    }
}
