package com.pojo;


import java.util.Map;

/**
 * 该对象是将用户换机信息存入redis使用
 */
public class RzLoginInfo {
    private String lastImei; //最近一成功登录的imei
    private Map<String, String> imeis;//key是年月日，value是逗号分隔的imei信息
    private Map<String, LoginCnt> logincnt; //key是年月日，value是成功登录次数和换机次数

    @Override
    public String toString() {
        return "RzLoginInfo{" +
                "lastImei='" + lastImei + '\'' +
                ", imeis=" + imeis +
                ", logincnt=" + logincnt +
                '}';
    }

    public String getLastImei() {
        return lastImei;
    }

    public void setLastImei(String lastImei) {
        this.lastImei = lastImei;
    }

    public Map<String, String> getImeis() {
        return imeis;
    }

    public void setImeis(Map<String, String> imeis) {
        this.imeis = imeis;
    }

    public Map<String, LoginCnt> getLogincnt() {
        return logincnt;
    }

    public void setLogincnt(Map<String, LoginCnt> logincnt) {
        this.logincnt = logincnt;
    }
}