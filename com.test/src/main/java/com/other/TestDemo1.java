package com.other;

import com.test.IotDiscntEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestDemo1 {
    public static String getJsonRspStr2Iot(String status, String resultMark) {
        String jsonRspStr = "";
        if ("true".equals(status) || "false".equals(status)) {
            jsonRspStr += "{\"data\":{\"status\":" + status;
        } else {
            jsonRspStr += "{\"error\":{\"status\":\"" + status + "\"";
        }
        if (resultMark != null && resultMark != "") {
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        } else {// 保证字段存在，不存在则返回系统内部错误
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        }
        jsonRspStr += "}}";
        return jsonRspStr;
    }

    @Test
    public void tewst() {
        for (int i = 0; i < 100; i++) {
            int j = i % 5;
            System.out.println("===" + i + "====" + j);
        }
    }

    @Test
    public void tewst1() {
        int i = 123;
        long j = 4070880000000L;
        long k = 122L;
        int z = (int) (j - k);


        if (j > k) {
            System.out.println("---");
        }
        System.out.println(z);
    }

    @Test
    public void tewst2() {
        String str = "PR_0001_PE_0001";
        String str1 = str.substring(8);
        String str2 = str.substring(1, 1);

        System.out.println(str1);
        System.out.println(str.substring(8, 15));

    }

    @Test
    public void tewst3() {
        String Str = "PR_0001_PE_0001";

        System.out.print("返回值 :");
        System.out.println(Str.substring(4));

        System.out.print("返回值 :");
        System.out.println(Str.substring(4, 10));
    }

    @Test
    public void tewst4() {
        String Str = "PR_0001_PE_0001";
        String title = Str.substring(0, 2);
        System.out.print("返回值 :");
        System.out.println(Str.substring(4));

        System.err.print("返回值 :" + title);
        System.out.println(Str.substring(4, 10));
        String str =
                "{\"error\":{\"status\":\"S-AF-007\",\"message\":\"转售企业时间戳timestamp：2020-10-20 12:19:37与VOPS时间:2020-10-30 16:23:50相差误差过大\"}}";
    }

    @Test
    public void tewst5() {
        Timestamp t = new Timestamp(new Date().getTime());
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        stringObjectHashMap.put("t", t);
        System.out.println(stringObjectHashMap.get("t"));
    }

    @Test
    public void tewst6() {
        String str = "PR_0001*PK_0001";
        String di = str.split("\\*")[2];
        System.out.println(di);
    }

    @Test
    public void tewst7() {
        String str = "VOPI";
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            System.out.println(s);
        }
    }

    @Test
    public void tewst8() {
        String s = UUID.randomUUID().toString().replace("-", "");
        System.out.println(s);
    }

    @Test
    public void tewst9() {
        String apiName = "cu.vop.basic_service.iot_push_mvno";
        String test1 = apiName.split("\\.")[2];

        String test2 = apiName.split("\\.")[3];
        System.out.println(test1);


    }

    @Test
    public void tewst10() {
        String logg = "{\n" +
                "    \"reqIotbody\":\"\",\n" +
                "    \"reqMessageBody\":\"{\"api_name\":\"cu.vop.orderComplete.iot_complete\",\"mvnokey\":\"OJvWpmI\",\"service_type\":\"orderComplete\",\"service_name\":\"iot_complete\",\"message\":\"成功\",\"status\":\"0000\",\"data\":{\"messageId\":\"9120112300003568\",\"iccid\":\"89860119900047065490\",\"resultCode\":\"0000\",\"resultDesc\":\"竣工成功\",\"timestamp\":\"2020-11-10 19:23:37 649\",\"version\":\"1.0\"}}\",\n" +
                "    \"reqTimeStamp\":{\n" +
                "        \"date\":23,\n" +
                "        \"day\":1,\n" +
                "        \"hours\":16,\n" +
                "        \"minutes\":27,\n" +
                "        \"month\":10,\n" +
                "        \"nanos\":670000000,\n" +
                "        \"seconds\":36,\n" +
                "        \"time\":1606120056670,\n" +
                "        \"timezoneOffset\":-480,\n" +
                "        \"year\":120\n" +
                "    },\n" +
                "    \"rspIotbody\":{\n" +
                "        \"api_name\":\"cu.vop.orderComplete.iot_complete\",\n" +
                "        \"mvnokey\":\"OJvWpmI\",\n" +
                "        \"service_type\":\"orderComplete\",\n" +
                "        \"service_name\":\"iot_complete\",\n" +
                "        \"message\":\"成功\",\n" +
                "        \"status\":\"0000\",\n" +
                "        \"data\":{\n" +
                "            \"messageId\":\"9120112300003568\",\n" +
                "            \"iccid\":\"89860119900047065490\",\n" +
                "            \"resultCode\":\"0000\",\n" +
                "            \"resultDesc\":\"竣工成功\",\n" +
                "            \"timestamp\":\"2020-11-10 19:23:37 649\",\n" +
                "            \"version\":\"1.0\"\n" +
                "        }\n" +
                "    },\n" +
                "    \"rspTimeStamp\":{\n" +
                "        \"date\":23,\n" +
                "        \"day\":1,\n" +
                "        \"hours\":16,\n" +
                "        \"minutes\":27,\n" +
                "        \"month\":10,\n" +
                "        \"nanos\":694000000,\n" +
                "        \"seconds\":36,\n" +
                "        \"time\":1606120056694,\n" +
                "        \"timezoneOffset\":-480,\n" +
                "        \"year\":120\n" +
                "    },\n" +
                "    \"url\":\"\"\n" +
                "}";

        String trim = logg.trim();
        System.out.println(trim);
        JSONObject jsonObj = JSONObject.fromObject(logg);

        System.out.println(jsonObj);


    }

    @Test
    public void tewst11() {
        String apiName = "cu.vop.basic_service.iot_push_mvno";
        String test1 = apiName.split("\\.")[2];

        String test2 = apiName.split("\\.")[3];
        System.out.println(test1);


    }

    @Test
    public void tewst12() {
        String e = "org.springframework.web.client.ResourceAccessException: I/O error on POST request for \"https://localhost:10010/iot_feedback/vop_for_iot_order/uploadterminal\": Read timed out; nested exception is java.net.SocketTimeoutException: Read timed out";
        String readTime = "Read timed out";
        String readTime2 = "Read timed out2";

        System.out.println(e.indexOf(readTime));
        System.out.println(e.indexOf(readTime2));
        if (e.indexOf(readTime2) > -1) {

        }

    }

    @Test
    public void tewst13() {
        String status = "true";
        String resultMark = "";
        String jsonRspStr = "";
        jsonRspStr += "{\"result_code\":\"" + status + "\"";
        if (resultMark != null && resultMark != "") {
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        } else {// 保证字段存在，不存在则返回系统内部错误
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        }
        jsonRspStr += "}";
        System.out.println(jsonRspStr);

    }

    @Test
    public void tewst14() {

        JSONObject outMessage = new JSONObject(); // 一级报文
        //一级报文 head
        /**
         * {
         *     "UNI_BSS_HEAD":{
         *         "APP_ID":"APP3948371",
         *         "TIMESTAMP":"2016-04-1215:06:06100",
         *         "TRANS_ID":"20160412150606100335423",
         *         "TOKEN":"c6eb4ca3daec54a8db74b41bd268fa26",
         *         "RESERVED":[
         *             {
         *                 "RESERVED_ID":"aaaaaa",
         *                 "RESERVED_VALUE":"bbbbbb"
         *             },
         *             {
         *                 "RESERVED_ID":"111111",
         *                 "RESERVED_VALUE":"222222"
         *             }
         *         ]
         *     },
         *     "UNI_BSS_BODY":{
         *
         *     },
         *     "UNI_BSS_ATTACHED":{
         *         "MEDIA_INFO":""
         *     }
         * }
         */
        JSONObject headMessage = new JSONObject();
        headMessage.put("APP_ID", "appId");
        headMessage.put("TIMESTAMP", "timestamp");
        headMessage.put("TRANS_ID", "transId");
        headMessage.put("TOKEN", "token");
        JSONArray reservedArr = new JSONArray();
        headMessage.put("RESERVED", reservedArr);
        outMessage.put("UNI_BSS_HEAD", headMessage);
        //一级报文 body
        /**
         * {
         *     "UNI_BSS_BODY":{
         *         "UPLOAD_TERMINAL_REQ":{
         *             "app_id":"",
         *             "timestamp":"",
         *             "trans_id":"",
         *             "token":"",
         *             "data":{
         *
         *             }
         *         }
         *     }
         * }
         */
        JSONObject bodyMessage = new JSONObject();
        JSONObject uploadterminalReqMessage = new JSONObject();
        uploadterminalReqMessage.put("app_id", "appId");
        uploadterminalReqMessage.put("timestamp", "timestamp");
        uploadterminalReqMessage.put("transId", "transId");
        uploadterminalReqMessage.put("token", "token");
        JSONObject secondaryMessage = new JSONObject();
        secondaryMessage.put("messageId", "messageId");
        secondaryMessage.put("openId", "openId");
        secondaryMessage.put("version", "version");
        secondaryMessage.put("asynchronous", "asynchronous");
        secondaryMessage.put("callbackUrl", "callbackUrl");
        secondaryMessage.put("source", "source");
        secondaryMessage.put("iccid", "iccid");
        secondaryMessage.put("msisdn", "msisdn");
        secondaryMessage.put("imsi", "imsi");
        secondaryMessage.put("accountId", "accountId");
        secondaryMessage.put("ratePlan", "ratePlan");
        secondaryMessage.put("nacId", "nacId");
        secondaryMessage.put("pin1", "pin1");
        secondaryMessage.put("pin2", "pin2");
        secondaryMessage.put("puk1", "puk1");
        secondaryMessage.put("puk2", "puk2");
        secondaryMessage.put("ki", "aimsKi");
        secondaryMessage.put("acc", "acc");
        secondaryMessage.put("adm", "adm");
        uploadterminalReqMessage.put("data", secondaryMessage);
        bodyMessage.put("UPLOAD_TERMINAL_REQ", uploadterminalReqMessage);
        outMessage.put("UNI_BSS_BODY", bodyMessage);
        //一级报文 报文附加信息
        JSONObject attachedMessage = new JSONObject();
        attachedMessage.put("MEDIA_INFO", "");
        outMessage.put("UNI_BSS_ATTACHED", attachedMessage);
        //return outMessage;
        System.out.println(outMessage);
    }

    /**
     * 测试md5加密
     */
    @Test
    public void tewst15() {
        String str = "123";
        String md5Password = DigestUtils.md5DigestAsHex(str.getBytes());
        System.out.println(md5Password);
    }

    /**
     * 测试md5加密
     */
    @Test
    public void tewst16() {
        String transId = "123-";
        transId = transId + (new Random().nextInt(999999));

        System.out.println(transId);
    }

    /**
     * 测试md5加密
     */
    @Test
    public void tewst17() {
        String timestamp = "2017-09-14 13:54:45";
        timestamp = getFormatedDateString(8);
        System.out.println(timestamp);
    }

    public String getFormatedDateString(float timeZoneOffset) {
        if (timeZoneOffset > 13 || timeZoneOffset < -12) {
            timeZoneOffset = 0;
        }

        int newTime = (int) (timeZoneOffset * 60 * 60 * 1000);
        TimeZone timeZone;
        String[] ids = TimeZone.getAvailableIDs(newTime);
        if (ids.length == 0) {
            timeZone = TimeZone.getDefault();
        } else {
            timeZone = new SimpleTimeZone(newTime, ids[0]);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        sdf.setTimeZone(timeZone);
        return sdf.format(new Date());
    }

 /*   private String jointToken(HashMap<String, String> headinnermap) {
        String tokenStr = "APP_ID"+headinnermap.get("APP_ID")+"TIMESTAMP"+headinnermap.get("TIMESTAMP")+"TRANS_ID"+headinnermap.get("TRANS_ID")+app_secret;
        String encrypt = MD5Util.encrypt(tokenStr);
        logger.info("Token"+tokenStr+"      ---     Token MD5"+encrypt);
        return encrypt;
    }*/


    /**
     * 测试md5加密
     */
    @Test
    public void tewst18() {
        String timestamp = "2020-12-17 14:18:27 505";
        String transId = "20170914135445687536273";
        transId = timestamp.replace("-", "").replace(" ", "").replace(":", "");

        System.out.println(transId);
        //2020 1217 1418 2750 5
    }

    /**
     * 测试md5加密
     */
    @Test
    public void tewst19() {
        String timestamp = "{\n" +
                "    \"UNI_BSS_HEAD\":{\n" +
                "        \"RESP_DESC\":\"Success\",\n" +
                "        \"TRANS_ID\":\"20201217053334020804795\",\n" +
                "        \"TIMESTAMP\":\"2020-12-17 05:33:34 020\",\n" +
                "        \"RESP_CODE\":\"00000\",\n" +
                "        \"APP_ID\":\"xxx\"\n" +
                "    },\n" +
                "    \"UNI_BSS_ATTACHED\":{\n" +
                "        \"MEDIA_INFO\":\"\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\":{\n" +
                "        \"UPLOAD_TERMINAL_RSP\":{\n" +
                "            \"message\":\"成功\",\n" +
                "            \"status\":\"0\",\n" +
                "            \"data\":{\n" +
                "                \"iccid\":\"11110000000000000008\",\n" +
                "                \"resultCode\":\"0000\",\n" +
                "                \"messageId\":\"1\",\n" +
                "                \"version\":\"1.0\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(timestamp);
        //System.out.println(jsonObject);
        Object uni_bss_body = jsonObject.get("UNI_BSS_BODY");
        //System.out.println(uni_bss_body);

        JSONObject jsonObject2 = JSONObject.fromObject(uni_bss_body);
        //System.out.println(jsonObject2);
        //jsonObject2.ge
        System.out.println(jsonObject2);

        //Object result = jsonObject2.keySet().iterator().next();
        JSONObject result = (JSONObject) jsonObject2.values().iterator().next();

        System.out.println(result);
        String message = (String) result.get("message");
        System.out.println(message);
        //Object resultCode = result.get("resultCode");
        //System.out.println(resultCode);
    }

    /**
     * 测试md5加密
     */
    @Test
    public <jsonObject> void tewst20() {
        String timestamp = "{\n" +
                "    \"UNI_BSS_HEAD\":{\n" +
                "        \"RESP_DESC\":\"Success\",\n" +
                "        \"TRANS_ID\":\"20201217053334020804795\",\n" +
                "        \"TIMESTAMP\":\"2020-12-17 05:33:34 020\",\n" +
                "        \"RESP_CODE\":\"00000\",\n" +
                "        \"APP_ID\":\"xxx\"\n" +
                "    },\n" +
                "    \"UNI_BSS_ATTACHED\":{\n" +
                "        \"MEDIA_INFO\":\"\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\":{\n" +
                "        \"UPLOAD_TERMINAL_RSP\":{\n" +
                "            \"message\":\"成功\",\n" +
                "            \"status\":\"0\",\n" +
                "            \"data\":{\n" +
                "                \"iccid\":\"11110000000000000008\",\n" +
                "                \"resultCode\":\"0000\",\n" +
                "                \"messageId\":\"1\",\n" +
                "                \"version\":\"1.0\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        JSONObject jsonObject = JSONObject.fromObject(timestamp);
        Object uniBssBody = jsonObject.get("UNI_BSS_BODY");
        JSONObject uniBssBodyObj = JSONObject.fromObject(uniBssBody);
        System.out.println(uniBssBodyObj);
        if (uniBssBodyObj.containsKey("UPLOAD_TERMINAL_RSP")) {
            jsonObject uploadTerminalTsp = (jsonObject) uniBssBodyObj.get("UPLOAD_TERMINAL_RSP");
            System.out.println(uploadTerminalTsp);
        }
    }

    /**
     * 测试md5加密
     */
    @Test
    public void tewst21() {
        String messageId = "6666666666";
        String rspStr = "{\n" +
                "    \"UNI_BSS_HEAD\":{\n" +
                "        \"RESP_DESC\":\"Success\",\n" +
                "        \"TRANS_ID\":\"20201217053334020804795\",\n" +
                "        \"TIMESTAMP\":\"2020-12-17 05:33:34 020\",\n" +
                "        \"RESP_CODE\":\"00000\",\n" +
                "        \"APP_ID\":\"xxx\"\n" +
                "    },\n" +
                "    \"UNI_BSS_ATTACHED\":{\n" +
                "        \"MEDIA_INFO\":\"\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\":{\n" +
                "        \"UPLOAD_TERMINAL_RSP\":{\n" +
                "            \"message\":\"成功\",\n" +
                "            \"status\":\"0\",\n" +
                "            \"data\":{\n" +
                "                \"iccid\":\"11110000000000000008\",\n" +
                "                \"resultCode\":\"0000\",\n" +
                "                \"messageId\":\"" + messageId + "\",\n" +
                "                \"version\":\"1.0\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(rspStr);
    }


    /**
     * 测试md5加密
     */
    @Test
    public void tews22() {
        String nlptChangeProduct = "产品变更";
        //
        JSONObject outMessage = new JSONObject();
        JSONObject headMessage = new JSONObject();
        headMessage.put("APP_ID", "nlptAppId");
        headMessage.put("TIMESTAMP", "nlptTimestamp");
        headMessage.put("TRANS_ID", "nlptTransId");
        headMessage.put("TOKEN", "nlptToken");
        JSONArray reservedArr = new JSONArray();
        headMessage.put("RESERVED", reservedArr);
        //一级报文 head
        outMessage.put("UNI_BSS_HEAD", headMessage);
        //一级报文 body
        JSONObject bodyMessage = new JSONObject();
        JSONObject editTerminalReqReqMessage = new JSONObject();
        editTerminalReqReqMessage.put("app_id", "iotAppId");
        editTerminalReqReqMessage.put("timestamp", "iotTimestamp");
        editTerminalReqReqMessage.put("transId", "iotTransId");
        editTerminalReqReqMessage.put("token", "iotToken");
        JSONObject secondaryMessage = new JSONObject();
        secondaryMessage.put("messageId", "messageId");
        secondaryMessage.put("openId", "openId");
        secondaryMessage.put("version", "version");
        secondaryMessage.put("asynchronous", "asynchronous");
        secondaryMessage.put("callbackUrl", "callbackUrl");
        secondaryMessage.put("iccid", "iccid");
        //如果是换产品或者预约生效产品才会给物联网传生效时间字段
      /*  if (mproducts != null && mproducts.size() == 2) {
            secondaryMessage.put("effectiveDate", effectiveDate);
        }*/
        secondaryMessage.put("nacId", "nacId");
        editTerminalReqReqMessage.put("data", secondaryMessage);
        bodyMessage.put(nlptChangeProduct, editTerminalReqReqMessage);
        outMessage.put("UNI_BSS_BODY", bodyMessage);
        //一级报文 附加
        JSONObject attachedMessage = new JSONObject();
        attachedMessage.put("MEDIA_INFO", "");
        outMessage.put("UNI_BSS_ATTACHED", attachedMessage);

        System.out.println(outMessage);
    }

    /**
     * 模拟开户响应报文
     */
    @Test
    public void tews23() {
        //拼接报文
        JSONObject outMessage = new JSONObject();
        //一级head
        JSONObject headMessage = new JSONObject();
        headMessage.put("RESP_DESC", "Success");
        headMessage.put("TRANS_ID", "20201217053334020804795");
        headMessage.put("TIMESTAMP", "2020-12-17 05:33:34 020");
        headMessage.put("RESP_CODE", "00000");
        headMessage.put("APP_ID", "xxxxx");
        //一级body
        JSONObject bodyMessage = new JSONObject();
        //一级body二级upload_terminal_rsp
        JSONObject uploadTerminalRsp = new JSONObject();
        uploadTerminalRsp.put("message", "成功");
        uploadTerminalRsp.put("status", "0");
        //一级body二级upload_terminal_rsp三级data
        JSONObject data = new JSONObject();
        data.put("iccid", "xxxxxxx");
        data.put("resultCode", "0000");
        data.put("messageId", "xxxxx");
        data.put("version", "1.0");
        uploadTerminalRsp.put("data", data);
        bodyMessage.put("UPLOAD_TERMINAL_RSP", uploadTerminalRsp);
        //一级attached
        JSONObject attachedMessage = new JSONObject();
        attachedMessage.put("MEDIA_INFO", "");
        //将一级报文放到outMessage中
        outMessage.put("UNI_BSS_HEAD", headMessage);
        outMessage.put("UNI_BSS_BODY", bodyMessage);
        outMessage.put("UNI_BSS_ATTACHED", attachedMessage);
        System.out.println(outMessage);
    }


    /**
     * 模拟开户响应报文
     */
    @Test
    public void tews24() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("key1");
        List<String> userOldOrderInstListCopy = new ArrayList<String>();
        userOldOrderInstListCopy.addAll(list1);
        System.out.println(userOldOrderInstListCopy);
    }

    @Test
    public void tews25() {

        //拼接报文
        // 一级报文
        JSONObject outMessage = new JSONObject();
        JSONObject headMessage = new JSONObject();
        headMessage.put("APP_ID", "nlptAppId");
        headMessage.put("TIMESTAMP", "nlptTimestamp");
        headMessage.put("TRANS_ID", "nlptTransId");
        headMessage.put("TOKEN", "nlptToken");
        JSONArray reservedArr = new JSONArray();
        headMessage.put("RESERVED", reservedArr);
        //一级报文 head
        outMessage.put("UNI_BSS_HEAD", headMessage);
        //一级报文 body
        JSONObject bodyMessage = new JSONObject();
        JSONObject editTerminalReqReqMessage = new JSONObject();
        editTerminalReqReqMessage.put("app_id", "iotAppId");
        editTerminalReqReqMessage.put("timestamp", "iotTimestamp");
        editTerminalReqReqMessage.put("trans_id", "iotTransId");
        editTerminalReqReqMessage.put("token", "iotToken");
        JSONObject secondaryMessage = new JSONObject();
        secondaryMessage.put("messageId", "messageId");
        secondaryMessage.put("openId", "openId");
        secondaryMessage.put("version", "version");
        secondaryMessage.put("asynchronous", "asynchronous");
        secondaryMessage.put("callbackUrl", "callbackUrl");
        secondaryMessage.put("iccid", "iccid");
        //如果是换产品或者预约生效产品才会给物联网传生效时间字段
        secondaryMessage.put("targetValue", "");
        secondaryMessage.put("changeType", "");
        editTerminalReqReqMessage.put("data", secondaryMessage);
        bodyMessage.put("EDIT_TERMINAL_REQ", editTerminalReqReqMessage);
        outMessage.put("UNI_BSS_BODY", bodyMessage);
        //一级报文 附加
        JSONObject attachedMessage = new JSONObject();
        attachedMessage.put("MEDIA_INFO", "");
        outMessage.put("UNI_BSS_ATTACHED", attachedMessage);
        System.out.println(outMessage);
    }

    @Test
    public void tews254() {


        //拼接报文
        // 一级报文
        JSONObject outMessage = new JSONObject();
        JSONObject headMessage = new JSONObject();
        headMessage.put("APP_ID", "nlptAppId");
        headMessage.put("TIMESTAMP", "nlptTimestamp");
        headMessage.put("TRANS_ID", "nlptTransId");
        headMessage.put("TOKEN", "nlptToken");
        JSONArray reservedArr = new JSONArray();
        headMessage.put("RESERVED", reservedArr);
        //一级报文 head
        outMessage.put("UNI_BSS_HEAD", headMessage);
        //一级报文 body
        JSONObject bodyMessage = new JSONObject();
        JSONObject editReqReqMessage = new JSONObject();
        editReqReqMessage.put("api_name", "apiName");
        editReqReqMessage.put("timestamp", "timeStamp");
        JSONObject dataMessage = new JSONObject();
        dataMessage.put("serial_number", "serialNumber");
        dataMessage.put("order_id", "orderId");
        dataMessage.put("status", "status");
        dataMessage.put("message", "message");
        editReqReqMessage.put("data", dataMessage);
        bodyMessage.put("messageType", editReqReqMessage);
        outMessage.put("UNI_BSS_BODY", bodyMessage);
        System.out.println(outMessage);
    }

    @Test
    public void test5() {
        String str = "1*2";
        str.replace("*", "");
        System.out.println(str.replace("*", ""));
        System.out.println(str);
    }

    @Test
    public void test61() {
        //初始化
        List<String> userOldOrderInstList = new ArrayList<>();
        HashMap<String, ArrayList<IotDiscntEntity>> orderDiscntMap = new HashMap<String, ArrayList<IotDiscntEntity>>();
        userOldOrderInstList.add("IOT00002");
        IotDiscntEntity iotDiscntEntity01 = new IotDiscntEntity();
        iotDiscntEntity01.setProductId("IOT_PR_0001");
        iotDiscntEntity01.setPackageId("IOT_PK_0002");
        iotDiscntEntity01.setDiscntId("IOT_ZE_0002");
        iotDiscntEntity01.setActionType("unsubscribe");
        IotDiscntEntity iotDiscntEntity02 = new IotDiscntEntity();
        iotDiscntEntity02.setProductId("IOT_PR_0001");
        iotDiscntEntity02.setPackageId("IOT_PK_0002");
        iotDiscntEntity02.setDiscntId("IOT_ZE_0007");
        iotDiscntEntity02.setActionType("order");
        ArrayList<IotDiscntEntity> iotDiscntEntities1 = new ArrayList<>();
        iotDiscntEntities1.add(iotDiscntEntity01);
        orderDiscntMap.put("IOT_PR_0001*IOT_PK_0002*IOT_ZE_0002", iotDiscntEntities1);
        ArrayList<IotDiscntEntity> iotDiscntEntities2 = new ArrayList<>();
        iotDiscntEntities2.add(iotDiscntEntity02);
        orderDiscntMap.put("IOT_PR_0001*IOT_PK_0002*IOT_ZE_0007", iotDiscntEntities2);


        //定义 map,key为prpk,value为指令个数
        HashMap<String, Integer> pkInstSizeMap = new HashMap<String, Integer>();


        for (String PrPkPe : orderDiscntMap.keySet()) {

            String oldOrderProductId = PrPkPe.split("\\*")[0];
            String oldOrderProdPackageId = PrPkPe.split("\\*")[1];
            String prpk = oldOrderProductId + "*" + oldOrderProdPackageId;

            ArrayList<IotDiscntEntity> iotDiscntEntities = orderDiscntMap.get(PrPkPe);

            for (IotDiscntEntity iotDiscntEntity : iotDiscntEntities) {
                //
                if ("order".equals(iotDiscntEntity.getActionType())) {
                    if (pkInstSizeMap.containsKey(prpk)) {
                        pkInstSizeMap.put(prpk, pkInstSizeMap.get(prpk) + 1);
                    } else {
                        pkInstSizeMap.put(prpk, 1);
                    }
                }
                if ("unsubscribe".equals(iotDiscntEntity.getActionType())) {
                    if (pkInstSizeMap.containsKey(prpk)) {
                        pkInstSizeMap.put(prpk, pkInstSizeMap.get(prpk) - 1);
                    } else {
                        pkInstSizeMap.put(prpk, -1);
                    }
                }
            }
            // String oldOrderInst = commonService.qryIotInstByPrPk(oldOrderProductId, oldOrderProdPackageId);

        }

        for (String key : pkInstSizeMap.keySet()) {
            System.out.println("====key===" + key + "====" + pkInstSizeMap.get(key));
        }

        System.out.println("====" + pkInstSizeMap);
        for (String prpk : pkInstSizeMap.keySet()) {
            String pr = prpk.split("\\*")[0];
            String pk = prpk.split("\\*")[1];
            int instSize = pkInstSizeMap.get(prpk);
            System.out.println("=pr==" + pr + "===pk==" + pk);
            String oldOrderInst = "IOT00002"; //commonService.qryIotInstByPrPk(pr, pk);
            if (instSize > 0) {
                if (oldOrderInst != null) {
                    userOldOrderInstList.add(oldOrderInst);
                }
            } else if (instSize < 0) {
                if (oldOrderInst != null) {
                    userOldOrderInstList.remove(oldOrderInst);
                }
            }
        }

        System.out.println("userOldOrderInstList===" + userOldOrderInstList);
    }

    @Test
    public void test62() {
        List<String> userOldOrderInstList = new ArrayList<>();
        HashMap<String, ArrayList<IotDiscntEntity>> orderDiscntMap = new HashMap<String, ArrayList<IotDiscntEntity>>();
        userOldOrderInstList.add("IOT00002");

        IotDiscntEntity iotDiscntEntity01 = new IotDiscntEntity();
        iotDiscntEntity01.setProductId("IOT_PR_0001");
        iotDiscntEntity01.setPackageId("IOT_PK_0002");
        iotDiscntEntity01.setDiscntId("IOT_ZE_0002");
        iotDiscntEntity01.setActionType("unsubscribe");
        System.out.println("====");
        IotDiscntEntity iotDiscntEntity02 = new IotDiscntEntity();
        iotDiscntEntity02.setProductId("IOT_PR_0001");
        iotDiscntEntity02.setPackageId("IOT_PK_0002");
        iotDiscntEntity02.setDiscntId("IOT_ZE_0007");
        iotDiscntEntity02.setActionType("order");

    }

    /*@Test
    public void test() {
        String 姓名="";
        if(姓名=="程高辉"){
            new Object();
        }
    }*/
    @Test
    public void test63() {
        JSONObject JSONObject = null;// new    JSONObject();
        String str = JSONObject == null ? new JSONObject().toString() : JSONObject.toString();
        System.out.println(str);
    }


    @Test
    public void test64() {
        String status = "true";
        String resultMark = "xxxx";
        String jsonRspStr = "";
        if ("true".equals(status) || "false".equals(status)) {
            jsonRspStr += "{\"data\":{\"status\":\"" + status + "\"";
        } else {
            jsonRspStr += "{\"error\":{\"status\":\"" + status + "\"";
        }
        if (resultMark != null && resultMark != "") {
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        } else {// 保证字段存在，不存在则返回系统内部错误
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        }
        jsonRspStr += "}}";
        System.out.println(jsonRspStr);
    }

    @Test
    public void test65() {
        String str = null;
        if ("rs".equals(str) && str != null) {
            System.out.println("111");
        } else {
            System.out.println("222");
        }
    }

    @Test
    public void test66() {
        String str = "";

        for (int i = 0; i < 65535; i++) {
            str += "s";
        }
        System.out.println(str);
    }

    @Test
    public void test67() {
        String str = "ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        System.out.println(str.length());
        System.out.println(str);
    }

    @Test
    public void test68() {
        String str = "";

        for (int i = 0; i < 65535; i++) {
            str += "s";
        }
        System.out.println(str);
    }


    @Test
    public void test69() {
        String messageId = "xxxxx";
        String rspStr = "{\n" +
                "    \"api_name\":\"cu.vop.orderComplete.iot_complete\",\n" +
                "    \"mvnokey\":\"OJvWpmI\",\n" +
                "    \"service_type\":\"orderComplete\",\n" +
                "    \"service_name\":\"iot_complete\",\n" +
                "    \"message\":\"成功\",\n" +
                "    \"status\":\"0000\",\n" +
                "    \"data\":{\n" +
                "        \"messageId\":\"" + messageId + "\",\n" +
                "        \"effectiveDate\":\"2018-12-05 10:23:35 649\",\n" +
                "        \"iccid\":\"898606XXXXX539521929\",\n" +
                "        \"resultCode\":\"0000\",\n" +
                "         \"resultDesc\":\"接受成功\",\n" +
                "        \"timestamp\":\"2018-12-05 10:23:37 649\",\n" +
                "        \"version\":\"1.0\"\n" +
                "    }\n" +
                "}";
        System.out.println(rspStr);
        JSONObject jsonObject = JSONObject.fromObject(rspStr);
        //String status = jsonObject.getString("status");
        JSONObject data = jsonObject.getJSONObject("data");
        String messageId2 = data.getString("messageId");
        String resultCode = data.getString("resultCode");

    }

    @Test
    public void test70() {
        String rspIotbody = "{\n" +
                "        \"UNI_BSS_HEAD\":{\n" +
                "        \"RESP_DESC\":\"Success\",\n" +
                "                \"TRANS_ID\":\"20210121155946270895303\",\n" +
                "                \"TIMESTAMP\":\"2021-01-21 15:59:46 270\",\n" +
                "                \"RESP_CODE\":\"00000\",\n" +
                "                \"APP_ID\":\"VOPMOMujA2\"\n" +
                "    },\n" +
                "        \"UNI_BSS_ATTACHED\":{\n" +
                "        \"MEDIA_INFO\":\"\"\n" +
                "    },\n" +
                "        \"UNI_BSS_BODY\":{\n" +
                "        \"UPLOAD_TERMINAL_RSP\":{\n" +
                "            \"message\":\"OK\",\n" +
                "                    \"status\":\"0\",\n" +
                "                    \"data\":{\n" +
                "                \"messageId\":\"9020012100000467\",\n" +
                "                        \"resultCode\":\"0000\",\n" +
                "                        \"resultDesc\":\"send kafka message success\",\n" +
                "                        \"timestamp\":\"2021-01-21 15:59:49\",\n" +
                "                        \"version\":\"1.0\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "    }";


        if (rspIotbody != null && !"".equals(rspIotbody) && !"null".equals(rspIotbody) && !"{}".equals(rspIotbody)) {
            JSONObject rspIotbodyJsonBody = JSONObject.fromObject(rspIotbody);
            System.out.println(rspIotbodyJsonBody);
        }


    }

    @Test
    public void test71() {
        String reqJson = "{\n" +
                "    \"mvnokey\":\"OJvWpmI\",\n" +
                "    \"serial_number\":\"cOKD31n20148882223311113335492\",\n" +
                "    \"timestamp\": \"2021-01-21 10:19:37\",\n" +
                "    \"service_type\":\"group_model_product\",\n" +
                "\t\"service_name\":\"business_order\",\n" +
                "\t\"api_name\":\"cu.vop.group_model_product.business_order\",\n" +
                "    \"data\": {\n" +
                "            \"order_id\":\"cOKD31n481121211224333294454229200\",\n" +
                "            \"order_type\":\"0\",\n" +
                "            \"order_mproducts\":[\n" +
                "\t\t\t{\n" +
                "\t\t\t\"mproduct_id\":\"PR_0008\",\n" +
                "\t\t\t\"action_type\":\"order\",\n" +
                "\t\t\t\"order_packages\":[\n" +
                "\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\"package_id\":\"PK_0105\",\n" +
                "\t\t\t\t\t\t\"order_discnts\":[\n" +
                "\t   \t\t\t\t\t\t{\n" +
                "\t\t\t\t\t\t\t\t\"discnt_id\":\"PE_0291\",\n" +
                "\t\t\t\t\t\t\t\t\"action_type\":\"order\",\n" +
                "                                \"effective_mode\":\"1\",\n" +
                "                                \"rent_type\":\"2\"\n" +
                "            \t\t\t\t}\n" +
                "           \t\t\t\t\t\n" +
                "\t\t\t\t\t\t\t]\t\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t\t\n" +
                "\t\t\t\t\t]\n" +
                "\t\t\t}\n" +
                "\t\t  ]\n" +
                "        }\n" +
                "}\n";

        JSONObject jsonObj = JSONObject.fromObject(reqJson);
        String mvnoKey = jsonObj.getString("mvnokey");
        String serialNumber = jsonObj.getString("serial_number");
        String apiName = jsonObj.getString("api_name");
        String timestamp = jsonObj.getString("timestamp");
        String service_type = jsonObj.getString("service_type");
        String service_name = jsonObj.getString("service_name");
        JSONObject jsonData = jsonObj.getJSONObject("data");
        //  add 20191206  start  获取报文中的34位订单编号
        String orderId = jsonData.getString("order_id"); // 34位
        JSONArray order_mproducts = jsonData.getJSONArray("order_mproducts");
        ArrayList<String> prodPackageIdList = new ArrayList<String>();

        for (int i = 0; i < order_mproducts.size(); i++) {
            JSONObject jsonObject = order_mproducts.getJSONObject(i);
            //获取报文中pk ， 根据pk产品包 判断用户的 权限 ，然后做业务权限校验
            JSONArray orderPackagesArray = jsonObject.getJSONArray("order_packages");
            for (int j = 0; j < orderPackagesArray.size(); j++) {
                JSONObject packageObject = orderPackagesArray.getJSONObject(j);
                System.out.println("=packageObject==" + packageObject);
                String packageId = packageObject.getString("package_id");
                System.out.println("=packageId==" + packageId);

                prodPackageIdList.add(packageId);
            }
        }
        System.out.println(prodPackageIdList.toString());
    }

    @Test
    public void test72() {
        String status = "true";
        String resultMark = "success";
        String jsonRspStr = "";
        if ("true".equals(status) || "false".equals(status)) {
            jsonRspStr += "{\"data\":{\"status\":" + status;
        } else {
            jsonRspStr += "{\"error\":{\"status\":\"" + status + "\"";
        }
        if (resultMark != null && resultMark != "") {
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        } else {// 保证字段存在，不存在则返回系统内部错误
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        }
        jsonRspStr += "}}";
        System.out.println(jsonRspStr);
    }

    @Test
    public void test73() {
        String str = "ZE_0002";
        if (str.indexOf("ZE") > -1) {
            System.out.println("存在");
        } else {
            System.out.println("不存在");

        }
    }


    @Test
    public void test74() {
        String reqJson = "{\n" +
                "    \"api_name\":\"cu.vop.basic_service.push_result\",\n" +
                "    \"timestamp\":\"2021-02-22 10:29:00\",\n" +
                "    \"data\":{\n" +
                "        \"serial_number\":\"OJv11mI20183333677777222212441\",\n" +
                "        \"order_id\":\"OJv11mI201833336777772222124410000\",\n" +
                "        \"status\":true,\n" +
                "        \"message\":\"ok\"\n" +
                "    }\n" +
                "}";
        System.out.println(reqJson);
        JSONObject jsonObj = JSONObject.fromObject(reqJson);
        System.err.println(jsonObj.toString());
        String apiName = jsonObj.getString("api_name");
        String timestamp = jsonObj.getString("timestamp");
        JSONObject data = jsonObj.getJSONObject("data");
        String serialNumber = data.getString("serial_number");
        String orderId = data.getString("order_id");
        String message = data.getString("message");
        String status = data.getString("status");
        System.out.println(apiName);
        System.out.println(timestamp);
        System.out.println(serialNumber);
        System.out.println(orderId);
        System.out.println(message);
        System.out.println(status);


    }

    @Test
    public void test247() {
        String status = "true";
        String resultMark = "sss";
        String jsonRspStr = "";
        if ("true".equals(status) || "false".equals(status)) {
            jsonRspStr += "{\"data\":{\"status\":\"" + status + "\"";
        } else {
            jsonRspStr += "{\"error\":{\"status\":\"" + status + "\"";
        }
        if (resultMark != null && resultMark != "") {
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        } else {// 保证字段存在，不存在则返回系统内部错误
            jsonRspStr += ",\"message\":\"" + resultMark + "\"";
        }
        jsonRspStr += "}}";
        System.out.println(jsonRspStr);
    }

    @Test
    public void test248() {
        String rspJson = "{\n" +
                "    \"UNI_BSS_HEAD\":{\n" +
                "        \"RESP_DESC\":\"成功！\",\n" +
                "        \"TRANS_ID\":\"20210222171007559695370\",\n" +
                "        \"TIMESTAMP\":\"2021-02-22 17:10:07 559\",\n" +
                "        \"RESP_CODE\":\"00000\",\n" +
                "        \"APP_ID\":\"VOPMOMujA2\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\":{\n" +
                "        \"RESULT_CALL_BACK_RSP\":{\n" +
                "            \"data\":{\n" +
                "                \"status\":\"0000\",\n" +
                "                \"message\":\"success\"\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";
        System.out.println(rspJson);
    }

    @Test
    public void test249() {


        Long svcNumber = 0L;
        String serviceName = "**************serviceName************";
        String operateName = "**************operateName************";
        String mark = "**************mark************";
        Timestamp lanchTime = new Timestamp(new Date().getTime());
        String medtaInfo = "**************medtaInfo************";
        Date processingTime = new Date();
        String actionType = "**************actionType************";
        String provCode = "**************provCode************";
        String sendFlag = "**************sendFlag************";
        String serviceId = "**************serviceId************";
        String productId = "**************productId************";
        String serialNumber = "**************serialNumber************";
        //
        StringBuffer sowmisMessage = new StringBuffer(1024);
        sowmisMessage.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sowmisMessage.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" ");
        sowmisMessage.append(" xmlns:unib=\"http://ws.chinaunicom.cn/VOPForLtmsSer/unibssBody\" ");
        sowmisMessage.append(" xmlns:unib1=\"http://ws.chinaunicom.cn/unibssHead\" ");
        sowmisMessage.append(" xmlns:tran=\"http://ws.chinaunicom.cn/VOPForLtmsSer/unibssBody/transLtmsProReq\" ");
        sowmisMessage.append(" xmlns:unib2=\"http://ws.chinaunicom.cn/unibssAttached\">");
        sowmisMessage.append("    <soapenv:Header/>");
        sowmisMessage.append("    <soapenv:Body>");
        sowmisMessage.append("        <unib:TRANS_LTMS_PRO_INPUT> ");
        sowmisMessage.append("            <unib1:UNI_BSS_HEAD> ");
        sowmisMessage.append("                <unib1:ORIG_DOMAIN>VOPS</unib1:ORIG_DOMAIN> ");
        sowmisMessage.append("                <unib1:SERVICE_NAME>").append(serviceName).append("</unib1:SERVICE_NAME> ");
        sowmisMessage.append("                <unib1:OPERATE_NAME>").append(operateName).append("</unib1:OPERATE_NAME> ");
        sowmisMessage.append("                <unib1:ACTION_CODE>0</unib1:ACTION_CODE> ");
        sowmisMessage.append("                <unib1:ACTION_RELATION>0</unib1:ACTION_RELATION> ");
        sowmisMessage.append("                <unib1:ROUTING> ");
        sowmisMessage.append("                    <unib1:ROUTE_TYPE>00</unib1:ROUTE_TYPE> ");
        if ("0".equals(sendFlag)) {//总部接收者
            sowmisMessage.append("                    <unib1:ROUTE_VALUE>D1</unib1:ROUTE_VALUE> ");
        } else {
            sowmisMessage.append("                    <unib1:ROUTE_VALUE>A2</unib1:ROUTE_VALUE> ");
        }
        sowmisMessage.append("                </unib1:ROUTING> ");
        sowmisMessage.append("                <unib1:PROC_ID>").append(serialNumber).append("</unib1:PROC_ID> ");
//		sowmisMessage.append("                <unib1:TRANS_IDO>").append("VOP"+new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(processingTime).toString()+svcNumber.toString()+"SM").append("</unib1:TRANS_IDO> "); 换成以毫秒来区别唯一
        sowmisMessage.append("                <unib1:TRANS_IDO>").append("VOP" + new java.text.SimpleDateFormat("MMddHHmmssSSSS").format(processingTime).toString() + svcNumber.toString() + "SM").append("</unib1:TRANS_IDO> ");
        sowmisMessage.append("                <unib1:PROCESS_TIME>").append(new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(processingTime)).append("</unib1:PROCESS_TIME> ");
        sowmisMessage.append("                <unib1:SP_RESERVE> ");
        sowmisMessage.append("                    <unib1:TRANS_IDC>201401141149565235384809707013</unib1:TRANS_IDC> ");
        sowmisMessage.append("                    <unib1:CUTOFFDAY>20140114</unib1:CUTOFFDAY> ");
        sowmisMessage.append("                    <unib1:OSNDUNS>9600</unib1:OSNDUNS> ");
        sowmisMessage.append("                    <unib1:HSNDUNS>xxxx</unib1:HSNDUNS> ");
        sowmisMessage.append("                    <unib1:CONV_ID>20110322202800100</unib1:CONV_ID> ");
        sowmisMessage.append("                </unib1:SP_RESERVE> ");
        sowmisMessage.append("                <unib1:TEST_FLAG>0</unib1:TEST_FLAG> ");
        sowmisMessage.append("                <unib1:MSG_SENDER>9600</unib1:MSG_SENDER> ");
        sowmisMessage.append("                <unib1:MSG_RECEIVER>9100</unib1:MSG_RECEIVER> ");
        sowmisMessage.append("            </unib1:UNI_BSS_HEAD> ");
        sowmisMessage.append("            <unib:UNI_BSS_BODY> ");
        sowmisMessage.append("                <tran:TRANS_LTMS_PRO_REQ> ");
        sowmisMessage.append("                    <tran:PHONE_NUMBER>").append(svcNumber).append("</tran:PHONE_NUMBER> ");

        if ("order".equals(actionType)) {
            sowmisMessage.append("                    <tran:START_DATE>")
                    .append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lanchTime))
                    .append("</tran:START_DATE> ");
        } else {
            sowmisMessage.append("                    <tran:CANCEL_DATE>")
                    .append(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lanchTime))
                    .append("</tran:CANCEL_DATE> ");
        }
        if ("LD002".equals(productId)) {
            sowmisMessage.append("                    <tran:FEE_RATE>3</tran:FEE_RATE> ");
        } else {
            sowmisMessage.append("                    <tran:FEE_RATE>1</tran:FEE_RATE> ");
        }

        if ("order".equals(actionType)) {
            sowmisMessage.append("                    <tran:STATUS>0</tran:STATUS> ");
        } else {
            sowmisMessage.append("                    <tran:STATUS>1</tran:STATUS> ");
        }
        sowmisMessage.append("                    <tran:VOP_NAME>").append(mark).append("</tran:VOP_NAME> ");
        sowmisMessage.append("                    <tran:NUMBER_HOME>").append(provCode).append("</tran:NUMBER_HOME> ");
        sowmisMessage.append("                    <tran:PARA>");//新增节点
        sowmisMessage.append("                    <tran:PARA_ID>SERVICE_ID</tran:PARA_ID> ");//新增业务编码
        sowmisMessage.append("                    <tran:PARA_VALUE>").append(serviceId).append("</tran:PARA_VALUE> ");//新增业务编码
        sowmisMessage.append("                    </tran:PARA>");//新增节点
        sowmisMessage.append("                    <tran:PARA>");//新增节点
        sowmisMessage.append("                    <tran:PARA_ID>PRODUCT_ID</tran:PARA_ID> ");//新增产品编码
        sowmisMessage.append("                    <tran:PARA_VALUE>").append(productId).append("</tran:PARA_VALUE> ");//新增产品编码
        sowmisMessage.append("                    </tran:PARA>");//新增节点
        sowmisMessage.append("                </tran:TRANS_LTMS_PRO_REQ> ");
        sowmisMessage.append("            </unib:UNI_BSS_BODY> ");
        sowmisMessage.append("            <unib2:UNI_BSS_ATTACHED> ");
        sowmisMessage.append("                <unib2:MEDIA_INFO/> ");
        sowmisMessage.append("            </unib2:UNI_BSS_ATTACHED> ");
        sowmisMessage.append("        </unib:TRANS_LTMS_PRO_INPUT> ");
        sowmisMessage.append("    </soapenv:Body> ");
        sowmisMessage.append("</soapenv:Envelope> ");

        System.out.println(sowmisMessage.toString());

    }



    @Test
    public void test250(){
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("user.dir"));
    }

    @Test
    public void test251(){
        StringBuffer sql = new StringBuffer("select s.service_inst,pe.pkg_element_id from dbvop.pkg_element pe");
        sql.append(" left join dbvop.pkg_element ppe on ppe.prod_package_id=pe.prod_package_id and ppe.pkg_element_type=0");
        sql.append(" left join dbvop.service s on s.service_id=ppe.pkg_element_id");
        sql.append(" where pe.pkg_element_id in (SELECT code_mark FROM DBVOP.D_CODE_MAP WHERE CODE_CATG='IS_LSMS_TYPE')");
        sql.append(" order by s.service_inst desc");
        System.out.println(sql.toString());
    }
    @Test
    public void test252(){
         String[] ldCodes = new String[]{"LTMSJR","LTMSSJ","GJDXJR","SJMPJR"};

        String join = StringUtils.join(ldCodes, ",");
        System.out.println(join);
    }


    @Test
    public void test253(){
        StringBuffer apiQrySql = new StringBuffer("select * from (SELECT dpm.mvno_user_type,dpm.mvno_user_id,dpm.svc_number,dpm.order_time,dpm.unsub_time,dpm.service_inst_status,dpm.mvno_business_mark,dpm.eparchy_code,dpm.discnt_id" );
        apiQrySql.append(" ,ROW_NUMBER() OVER(PARTITION BY dpm.svc_number,decode(dpm.mvno_user_type,'2',dpm.mvno_user_id,0) ORDER BY dpm.order_time desc) AS RN FROM (");
        apiQrySql.append(" select decode(lut.mvno_user_type,'2','2','1') mvno_user_type,mu.mvno_user_id,mu.svc_number,to_char(sis.order_time, 'yyyymmddhh24miss')as order_time,nvl(to_char(sis.unsub_time, 'yyyymmddhh24miss'),'20000101000000')as unsub_time, "
                + "decode(sis.service_inst_status,'1','0','1') service_inst_status,mu.mvno_business_mark,mu.eparchy_code,ds.discnt_id " );
        apiQrySql.append(" from dbvop.service_inst_subscribe sis,dbvop.mvno_user mu " );
        apiQrySql.append(" left join  dbvop.prod_subscribe ps on ps.mvno_user_id=mu.mvno_user_id and ps.MVNO_BUSINESS_MARK=? and ps.order_time<=? and (ps.unsub_time >= ? or ps.unsub_time is null)");
        apiQrySql.append(" left join  dbvop.discnt_subscribe ds on ds.prod_subscribe_id= ps.prod_subscribe_id and ds.MVNO_BUSINESS_MARK=? and ds.discnt_id in (?)");
        apiQrySql.append(" left join dbvop.life_user_type lut on lut.mvno_user_id=mu.mvno_user_id and lut.mvno_mark=? and to_char(lut.begin_time,'yyyymm')<=? and to_char(lut.end_time,'yyyymm')>=?");
        apiQrySql.append(" where sis.MVNO_BUSINESS_MARK=? and mu.MVNO_BUSINESS_MARK=? and  sis.mvno_user_id=mu.mvno_user_id and sis.order_time <=? and (sis.unsub_time >= ? or sis.unsub_time is null) ");
        apiQrySql.append(" and sis.service_inst=? ) dpm ) d where d.RN=1");
        System.out.println(apiQrySql);
    }
}

