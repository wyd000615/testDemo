package en;

import com.n3.ecs.open.util.HMACUtil;
import com.n3.ecs.open.util.SignUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ShaDemo {

    @Test
    public void Shatest(){
/*
        Map<String,Object> reqJsonMap = new HashMap<String,Object>();
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        //String time = df.format(orderDate);//
        reqJsonMap.put("time", "20200622114754");
        reqJsonMap.put("appId", appid);
        reqJsonMap.put("serviceCode", serviceCode);

        Map<String,Object> buffer = new HashMap<String,Object>();
        buffer.put("orderId", orderId);
        buffer.put("serviceNo", "");
        buffer.put("accountInfo", accountInfo);
        buffer.put("goodsCode", productId);
        buffer.put("reqOrderTime",time);
        //buffer.put("activityNo",""); //活动编码，此项不填
        //buffer.put("activityName","");//活动名称，此项不填
        buffer.put("purchaserNo", "DXCHSP01");
        reqJsonMap.put("params", SignUtil.encrypt(JSON.toJSONString(buffer),encryption));//进行加密


        String paramStr = "";
        String[] keyArray = (String[]) reqJsonMap.keySet().toArray(new String[]{});
        Arrays.sort(keyArray);
        for (int i = 0; i < keyArray.length; i++) {
            paramStr += keyArray[i] + "=" + reqJsonMap.get(keyArray[i]).toString() + "&";
        }
        paramStr = paramStr.substring(0, paramStr.length() - 1);
        String signStr = null;
        logger.info("==定向流量发往视频平台的报文===phoneNumber==="+phoneNumber+"===paramStr加密前报文内容"+paramStr);
        signStr = HMACUtil.encrypt(paramStr, SHAencryption, "utf-8");//加密字段

        reqJsonMap.put("sign", signStr);
        reqJson = JSON.toJSONString(reqJsonMap);
*/

    }
}

