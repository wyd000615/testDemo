package com.other;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

public class StringObject {
    @Test
    public void test(){
        RocketMqProductSendMessageObejctVO rocketMqProductSendMessageObejctVO = new RocketMqProductSendMessageObejctVO();
        rocketMqProductSendMessageObejctVO.setUrl("xxxx");
        rocketMqProductSendMessageObejctVO.setReqMessageBody("sssss");
        rocketMqProductSendMessageObejctVO.setReqTimeStamp(new Timestamp(new Date().getTime()));
        rocketMqProductSendMessageObejctVO.setRspTimeStamp(new Timestamp(new Date().getTime()));

        //String str = rocketMqProductSendMessageObejctVO.toString();

        JSONObject json = JSONObject.fromObject(rocketMqProductSendMessageObejctVO);

String str =json.toString();
        System.out.println(str);
    }
    @Test
    public void test01(){
        //String str =" RocketMqProductSendMessageObejctVO(url=http://localhost:9300/orderComplete/register_account_orderComplete, reqIotbody=null, rspIotbody={\"iccid\":\"11110000000000000008\",\"messageId\":\"1\",\"version\":\"1.0\",\"resultCode\":\"0000\",\"resultDesc\":\"开户成功\"}, reqMessageBody=null, reqTimeStamp=2020-10-28 14:21:44.063, rspTimeStamp=2020-10-28 14:21:44.063)";
       // String str ="{url='xxxx', reqIotbody=null, rspIotbody=\"1231\", reqMessageBody='sssss', reqTimeStamp=null, rspTimeStamp=null}";
          //String str ="{url='http://localhost:9300/orderComplete/register_account_orderComplete', reqIotbody=null, rspIotbody={\"iccid\":\"11110000000000000008\",\"messageId\":\"1\",\"version\":\"1.0\",\"resultCode\":\"0000\",\"resultDesc\":\"开户成功\"}, reqMessageBody='null',reqTimeStamp=2020-10-28 15:47:13.777, rspTimeStamp=2020-10-28 15:47:13.777}";
        String str ="{\"reqIotbody\":null,\"reqMessageBody\":\"sssss\",\"reqTimeStamp\":{\"date\":28,\"day\":3,\"hours\":16,\"minutes\":4,\"month\":9,\"nanos\":499000000,\"seconds\":47,\"time\":1603872287499,\"timezoneOffset\":-480,\"year\":120},\"rspIotbody\":null,\"rspTimeStamp\":{\"date\":28,\"day\":3,\"hours\":16,\"minutes\":4,\"month\":9,\"nanos\":499000000,\"seconds\":47,\"time\":1603872287499,\"timezoneOffset\":-480,\"year\":120},\"url\":\"xxxx\"}";
        System.out.println("==str="+str);
        JSONObject json = JSONObject.fromObject(str);
        String rspIotbody = json.getString("rspIotbody");
        System.out.println(rspIotbody);

    }
}
