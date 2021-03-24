package java;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Tets {
    @Test
    public void test2() {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("1", null);
        JSONObject json = JSONObject.fromObject(hashMap);
        System.out.println(json.toString());
    }

    @Test
    public void test3() {
        Timestamp timestamp = new Timestamp(11111111);
        System.out.println(timestamp);
    }

    @Test
    public void test4() {
        String str = "{" +
                "    \"data\": {" +
                "        \"status\": \"true\"," +
                "        \"message\": \"success\"" +
                "    }\n" +
                "}";
        System.out.println(str);
    }

    @Test
    public void test5() {
        String str = "1*2";
        str.replace("\\*", "");
        System.out.println(str.replace("\\*", ""));
        System.out.println(str);
    }

    @Test
    public void test6() {
        Random r = new Random(System.currentTimeMillis());

        String dateStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
        double d = r.nextDouble();
        d += 1;
        String str = dateStr + new BigDecimal(d * 1000000000000000L).longValue();
        System.out.println(str);

    }

    /*
    按位运算符有6个
& 按位与
|按位或
^按位异或
~取反
>>右移
<<左移
     */
    @Test
    public void test7() {
        int num =1;
        int num2 =2;
        //&
        int num3 = num & num2;
        System.out.println(num3);

    }
}
