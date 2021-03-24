package com.other;


import java.io.Serializable;
import java.sql.Timestamp;


public class RocketMqProductSendMessageObejctVO implements Serializable {
    private String url;//请求地址
    private Object reqIotbody;//vop请求物联网报文体
    private Object rspIotbody;//物联网响应返回报文体
    private String reqMessageBody; //Vop下发请求报文体
    private Timestamp reqTimeStamp;//发送时间
    private Timestamp rspTimeStamp;//响应时间



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getReqIotbody() {
        return reqIotbody;
    }

    public void setReqIotbody(Object reqIotbody) {
        this.reqIotbody = reqIotbody;
    }

    public Object getRspIotbody() {
        return rspIotbody;
    }

    public void setRspIotbody(Object rspIotbody) {
        this.rspIotbody = rspIotbody;
    }

    public String getReqMessageBody() {
        return reqMessageBody;
    }

    public void setReqMessageBody(String reqMessageBody) {
        this.reqMessageBody = reqMessageBody;
    }

    public Timestamp getReqTimeStamp() {
        return reqTimeStamp;
    }

    public void setReqTimeStamp(Timestamp reqTimeStamp) {
        this.reqTimeStamp = reqTimeStamp;
    }

    public Timestamp getRspTimeStamp() {
        return rspTimeStamp;
    }

    public void setRspTimeStamp(Timestamp rspTimeStamp) {
        this.rspTimeStamp = rspTimeStamp;
    }
}
