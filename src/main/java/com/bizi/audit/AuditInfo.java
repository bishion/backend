package com.bizi.audit;

public class AuditInfo {
    private String loginName;
    private String clientIp;
    private String serverIp;
    private String requestVal;
    private String returnVal;
    private String action;
    private String system;
    private String flag;

    public AuditInfo(String loginName, ClientInfo clientInfo, String requestVal, String returnVal, String action, String system, String flag) {
        this.loginName = loginName;
        this.clientIp = clientInfo.getClientIp();
        this.serverIp = clientInfo.getServerIp();
        this.requestVal = requestVal;
        this.returnVal = returnVal;
        this.action = action;
        this.system = system;
        this.flag = flag;
    }



    public String getLoginName() {
        return loginName;
    }

    public String getClientIp() {
        return clientIp;
    }

    public String getServerIp() {
        return serverIp;
    }

    public String getRequestVal() {
        return requestVal;
    }

    public String getReturnVal() {
        return returnVal;
    }

    public String getAction() {
        return action;
    }

    public String getSystem() {
        return system;
    }

    public String getFlag() {
        return flag;
    }

    @Override
    public String toString() {
        return "AuditInfo{" +
                "loginName='" + loginName + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", requestVal='" + requestVal + '\'' +
                ", returnVal='" + returnVal + '\'' +
                ", action='" + action + '\'' +
                ", system='" + system + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
