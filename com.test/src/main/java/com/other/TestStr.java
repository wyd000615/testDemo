package com.other;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.collection.Collections2;
import com.date.Student;
import com.date.TimestampUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.*;
import com.util.CompetencePlatformTokenUtil;
import com.util.MD5Util;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.logging.log4j.util.Strings;
import org.junit.Test;
import sun.misc.BASE64Decoder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.zip.GZIPInputStream;

public class TestStr {


    public static void main(String[] args) {
       /* String str ="12123123123123123123";
        String str1 = "{" +
                "    \"service_name\": \"push_information\"," +
                "    \"api_name\": \"cu.vop.extended_service.push_information\"," +
                "    \"timestamp\": \"2020-08-13 10:19:37\"," +
                "    \"service_type\": \"basic_service\"," +
                "    \"serial_number\": \"OJvWpmIe0l0j0000\"," +
                "    \"mvnokey\": \"OJvWpmI\"," +
                "    \"data\": \"HQxXSw7o3HD6qPAZJKR+12mGylUCvwlS3e/fPz1nrJRk7/GeqDbif18O8P0YDH/VJxqLbXY6jnTmlM7kUdRTcgW+vwIYAiwDH++6rQ/pw8IRPxb0WmiHwmriM7aD4fKYsg8LO5gRIHoRREwDQ38pG0asxOZtGRFdUDPDWs+M7fM9lieyllmIlFZy+9wu9hi80B0zWeh+Ji50X7WAzSyewC+kmLXhJ438nQ1HAWB7YoWGi3DYzGjBZrQj/usrxrB4cd0SwRypv575ReX3sWtNgeoAkzo1kDi5NoZzXi5kxkHUIDSOopHqEfcQSoT4YPFJbgK+E0hUo+ZAVz8LWS6eAqhhtvcvqD5jr246dtVRiItGELAs5RdDzZMmGpiohdFrBqbIC3m0s2Zz3Km66Gl/2pNeUW2zLa2LqB6dMBgEVpy2CK26M2OhaYpGEGRmzyN8MJGQeHAEXGFecw4K0tAnnj4sH0f/tIEr+iLCtwU90jPQymcek3+8aT8JMZ8ZY4TmBtGtjcKgdnXQudwImeaoGFczbHhzc//7z880+ThaAoxFV/3G02qpWwFzEU2JpHWex2u0LaXuKRYEtRgHVorjhl5Ji0f/tIBdU8mX2RxOG525AIHeXyHKCzx9+o6Y7GvOUsbOldYlnvXTluWPNtOiUZe3iZZDAA1Q+ViJbBPuL2gqyp1K+IYogNnR70CHvpasI5Oc7OlQyoTviu3ACdT59CJ1EZ8EcWoYdTOHbEEEPdAQMmNX7q4TO5Vco9fGcyBQi6eTBTCvdqzAx+BnXoheSS+SYWGnU/jHjBvm35wnG9uNNsiJz8CAWkArLl8RFiZJIolK5vi0LJhIaS9+SqlAUQ80akZ81BgbzQiBUfYaLd3hTVnie3MNn2KP4sgpbJPVMMFxVwHS5/i/Rfs2tf/RgmvEIsFUOSUHtlZ8LLv9kSI=\"" +
                "}" ;
        System.out.println(str1);*/
        String str = "/sso/login";
        System.out.println(str);
        if (str.contains("sso/login")) {
            System.out.println("a");
        }
        if (str.indexOf("sso/login") != -1) {
            System.out.println("aa");
        }
    }

    public static byte[] base64DecodeAndUnGzip(String str) {
        BASE64Decoder base64decoder = null;
        ByteArrayOutputStream out = null;
        ByteArrayInputStream in = null;
        GZIPInputStream gunzip = null;
        try {
            base64decoder = new BASE64Decoder();
            byte[] b = base64decoder.decodeBuffer(str);
            if (b == null || b.length == 0) {
                return null;
            }
            in = new ByteArrayInputStream(b);
            gunzip = new GZIPInputStream(in);
            out = new ByteArrayOutputStream();

            byte[] buffer = new byte[256];
            int n;
            while ((n = gunzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
        } catch (Exception e) {
            throw new RuntimeException("对报文进行GZIP解压时出错，", e);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
            }
            try {
                if (gunzip != null) {
                    gunzip.close();
                }
            } catch (IOException e) {
            }
        }
        return out.toByteArray();
    }

    static void cnn() {
        System.out.print("CNN ");
    }

    public static String generateRandomNumber(int num) {
        try {
            String random = "";
            for (int i = 0; i < num; i++) {
                int rand = (int) (Math.random() * 10);
                random = random + rand;
            }
            return random;
        } catch (Exception e) {
        }
        return "0";
    }

    public static int certAge(String id) {
        //
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        String cardBirthDay = id.substring(6, 10);
        String nowDay = sdf.format(new Date());
        return Math.abs(Integer.parseInt(nowDay) - Integer.parseInt(cardBirthDay));
    }

    private static String makeRandom() {
        int random = (int) ((Math.random() * 9 + 1) * 1000);
        return String.valueOf(random);
    }

    /**
     * @param firstArrayList  第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 差集ArrayList
     * @方法描述：获取两个ArrayList的差集
     */
    public static List<String> receiveDefectList(List<String> firstArrayList, List<String> secondArrayList) {
        List<String> resultList = new ArrayList<String>();
        LinkedList<String> result = new LinkedList<String>(firstArrayList);// 大集合用linkedlist
        HashSet<String> othHash = new HashSet<String>(secondArrayList);// 小集合用hashset
        Iterator<String> iter = result.iterator();// 采用Iterator迭代器进行数据的操作
        while (iter.hasNext()) {
            if (othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        resultList = new ArrayList<String>(result);
        return resultList;
    }

    /**
     * @param firstArrayList  第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 交集ArrayList
     * @方法描述：获取两个ArrayList的交集
     */
    public static List<String> receiveCollectionList(List<String> firstArrayList, List<String> secondArrayList) {
        List<String> resultList = new ArrayList<String>();
        LinkedList<String> result = new LinkedList<String>(firstArrayList);// 大集合用linkedlist
        HashSet<String> othHash = new HashSet<String>(secondArrayList);// 小集合用hashset
        Iterator<String> iter = result.iterator();// 采用Iterator迭代器进行数据的操作
        while (iter.hasNext()) {
            if (!othHash.contains(iter.next())) {
                iter.remove();
            }
        }
        resultList = new ArrayList<String>(result);
        return resultList;
    }

    /**
     * @param firstArrayList  第一个ArrayList
     * @param secondArrayList 第二个ArrayList
     * @return resultList 去重并集ArrayList
     * @方法描述：获取两个ArrayList的去重并集
     */
    public static List<String> receiveUnionList(List<String> firstArrayList, List<String> secondArrayList) {
        List<String> resultList = new ArrayList<String>();
        Set<String> firstSet = new TreeSet<String>(firstArrayList);
        for (String id : secondArrayList) {
            // 当添加不成功的时候 说明firstSet中已经存在该对象
            firstSet.add(id);
        }
        resultList = new ArrayList<String>(firstSet);
        return resultList;
    }

    @Test
    public void test6() {
        Random r = new Random(System.currentTimeMillis());

        String dateStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
        double d = r.nextDouble();
        System.out.println(d);

        d += 1;
        System.out.println(d);

        String str = dateStr + new BigDecimal(d * 1000000000000000L).longValue();
        System.out.println(dateStr);
        System.out.println(new BigDecimal(d * 1000000000000000L).longValue());

        System.out.println(str);
        int i = new Random().nextInt(999999);
        System.out.println(i);
    }

    @Test
    public void test8() {
        byte[] bytes = base64DecodeAndUnGzip("asdasdasdasd");
        System.out.println(bytes);
    }

    @Test
    public void test9() {
        String busiType = "18";
        switch (busiType) {
            case "17":
                System.out.println("17");
                break;
            case "18":
                System.out.println("18");
                break;
        }
    }

    @Test
    public void test10() {
        String provinceCode = "10";
        String cityCode = "100";
        HashMap<String, String> provinceCityCodeMap = new HashMap<>();
        provinceCityCodeMap.put("100", "11");
        if (!provinceCityCodeMap.containsKey(cityCode) || !provinceCode.equals(provinceCityCodeMap.get(cityCode))) {
            System.out.println("-------");
        }
    }

    @Test
    public void test01() throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engineJs = sem.getEngineByName("javascript");
        String str = "function f() {\n" +
                "    var map = new java.util.HashMap();\n" +
                "    var set = new java.util.HashSet();" +
                "    var setIter = \n" +
                "return map.containsKey(\"a\")?\"包含0017\":\"不包含\";\n" +
                "}";
        engineJs.eval(str);
        // 使用 engine 的父接口，可执行的
        Invocable inv = (Invocable) engineJs;
        Object object = inv.invokeFunction("f");
        System.out.println(object);
    }

    @Test
    public void test02() throws Exception {
        ScriptEngineManager sem = new ScriptEngineManager();
        ScriptEngine engineJs = sem.getEngineByName("javascript");
        String str = "function f(){\n" +
                "var str=\"{\\\"error\\\":{\\\"status\\\":\\\"S-AF-007\\\",\\\"message\\\":\\\"转售企业时间戳timestamp：2020-10-20 12:19:37与VOPS时间:2020-10-30 16:23:50相差误差过大\\\"}}\";\n" +
                "return str;\n" +
                "}\n";
        engineJs.eval(str);
        // 使用 engine 的父接口，可执行的
        Invocable inv = (Invocable) engineJs;
        Object object = inv.invokeFunction("f");
        System.out.println(object);
    }

    @Test
    public void test03() throws Exception {
        int str = Integer.MAX_VALUE;
        System.out.println(str);
    }

    @Test
    public void minCut() {
        String s = "abb";
        int n = s.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(g[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            //System.out.println("====i=="+i);
            for (int j = i + 1; j < n; ++j) {
                // System.out.println("====j=="+j);

                g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
                //System.err.println("=== s.charAt(i)==="+s.charAt(i)+"== s.charAt(j) =="+ s.charAt(j) +"=g[i + 1][j - 1]="+ g[i + 1][j - 1]);

                //System.out.println("=== g[i][j]==="+i+"===="+j+"=="+ g[i][j]);
            }
        }

        int[] f = new int[n];
        Arrays.fill(f, Integer.MAX_VALUE);
        for (int i = 0; i < n; ++i) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; ++j) {
                    if (g[j + 1][i]) {
                        System.out.println("==f[i]==" + f[i] + "===" + f[j] + 1);

                        f[i] = Math.min(f[i], f[j] + 1);
                        System.out.println("==f[i]==" + f[i]);
                    }
                }
            }
        }
        System.out.println(f[n - 1]);
        //return f[n - 1];
    }

    @Test
    public void test04() {

        for (int i = 0; i < 10; ++i) {
            System.out.println(i);
        }
    }

    @Test
    public void test05() {
        int i = 10;
        //i++;
        ++i;
        System.out.println(i);

    }

    /*   public void test60(int i) {
           System.out.println("1");
       }*/
    public void test60(long i) {
        System.out.println("12");
    }

    public void test60(Integer i) {
        System.out.println("2");
    }

    public void test60(Long i) {
        System.out.println("132");
    }

    @Test
    public void test06() {
        test60(1);
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
        int num = 1;
        int num2 = 2;
        //&
        int num3 = num2 & num;
        System.out.println(num3);
        System.out.println(num2 >> 1);
        System.out.println(num2 << 1);
        System.out.println(num2 << 2);


    }

    @Test
    public void Test8() {

        String Str = new String("www.runoob.com");
        System.out.println("字符串的哈希码为 :" + Str.hashCode());
    }

    @Test
    public void Test9() {

        System.out.println(2 << 1);
        //10000
    }

    @Test
    public void Test10() {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        System.out.println(objectObjectHashMap.get("asdas"));
        //10000
    }

    /**
     * 正则表达式
     */
    @Test
    public void RegexExample() {
        String content = "I am noob " + "from runoob.com.";
        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    public Integer method(int i) {

        try {
            if (i++ > 0)
                throw new IOException();
            return i++;
        } catch (IOException e) {
            i++;
            return i++;
        } catch (Exception e) {
            i++;
            return i++;
        } finally {
            return i++;
        }
    }

    @Test
    public void RegexExample1() {
        System.out.println(method(0));
        String s = new String(new char[]{'没', '人', '比', '我', '更', '懂', 'j', 'a', 'v', 'a'});
        String si = "没人比我更懂java";
        System.out.println(s == si);
        System.out.println(s.intern() == "没人比我更懂java");
        System.out.println(s == si.intern());
        char[] chars = "没人比我更懂".toCharArray();
        System.out.println(chars.length);
        //一棵二叉树后序遍历的节点顺序是: 6  4  5  2   7    3     1 ，中序遍历是: 6 4  2  5    1     3 7 ，则前序遍历结果为:
 /*           1
       2             3
     4    5                 7
    6

         1 2 4 6 5 37*/
    }

    @Test
    public void RegexExample2() {
        Thread t = new Thread() {
            @Override
            public void run() {
                cnn();
            }
        };
        t.run();
        System.out.print("FakeNews ");
        System.out.print("; ");
        t.start();
        System.out.print("FakeNews ");
    }

    @Test
    public void RegexExample3() {
        String str = " businessStatus";
        System.out.println(str);
        System.out.println("我是分之test21");
        System.out.println("我是分之test21-statch");
    }

    public void init() {
        System.out.println("init");
    }

    @Test
    public void yersy1() {
        System.out.println("213123");
        String s = dealAddress("123北京市4444大祭司啊99999.....");
        System.out.println(s);
        List<String> list = new ArrayList<>();
  /*      list.add("1");
        list.add("2");

        list.add("3");
        list.add("1");*/
        list.add("");
        list.add("1");

        String difference = isDifference(list);
        System.out.println(difference);
    }

    public String dealAddress(String adress) {
        String result = adress.replaceAll("\\d+", "").replaceAll("[a-zA-Z]", "");

        return result;
    }

    private String isDifference(List<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            String s = strings.get(i);
            System.out.println("====s====" + s);
            for (int j = i + 1; j < strings.size(); j++) {
                System.err.println("===j===" + strings.get(j));
                if (s == null || s.equals(strings.get(j))) {
                    return "0";
                }
            }
        }

        return "1";
    }

    @Test
    public void yersy2() throws Exception {
        CaptchaCodeUtils c = new CaptchaCodeUtils();
        BufferedImage image = c.getImage();
        System.out.println(image);
        String text = c.getText();
        System.out.println(text);
        CaptchaCodeUtils instance = CaptchaCodeUtils.getInstance();
        CaptchaCodeUtils.CaptchaCode code = instance.getCode();
        System.out.println(code.getText());
        System.out.println(code.getData().toString());

    }

    @Test
    public void yersy23() throws Exception {
        double d = 1619256532603.903076;

    }

    @Test
    public void yersy24() throws Exception {
        int round = (int) (Math.random() * 100);
        System.out.println(round);

    }

    //快排
    private void QKSourt(int[] a, int start, int end) {
        if (a.length < 0) {
            return;
        }
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int temp = a[left];
        while (left < right) {
            while (left < right && a[right] >= temp) {
                right--;
            }
            a[left] = a[right];
            while (left < right && a[left] <= temp) {
                left++;
            }
            a[right] = a[left];
        }
        a[left] = temp;
        // System.out.println(Arrays.toString(a));
        QKSourt(a, start, left - 1);
        QKSourt(a, left + 1, end);
    }

    @Test
    public void yersy25() {
        int[] a = {1, 6, 8, 7, 3, 5, 16, 4, 8, 36, 13, 44};
        QKSourt(a, 0, a.length - 1);
        for (int i : a) {
            System.err.print(i + " ");
        }

        List<Integer> numTransderList = Arrays.stream(a).boxed().collect(Collectors.toList());
        System.out.println(numTransderList.toString());

        numTransderList = numTransderList.stream().skip(1).limit(numTransderList.size() - 2).collect(Collectors.toList());

        System.out.println(numTransderList.toString());

    }

    @Test
    public void yersy26() {
        String str = "我是${1},今天是个${2},太好了";
        StringBuffer whereValues = new StringBuffer("");
        whereValues.append(String.valueOf("wyd" + ","));
        whereValues.append(String.valueOf("好天气" + ","));
        String s = Parser.parse0(str, whereValues.toString().split(","));
        System.out.println(s);

        String message = "【由渠道中心统一风控平台发送】2021-04-29 ${1}点~${2}点 【${3}】【${4}】调用总量${5}条，环比增幅超过200%（近30日环比${6}条、近20日环比${7}条、近10日环比${8}条，近5日环比${9}条），请关注！ ";

    }

    public String changeJsonToArguments(JSONObject argument) {
        Set<String> keys = argument.keySet();
        for (String key : keys) {
            String value = argument.getString(key);
            argument.put(key, urlEncoderText(value));
        }
        String one = argument.toString();
        String two = "?" + one.substring(1, one.length() - 1).replace(",", "&").replace(":", "=").replace("\"", "");
        return two;
    }

    public String urlEncoderText(String text) {
        String result = "";
        try {
            result = java.net.URLEncoder.encode(text, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void yersy27() throws UnsupportedEncodingException {
        String alarmMessage =
                "【由渠道中心统一风控平台发送】2021-05-12 20:50:00~2021-05-12 21:00:00 【  】【PloyEventIdQD003】调用总量5条，环比增幅超过0%（近30日环比8条、>近20日环比8条、近10日环比7条，近5日环比8条），请关注！";
        //String s = URLDecoder.decode(alarmMessage, "UTF-8");
        JSONObject input = new JSONObject();
        ///input.put("message",  "【由渠道中心统一风控平台发送】2021-05-12 20:50:00~2021-05-12 21:00:00 【  】【PloyEventIdQD003】调用总量5条，环比增幅超过0%（近30日环比8条、>近20日环比8条、近10日环比7条，近5日环比8条），请关注！");
        input.put("teams", "testWYD");
        input.put("message", "fk");
        // input.put("tems2", s);

        String ss = changeJsonToArguments(input);
        System.out.println(ss);
    }

    public void test28(final String i) {
        System.out.println(i);
    }

    @Test
    public void yersy29() {
        test28("w");
        test28("z");
    }

    @Test
    public void yersy30() {
        long aimValue = 100;
        long alarmThreshold = 1;
        long referenceValue_Day5 = 0;
        long referenceValue_Day10 = 0;
        long referenceValue_Day20 = 0;
        long referenceValue_Day30 = 0;
      /*  Boolean  isAlarm = ((aimValue > alarmThreshold * (referenceValue_Day5 + referenceValue_Day10 + referenceValue_Day20))
                || (aimValue > alarmThreshold * (referenceValue_Day5 + referenceValue_Day10 + referenceValue_Day30))
                || (aimValue > alarmThreshold * (referenceValue_Day10 + referenceValue_Day20 + referenceValue_Day30))
                || (aimValue > alarmThreshold * (referenceValue_Day5 + referenceValue_Day20 + referenceValue_Day30)));*/
        Boolean isAlarm = (false
                || false || true

        );
        System.out.println(isAlarm);
    }

    @Test
    public void yersy31() {
   /*     Map<String, Double> map =new HashMap<>();
        map.put("key", (double) 168);
        String  str = String.valueOf(map.get("key"));
        Double i = Double.valueOf(str);
        System.out.println(str);
        System.out.println(i);*/
        Map<String, Double> map = new HashMap<>();
        map.put("num", (double) 168);
        String key = String.valueOf(map.get("key"));
        int i = !"NaN".equals(String.valueOf(map.get("num"))) ? (int) Double.parseDouble(String.valueOf(map.get("num"))) : 0;
        System.out.println(key);
        System.out.println(i);
    }

    @Test
    public void yersy32() {
        JSONObject json = new JSONObject();
        JSONObject finalResult = new JSONObject();
        finalResult.put("feedbackCode", "0000");//todo 待确认
        finalResult.put("riskGrade", 0);//todo 待确认
        finalResult.put("feedbackName", "");//todo 待确认
        JSONArray ruleSets = new JSONArray();
        json.put("finalResult", finalResult);
        json.put("ployName", "ployName");
        json.put("ployEventId", "ployEventId");
        json.put("success", true);
        json.put("ruleSets", ruleSets);

        System.out.println(json.toString());
    }

    @Test
    public void yersy33() {
        String str = "{\"busId\":\"0000\",\"eventId\":\"PloyEventIdDD001\",\"branchId\":\"0000\",\"sessionNbr\":\"orderAPPID12372646513301621325028761\",\"agencyId\":\"superfriday\",\"eventType\":\"LOGIN\",\"eventStartDate\":1621325028740,\"sceneCode\":\"00\",\"orderNo\":\"3412243452\",\"channelContact\":\"08-79249850132\",\"isKOLOrder\":\"1\",\"userIp\":\"\",\"certType\":\"01\",\"certNo\":\"130623199866015509\",\"certNoHkey\":\"509130623199866015\",\"certName\":\"小小\",\"age\":\"17\",\"certProvinceName\":\"天津\",\"svcNumber\":\"155109655998\",\"postProvinceCode\":\"\",\"postProvinceName\":\"\",\"postCityCode\":\"\",\"postCityName\":\"\",\"postCityName01\":\"\",\"postDistrictCode\":\"\",\"postDistrictName\":\"\",\"postAddr\":\"\",\"postAddrCh\":\"\",\"provinceCode\":\"19\",\"provinceName\":\"山西\",\"cityCode\":\"200\",\"cityName\":\"吕梁\",\"developProvinceCode\":\"11\",\"developProvinceName\":\"北京\",\"isFourDifference\":\"0\",\"isKOLallopatryOrder\":\"0\",\"isAllopatryCOrder\":\"0\",\"isAllopatryPOrder\":\"0\",\"allopatryOrderNum01\":9,\"allopatryOrderNum02\":9,\"allopatryOrderNum03\":9,\"thrSameOrderNum\":0,\"allopatryNum\":0,\"OrderNum\":0}";
        JSONObject json = JSONObject.parseObject(str);
        System.out.println(json.toString());
    }

    @Test
    public void yersy34() {
        JSONObject json = new JSONObject();
        System.out.println(json.get("222"));
    }

    @Test
    public void yersy35() throws ParseException {
        String date = "2021-05-19 19:02:46.0";
        //1621422166594
        Date date1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date);

        System.out.println(date1.getTime());
        String date2 = "2021-05-19 19:16:49.004";
        // Fri Dec 04 23:09:01 CST 2020
        Date date12 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(date);

        System.out.println(date12.getTime());
        ///
        //1621422942645
        //1621422166594
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:scs.SSS").format(new Date(1621423059325L)));


    }

    @Test
    public void yersy36() {
        String userIp = "127.0.0.1";
        String newIp = userIp.length() <= 1 ? userIp :
                userIp.substring(userIp.length() - 1) + "" + userIp.substring(0, userIp.length() - 1);
        System.out.println(newIp);
    }

    @Test
    public void yersy37() {
        String str = "{\"success\":true,\"ruleSets\":[{\"setName\":\"游戏平台风控事件规则集\",\"proposal\":{\"feedbackCode\":\"1\",\"feedbackState\":\"\",\"riskGrade\":0,\"feedbackName\":\"建议通过\"},\"ruleSetWeight\":\"0\",\"hitRules\":[],\"setCode\":\"COL_SetCodeYX001\",\"setDescription\":\"游戏平台风控事件规则集\"}],\"ployName\":\"游戏平台风控事件\",\"ployEventId\":\"PloyEventIdCJ004\",\"finalResult\":{\"feedbackCode\":\"1\",\"riskGrade\":\"0\",\"feedbackName\":\"建议通过\"}}";
        JSONObject json = (JSONObject) JSONObject.parse(str);
        System.out.println(json);
    }

    @Test
    public void yersy328() {
        String str = "verificationCode";
        int respValue = 0;
        try {
            respValue = Integer.parseInt(str);
        } catch (Exception e) {
            //log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        System.out.println(respValue);
    }

    @Test
    public void yersy329() {
        int i = 0;
        try {
            i = 9 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // return;
        }
        System.out.println(i);
    }

    public void testTry() {
        try {
            int i = 9 / 0;
        } catch (Exception e) {
            return;
        }

    }

    @Test
    public void testTry2() {
        String str = "12";
        testTry3(str);
        System.out.println(str);
    }

    public void testTry3(String str) {
        str = "22" + str;
        //System.out.println(str);
    }

    @Test
    public void testTry4() {

        String str = (int) (Math.random() * 9) * 10 + "-" + (int) ((Math.random() * 9 + 1) * 100000);
        System.out.println(str);
    }

    @Test
    public void testTry5() {
        String str = null;
        System.out.println(StringUtils.isBlank(str));
    }

    @Test
    public void testTry6() {
        Student stu = new Student();
        stu.setName("JSON");
        stu.setAge("23");
        stu.setAddress("北京市西城区");
        System.out.println(stu.toString());

        Object info = JSONObject.toJSON(stu);
        System.out.println(String.valueOf(info));

       /* net.sf.json.JSONObject userInfoJson= net.sf.json.JSONObject.fromObject(stu.toString());
        Student rzLoginInfo=(Student) net.sf.json.JSONObject.toBean(userInfoJson, Student.class);
        System.out.println(rzLoginInfo);*/

        net.sf.json.JSONObject userInfoJson = net.sf.json.JSONObject.fromObject(info);
        Student rzLoginInfo = (Student) net.sf.json.JSONObject.toBean(userInfoJson, Student.class);
        System.out.println(rzLoginInfo.getAddress());
    }

    @Test
    public void testTry7() {
        Student stu = new Student();
        stu.setName("JSON");
        stu.setAge("23");
        stu.setAddress("北京市西城区");
        //Object parse = JSONObject.toBean(stu);
    }

    //获取list中的值的次数
    @Test
    public void testTry8() {
        List list = new ArrayList();
        list.add("a");
        list.add("a");
        list.add("a");
        int occurrences = Collections.frequency(list, "a");
        System.out.println(occurrences);
        //
        String str = "1,2,3,4,3,2,1,1,2,";
        //str=str.substring(0,str.length()-1);
        String[] strs = str.substring(0, str.length() - 1).substring(0, str.length() - 1).split(",");
        System.out.println(str);
        List<String> strings = Arrays.asList(strs);
        System.out.println(strings);
        int occurrences2 = Collections.frequency(strings, "1");
        System.out.println(occurrences2);

    }

    @Test
    public void testTry9() {
        int i = 8;
        int j = 10;
        int d = (i * 100 / j);
        if ((i * 100 / j) > 30) {
            System.out.println(d);

        }
    }

    @Test
    public void testTry120() {
        String loginTimeTarget = "1619884807.360005";
        String[] split = loginTimeTarget.split("\\.");
        System.out.println(split.length);
        String loginTimeTargetVaild = loginTimeTarget.split("\\.")[0];
        if (loginTimeTargetVaild.length() != 13) {
            loginTimeTargetVaild = loginTimeTargetVaild + "000";
        }
        System.out.println(loginTimeTargetVaild);
        loginTimeTargetVaild = loginTimeTargetVaild.substring(0, 12);
    }

    @Test
    public void testTry121() {
        String s = callInterface();
        System.out.println(s);
    }

    //返回报文
    public String callInterface() {
        net.sf.json.JSONObject jsonObjectResultReq = new net.sf.json.JSONObject();
        net.sf.json.JSONObject noticeObject = new net.sf.json.JSONObject();
        net.sf.json.JSONObject uniObject = new net.sf.json.JSONObject();
        try {
            jsonObjectResultReq.put("IP", "1111111");//问题IP （IP/userIp）
            jsonObjectResultReq.put("IMEI", "22222222222");//问题终端IMEI
            jsonObjectResultReq.put("APPID", "22222222222");//问题APPID
            jsonObjectResultReq.put("ICCID", "22222222222");//问题ICCID
            jsonObjectResultReq.put("IMSI", "22222222222");//问题IMSI
            jsonObjectResultReq.put("MAC", "22222222222");//问题MAC
            jsonObjectResultReq.put("MEID", "22222222222");//问题MEID
            jsonObjectResultReq.put("RISK_CONTROL_CODE", "22222222222");//风控点编码：PloyEventIdRZ002
            jsonObjectResultReq.put("RISK_CONTROL_NAME", "22222222222");//风控点名称
            jsonObjectResultReq.put("RETURN_CODE", "22222222222");//风控返回编码：5
            jsonObjectResultReq.put("RETURN_NAME", "22222222222");//风控返回描述：建议拒绝
            noticeObject.put("NOTICE_RESULTS_REQ", jsonObjectResultReq);
            uniObject.put("UNI_BSS_BODY", noticeObject);
            //logger.error("===callInterface====uniObject=="+uniObject);
            // System.out.println(uniObject);
        } catch (Exception e) {
            // logger.error("RzFengkongService.callInterface error:" + e);
        }
        return uniObject.toString();
    }

    @Test
    public void testTry122() {
        String str = "20210603";
        String str1 = "20210605";
        if (Integer.valueOf(str) < Integer.valueOf(str1)) {
            System.out.println("小于");
        }
        System.out.println(str.substring(0, 3));
    }

    @Test
    public void testTry125() {
        Student student = new Student();
        testTry123(student);
        testTry124(student);
        System.out.println(student);
    }

    public void testTry123(Student student) {
        student.setName("w22");
    }

    public void testTry124(Student student) {
        student.setAge("222");
    }

    @Test
    public void testTry126() {
        // LogRzLoginData LogRzLoginData
        String info = "{ \"titleName\": \"01\", \"mobile\": \"15546458187\", \"pordId\": \"\", \"provinceCode\": \"097\", \"cityCode\": \"971\", \"netType\": \"112\", \"loginTime\": \"1622706185814\", \"loginType\": \"06\", \"loginState\": \"01\", \"imei\": \"861119041546512\", \"userIp\": \"111.41.170.251\", \"appid\": \"1f7af72ad6912d306b5053abf90c7ebbfb83f2248de3836b128611a6ffeb7e7945ff6afbacc2c4228ddd781ffc6c4fe3d1e4ae9c7c909dbc226898731a5129f4\", \"iccid\": \"\", \"imsi\": \"460016444407860\", \"mac\": \"28:16:7F:3A:AD:3D\", \"meid\": \"861119041546512\", \"lat\": \"45.744956\", \"lon\": \"126.598013\", \"deviceBrand\": \"Xiaomi\", \"deviceModel\": \"Redmi Note 8 Pro\", \"os\": \"android\", \"osVersion\": \"android9\", \"screen\": \"2340*1080\", \"memorySpace\": \"1.60 GB\", \"phoneSpace\": \"118 GB\", \"insertTime\": null, \"Hkey\": \"\", \"loginTimeFormat\": \"\", \"isAlarm\": \"\", \"ip\": \"\", \"agencyId\": \"\" }";
        net.sf.json.JSONObject userInfoJson = net.sf.json.JSONObject.fromObject(info);
        LogRzLoginData logRzLoginData = (LogRzLoginData) net.sf.json.JSONObject.toBean(userInfoJson, LogRzLoginData.class);
        System.out.println(logRzLoginData.getMobile());

    }

    @Test
    public void testTry127() {
        try {
            StringBuilder imeiTotalStr = new StringBuilder();
            long imeiTotal = 0;
            String[] imeiArr = "861119041546512,".split(",");
            System.out.println(imeiArr.length);
            imeiTotal += imeiArr.length - 1;
            // int i = 10 / 0;
            imeiTotalStr.append("861119041546512,");
            System.out.println(imeiTotal);
            System.out.println(imeiTotalStr);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testTry128() {
        String str = "{\"result\":\"22\"}";
        net.sf.json.JSONObject userInfoJson = net.sf.json.JSONObject.fromObject(str);
        String result = String.valueOf(userInfoJson.get("result"));
        System.out.println(result);
    }

    public String testTry129(String str) {
        if ("4".equals(str)) {

        }
        return "123";
    }

    @Test
    public void testTry129() {
        String last30Days = new SimpleDateFormat("yyyyMMdd").format(new Date(Calendar.getInstance().getTimeInMillis() - 30 * 24 * 60 * 60 * 1000L));
        System.out.println(last30Days);
        String last30Days2 = new SimpleDateFormat("yyyyMMdd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        System.out.println(last30Days2);
        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(Calendar.getInstance().getTimeInMillis() + 30 * 24 * 60 * 60 * 1000);
        System.out.println(30 * 24 * 60 * 60 * 1000L);


    }

    @Test
    public void testTry130() {
        RzLoginInfo rzLoginInfo = null;
        rzLoginInfo = new RzLoginInfo();
        //redis里面没有说明没有换机
        // RzLoginInfo RzLoginInfo = new RzLoginInfo();
        rzLoginInfo.setLastImei("imeiTarget");
        Map imeiMap = new HashMap<String, String>();
        imeiMap.put("20210609", "imeiTarget" + ",");
        rzLoginInfo.setImeis(imeiMap);
        LoginCnt loginCnt = new LoginCnt();
        loginCnt.setChangeImeiCount(0);
        loginCnt.setLoginSuccessCount(1);
        Map loginCntMap = new HashMap<String, String>();
        loginCntMap.put("20210609", loginCnt);
        rzLoginInfo.setLogincnt(loginCntMap);
        Object rzLoginInfoObj = JSONObject.toJSON(rzLoginInfo);
        System.out.println(String.valueOf(rzLoginInfoObj));
        //{"lastImei":"imeiTarget","logincnt":{"20210609":{"changeImeiCount":0,"loginSuccessCount":1}},"imeis":{"20210609":"imeiTarget,"}}
        /*---------------------------------*/
        System.err.println("------------------------------------------");

        net.sf.json.JSONObject userInfoJson = net.sf.json.JSONObject.fromObject(String.valueOf(rzLoginInfoObj));

        Map<String, Class<?>> classMap = new HashMap<String, Class<?>>();
        classMap.put("LoginCnt", LoginCnt.class);

        rzLoginInfo = (RzLoginInfo) net.sf.json.JSONObject.toBean(userInfoJson, RzLoginInfo.class, classMap);

        System.out.println("------从redis里面拿出的数据------------" + rzLoginInfo.toString());

        String lastImei = rzLoginInfo.getLastImei();
        Map<String, String> userImeisMap = rzLoginInfo.getImeis();
        Map<String, LoginCnt> userLogincntMap = rzLoginInfo.getLogincnt();
        // System.err.println("------------------遍历map中的对象------------------------");
        Map<String, LoginCnt> userLogincntMapTemp = new HashMap<>();

        for (String key : userLogincntMap.keySet()) {
            Object loginCnt1 = userLogincntMap.get(key);
            net.sf.json.JSONObject userInfoJson2 = net.sf.json.JSONObject.fromObject(loginCnt1);
            LoginCnt loginCnt2 = (LoginCnt) net.sf.json.JSONObject.toBean(userInfoJson2, LoginCnt.class);
            System.out.println("loginCnt1===" + loginCnt2.toString());
            userLogincntMapTemp.put(key, loginCnt2);


        }

        rzLoginInfo.setLastImei(lastImei);
        rzLoginInfo.setImeis(userImeisMap);
        rzLoginInfo.setLogincnt(userLogincntMapTemp);
        System.out.println(rzLoginInfo.toString());

        Object rzLoginInfoObj2 = JSONObject.toJSON(rzLoginInfo);
        System.out.println("-----最后放入redis里面的值-----------" + String.valueOf(rzLoginInfoObj2));

    }

    @Test
    public void testTry131() {
        String httpPosition = " {\"result\":\"0\",\"resp_type\":\"1\",\"resp_code\":\"0\",\"level\":\"5\",\"lasttime\":\"20210609184032\",\"flag\":\"0x8011\"}";
        net.sf.json.JSONObject positionJson = net.sf.json.JSONObject.fromObject(httpPosition);
        System.out.println(positionJson);
        if (positionJson.has("lasttime") && positionJson.has("level")) {
            httpPosition = positionJson.get("level").toString();
            int httpJson = Integer.parseInt(httpPosition);
            System.out.println(httpJson);
        } else {
        }
    }

    @Test
    public void testTry132() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        List<String> myList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(myList);

    }

    @Test
    public void testTry133() {
        long i = 30 * 24 * 60 * 60 * 1000L;
        System.out.println(i);
        int j = 30 * 24 * 60 * 60;
        System.out.println(j);

    }

    @Test
    public void testTry134() {
        String[] imeiChangeFlagReusltList = new String[]{"HF0", "HT0", "HT1", "HM0", "HM1"};
        List<String> imeiChangeFlagReusltList2 = Arrays.asList(imeiChangeFlagReusltList);
        String[] positionResultList = new String[]{"LE0", "LN0", "LN1", "LN2", "LE1"};
        List<String> positionResultList2 = Arrays.asList(positionResultList);


        String imeiChangeFlagReuslt = "HT0";
        String positionResult = "LE1";

        for (int i = 0; i < imeiChangeFlagReusltList2.size(); i++) {
            imeiChangeFlagReuslt = imeiChangeFlagReusltList2.get(i);
            for (int j = 0; j < positionResultList2.size(); j++) {
                positionResult = positionResultList2.get(j);
                String checkResult = "";

                if (("HF0".equals(imeiChangeFlagReuslt) || "HT0".equals(imeiChangeFlagReuslt)) && !"LE1".equals(positionResult)
                        || ("LE0".equals(positionResult) && !"HM1".equals(imeiChangeFlagReuslt))) {
                    checkResult = "换机核验通过";
                } else if (("HM1".equals(imeiChangeFlagReuslt) && !"LE0".equals(positionResult))
                        || ("LE1".equals(positionResult) && ("HT1".equals(imeiChangeFlagReuslt) || "HM0".equals(imeiChangeFlagReuslt) || "HM1".equals(imeiChangeFlagReuslt)))) {
                    checkResult = "换机核验拒绝";
                } else {
                    checkResult = "换机核验待定";
                }
                System.out.println(imeiChangeFlagReuslt + "===" + positionResult + "=====" + checkResult);
            }
        }


    }

    @Test
    public void testTry135() {
        String Str = "{\n" +
                "    \"key\":\"123\",\n" +
                "    \"value\":\"123\"\n" +
                "}";
        net.sf.json.JSONObject jsonObject = net.sf.json.JSONObject.fromObject(Str);
        Object key = jsonObject.get("key");
        System.out.println(String.valueOf(key));
        String str = "1234";

        System.out.println(str.substring(1, 3));

    }

    @Test
    public void testTry136() {
        byte[] bytes = "a".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println(bytes.toString());
        List list = new ArrayList();

    }

    @Test
    public void testTry137() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        List<String> myList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(myList);
        list.stream().forEach(x -> {
            int length = x.length();
            System.out.println(length);
        });
    }

    @Test
    public void testTry138() {
        System.out.println(4 * 100 / 9);
        System.out.println(44 * 9);
        String userInfo = "{\"lastImei\":\"AAAAAAAAAA00004\",\"logincnt\":{\"20210615\":{\"changeImeiCount\":1,\"loginSuccessCount\":2}},\"imeis\":{\"20210615\":\"AAAAAAAAAA00003,AAAAAAAAAA00004,\"}}";
        System.out.println(userInfo);
        net.sf.json.JSONObject userInfoJson = net.sf.json.JSONObject.fromObject(userInfo);
        RzLoginInfo rzLoginInfo = (RzLoginInfo) net.sf.json.JSONObject.toBean(userInfoJson, RzLoginInfo.class);
        System.out.println(rzLoginInfo);
    }

    @Test
    public void testTry139() {
        String str = "182c87";
        byte[] bytes = "182c87".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }
        System.out.println(bytes.toString());
        List list = new ArrayList();

    }

    @Test
    public void testTry140() {
        for (int i = 0; i < 10; i++) {
            System.out.println("22222");

            Object exitOrderId = "1";
            if (!"null".equals(exitOrderId) && Integer.valueOf((Integer) exitOrderId) > 0) {
                System.out.println("--------------");

                continue;
            } else {
                System.out.println(i);
            }
            System.out.println("1111111111");
        }
    }

    public String testTry141() {
        String str = "------";
        try {
            int i = 1 / 0;
            return "1";
        } catch (Exception e) {
            str = "2";
        } finally {

            System.out.println("fin=" + str);
        }
        return "0";
    }

    @Test
    public void testTry142() {
        String s = testTry141();
        System.out.println("s===" + s);
    }

    //大对象转小对象
    @Test
    public void testTry143() {
        List<User> userList = new ArrayList<>();

        userList.add(new User("w1", "12", "1"));
        userList.add(new User("w1", "12", "4"));

        List<Student2> collect = userList.stream()
                .map(l -> new Student2(l.getName(), l.getCode())
                )
                .collect(Collectors.toList());

        System.out.println(collect);

        String s =
                "{\"UNI_BSS_HEAD\":{\"APP_ID\":\"ecsnkAPPID\",\"TIMESTAMP\":\"20210621190706709\",\"TRANS_ID\":\"1624273626709840423\"},\"UNI_BSS_BODY\":{\"RISK_CONTROL_DECISION_RSP\":{\"RESP_CODE\":\"0000\",\"RESP_DESC\":\"成功\",\"RESP_INFO\":{\"USER_ID\":\"17673241187\",\"RISK_CONTROL_CODE\":\"PloyEventIdQD003\",\"RISK_CONTROL_NAME\":\"签到平台风控事件三\",\"RETURN_CODE\":\"1\",\"RETURN_NAME\":\"建议通过\",\"RULE_INFO\":[]}}}}";
    }

    @Test
    public void testTry144() {

        String ResponseInfo =
                "{\"UNI_BSS_HEAD\":{\"APP_ID\":\"ecsnkAPPID\",\"TIMESTAMP\":\"20210621190706709\",\"TRANS_ID\":\"1624273626709840423\"},\"UNI_BSS_BODY\":{\"RISK_CONTROL_DECISION_RSP\":{\"RESP_CODE\":\"0000\",\"RESP_DESC\":\"成功\",\"RESP_INFO\":{\"USER_ID\":\"17673241187\",\"RISK_CONTROL_CODE\":\"PloyEventIdQD003\",\"RISK_CONTROL_NAME\":\"签到平台风控事件三\",\"RETURN_CODE\":\"1\",\"RETURN_NAME\":\"建议通过\",\"RULE_INFO\":[]}}}}";
        Map<String, String> responseMap = new HashMap<String, String>();
        responseMap.put("responseMessage", ResponseInfo);
        //定义返回结果
        Result result = Result.ok(responseMap);
        //Result result = Result.ok(s);
        System.out.println(result.toString());
        net.sf.json.JSONObject userInfoJson = net.sf.json.JSONObject.fromObject(result);
        System.out.println(userInfoJson);
    }

    @Test
    public void testTry145() {
 /*       {
            "accessKey":"",
                "type":"",
                "appId":"",
                "data":{
            "text":"",
                    "tokenId":""
        }*/

        JSONObject json = new JSONObject();
        json.put("accessKey", "3B6f1yaj52T5WzR5WtF");
        json.put("type", "ZHIBO");
        json.put("appId", "0iqAAFkXhOBS6GllZxEm");
        JSONObject data = new JSONObject();
        data.put("text", "尼玛的");
        data.put("tokenId", UUID.randomUUID());
        json.put("data", data);
        System.out.println(json.toString());
    }

    @Test
    public void testTry146() {
        String str = "1";
        try {
            List list = null;

            try {
         /*   list.size();
            str="123";*/
                int j = 10 / 0;
            } catch (NullPointerException e) {
                str = "error";
            }
            System.out.println(str);

        } catch (Exception e) {
            System.out.println("str=====" + str + e.getMessage());
        }
    }

    @Test
    public void testTry147() {
        String str = "[RuleNumQD000002, RuleNumTY000036]";
        str = str.replace("[", "").replace("]", "");
        String[] split = str.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        System.out.println(str);

        String s = "";
        System.err.println(s.length());
        String s2 = null;
        //System.err.println(s2.length());
        String rulesets = null;
        if (StringUtils.isBlank(rulesets)) {
            System.out.println("------------");
        }

        String rulesets2 = "";
        if (StringUtils.isBlank(rulesets2)) {
            System.out.println("------2------");
        }
        String rulesets3 = "null";
        if (StringUtils.isBlank(rulesets3)) {
            System.out.println("------3------");
        }

        String rulesets4 = "null1,2,";
        System.out.println(rulesets4.trim());

        rulesets4 = rulesets4.substring(0, rulesets4.length() - 1);
        System.out.println(rulesets4);


    }

    @Test
    public void testTry148() {
        String rulesets = "";
        if (!StringUtils.isBlank(rulesets)) {
            rulesets = rulesets.replace("[", "").replace("]", "");
            String ruleResult = "";
            String[] rulesetsArr = rulesets.split(",");
            for (int i = 0; i < rulesetsArr.length; i++) {
                // System.out.println(rulesetsArr[i]);
                String ruleInfo = "中文信息";
                ruleResult = ruleResult + rulesetsArr[i] + "+" + ruleInfo + ",";
            }
            rulesets = ruleResult.substring(0, ruleResult.length() - 1);
        }
        System.err.println(rulesets);
    }

    @Test
    public void testTry149() {
        String str = "{\"setName\":\"看广告送积分风控规则集\",\"proposal\":{\"feedbackCode\":\"1\",\"feedbackState\":\"\",\"riskGrade\":0,\"feedbackName\":\"建议通过\"},\"ruleSetWeight\":\"0\",\"hitRules\":[],\"setCode\":\"COL_SetCodeGG001\",\"setDescription\":\"看广告送积分风控规则集\"}";
        //JSONObject json =  JSONObject.parse(str);
        net.sf.json.JSONObject json = net.sf.json.JSONObject.fromObject(str);
        System.out.println(json);

    }

    @Test
    public void testTry150() {
        String str = "{\"setName\":\"签到运营平台风控规则集三\",\"proposal\":{\"feedbackCode\":\"5\",\"feedbackState\":\"\",\"riskGrade\":80,\"feedbackName\":\"建议拒绝\"},\"ruleSetWeight\":\"0\",\"hitRules\":[{\"ruleWeight\":0,\"ruleNum\":\"RuleNumTY000001\",\"ruleLevel\":0,\"ruleName\":\"风控检出黑名单规则\",\"ruleDescription\":\"此用户为风控平台检出的黑名单用户\"}],\"setCode\":\"COL_SetCodeQD003\",\"setDescription\":\"签到运营平台风控规则集三\"},{\"setName\":\"签到运营平台风控规则集三\",\"proposal\":{\"feedbackCode\":\"5\",\"feedbackState\":\"\",\"riskGrade\":80,\"feedbackName\":\"建议拒绝\"},\"ruleSetWeight\":\"0\",\"hitRules\":[{\"ruleWeight\":0,\"ruleNum\":\"RuleNumTY000001\",\"ruleLevel\":0,\"ruleName\":\"风控检出黑名单规则\",\"ruleDescription\":\"此用户为风控平台检出的黑名单用户\"}],\"setCode\":\"COL_SetCodeQD003\",\"setDescription\":\"签到运营平台风控规则集三\"}";
        List<String> list = Arrays.asList(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
    }

    @Test
    public void testTry151() {
        String str = "[{\"setName\":\"看广告送积分风控规则集\",\"proposal\":{\"feedbackCode\":\"1\",\"feedbackState\":\"\",\"riskGrade\":0,\"feedbackName\":\"建议通过\"},\"ruleSetWeight\":\"0\",\"hitRules\":[],\"setCode\":\"COL_SetCodeGG001\",\"setDescription\":\"看广告送积分风控规则集\"},{\"setName\":\"看广告送积分风控规则集\",\"proposal\":{\"feedbackCode\":\"1\",\"feedbackState\":\"\",\"riskGrade\":0,\"feedbackName\":\"建议通过\"},\"ruleSetWeight\":\"0\",\"hitRules\":[],\"setCode\":\"COL_SetCodeGG001\",\"setDescription\":\"看广告送积分风控规则集\"},{\"setName\":\"看广告送积分风控规则集\",\"proposal\":{\"feedbackCode\":\"1\",\"feedbackState\":\"\",\"riskGrade\":0,\"feedbackName\":\"建议通过\"},\"ruleSetWeight\":\"0\",\"hitRules\":[],\"setCode\":\"COL_SetCodeGG001\",\"setDescription\":\"看广告送积分风控规则集\"},{\"setName\":\"看广告送积分风控规则集\",\"proposal\":{\"feedbackCode\":\"1\",\"feedbackState\":\"\",\"riskGrade\":0,\"feedbackName\":\"建议通过\"},\"ruleSetWeight\":\"0\",\"hitRules\":[],\"setCode\":\"COL_SetCodeGG001\",\"setDescription\":\"看广告送积分风控规则集\"}]";
        JSONArray jsonArray = JSONArray.parseArray(str);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject o = (JSONObject) jsonArray.get(i);
            Object setName = o.get("setName");
            System.out.println(setName);
            System.out.println(o);
        }
    }

    @Test
    public void testTry1521() {
        for (int i = 0; i < 36 * 10000; i++) {
            if (i % 10000 == 0) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void testTry1522() {
        String deviceNumber = "123";
        String svcNumber = "124";
        if (!(deviceNumber.length() == svcNumber.length() && !deviceNumber.equals(svcNumber))) {
            System.out.println("2222");

        } else {
            System.out.println("1111");
        }
        Timestamp loadKafkaTime = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        Timestamp loadKafkaTime2 = new Timestamp(System.currentTimeMillis());
        System.out.println(loadKafkaTime);
        System.out.println(loadKafkaTime2);
        //System.out.println(loadKafkaTime2-loadKafkaTime);
    }

    //获取随机数
    @Test
    public void testTry1523() {
        int round = (int) Math.random() * 10;//*10;
        System.out.println(round);
        System.out.println("Method one:" + Math.random() * 100);
        Random random = new Random();
        System.out.println("Method two:" + random.nextInt(100));


    }

    //获取随机数
    @Test
    public void testTry1524() {
        String str1 = "12345";
        String str2 = "123";
        boolean contains = str1.contains(str2);
        System.out.println(contains);
    }

    @Test
    public void testTry1525() {
        String rulesets = "[RuleNumQD000002, RuleNumTY000036]";
        rulesets = rulesets.replace("[", "").replace("]", "");
        String ruleResult = "";
        String[] rulesetsArr = rulesets.split(",");
        for (int i = 0; i < rulesetsArr.length; i++) {
            // System.out.println(rulesetsArr[i]);
            String ruleInfo = rulesetsArr[i];
            ruleResult = ruleResult + "=" + rulesetsArr[i].trim() + "+" + ruleInfo + ",";
        }
        rulesets = ruleResult.substring(0, ruleResult.length() - 1);
        System.out.println(rulesets);


        String str = " 123 ";
        System.out.println("=" + str.trim() + "=");
    }

    @Test
    public void testTry1526() {
        String channelContact = "6";
        if (channelContact.length() > 2 && "08".equals(channelContact.substring(0, 2))) {
            System.out.println("08");
        } else {
            System.out.println("其他");

        }
    }

    @Test
    public void testTry1527() {

        String str = (int) (Math.random() * 9) * 10 + "-" + (int) ((Math.random() * 9 + 1) * 100000);
        System.out.println(str);
    }

    @Test
    public void testTry158() {
        String str = "{\"score\":0,\"code\":1100,\"riskLevel\":\"PASS\",\"requestId\":\"4b9eaacb563ea66abbecdf48ed8dbefc\",\"detail\":\"{\\\"contactResult\\\":[],\\\"description\\\":\\\"正常\\\",\\\"descriptionV2\\\":\\\"正常\\\",\\\"model\\\":\\\"M1000\\\",\\\"riskType\\\":0}\",\"message\":\"成功\",\"status\":0}";
        System.out.println(str);
        JSONObject parse = (JSONObject) JSONObject.parse(str);
        Object score = parse.get("score");
        System.out.println(score);
        Object code = parse.get("code");
        System.out.println(code);

        String detail = (String) parse.get("detail");
        JSONObject detailJson = (JSONObject) JSONObject.parse(detail);
        Object description = detailJson.get("description");
        System.out.println(description);

        String expression = "REVIEW";
        String feedcodeback = "";
        switch (expression) {
            case "PASS":
                //语句
                feedcodeback = "1";
                break; //可选
            case "REVIEW":
                //语句
                feedcodeback = "3";
                break; //可选
            case "REJECT":
                //语句
                feedcodeback = "5";
                break; //可选
            //你可以有任意数量的case语句
            default: //可选
                //语句
        }
        System.out.println(feedcodeback);
    }

    @Test
    public void testTry159() {
        System.out.println(new Timestamp(System.currentTimeMillis()));
        BigDecimal aim = new BigDecimal(Double.parseDouble("0.01"));
        //errorCount = 17=totalCount=67861==errorRate==0
        long errorCount = 1L;
        long totalCount = 60878;
        double end = (double) errorCount / (double) totalCount * 100;
        BigDecimal bd = new BigDecimal(end);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println("aim=" + aim);
        System.err.println("aim=" + bd);
        if (bd.compareTo(aim) > 0) {
            System.out.println("1111");
        } else {
            System.out.println("2222");
        }


        System.out.println(bd);
        System.out.println(String.valueOf(100 - Double.parseDouble("0.02")));


    }

    /**
     * {
     * "UNI_BSS_HEAD":{
     * "APP_ID":"orderAPPID",
     * "TIMESTAMP":"1621996306730",
     * "TRANS_ID":"20210526103146730615191",
     * "TOKEN":"7dfe89bccbcb0a96b2b2e496ea145b48",
     * "RESP_DESC":""
     * },
     * "UNI_BSS_BODY":{
     * "TEXT_RISK_CONTROL_REQ_RSP":{
     * "RESP_CODE":"0000",
     * "RESP_DESC":"成功",
     * "RESP_INFO":{
     * "USER_ID":"PloyEventIdDD001",
     * "TITLE":"0000",
     * "TOPIC":"建议通过",
     * "RETURN_CODE":"",
     * "RETURN_NAME":"商城订单导单流程风控事件",
     * "RULE_INFO":"商城订单导单流程风控事件",
     * "RISK_TYPE":"商城订单导单流程风控事件",
     * "DESCRIPTION":"商城订单导单流程风控事件"
     * }
     * }
     * }
     * }
     */

    @Test
    public void testTry160() {
        JSONObject response = new JSONObject();
        JSONObject uniBssHead = new JSONObject();
        JSONObject uniBssBody = new JSONObject();
        JSONObject textRiskControlReqRsp = new JSONObject();
        JSONObject respInfo = new JSONObject();
        respInfo.put("USER_ID", "PloyEventIdDD001");
        respInfo.put("TITLE", "TITLE");
        respInfo.put("TOPIC", "TOPIC");
        respInfo.put("RETURN_CODE", "RETURN_CODE");
        respInfo.put("RETURN_NAME", "RETURN_NAME");
        respInfo.put("RULE_INFO", "RULE_INFO");
        respInfo.put("RISK_TYPE", "RISK_TYPE");
        respInfo.put("DESCRIPTION", "DESCRIPTION");
        textRiskControlReqRsp.put("RESP_INFO", respInfo);
        textRiskControlReqRsp.put("RESP_CODE", "RESP_CODE");
        textRiskControlReqRsp.put("RESP_DESC", "RESP_DESC");
        uniBssBody.put("TEXT_RISK_CONTROL_REQ_RSP", textRiskControlReqRsp);
        response.put("UNI_BSS_BODY", uniBssBody);
        uniBssHead.put("APP_ID", "APP_ID");
        uniBssHead.put("TIMESTAMP", "TIMESTAMP");
        uniBssHead.put("TRANS_ID", "TRANS_ID");
        uniBssHead.put("TOKEN", "TOKEN");
        uniBssHead.put("RESP_DESC", "RESP_DESC");
        response.put("UNI_BSS_HEAD", uniBssHead);
        System.out.println(response);
    }

    @Test
    public void testTry161() {
        ArrayList<String> ltMobile = (ArrayList<String>) Arrays.asList(new String[]{"130", "131", "132", "155", "156", "185", "186", "166", "175", "176"});
        System.out.println(ltMobile);
    }

    @Test
    public void testTry1622() {
        String appId = "orderAPPID";
        String timesTamp = "1621996306730";
        String transId = "20210526103146730615191";
        String token = "7dfe89bccbcb0a96b2b2e496ea145b48";
        String str = transId + timesTamp + appId;
        String md5Str = CompetencePlatformTokenUtil.getMD5(str);
        System.out.println(md5Str);
    }

    public String testTry162() {
        JSONObject reponse = new JSONObject();
        net.sf.json.JSONObject rspBody = new net.sf.json.JSONObject();
        net.sf.json.JSONObject rsp = new net.sf.json.JSONObject();
        Student student = new Student();
        Map map = new HashMap();
        try {
            check(reponse, student, map);
            System.err.println("reponse=" + reponse);
            return "123";
        } catch (Exception e) {
            System.out.println("123");
            // e.printStackTrace();
            System.err.println(reponse);
            System.out.println("map  key-=" + map.containsKey("key"));

            System.out.println("st2222222=" + student.toString());

            //炎黄响应报文
            if (reponse.containsKey("UNI_BSS_BODY")) {
                return reponse.toString();
            } else {
                //reponse = new JSONObject();

                rsp.put("RESP_CODE", "9001");
                rsp.put("RESP_DESC", "服务内部错误");
                rspBody.put("OEDER_RISK_CONTROL_DECISION_RSP", rsp);
                reponse.put("UNI_BSS_BODY", rspBody);
                reponse.put("UNI_BSS_HEAD", "123");
                return reponse.toString();
            }

        } finally {
            System.out.println("1111111111111111111111111111");
            //拼装响应报文请求头
            if (!reponse.containsKey("UNI_BSS_HEAD")) {
                JSONObject uniBssHead = new JSONObject();
                // net.sf.json.JSONObject inputUniBssHead = input.getJSONObject("UNI_BSS_HEAD");
                uniBssHead.put("APP_ID", "APP_ID");
                uniBssHead.put("TIMESTAMP", String.valueOf(new Timestamp(System.currentTimeMillis())));
                uniBssHead.put("TRANS_ID", "TRANS_ID");
                uniBssHead.put("TOKEN", "token");
                uniBssHead.put("RESP_DESC", "");
                reponse.put("UNI_BSS_HEAD", uniBssHead);
            }

            System.out.println("2222222222222222222222222" + reponse.toString());

        }
    }

    public void check(JSONObject rsp, Student student, Map map) throws Exception {
        JSONObject rspBody = new JSONObject();
        JSONObject result = new JSONObject();
        if (true) {
            JSONObject rsp2 = new JSONObject();
            rsp2.put("RESP_CODE", "1002");
            rsp2.put("RESP_DESC", "Token解析失败");
            System.out.println("====rsp==" + rsp2);
            //student = new Student();
            student.setName("123");
            System.out.println("st=" + student.toString());
            // map = new HashMap();
            map.put("key", "123");
            System.out.println("map  key-=" + map.containsKey("key"));
            rspBody.put("TEXT_RISK_CONTROL_REQ_RSP", rsp2);
            rsp.put("UNI_BSS_BODY", rspBody);
            throw new Exception();
        }
    }

    @Test
    public void testTry163() {
        System.out.println(testTry162());
        System.out.println("123");
    }

    public int testTry1612() {
        int i = 0;
        try {
            i = 5;
            System.err.println(i);
            return i;
        } catch (Exception e) {
            i = 6;
        } finally {
            i = 7;
            System.out.println(i);

        }
        return 0;
    }

    @Test
    public void testTry164() {
        System.out.println(System.currentTimeMillis());
        //1621996306730
        //1625559931028


        System.out.println(new Timestamp(System.currentTimeMillis()));
        System.out.println(new Timestamp(Long.parseLong(System.currentTimeMillis() + "000")));


        System.err.println(System.currentTimeMillis());
        String time = String.valueOf(System.currentTimeMillis());
        time = time.substring(0, 13);
        System.err.println(time);


    }

    /**
     * {
     * "code": 1100,
     * "message": "成功",
     * "requestId": "540c862faf35b7498c1f16a45880bd16",
     * "score": 0,
     * "riskLevel": "PASS",
     * "detail": "{\"contactResult\":[],\"description\":\"正常\",\"descriptionV2\":\"正常\",\"model\":\"M1000\",\"riskType\":0,\"tokenScore\":30}",
     * "status": 0
     * }
     */


    @Test
    public void testTry165() {
        JSONObject response = new JSONObject();
        JSONObject shumeiResponseBody = new JSONObject();
        shumeiResponseBody.put("contactResult", new String[]{});
        shumeiResponseBody.put("description", "正常");
        shumeiResponseBody.put("descriptionV2", "正常");
        shumeiResponseBody.put("model", "M1000");
        shumeiResponseBody.put("riskType", 0);
        shumeiResponseBody.put("tokenScore", 30);

        response.put("code", 0030);
        response.put("message", "成功");
        response.put("requestId", "540c862faf35b7498c1f16a45880bd16");
        response.put("score", 0);
        response.put("riskLevel", "PASS");
        response.put("detail", shumeiResponseBody);
        response.put("status", 0);
        System.out.println(response);
    }

    public Map test100() {
        Timestamp shumeiBeginTime = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        Map map = new HashMap();
        map.put("str", "123");
        map.put("begin", shumeiBeginTime);
        return map;
    }

    @Test
    public void testTry166() {
        Map map = test100();
        String str = String.valueOf(map.get("s2tr22222222222222222222222"));
        Timestamp begin = (Timestamp) map.get("begin");
        System.out.println(str);
        System.out.println(begin.getTime());
    }

    @Test
    public void testTry167() {
        String str = "12345678";
        System.out.println(str.substring(2));
    }

    @Test
    public void testTry168() {
        String dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        System.out.println(dateStr);

        long totalCount = 2909;
        long errorCount = 4;
        double end = (double) errorCount / (double) totalCount * 100;
        BigDecimal bd = new BigDecimal(end);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(bd.doubleValue());

        System.out.println(String.valueOf(100 - bd.doubleValue()));
    }

    @Test
    public void testTry169() {
        String str = "{\"score\":0,\"code\":1100,\"riskLevel\":\"PASS\",\"requestId\":\"e27bd3db4e3cee0cc7e05cf60ebfaa6e\",\"detail\":\"{\\\"contactResult\\\":[{\\\"contactString\\\":\\\"12465173246\\\",\\\"contactType\\\":1},{\\\"contactString\\\":\\\"65\\\",\\\"contactType\\\":3}],\\\"description\\\":\\\"??\\\",\\\"descriptionV2\\\":\\\"??\\\",\\\"model\\\":\\\"M1000\\\",\\\"riskType\\\":0}\",\"message\":\"??\",\"status\":0}";

    }

    @Test
    public void testTry170() {
        JSONObject response = new JSONObject();
        JSONObject shumeiResponseBody = new JSONObject();

        shumeiResponseBody.put("descriptionV2", " ");
        shumeiResponseBody.put("model", "M1000");

        response.put("detail", shumeiResponseBody);
        response.put("status", 0);
        System.out.println(response);

        String text = response.getJSONObject("detail").getString("descriptionV2");
        System.out.println("--------------" + text);
        if (text == null || "".equals(text)) {
            System.err.println("--------------" + text);
        }

        if (StringUtils.isBlank(text)) {
            System.err.println("------2--------" + text);

        }
        if (StringUtils.isEmpty(text)) {
            System.err.println("------3--------" + text);

        }

    }

    public int testTry171() {
        String verificationCode = "67084f";
        //int pointValid = Integer.parseInt(point);
        // System.out.println(pointValid);
        try {
            return Integer.parseInt(verificationCode);
        } catch (Exception e) {
            return 2;
        }


    }

    @Test
    public void testTry172() {
        System.out.println(generateRandomNumber(13));
    }

    @Test
    public void testTry173() {
        String minute = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(Calendar.getInstance().getTimeInMillis()));
        String lastMinute = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(Calendar.getInstance().getTimeInMillis() - 60000L));

        String lastTenMinute = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(Calendar.getInstance().getTimeInMillis() - 600000L)).substring(0, 11) + "0";
        String tenMinute = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(Calendar.getInstance().getTimeInMillis())).substring(0, 11) + "0";
        String lastHour = new SimpleDateFormat("yyyyMMddHH").format(new Date(Calendar.getInstance().getTimeInMillis() - 60 * 60 * 1000L));

        System.out.println(lastMinute);

        System.out.println(minute);

        System.out.println(lastTenMinute);
        System.out.println(tenMinute);
        System.out.println(lastHour);

    }

    @Test
    public void testTry174() {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        String lastHour = new SimpleDateFormat("yyyyMMddHH").format(new Date(Calendar.getInstance().getTimeInMillis() - 60 * 60 * 1000L));
        System.err.println(lastHour);

        map2.put("202106151600", 120);
        map2.put("202106151610", 120);
        List list = new ArrayList();

        for (String key : map2.keySet()) {
            String time = key.substring(0, 10);
            System.out.println(time);
            if (Integer.parseInt(lastHour) > Integer.parseInt(time)) {
                System.out.println("111111111111111111");
                list.add(key);
            } else {
                System.out.println("222222222222222");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            map2.remove(list.get(i));
        }
        System.out.println(map2.size());
        //System.out.println(String.valueOf(map2.get("123")));
    }

    @Test
    public void testTry175() {
        //  1411   得到的值 为  1400
        //  1440   得到的值  为  1430
        //获取当前 小时   1400
        //获取当前小时半  1430


        //
        String minute = new SimpleDateFormat("yyyyMMddHHmm").format(new Date(Calendar.getInstance().getTimeInMillis()));
        String minuteStart = minute.substring(0, 10);

        String minuteEnd = minute.substring(minute.length() - 2);
        System.out.println(minuteEnd);

        if (Integer.parseInt(minuteEnd) > 30) {
            minuteStart = minuteStart + "30";
        } else {
            minuteStart = minuteStart + "00";

        }
        System.out.println(minuteStart);

        ///System.err.println(minute);
        String lastHour = new SimpleDateFormat("yyyyMMddHH").format(new Date(Calendar.getInstance().getTimeInMillis() - 60 * 60 * 1000L));
        System.err.println(lastHour);

    }

    @Test
    public void testTry176() {
        String str = "02";
        System.out.println(Integer.parseInt(str));
    }

    public String syss() {
        try {
            return "1";
        } catch (Exception e) {
            return "2";
        } finally {
            System.out.println("3");
        }
    }

    @Test
    public void testTry177() {
        net.sf.json.JSONObject json = new net.sf.json.JSONObject();
        json.put("str", "123");
        System.out.println(json.size());
        String minute = new SimpleDateFormat("yyyyMMdd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        System.out.println(minute);
        String day = minute.substring(minute.length() - 2);
        System.out.println(day);


        String str = "1";
        switch (str) {
            case "1":
                System.out.println("Monday1\n");
                break;
            case "2":
                System.out.println("Monday2\n");
                break;
            case "3":
                System.out.println("Monday3\n");
                break;
        }
        Map map = new HashMap();
        for (int i = 0; i < 18567081752L; i++) {
            map.put(i, i);
        }

    }

    @Test
    public void testTry178() {
        String today = "20210712";
        today = today == null ? new SimpleDateFormat("yyyyMMdd").format(new Date(Calendar.getInstance().getTimeInMillis())) : today;
        System.out.println(today);

        String value = "1_20210726_26";
        System.out.println(value.split("_")[0]);

        System.out.println(certAge("130132199701242878"));
        System.out.println(makeRandom());
        System.out.println((Math.random() * 9 + 1));
    }

    @Test
    public void testTry179() {


        /* String svc="1313819";
       for (int i = 0; i <10000 ; i++) {
            String s = autoGenericCode(String.valueOf(i),4);
            s=svc+s;
            System.out.println(s);

        }*/
   /*     String svcNumber="131381920";
        for (int i = 0; i <10000 ; i++) {
            String svcNum = autoGenericCode(String.valueOf(i), 4);
            svcNum = svcNumber + svcNum;
            System.out.println(svcNum.substring(0,11));
        }
        //System.out.println(s);*/
        String svcNumber = "15546458117";
        Set set = new HashSet();
        for (int i = 0; i < 3; i++) {
            String svcNum = autoGenericCode(String.valueOf(i), 4);
            svcNum = svcNumber + svcNum;
            System.out.println(svcNum);

            //System.out.println(set.contains(svcNum.substring(0, 11)));
            if (!set.contains(svcNum.substring(0, 11))) {
                set.add(svcNum.substring(0, 11));
                System.out.println("12");
            }
        }
    }

    /**
     * 不够位数的在前面补0，保留num的长度位数字
     *
     * @param code
     * @return
     */
    private String autoGenericCode(String code, int num) {
        String result = "";
        result = String.format("%0" + num + "d", Integer.parseInt(code));

        return result;
    }

    @Test
    public void testTry180() {
        String str = " 1  2  ";
        String str1 = "-";
        String str2 = "-";
        System.out.println(str1 + str.trim().replace(" ", "") + str2);
        List eventIdList = new ArrayList();

        String[] keyList = "1,2".split(",");
        eventIdList = Arrays.asList(keyList);
        System.out.println(eventIdList);

        String s = "{\"UNI_BSS_BODY\":{\"RISK_CONTROL_DECISION_REQ\":{\"AGENCY_ID\":\"superfriday\",\"APPID\":\"adpotAPPID\",\"RISK_CONTROL_CODE\":\"PloyEventIdGG001\",\"SCENE_CODE\":\"00\",\"USER_ID\":\"18911550923\",\"USER_IP\":\"\"}},\"UNI_BSS_HEAD\":{\"APP_ID\":\"adpotAPPID\",\"TIMESTAMP\":1625327996801,\"TOKEN\":\"bec641a4e7b2759be0c94a27a0db395e\",\"TRANS_ID\":\"20210703235956801307810\"}}";
        String s1 = "{\"UNI_BSS_HEAD\":{\"APP_ID\":\"adpotAPPID\",\"TIMESTAMP\":\"1625327996801\",\"TRANS_ID\":\"20210703235956801307810\"},\"UNI_BSS_BODY\":{\"RISK_CONTROL_DECISION_RSP\":{\"RESP_CODE\":\"0000\",\"RESP_DESC\":\"成功\",\"RESP_INFO\":{\"USER_ID\":\"18911550923\",\"RISK_CONTROL_CODE\":\"PloyEventIdGG001\",\"RISK_CONTROL_NAME\":\"看广告送积分风控事件\",\"RETURN_CODE\":\"1\",\"RETURN_NAME\":\"建议通过\",\"RULE_INFO\":[]}}}}";
        JSONObject jsonObject = JSONObject.parseObject(s);
        System.out.println(jsonObject);

    }

    @Test
    public void testTry181() {
        String time = "202107";
        System.out.println(time.substring(time.length() - 2));

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        System.out.println(list.size());
        int modValue = getModValue();
        System.err.println(modValue);
    }

    public int getModValue() {
        String svcNumber = "15693425848";
        String str = (int) (Math.random() * 9) * 10 + "" + (int) ((Math.random() * 9 + 1) * 100000);
        return FnvHash(StringUtils.isBlank(svcNumber) ? str : svcNumber) % 4;
    }

    public int FnvHash(String key) {
        final int p = 16777619;
        long hash = (int) 2166136261L;
        for (int i = 0, n = key.length(); i < n; i++) {
            hash = (hash ^ key.charAt(i)) * p;
        }
        hash += hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return ((int) hash & 0x7FFFFFFF);
    }

    public void testTry1821() {
        System.out.println("22222");

        if (true) {
            return;
        }
        System.out.println("1111");
    }

    @Test
    public void testTry182() {
        testTry1821();
    }

    @Test
    public void testTry183() {
        String str = "i 123,7*&^$%$()-;ASD";
        String s = str.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        System.out.println(s);
    }

    @Test
    public void testTry184() throws ParseException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("svcNumber", "110");
        String[] timeStr = new String[]{"20210801", "20210802"};
        List timeList = Arrays.asList(timeStr);
        System.out.println(timeList);
        jsonObject.put("timeList", timeList);
        System.out.println(jsonObject.toString());
        System.out.println("----------------------------");
        List<String> timeList1 = (List) jsonObject.getJSONArray("timeList");
        System.out.println(timeList1);
        List<String> queryDataTimeList = new ArrayList();
        System.out.println("----------------------------");

        ////-------------------
        for (int i = 0; i < timeList1.size(); i++) {
            String time = timeList1.get(i);
            // 先去查result表,如果查不到数据 就去查日表,由于结果表是今天获取昨日数据,所以前台传的查询条件的时间需要+1天
            Date date = new SimpleDateFormat("yyyyMMdd").parse(time);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, 1);
            String execTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
            queryDataTimeList.add(execTime);
        }
        ///----------------------
        System.out.println(queryDataTimeList);
    }

    @Test
    public void testTry1831() {
        List list = new ArrayList();
        list.add(1);
        list.add(2);

        JSONObject JSONObject = new JSONObject();
        JSONObject.put("L", list);
        JSONArray l = JSONObject.getJSONArray("L");
        System.out.println(l.get(1).getClass().toString());

        Integer o = (Integer) l.get(1);
        System.out.println(o.getClass().toString());
    }

    @Test
    public void testTry1832() {
        String risk = "not alert, e=java.util.concurrent.CompletionException: java.util.ConcurrentModificationException";
        if (risk.contains("Exception")) {
            //如果不存在直接返回
            System.out.println("Code does not exist -->0020" + risk);
            // state = "0020";
        }
    }

    @Test
    public void testTry1833() {
        Map<String, Long> interfaceMap = new HashMap<>();
        interfaceMap.put("1", 222L);
        String str = interfaceMap.containsKey("2") ? String.valueOf(interfaceMap.get("2")) : "0";

        System.out.println(str);
    }

    @Test
    public void testTry1834() {
        Set<String> svcNumberSet = new HashSet();

        for (int i = 0; i < 11949643; i++) {
            svcNumberSet.add(String.valueOf(i));
        }
        for (String svcNumber : svcNumberSet) {
            System.out.println(svcNumber);
        }
        System.out.println(svcNumberSet.size());
    }

    @Test
    public void testTry1835() {
        Map map = new HashMap();
        map.remove("1");
        System.out.println("1");
    }

    @Test
    public void testTry186() {
        int i = 0030;
        String str1 = "20210812000000";
        System.out.println(str1.substring(0, 8));
        String str = String.valueOf(i);
        System.out.println(str);
    }

    @Test
    public void testTry187() {

        //拼装响应报文
        com.alibaba.fastjson.JSONObject response = new com.alibaba.fastjson.JSONObject();
        //拼装响应报文head部分
       /* com.alibaba.fastjson.JSONObject uniBssHead = new com.alibaba.fastjson.JSONObject();
        net.sf.json.JSONObject inputUniBssHead = input.getJSONObject("UNI_BSS_HEAD");
        uniBssHead.put("APP_ID", inputUniBssHead.get("APP_ID"));
        uniBssHead.put("TIMESTAMP", String.valueOf(System.currentTimeMillis()));
        uniBssHead.put("TRANS_ID", inputUniBssHead.get("TRANS_ID"));
        uniBssHead.put("TOKEN", inputUniBssHead.get("TOKEN"));
     */
        com.alibaba.fastjson.JSONObject uniBssBody = new com.alibaba.fastjson.JSONObject();
        com.alibaba.fastjson.JSONObject blackListQueryRsp = new com.alibaba.fastjson.JSONObject();
        blackListQueryRsp.put("RESP_CODE", "0000");
        blackListQueryRsp.put("RESP_DESC", "成功");
        com.alibaba.fastjson.JSONObject respInfo = new com.alibaba.fastjson.JSONObject();
        respInfo.put("USER_ID", "110");
        respInfo.put("IS_BLACKLIST", "1");
        respInfo.put("BLACKLIST_TYPE", "2");
        blackListQueryRsp.put("RESP_INFO", respInfo);
        uniBssBody.put("BLACKLIST_QUERY_RSP", blackListQueryRsp);
        response.put("UNI_BSS_BODY", uniBssBody);


        // response.put("UNI_BSS_HEAD", uniBssHead);
        System.out.println(response.toString());
    }

    @Test
    public void testTry188() {
        String str = "\'00\'" + "123";
        System.out.println(str);
        String userId = "12345-7890";
        System.out.println(userId.substring(userId.length() - 3) + userId.substring(0, userId.length() - 3));


    }

    @Test
    public void testTry189() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "--->" + index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    @Test
    public void testTry190() {
        List<String> list = Arrays.asList(new String[]{"100", "01", "09", "", ""});
        //list.remove("");
        List myList = Arrays.stream(new String[]{"100", "01", "09", "", ""}).collect(Collectors.toList());
        myList.remove("");
        List<String> resultList2 = new ArrayList();
        resultList2.addAll(list);
        List<Integer> resultList = new ArrayList();
        for (String element : list) {
            if (!"".equals(element)) {
                resultList.add(Integer.parseInt(element));

            }
        }

        System.out.println(Collections.min(resultList2));


    }

    @Test
    public void testTry191() {
        List<String> resultList = new ArrayList<>();

        resultList.add("");
        //
        resultList.remove("");
        String min = "";
        if (!resultList.isEmpty()) {
            min = Collections.min(resultList);
        }
        System.out.println(min);
        System.out.println("=");


    }

    @Test
    public void testTry192() {
        //获取今日0点时间
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        String todayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(zero.getTime());  // 获取年月日时分秒
        String today = new SimpleDateFormat("yyyyMMdd").format(zero.getTime());  // 获取年月日时分秒
        System.out.println(today);
        System.out.println(todayTime);
    }

    @Test
    public void testTry193() {
        String str = "1";
        if (str != null && !"null".equals(str) && !"".equals(str) && str.length() >= 2) {
            System.out.println("1111");
        }
        System.out.println("2222");

    }

    @Test
    public void testTry194() {
        /*queryLevel6BlackUser=userActionList=394583=yesterday==20210824
queryLevel6BlackUser=UserPortraitList=66428*/
        List<String> list = new ArrayList();

        List<String> list1 = new ArrayList();
        for (int i = 0; i < 394583; i++) {
            list1.add(String.valueOf(i));
        }
        List<String> list2 = new ArrayList();
        for (int i = 0; i < 664280; i++) {
            list2.add(String.valueOf(i));
        }
        System.out.println("startTime=" + System.currentTimeMillis());
/*        for (String svcNumber : list1) {
            if (list2.contains(svcNumber)) {
                list.add(svcNumber);
            }
        }
        System.out.println(list.size());*/

        List list3 = receiveCollectionList(list1, list2);
        System.out.println(list3.size());
        System.out.println("endTime=" + System.currentTimeMillis());

       /* List list = receiveCollectionList(list1, list2);
        System.out.println(list);*/

    }

    @Test
    public void testTry195() {
        System.out.println(Double.parseDouble("".equals("") ? "1.00" : "0.00"));
        String i = String.valueOf(30 * 24 * 60 * 60);

        //2591978
        //2591963
        //2592000
        int j = Integer.valueOf(i);
        System.out.println(j);

    }

    @Test
    public void testTry196() {
        List<String> queryBlackList = new ArrayList<String>();
        queryBlackList.add("01");
        queryBlackList.add("02");
        System.out.println(queryBlackList.toString().replace("[", "").replace("]", ""));
    }

    @Test
    public void testTry197() {
        List list = new ArrayList();
        List list2 = new ArrayList();

        list.add("01");
        list.add("02");
        String str = list.toString().replace("[", "").replace("]", "");
        String[] split = str.split(",");
        List<String> strings = Arrays.asList(split);
        for (int i = 0; i < strings.size(); i++) {
            System.out.println("+" + strings.get(i) + "=");
            System.out.println("+" + strings.get(i).trim() + "=");

            list2.add(strings.get(i).trim());
        }
        System.out.println(list2);
        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i));

        }
    }

    @Test
    public void testTry198() {

        String response = "";
        String isYangkaUser = "";
        String isXujiaUser = "";
        String isXukaiUser = "";
        List responseList = new ArrayList();

        //是否疑似养卡用户
        isYangkaUser = "是";
        //是否虚假用户
        isXujiaUser = "是";
        //是否虚开养卡用户
        isXukaiUser = "是";


        if ("是".equals(isYangkaUser)) {
            //response = "09";
            responseList.add("09");
            System.out.println("1" + "是".equals(isXujiaUser));
        }
        if ("是".equals(isXujiaUser)) {
            // response = "10";
            responseList.add("10");
            System.out.println("2");

        }
        if ("是".equals(isXukaiUser)) {
            //response = "11";
            responseList.add("11");
            System.out.println("3");

        }
        response = responseList.toString().replace("[", "").replace("]", "");
        System.out.println(response);
    }

    @Test
    public void testTry199() {
        String[] strings = {"a", "b"};
        List<String> strings1 = Arrays.asList(strings);
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//设定格式

        System.out.println(strings1.contains("a"));
        Date date = DateUtils.addHours(new Date(), 24);
        Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        Timestamp timestamp2 = new Timestamp(now.getTime());
        System.out.println(dateFormat.format(date));

    }

    @Test
    public void testTry200() {
        Timestamp now1 = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        //将数据存到hbase中
        Date date = DateUtils.addHours(new Date(now1.getTime()), 24);
        new Timestamp(date.getTime());
        System.out.println("now=" + now1);
        System.out.println(new Timestamp(date.getTime()));

    }

    @Test
    public void testTry201() {
        long time1 = System.currentTimeMillis();
        // 查询hbase数据
        String blackListType = "";
        //log.error("query blackList userId2=" + (userId.length() - 3) + userId.substring(0, userId.length() - 3));
        String result01 = "";
        String result02 = "";
        String result03 = "";
        String result04 = "";
        try {
            long time1_1 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_1 time " + (time1_1 - time1));
            //改为多线程并行处理查询
            List<String> queryBlackList = new ArrayList<String>();
            ExecutorService pool = Executors.newFixedThreadPool(4);
            long time1_2 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_2 time " + (time1_2 - time1_1));
            //风控检出黑名单-00
            Future<String> submit1 = pool.submit(() -> getFengkongBlackList());
            long time1_3 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_3 time " + (time1_3 - time1_2));
            //统一认证黑名单-01  交费充值黑名单-02
            Future<String> submit2 = pool.submit(() -> getYaxinPhoneBlackList());
            long time1_4 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_4 time " + (time1_4 - time1_3));
            // 鹰眼骚扰黑名单	03 鹰眼欺诈黑名单	04  鹰眼高危基站黑名单	05 公安涉案黑名单	06 工信部骚扰黑名单	07 工信部欺诈黑名单	08
            Future<String> submit3 = pool.submit(() -> getYingyanPhoneBlackList());
            long time1_5 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_5 time " + (time1_5 - time1_4));
            // 疑似养卡用户黑名单-09 虚假用户黑名单-10 虚开养卡用户黑名单-11
            Future<String> submit4 = pool.submit(() -> getMonthLabelData());
            long time1_6 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_6 time " + (time1_6 - time1_5));
            try {
                //设置超时时间，未超时返回
                result01 = submit1.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit1.cancel(true);
                result01 = "";
            }
            long time1_7 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_7 time " + (time1_7 - time1_6));
            try {
                //设置超时时间，未超时返回
                result02 = submit2.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit2.cancel(true);
                result02 = "";
            }
            long time1_8 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_8 time " + (time1_8 - time1_7));
            try {
                //设置超时时间，未超时返回
                result03 = submit3.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit3.cancel(true);
                result03 = "";
            }
            long time1_9 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_9 time " + (time1_9 - time1_8));
            try {
                //设置超时时间，未超时返回
                result04 = submit4.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit4.cancel(true);
                result04 = "";
            }
            long time1_10 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_10 time " + (time1_10 - time1_9));

            queryBlackList.add(result01);
            //log.error("query blackList submit1.get()=" + submit1.get());
            queryBlackList.add(result02);
            //log.error("query blackList submit2.get()=" + submit2.get());
            queryBlackList.add(result03);

        } catch (Exception e) {

        }
        long time2 = System.currentTimeMillis();
        System.out.println("queryHbaseDataByUserId total time " + (time2 - time1));

    }

    public String testTry2011() {
        long time1 = System.currentTimeMillis();
        // 查询hbase数据
        String blackListType = "";
        //log.error("query blackList userId2=" + (userId.length() - 3) + userId.substring(0, userId.length() - 3));
        String result01 = "";
        String result02 = "";
        String result03 = "";
        String result04 = "";
        try {
            long time1_1 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_1 time " + (time1_1 - time1));
            //改为多线程并行处理查询
            List<String> queryBlackList = new ArrayList<String>();
            ExecutorService pool = new ThreadPoolExecutor(10, 20, 1, TimeUnit.MINUTES,
                    new ArrayBlockingQueue<>(100), new ThreadPoolExecutor.CallerRunsPolicy());
            //Executors.newFixedThreadPool(4);
            long time1_2 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_2 time " + (time1_2 - time1_1));
            //风控检出黑名单-00
            Future<String> submit1 = pool.submit(() -> getFengkongBlackList());
            long time1_3 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_3 time " + (time1_3 - time1_2));
            //统一认证黑名单-01  交费充值黑名单-02
            Future<String> submit2 = pool.submit(() -> getYaxinPhoneBlackList());
            long time1_4 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_4 time " + (time1_4 - time1_3));
            // 鹰眼骚扰黑名单	03 鹰眼欺诈黑名单	04  鹰眼高危基站黑名单	05 公安涉案黑名单	06 工信部骚扰黑名单	07 工信部欺诈黑名单	08
            Future<String> submit3 = pool.submit(() -> getYingyanPhoneBlackList());
            long time1_5 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_5 time " + (time1_5 - time1_4));
            // 疑似养卡用户黑名单-09 虚假用户黑名单-10 虚开养卡用户黑名单-11
            Future<String> submit4 = pool.submit(() -> getMonthLabelData());
            long time1_6 = System.currentTimeMillis();
            //System.out.println("queryHbaseDataByUserId time1_6 time " + (time1_6 - time1_5));
          /*    try {
                //设置超时时间，未超时返回
                result01 = submit1.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit1.cancel(true);
                result01 = "";
            }
            long time1_7 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_7 time " + (time1_7 - time1_6));
          try {
                //设置超时时间，未超时返回
                result02 = submit2.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit2.cancel(true);
                result02 = "";
            }
            long time1_8 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_8 time " + (time1_8 - time1_7));
            try {
                //设置超时时间，未超时返回
                result03 = submit3.get(500, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit3.cancel(true);
                result03 = "";
            }
            long time1_9 = System.currentTimeMillis();
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_9 time " + (time1_9 - time1_8));
            try {
                //设置超时时间，未超时返回
                result04 = submit4.get(5000, TimeUnit.MILLISECONDS);
            } catch (TimeoutException timeoutException) {
                //终止线程
                submit4.cancel(true);
                result04 = "";
            }*/
            long time1_10 = System.currentTimeMillis();
            //System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "queryHbaseDataByUserId time1_10 time " + (time1_10 - time1_9));

            queryBlackList.add(submit1.get());
            //log.error("query blackList submit1.get()=" + submit1.get());
            queryBlackList.add(submit2.get());
            //log.error("query blackList submit2.get()=" + submit2.get());
            queryBlackList.add(submit3.get());
            queryBlackList.add(submit4.get());

        } catch (Exception e) {

        }
        long time2 = System.currentTimeMillis();
        System.out.println("queryHbaseDataByUserId total time " + (time2 - time1));
        return "00";
    }

    public String getFengkongBlackList() {
        try {
            Thread.sleep(600);
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "1111111111111");

        } catch (Exception e) {

        }
        return "1";
    }

    public String getYaxinPhoneBlackList() {
        try {
            Thread.sleep(600);
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "2222222222222");

        } catch (Exception e) {

        }
        return "2";

    }

    public String getYingyanPhoneBlackList() {
        try {
            Thread.sleep(600);
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "3333333333333");
        } catch (Exception e) {

        }
        return "3";

    }

    public String getMonthLabelData() {
        try {
            Thread.sleep(6000);
            System.out.println(Thread.currentThread().getName() + Thread.currentThread().getId() + "44444444444444");

        } catch (Exception e) {

        }
        return "4";

    }


    public String testTry2021() {
        int corePoolSize = 300;   // 核心线程数
        int maximumPoolSize = 700; //最大线程数
        int queueSize = 1000;       //队列容量
        String result = "";
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(queueSize), new ThreadPoolExecutor.CallerRunsPolicy());
        try {
            //定时逻辑计时
            Future<String> future = executor.submit(() ->
                    {
                        //主逻辑
                        return testTry2011();
                    }
            );

            //设置超时时间，未超时返回
            result = future.get(20500, TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            return "-2";
        }
        return "-1";
    }


    @Test
    public void testTry203() {
        String s = testTry2021();
        System.out.println(s);
    }

    @Test
    public void testTry204() {
        String str = "12-34";
        System.out.println(str.substring(2));
        String time = "20210821";
        String day = time.substring(time.length() - 2);
        System.out.println(day);

        String phone = "13138190955";
        System.out.println(phone.substring(2));
    }

    @Test
    public void testTry205() {
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("5");
        String phone = "1313819095,-";
        phone = phone.replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "");
        System.out.println(phone);
        System.out.println(Integer.parseInt(phone.substring(phone.length() - 1)) % 2);
        System.out.println(list.contains(phone.substring(phone.length() - 1)));

        for (int i = 0; i < 10; i++) {
            System.out.println("i=" + i + (i % 2));

        }
        String svcNumber = "1313819095,-";

        if (Integer.parseInt(svcNumber.substring(svcNumber.length() - 1).replaceAll("[\\pP+~$`^=|<>～｀＄＾＋＝｜＜＞￥×]", "")) % 2 == 0) {
            System.out.println("1");
        } else {
            System.out.println("2");

        }
    }

    @Test
    public void testTry206() {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("2");
        list.add("3");
        System.out.println(list.toString());
        list = (List) list.stream().distinct().collect(Collectors.toList());
        System.out.println(list.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    @Test
    public void testTry27() {
        List<User> list = new ArrayList<>();
        Set set = new TreeSet();
        Set set2 = new HashSet();

        for (int i = 0; i < 100; i++) {
            User User = new User();
            User.setCode(String.valueOf(i));
            list.add(User);
            set.add(User.getCode());
            set2.add(User.getCode());

        }
      /*  for (User user : list) {
            System.out.println(user);
        }*/


        System.out.println("1111111111111");
        list.stream().forEach(x -> System.out.println(x));
        System.err.println("2222222222222");

        set.stream().forEach(x -> System.out.println(Thread.currentThread().getName() + "========" + x));
        System.err.println("3333333333333");

        set2.stream().forEach(x -> System.out.println("-------------" + x));
        Map feebackcodeMap = new HashMap();
        feebackcodeMap.put("01", "手机号码号+服务密码");
        feebackcodeMap.put("02", "固话");
        feebackcodeMap.put("03", "ADSL");
        feebackcodeMap.put("04", "WLAN");
        feebackcodeMap.put("05", "邮箱");
        feebackcodeMap.put("06", "短信验证码登录");
        feebackcodeMap.put("", "");

    }

    //生成01-06的随机数
    @Test
    public void testTry28() {
        for (int i = 0; i < 100; i++) {
            int random = (int) ((Math.random() * 6 + 1));
            System.out.println(String.valueOf("0" + random));
        }

    }

    //map 转 字符串
    public String getMapToString(Map<String, Object> map) {
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(String.valueOf(map.get(keyArray[i])).trim());
            }
            if (i != keyArray.length - 1) {
                sb.append("|");
            }
        }
        return sb.toString();
    }

    //字符串转map
    public Map<String, Object> getStringToMap2(String str) {
        //根据逗号截取字符串数组
        String[] str1 = str.split(",");
        //创建Map对象
        Map<String, Object> map = new HashMap<String, Object>();
        //循环加入map集合
        for (int i = 0; i < str1.length; i++) {
            //根据":"截取字符串数组
            String[] str2 = str1[i].split(":");
            //str2[0]为KEY,str2[1]为值
            map.put(str2[0], str2[1]);
        }
        return map;
    }

    @Test
    public void testTry29() {
        Map map = new HashMap();
        Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date(now.getTime()));
        map.put("20210910", "110,112,119");
        map.put("20210911", "222,333");
        String mapToString = getMapToString(map);
        System.out.println("map转字符串-->" + mapToString);
        String[] split = mapToString.split("\\|");
        System.out.println(split.length);
        Map resultMap = new HashMap();
        Set resultSet = new HashSet();
        for (int i = 0; i < split.length; i++) {
            String dayInfo = split[i];
            String day = dayInfo.split(":")[0];
            String dayData = dayInfo.split(":")[1];
            System.out.println("day=" + day + "====dayData" + dayData);
            resultMap.put(day, dayData);
            String[] data = dayData.split(",");
            for (int j = 0; j < data.length; j++) {
                resultSet.add(data[j]);

            }
        }
        //获取对应信息
        //获取 近30日的绑定手机号数量 (去重)
        System.out.println("近30日绑定手机数量为" + resultSet.size());
        if (resultMap.containsKey(today)) {
            String dayData = (String) resultMap.get(today);
            dayData = dayData + "," + "131";
            resultMap.put(today, dayData);
        } else {
            resultMap.put(today, "132");
        }
        String mapToString2 = getMapToString(resultMap);
        System.err.println("map2转字符串-->" + mapToString2);
    }

    @Test
    public void testTry30() {
        Map map = new HashMap();
        Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date(now.getTime()));
        map.put("20210910", "110,112,119");
        map.put("20210911", "222,333");
        JSONObject jsonObject = new JSONObject(map);
        String jsonObjectStr = jsonObject.toString().toString();
        System.out.println(jsonObject.toString());

        //字符串转map
        Object parse = JSONObject.parse("{}");
        Map map1 = (Map) parse;
        for (Object str : map1.keySet()) {
            System.err.println(str);
        }
    }

    @Test
    public void testTry31() {
        //List
        Set set = new HashSet();
        set.add("110");
        set.add("120");
        System.out.println(set.contains("120"));
        String trim = set.toString().replace("[", "").replace("]", "").replace(" ", "").trim();

        System.out.println(trim);
        String[] split = trim.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
    }


    /* @Test
     public void testTry32(){
        // Timestamp ts = new Timestamp(System.currentTimeMillis());
         String tsStr = "2011-05-09 11:49:45";
         try {
             Timestamp ts = Timestamp.valueOf(tsStr);
             System.out.println(ts);
         } catch (Exception e)
             e.printStackTrace();
         }
         System.out.println(("123".getBytes()));
     }*/
    @Test
    public void testTry33() {
        //List
        Set set = new HashSet();
        set.add("110");
        set.add("120");
        System.out.println(set.contains("120"));
        String trim = set.toString().replace("[", "").replace("]", "");

        System.out.println(trim);
        String[] split = trim.split(",");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);//jd1k11引入了.strip()
        }
    }

    public String changeJsonToArguments2(JSONObject argument) {
        Set<String> keys = argument.keySet();
        for (String key : keys) {
            String value = argument.getString(key);
            argument.put(key, urlEncoderText(value));
        }
        String one = argument.toString();
        String two = "?" + one.substring(1, one.length() - 1).replace(",", "&").replace(":", "=").replace("\"", "");
        return two;
    }

    public String urlEncoderText2(String text) {
        String result = "";
        try {
            result = java.net.URLEncoder.encode(text, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public void testTry34() {
        Map map = new HashMap();
        String str = "";
        for (int i = 0; i < 3000; i++) {
            String j = "";
            if (str.length() > 11) {
                j = str.substring(str.length() - 11) + i;
            } else {
                j = "12345678" + i;
            }
            str = str + "," + j;
        }

        map.put("imei", str);
        System.out.println(map);
        System.out.println(str.split(",").length);
    }

    @Test
    public void testTry35() {
        String str = "12345678910111";
        System.out.println(str.substring(str.length() - 11));

        Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        String time = new SimpleDateFormat("yyyyMMdd").format(new Date(now.getTime() - 30 * 24 * 60 * 60 * 1000L));
        System.out.println(time);
    }

    @Test
    public void testTry36() {
        Map map = new HashMap();
        map.put("123", "1234");
        // map.


    }

    private String getToken(HashMap<String, String> headinnermap, String appSecret) {
        String tokenStr = "APP_ID" + headinnermap.get("APP_ID") + "TIMESTAMP" + headinnermap.get("TIMESTAMP") + "TRANS_ID" + headinnermap.get("TRANS_ID") + appSecret;
        String encrypt = MD5Util.encrypt(tokenStr);
        //logger.info("Token" + tokenStr + "      ---     Token MD5" + encrypt);
        System.out.println("Token=" + tokenStr + "---Token MD5=" + encrypt);
        return encrypt;
    }

    /**
     * 能力平台  鉴权
     */
    @Test
    public void testTry37() {
        HashMap<String, String> map = new HashMap();
        map.put("APP_ID", "jIlt3ukg3C");
      /*  map.put("TIMESTAMP", "2021-10-11 11:04:34 924");2021-09-29 15:57:20 161
        map.put("TRANS_ID", "20211011110434924234654");//20210929155720161463775*/
    /*  map.put("TIMESTAMP", "2021-09-29 15:57:20 161");
        map.put("TRANS_ID", "20210929155720161463775");*/
       /* map.put("TIMESTAMP", "2021-10-11 14:29:16 436");
        map.put("TRANS_ID", "20211011142916436283334");*/
       /* map.put("TIMESTAMP", "2021-10-11 14:29:16 436");
        map.put("TRANS_ID", "20211011142916436283334");*/


        map.put("TIMESTAMP", "2021-09-29 15:57:20 161");
        map.put("TRANS_ID", "20210929155720161463775");
        String appSecret = "yAKN1dLwRPTtMXjRTtpMM1VBWnHLIhTU";//"mf4DxOj3ceyfrN7pGvgypSmKfn1WcCON";//"9UjPPxVaG9TWZdftBA1ez0j7NqoCNnMF";// "mf4DxOj3ceyfrN7pGvgypSmKfn1WcCON";
        String token = getToken(map, appSecret);
        System.out.println(token);
        // map.


    }

    @Test
    public void testTry38() {
        net.sf.json.JSONObject reqNLPTJson = new net.sf.json.JSONObject();


        net.sf.json.JSONObject reqNLPTJsonBody = new net.sf.json.JSONObject();
        //UNI_BSS_ATTACHED
        net.sf.json.JSONObject reqNLPTJsonAttached = new net.sf.json.JSONObject();
        reqNLPTJsonAttached.put("MEDIA_INFO", "");
        HashMap<String, String> informationInquiryReqMap = new HashMap<>();
        //1.获取请求报文
        String phone = "";// requestJson.containsKey("phone") ? requestJson.get("phone").toString() : "";
        //2.拼装请求报文
        //a.拼装head部分
        //reqNLPTJsonHeadMap.put("APP_ID", appId);
        //reqNLPTJsonHeadMap.put("TIMESTAMP", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS").format(new Date()));
        //reqNLPTJsonHeadMap.put("TRANS_ID", new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + (int) ((Math.random() * 9 + 1) * 100000));
        //String token = getToken(reqNLPTJsonHeadMap, appSecret);
        // reqNLPTJsonHeadMap.put("TOKEN", token);
        //reqNLPTJson.put("UNI_BSS_HEAD", reqNLPTJsonHeadMap);
        //b.拼装body部分
        informationInquiryReqMap.put("phone", phone);
        reqNLPTJsonBody.put("INFORMATION_INQUIRY_REQ", informationInquiryReqMap);
        reqNLPTJson.put("UNI_BSS_BODY", reqNLPTJsonBody);
        reqNLPTJson.put("UNI_BSS_ATTACHED", reqNLPTJsonAttached);

        System.out.println("reqNLPTJson===>>" + reqNLPTJson);
    }

    /**
     * 字符串转json
     */
    @Test
    public void testTry39() {
        String jsonStr = "{\"result\":\"0\",\"resp_type\":\"1\",\"resp_code\":\"0\",\"level\":\"1\",\"lasttime\":\"20211015152043\",\"flag\":\"0x8091\"}";
        JSONObject jsonObject = JSONObject.parseObject(jsonStr);
        System.out.println(jsonObject);
    }

    /**
     * 字符串 转时间格式
     */
    @Test
    public void testTry40() throws ParseException {
        //2021 10 15 15 20 43
        String str = "20211015152043";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));
        String format = simpleDateFormat2.format(simpleDateFormat.parse(str));
        System.out.println(format);


    }

    @Test
    public void testTry41() {
        String str = "123";
        //"str.contains()".equals()
        String format = TimestampUtils.format(TimestampUtils.addDays(new Date(), -1), TimestampUtils.DATE2);
        System.out.println(format);


    }

    @Test
    public void testTry42() {
        ArrayList userActionBlackUserList = new ArrayList<>();
        //获取近7日时间
        List<String> aimTimeList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();
        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
        for (int i = 0; i < 7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            aimTimeList.add(aimTime);
        }
        System.out.println(aimTimeList);
    }


    //  将报文转换为jsonObject,并从中获取有效信息并返回
    @Test
    public void testTry43() {
        String str = "{\n" +
                "    \"UNI_BSS_ATTACHED\": {\n" +
                "        \"MEDIA_INFO\": \"\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\": {\n" +
                "        \"INFORMATION_INQUIRY_RSP\": [\n" +
                "            {\n" +
                "                \"code\": \"1\",\n" +
                "                \"13138190957_message\": {\n" +
                "                    \"latitude\": \"39.790831212\",\n" +
                "                    \"updata_time\": \"2021-10-26 10:00:08\",\n" +
                "                    \"longitude\": \"116.507806295\"\n" +
                "                },\n" +
                "                \"messages\": \"成功\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"UNI_BSS_HEAD\": {\n" +
                "        \"RESP_DESC\": \"Success\",\n" +
                "        \"APP_ID\": \"jIlt3ukg3C\",\n" +
                "        \"RESP_CODE\": \"A0000\",\n" +
                "        \"TIMESTAMP\": \"2021-10-26 10:19:02 897\",\n" +
                "        \"TRANS_ID\": \"20211026101902897946161\"\n" +
                "    }\n" +
                "}";
        //System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject);
        //UNI_BSS_BODY
        JSONObject uniBssHead = jsonObject.getJSONObject("UNI_BSS_HEAD");
        String transId = uniBssHead.getString("TRANS_ID");
        System.out.println(uniBssHead.getString("RESP_CODE"));
        String code = "1";//1代表失败,0代表成功
        String message = "";
        String longitude = "";
        String latitude = "";
        String updata_time = "";
        if ("00000".equals(uniBssHead.getString("RESP_CODE"))) {
            JSONObject uniBssBody = jsonObject.getJSONObject("UNI_BSS_BODY");
            //String INFORMATION_INQUIRY_RSP = uniBssBody.getString("code");
            //JSONObject informationInquiryRsp = uniBssBody.getJSONObject("INFORMATION_INQUIRY_RSP");
            JSONArray informationInquiryRspArr = uniBssBody.getJSONArray("INFORMATION_INQUIRY_RSP");
            JSONObject informationInquiryRsp = (JSONObject) informationInquiryRspArr.get(0);
            code = informationInquiryRsp.getString("code");
            System.out.println(code);
            message = informationInquiryRsp.getString("messages");
            System.out.println(message);
            if ("0".equals(code)) {
                for (String key : informationInquiryRsp.keySet()) {
                    if (key.contains("_message")) {
                        JSONObject _messageJsonObj = informationInquiryRsp.getJSONObject(key);
                        longitude = _messageJsonObj.getString("longitude");
                        latitude = _messageJsonObj.getString("latitude");
                        updata_time = _messageJsonObj.getString("updata_time");
                        System.out.println(longitude);
                        System.out.println(latitude);
                        System.out.println(updata_time);

                    }
                }
            }
        }
        //封装响应报文
        JSONObject responseJsonObj = new JSONObject();
        responseJsonObj.put("transId", transId);
        responseJsonObj.put("code", code);
        responseJsonObj.put("message", message);
        responseJsonObj.put("longitude", longitude);
        responseJsonObj.put("latitude", latitude);
        responseJsonObj.put("updataTime", updata_time);
        System.out.println(responseJsonObj.toString());
        //System.out.println(code);
        //uniBssBody.get
    }


    @Test
    public void testTry44() {
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("null"));
        System.out.println(StringUtils.isBlank(null));


    }

    //  将报文转换为jsonObject,并从中获取有效信息并返回
    @Test
    public void testTry45() {
        String str = "{\n" +
                "    \"UNI_BSS_HEAD\": {\n" +
                "        \"RESP_DESC\": \"Success\",\n" +
                "        \"TRANS_ID\": \"20211027151956389485308\",\n" +
                "        \"TIMESTAMP\": \"2021-10-27 15:19:56 389\",\n" +
                "        \"RESP_CODE\": \"00000\",\n" +
                "        \"APP_ID\": \"jIlt3ukg3C\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\": {\n" +
                "        \"IP_LOCATION_RSP\": {\n" +
                "            \"status\": \"1\",\n" +
                "            \"info\": \"OK\",\n" +
                "            \"infocode\": \"10000\",\n" +
                "            \"province\": \"天津市\",\n" +
                "            \"city\": \"天津市\",\n" +
                "            \"adcode\": \"120000\",\n" +
                "            \"rectangle\": \"116.9334447,38.91360118;117.4980283,39.34728312\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject);
        //UNI_BSS_BODY
        JSONObject uniBssHead = jsonObject.getJSONObject("UNI_BSS_HEAD");
        String transId = uniBssHead.getString("TRANS_ID");
        System.out.println(uniBssHead.getString("RESP_CODE"));
        JSONObject informationInquiryRsp = null;
        if ("00000".equals(uniBssHead.getString("RESP_CODE"))) {
            JSONObject uniBssBody = jsonObject.getJSONObject("UNI_BSS_BODY");
            //JSONArray informationInquiryRspArr = uniBssBody.getJSONArray("IP_LOCATION_RSP");
            //JSONObject informationInquiryRsp = (JSONObject) informationInquiryRspArr.get(0);
            informationInquiryRsp = uniBssBody.containsKey("IP_LOCATION_RSP") ? uniBssBody.getJSONObject("IP_LOCATION_RSP") : null;
            if (informationInquiryRsp != null) {
                informationInquiryRsp.put("transId", transId);
                System.out.println(informationInquiryRsp);
            }
        }


    }


    @Test
    public void testTry46() {
        /**
         *
         * {
         *     "province":"天津市",
         *     "city":"天津市",
         *     "adcode":"120000",
         *     "transId":"20211027151956389485308",
         *     "infocode":"10000",
         *     "rectangle":"116.9334447,38.91360118;117.4980283,39.34728312",
         *     "status":"1",
         *     "info":"OK"
         * }
         */
        com.alibaba.fastjson.JSONObject responseJsonObj = new com.alibaba.fastjson.JSONObject();
        //responseJsonObj.put("transId", transId);
        responseJsonObj.put("province", "");
        responseJsonObj.put("city", "");
        responseJsonObj.put("adcode", "");
        responseJsonObj.put("infocode", "");
        responseJsonObj.put("rectangle", "");
        responseJsonObj.put("status", "0");
        responseJsonObj.put("info", "");
    }


    //  将报文转换为jsonObject,并从中获取有效信息并返回
    @Test
    public void testTry48() {
        String str = "{\n" +
                "    \"UNI_BSS_HEAD\": {\n" +
                "        \"RESP_DESC\": \"Success\",\n" +
                "        \"TRANS_ID\": \"20211028102948271360796\",\n" +
                "        \"TIMESTAMP\": \"2021-10-28 10:29:48 271\",\n" +
                "        \"RESP_CODE\": \"00000\",\n" +
                "        \"APP_ID\": \"jIlt3ukg3C\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\": {\n" +
                "        \"GEOCODING_RSP\": {\n" +
                "            \"status\": \"1\",\n" +
                "            \"info\": \"OK\",\n" +
                "            \"infocode\": \"10000\",\n" +
                "            \"count\": \"1\",\n" +
                "            \"geocodes\": [\n" +
                "                {\n" +
                "                    \"formatted_address\": \"河北省石家庄市长安区西古城\",\n" +
                "                    \"country\": \"中国\",\n" +
                "                    \"province\": \"河北省\",\n" +
                "                    \"citycode\": \"0311\",\n" +
                "                    \"city\": \"石家庄市\",\n" +
                "                    \"district\": \"长安区\",\n" +
                "                    \"township\": [],\n" +
                "                    \"neighborhood\": {\n" +
                "                        \"name\": [],\n" +
                "                        \"type\": []\n" +
                "                    },\n" +
                "                    \"building\": {\n" +
                "                        \"name\": [],\n" +
                "                        \"type\": []\n" +
                "                    },\n" +
                "                    \"adcode\": \"130102\",\n" +
                "                    \"street\": [],\n" +
                "                    \"number\": [],\n" +
                "                    \"location\": \"114.530895,38.089906\",\n" +
                "                    \"level\": \"村庄\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject);
        //UNI_BSS_BODY
        JSONObject uniBssHead = jsonObject.getJSONObject("UNI_BSS_HEAD");
        String transId = uniBssHead.getString("TRANS_ID");
        System.out.println(uniBssHead.getString("RESP_CODE"));

        JSONObject informationInquiryRsp = null;
        if ("00000".equals(uniBssHead.getString("RESP_CODE"))) {
            JSONObject uniBssBody = jsonObject.getJSONObject("UNI_BSS_BODY");
            informationInquiryRsp = uniBssBody.containsKey("GEOCODING_RSP") ? uniBssBody.getJSONObject("GEOCODING_RSP2") : null;
        }
        if (informationInquiryRsp != null) {
            informationInquiryRsp.put("transId", transId);
            System.out.println(informationInquiryRsp);
        } else {
            com.alibaba.fastjson.JSONObject responseJsonObj = new com.alibaba.fastjson.JSONObject();
            responseJsonObj.put("transId", !StringUtils.isBlank(transId) ? transId : "");
            responseJsonObj.put("count", "");
            responseJsonObj.put("infocode", "");
            responseJsonObj.put("geocodes", new ArrayList<>());
            responseJsonObj.put("status", "0");
            responseJsonObj.put("info", "");
            informationInquiryRsp = responseJsonObj;
        }
        System.err.println(informationInquiryRsp);

    }

    //  将报文转换为jsonObject,并从中获取有效信息并返回
    @Test
    public void testTry49() {
        String str = "{\n" +
                "    \"UNI_BSS_HEAD\": {\n" +
                "        \"RESP_DESC\": \"Success\",\n" +
                "        \"TRANS_ID\": \"20211028110410554265798\",\n" +
                "        \"TIMESTAMP\": \"2021-10-28 11:04:10 554\",\n" +
                "        \"RESP_CODE\": \"00000\",\n" +
                "        \"APP_ID\": \"jIlt3ukg3C\"\n" +
                "    },\n" +
                "    \"UNI_BSS_BODY\": {\n" +
                "        \"INVERSE_GEOCODING_RSP\": {\n" +
                "            \"status\": \"1\",\n" +
                "            \"regeocode\": {\n" +
                "                \"addressComponent\": {\n" +
                "                    \"city\": [],\n" +
                "                    \"province\": \"重庆市\",\n" +
                "                    \"adcode\": \"500112\",\n" +
                "                    \"district\": \"渝北区\",\n" +
                "                    \"towncode\": \"500112012000\",\n" +
                "                    \"streetNumber\": {\n" +
                "                        \"number\": \"16号\",\n" +
                "                        \"location\": \"106.465819,29.626203\",\n" +
                "                        \"direction\": \"东南\",\n" +
                "                        \"distance\": \"458.382\",\n" +
                "                        \"street\": \"华山南路\"\n" +
                "                    },\n" +
                "                    \"country\": \"中国\",\n" +
                "                    \"township\": \"大竹林街道\",\n" +
                "                    \"businessAreas\": [\n" +
                "                        []\n" +
                "                    ],\n" +
                "                    \"building\": {\n" +
                "                        \"name\": [],\n" +
                "                        \"type\": []\n" +
                "                    },\n" +
                "                    \"neighborhood\": {\n" +
                "                        \"name\": [],\n" +
                "                        \"type\": []\n" +
                "                    },\n" +
                "                    \"citycode\": \"023\"\n" +
                "                },\n" +
                "                \"formatted_address\": \"重庆市渝北区大竹林街道大农路\"\n" +
                "            },\n" +
                "            \"info\": \"OK\",\n" +
                "            \"infocode\": \"10000\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //System.out.println(str);
        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject);
        //UNI_BSS_BODY
        JSONObject uniBssHead = jsonObject.getJSONObject("UNI_BSS_HEAD");
        String transId = uniBssHead.getString("TRANS_ID");
        System.out.println(uniBssHead.getString("RESP_CODE"));

        JSONObject informationInquiryRsp = null;
        if ("00000".equals(uniBssHead.getString("RESP_CODE"))) {
            JSONObject uniBssBody = jsonObject.getJSONObject("UNI_BSS_BODY");
            informationInquiryRsp = uniBssBody.containsKey("INVERSE_GEOCODING_RSP") ? uniBssBody.getJSONObject("INVERSE_GEOCODING_RSP2") : null;
        }
        if (informationInquiryRsp != null) {
            informationInquiryRsp.put("transId", transId);
            System.out.println(informationInquiryRsp);
        } else {
            com.alibaba.fastjson.JSONObject responseJsonObj = new com.alibaba.fastjson.JSONObject();
            responseJsonObj.put("transId", !StringUtils.isBlank(transId) ? transId : "");
            responseJsonObj.put("infocode", "");
            responseJsonObj.put("regeocode", new ArrayList<>());
            responseJsonObj.put("status", "0");
            responseJsonObj.put("info", "");
            informationInquiryRsp = responseJsonObj;
        }
        System.err.println(informationInquiryRsp);

    }

    public void perm(char[] buf, int start, int end) {
        if (start == end) {//当只要求对数组中一个字母进行全排列时，只要就按该数组输出即可
            for (int i = 0; i <= end; i++) {
                System.out.print(buf[i]);
            }
            System.out.println();
        } else {//多个字母全排列
            for (int i = start; i <= end; i++) {
                char temp = buf[start];//交换数组第一个元素与后续的元素
                buf[start] = buf[i];
                buf[i] = temp;
                perm(buf, start + 1, end);//后续元素递归全排列
                temp = buf[start];//将交换后的数组还原
                buf[start] = buf[i];
                buf[i] = temp;
            }
        }


    }

    @Test
    public void testTry50() {
        char buf[] = {'1', '2', '3', '4'};

        perm(buf, 0, buf.length - 1);
    }

    @Test
    public void testTry51() {
        JSONObject obj = new JSONObject();
        String str = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"transId\": \"20211101174436765603606\",\n" +
                "    \"updataTime\": \"2021-11-01 17:24:58\",\n" +
                "    \"latitude\": \"39.790831212\",\n" +
                "    \"message\": \"成功\",\n" +
                "    \"longitude\": \"116.507806295\"\n" +
                "}";
        //System.out.println(str);

        JSONObject parse = (JSONObject) JSONObject.parse(str);
        String code = parse.getString("code");
        System.out.println(code);
        if ("0".equals(code)) {
            if (parse.containsKey("longitude")) {
                System.out.println(parse.getString("longitude"));
            }
            if (parse.containsKey("latitude")) {
                System.out.println(parse.getString("latitude"));
            }
        }
    }

    @Test
    public void testTry52() throws ParseException {
        String str = "2021-06-03 15:43:05.001";
        Timestamp time = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime());
        Timestamp time2 = new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime());
        long time1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();

        System.out.println(time);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        System.out.println(timestamp);
        String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime()));
        System.err.println(data);
    }

    @Test
    public void testTry53() {
        String svcNumber = "";
        String lon;
        String lat;
        String imei;
        Timestamp insertTime;
        Timestamp loginTimeFormat;
        String dataType = "01";//传：01：登录地
        Timestamp reqTime;//发起调“逆地理编码接口”时间
        Timestamp updataTime;//空
        String reqInfo;//1请求报文
        //
        String abilityCode = "";//adcode
        String province = "";
        String city = "";
        String district = "";
        String township = "";
        String formattedAddress = "";
        String rspInfo = "";
        /**
         * 用户号码	svc_number	登录日志中当前用户号码：mobile
         * 登录时间	login_time_format	登录日志中当前用户登录时间：login_time_format
         * IMEI	imei	登录日志中当前用户imei
         * 经度	lon	登录日志中当前用户经度：lon
         * 纬度	lat	登录日志中当前用户纬度：lat
         * 数据类型	data_type	传：01：登录地
         * 能力编码	ability_code	gaode：高德逆地理编码
         * 请求时间	req_time	发起调“逆地理编码接口”时间
         * 格式：YYYY-MM-DD hh:mm:ss
         * 数据更新时间	updata_time	空
         * 数据插入时间	insert_time	数据入表时间
         * 格式：YYYY-MM-DD hh:mm:ss
         * 耗时时间
         * 坐标点所在省	province	高德响应报文：province
         * 坐标点所在城市	city	高德响应报文：city
         * 坐标点所在区	district	高德响应报文：district
         * 坐标点所在乡镇/街道	township	高德响应报文：township
         * 地址信息	formatted_address	高德响应报文：formatted_address
         * 请求报文	req_info	请求能力平台报文
         * 响应报文	rsp_info	能力平台响应报文
         */
        //解析报文
        String str1 = "{\n" +
                "    \"transId\": \"20211103145849614607481\",\n" +
                "    \"infocode\": \"20011\",\n" +
                "    \"status\": \"0\",\n" +
                "    \"info\": \"INSUFFICIENT_ABROAD_PRIVILEGES\"\n" +
                "}";
        String str = "{\n" +
                "    \"transId\": \"20211103144016243845524\",\n" +
                "    \"infocode\": \"10000\",\n" +
                "    \"regeocode\": {\n" +
                "        \"formatted_address\": \"贵州省遵义市仁怀市长岗镇潘家土\",\n" +
                "        \"addressComponent\": {\n" +
                "            \"businessAreas\": [\n" +
                "                []\n" +
                "            ],\n" +
                "            \"country\": \"中国\",\n" +
                "            \"province\": \"贵州省\",\n" +
                "            \"citycode\": \"0852\",\n" +
                "            \"city\": \"遵义市\",\n" +
                "            \"adcode\": \"520382\",\n" +
                "            \"streetNumber\": {\n" +
                "                \"number\": [],\n" +
                "                \"distance\": [],\n" +
                "                \"street\": [],\n" +
                "                \"direction\": []\n" +
                "            },\n" +
                "            \"towncode\": \"520382103000\",\n" +
                // "            \"district\": \"仁怀市\",\n" +
                "            \"neighborhood\": {\n" +
                "                \"name\": [],\n" +
                "                \"type\": []\n" +
                "            },\n" +
                "            \"township\": \"长岗镇\",\n" +
                "            \"building\": {\n" +
                "                \"name\": [],\n" +
                "                \"type\": []\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"status\": \"1\",\n" +
                "    \"info\": \"OK\"\n" +
                "}";
        //System.out.println(str);

        JSONObject responseMessage = (JSONObject) JSONObject.parse(str);
        String status = responseMessage.getString("status");
        if ("1".equals(status)) {
            JSONObject regeocode = responseMessage.getJSONObject("regeocode");
            formattedAddress = regeocode.getString("formatted_address");

            JSONObject addressComponent = regeocode.getJSONObject("addressComponent");
            abilityCode = addressComponent.getString("adcode");
            province = addressComponent.getString("province");
            city = addressComponent.getString("city");
            district = addressComponent.getString("district");
            township = addressComponent.getString("township");

        }
        //输出结果

        System.err.println("abilityCode=" + abilityCode);
        System.err.println("province=" + province);
        System.err.println("city=" + city);
        System.err.println("district=" + district);
        System.err.println("township=" + township);
        System.err.println("formattedAddress=" + formattedAddress);
        System.err.println("rspInfo=" + rspInfo);

    }

    @Test
    public void testTry54() {
        String aimUpdataTime = "";
        String aimLon = "";
        String aimLat = "";
        String str = "{\n" +
                "    \"code\": \"0\",\n" +
                "    \"transId\": \"20211103161531299569964\",\n" +
                "    \"updataTime\": \"2021-11-03 16:00:15\",\n" +
                "    \"latitude\": \"39.790831212\",\n" +
                "    \"message\": \"成功\",\n" +
                "    \"longitude\": \"116.507806295\"\n" +
                "}";

        JSONObject responseMessage = (JSONObject) JSONObject.parse(str);
        String code = responseMessage.getString("code");
        if ("0".equals(code)) {
            aimLon = responseMessage.getString("longitude");
            aimLat = responseMessage.getString("latitude");
            // updataTime = responseMessage.getString("updataTime");
        }
    }

    @Test
    public void testTry55() {
        String svcNumber = "13138190957";
        System.out.println(svcNumber.substring(0, 7));
    }

    @Test
    public void testTry56() {
        String inverseGeocodingResponseStr1 = "{\n" +
                "    \"transId\":\"20211104154718028674321\",\n" +
                "    \"infocode\":\"10000\",\n" +
                "    \"regeocode\":{\n" +
                "        \"formatted_address\":\"黑龙江省哈尔滨市宾县胜利镇小城子屯\",\n" +
                "        \"addressComponent\":{\n" +
                "            \"businessAreas\":[\n" +
                "                [\n" +
                "\n" +
                "                ]\n" +
                "            ],\n" +
                "            \"country\":\"中国\",\n" +
                "            \"province\":\"黑龙江省\",\n" +
                "            \"citycode\":\"0451\",\n" +
                "            \"city\":\"哈尔滨市\",\n" +
                "            \"adcode\":\"230125\",\n" +
                "            \"streetNumber\":{\n" +
                "                \"number\":[\n" +
                "\n" +
                "                ],\n" +
                "                \"distance\":[\n" +
                "\n" +
                "                ],\n" +
                "                \"street\":[\n" +
                "\n" +
                "                ],\n" +
                "                \"direction\":[\n" +
                "\n" +
                "                ]\n" +
                "            },\n" +
                "            \"towncode\":\"230125106000\",\n" +
                "            \"district\":\"宾县\",\n" +
                "            \"neighborhood\":{\n" +
                "                \"name\":[\n" +
                "\n" +
                "                ],\n" +
                "                \"type\":[\n" +
                "\n" +
                "                ]\n" +
                "            },\n" +
                "            \"township\":\"胜利镇\",\n" +
                "            \"building\":{\n" +
                "                \"name\":[\n" +
                "\n" +
                "                ],\n" +
                "                \"type\":[\n" +
                "\n" +
                "                ]\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"status\":\"1\",\n" +
                "    \"info\":\"OK\"\n" +
                "}";
        String inverseGeocodingResponseStr = "{\"transId\":\"20211104154718028674321\",\"infocode\":\"10000\",\"regeocode\":{\"formatted_address\":\"黑龙江省哈尔滨市宾县胜利镇小城子屯\",\"addressComponent\":{\"businessAreas\":[[]],\"country\":\"中国\",\"province\":\"黑龙\n" +
                "江省\",\"citycode\":\"0451\",\"city\":\"哈尔滨市\",\"adcode\":\"230125\",\"streetNumber\":{\"number\":[],\"distance\":[],\"street\":[],\"direction\":[]},\"towncode\":\"230125106000\",\"district\":\"宾县\",\"neighborhood\":{\"name\":[],\"type\":[]},\"township\":\"胜利镇\",\"building\":{\"name\":[],\"type\":[]}}},\"status\":\"1\",\"info\":\"OK\"}";
        JSONObject inverseGeocodingResponse = (JSONObject) JSONObject.parse(inverseGeocodingResponseStr);
        String status = inverseGeocodingResponse.getString("status");
        if ("1".equals(status)) {
            JSONObject regeocode = inverseGeocodingResponse.getJSONObject("regeocode");
            //formattedAddress = regeocode.getString("formatted_address");
            JSONObject addressComponent = regeocode.getJSONObject("addressComponent");
            //abilityCode = addressComponent.getString("adcode");
            String province = addressComponent.getString("province2") == null ? "" : addressComponent.getString("province2").replace("\n", "");
            System.err.println(province);
            String city = addressComponent.getString("city");
            System.out.println(city);

            //district = addressComponent.getString("district");
            // township = addressComponent.getString("township");
        }

    }

    @Test
    public void testTry57() {
        String text = null;

    }

    /**
     * not 字段 like any  和 字段 not like any
     */
    @Test
    public void testTry58() {
        String[] str = new String[]{"1", "2", "3", "4", "5", "6", "7"};

        List<String> strList = Arrays.asList(str);
        String[] aim = new String[]{"1", "2", "3"};

        List<String> aimList = Arrays.asList(str);
        // System.out.println(strList);

        for (String value : strList) {
            // not 字段 like any
            if (!(value == "1" || value == "2" || value == "3")) {
                System.out.println(value);
            }
            //字段 not like any
            if (value != "1" || value != "2" || value != "3") {

                System.err.println(value);

            }
        }

    }

    @Test
    public void testTry59() {
        String date = "";

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String loginTime = "1638180227871";//"1637824794638.403809";
        if (loginTime.contains(".")) {
            int i = loginTime.indexOf(".");
            date = format.format(new Date(Long.parseLong(loginTime.substring(0, i))));
        } else {
            //date = format.format(new Date(Long.parseLong(loginTime)));
            date = format.format(new Date(Long.parseLong(loginTime)));

        }

        System.out.println(date);
    }

    @Test
    public void testTry60() {
        String userJson = "[{'isDeveloper':false,'name':'xiaoqiang','age':26,'email':'578570174@qq.com'}," +
                "{'isDeveloper':true," +
                "'name':'xiaoqiang123'," +
                "'age':27," +
                "'email':'578570174@gmail.com'}]";

        Gson gson = new Gson();
        Type userListType = new TypeToken<ArrayList<User>>() {
        }.getType();

        List<User> userList = gson.fromJson(userJson, userListType);
        for (Object o : userList
        ) {
            System.out.println(o.toString());
        }
    }

    @Test
    public void testTry61() {
        Integer i = 1000;
        new ThreadLocal<>();
        System.out.println(i);
    }

    @Test
    public void testTry62() {
        int n = 2;

        for (int i = 0; i < 10; i++) {
            n = ++n;
            System.err.println(n);

        }

        System.out.println(n);
        System.out.println("---" + n++);

    }

    @Test
    public void testTry63() {
        int i = 2;
        System.out.println(i++);
        int j = 2;
        System.err.println(++j);

        //-23   11101001  11101000
        //76 01001100


    }

    /**
     * 1636424371947.389160    53826-03-24 05:32:27
     * 1633363190850.029053    53729-03-21 21:27:30
     * 1633363188610            2021-10-04 23:59:48
     * <p>
     * 1633363190850           2021-10-04 23:59:50
     */
    @Test
    public void testTry64() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String date = "";
        //1633363188610
        //1633363190850.029053
        String time = "1633363190850.029053";//"1636424371947.389160";
        if (time.contains(".")) {
            int i = time.indexOf(".");
            System.out.println("--====-" + i);

            date = format.format(new Date(Long.parseLong(time.substring(0, i))));
            System.out.println("---" + date);
        } else {
            date = format.format(new Date(Long.parseLong(time)));
        }

        System.out.println(date);
    }

    @Test
    public void testTry65() {
        List<CommonConfigData> saveHbaseFlagList = null;
        CommonConfigData commonConfigData = saveHbaseFlagList == null ? new CommonConfigData() : saveHbaseFlagList.get(0);
        System.out.println("LEVEL6_BLACK_TASK_SAVE_HBASE_FLAG response :" + commonConfigData);

        System.out.println("LEVEL6_BLACK_TASK_SAVE_HBASE_FLAG response :" + commonConfigData.getConfigValue());
    }

    @Test
    public void testTry66() {
    /*    ArrayList<Object> arrList = new ArrayList<>(2);
        arrList.add(1);
        arrList.add(1);
        arrList.add(1);
        System.out.println(arrList);
        System.out.println(arrList.hashCode());
        arrList.add(1);
        System.out.println(arrList.hashCode());*/

/*
        int i =100;
        System.out.println(i>>1);*/

/*        int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
        System.err.println(MAX_ARRAY_SIZE);
        System.out.println(Integer.MAX_VALUE);*/
        ArrayList<Object> arrList = new ArrayList<>(12);
        arrList.add(1);
        arrList.add(2);
        arrList.add(3);
        arrList.remove(null);
        System.out.println(arrList.size());

    }


    @Test
    public void testTry67() {
        List<String> list = new ArrayList<String>();
        //CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("b");
        list.add("a");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            // list.remove(str);
            if (str.equals("a")) {
                list.remove(str);
            } else {
                System.out.println(str);
            }
        }
    }

    @Test
    public void testTry68() {
        List<String> list = new ArrayList<String>();
        //CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        // list.add("a");
        // list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String str = (String) iterator.next();
            if (str.equals("d")) {
                list.remove(str);
            } else {
                System.out.println(str);
            }
        }
    }

    @Test
    public void testTry69() {
        List<String> list = new ArrayList<String>();
        //CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        // list.add("a");
        // list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

    }


    @Test
    public void testTry70() {
        String str = new String("[]111");
        System.out.println(str);
        System.out.println(str.replace("[", "").replace("]", ""));
        String provin = "上海市";
        String city = "";
        if (provin.contains("市")) {
            city = provin;
        }
        System.out.println(city);

    }

    private String formatString(String str) {
        return str == null ? "" : str.replace("\n", "").replace("[", "").replace("]", "");
    }

    @Test
    public void testTry71() {
        JSONObject inverseGeocodingResponse = JSON.parseObject("{\"transId\":\"20211111132523410329888\",\"infocode\":\"10000\",\"regeocode\":{\"formatted_address\":\"北京市朝阳区高碑店乡艺考蜂东亿国际传媒产业园\",\"addressComponent\":{\"businessAreas\":[{\"name\":\"高碑店村\",\"location\":\"116.531484,39.899875\",\"id\":\"110105\"},{\"name\":\"定福庄\",\"location\":\"116.557135,39.916800\",\"id\":\"110105\"}],\"country\":\"中国\",\"province\":\"北京市\",\"citycode\":\"010\",\"city\":[],\"adcode\":\"110105\",\"streetNumber\":{\"number\":\"27号院\",\"distance\":\"105.128\",\"street\":\"建国路\",\"location\":\"116.541440,39.912514\",\"direction\":\"东南\"},\"towncode\":\"110105222000\",\"district\":\"朝阳区\",\"neighborhood\":{\"name\":[],\"type\":[]},\"township\":\"高碑店乡\",\"building\":{\"name\":[],\"type\":[]}}},\"status\":\"1\",\"info\":\"OK\"}\n");
        //JSONObject json = new JSONObject();
        //JSONObject inverseGeocodingResponse = (JSONObject) JSONObject.parse(inverseGeocodingResponseStr);
        String status = inverseGeocodingResponse.getString("status");
        if ("1".equals(status)) {
            JSONObject regeocode = inverseGeocodingResponse.getJSONObject("regeocode");
            JSONObject addressComponent = regeocode.getJSONObject("addressComponent");
            String province = formatString(addressComponent.getString("province"));
            System.out.println(province);

            String city = formatString(addressComponent.getString("city"));
            System.err.println(city);
            if (province.contains("市")) {
                city = province;
            }
            System.err.println(city);
        }

    }

    @Test
    public void testTry72() {
        String[] str = new String[]{"1", "2", "3"};
        System.err.println(str);

        String[] strings = Arrays.copyOf(str, 1);
        List<String> strings1 = Arrays.asList(strings);
        System.err.println(strings1);
        strings1.stream().forEach(x -> System.out.println(x = x + "---"));
        System.out.println(strings1);
    }

    public void test1(HashMap<String, String> map) {
        map.put("key1", "01");
    }

    public void test2(HashMap<String, String> map) {
        map.put("key2", "02");
    }

    public void test3(HashMap<String, String> map) {
        map.put("key3", "03");
    }

    @Test
    public void testTry73() {
        HashMap<String, String> map = new HashMap<String, String>();
        test1(map);
        test2(map);
        test3(map);
        for (String key : map.keySet()) {
            System.out.println(key + "---" + map.get(key));
        }

    }

    public void test4(String str) {
        str += "1";
    }

    public void test5(String str) {
        str += "2";
    }

    public void test6(String str) {
        str += "3";
    }

    @Test
    public void testTry74() {
        String str = "-";
        test4(str);
        test5(str);
        test6(str);

        System.out.println(str);


    }

    public String test7(String str) {
        str += "1";
        return str;
    }

    public String test8(String str) {
        str += "2";
        return str;
    }

    public String test9(String str) {
        str += "3";
        return str;
    }

    @Test
    public void testTry75() {
        String str = "-";
        str = test7(str);
        str = test8(str);
        str = test9(str);

        System.out.println(str);


    }


    @Test
    public void testTry76() {
        String str = "19";
        switch (str) {
            case "17":
                System.out.println("17");
                break;
            case "18":
                System.out.println("18");
                break;

            default:
                System.out.println("查無辭職");
        }

    }

    /**
     * 【近30天换机行为】打标	【IMEI黑名单】打标	【实时换机】打标	风控返回编码	风控返回结果
     * 01/02	01	01/02	1	通过
     * 01/02	01	03/05	2	简单验证
     * 01/02	01	04	4	复杂验证
     * 01/02	02/03	01/02	4	复杂验证
     * 01/02	02/03	03/05	4	复杂验证
     * 01/02	02/03	04	5	拒绝
     * 03/04	01	01/02	1	通过
     * 03/04	01	03/05	2	简单验证
     * 03/04	01	04	4	复杂验证
     * 03/04	02/03	01/02	4	复杂验证
     * 03/04	02/03	03/05	4	复杂验证
     * 03/04	02/03	04	5	拒绝
     * 05/06	01	01/02	1	通过
     * 05/06	01	03/05	2	简单验证
     * 05/06	01	04	4	复杂验证
     * 05/06	02/03	01/02	4	复杂验证
     * 05/06	02/03	03/05	4	复杂验证
     * 05/06	02/03	04	5	拒绝
     */
    /**
     * 01/02	01	01/02	1	通过
     * 03/04	01	01/02	1	通过
     * 05/06	01	01/02	1	通过
     * <p>
     * <p>
     * 01/02	01	03/05	2	简单验证
     * 03/04	01	03/05	2	简单验证
     * 05/06	01	03/05	2	简单验证
     * <p>
     * <p>
     * 01/02	02/03	04	5	拒绝
     * 03/04	02/03	04	5	拒绝
     * 05/06	02/03	04	5	拒绝
     * <p>
     * 01/02	01	04	4	复杂验证
     * 01/02	02/03	01/02	4	复杂验证
     * 01/02	02/03	03/05	4	复杂验证
     * 03/04	01	04	4	复杂验证
     * 03/04	02/03	01/02	4	复杂验证
     * 03/04	02/03	03/05	4	复杂验证
     * 05/06	01	04	4	复杂验证
     * 05/06	02/03	01/02	4	复杂验证
     * 05/06	02/03	03/05	4	复杂验证
     */
    @Test
    public void testTry77() {
        long startTime = System.currentTimeMillis();
        //System.out.println(System.currentTimeMillis());
        //打标结果
        String[] imeiArr = new String[]{"01", "02", "03"};
        String[] changeArr = new String[]{"01", "02", "03", "04", "05"};
        String[] historyChangeArr = new String[]{"01", "02", "03", "04", "05", "06"};
        //风控风险级别
        List<String> passList = new ArrayList<>();
        //     01/02	01	01/02	1	通过

        passList.add("01,01,01");
        passList.add("01,01,02");
        passList.add("02,01,01");
        passList.add("02,01,02");
        //     03/04	01	01/02	1	通过
        passList.add("03,01,01");
        passList.add("03,01,02");
        passList.add("04,01,01");
        passList.add("04,01,02");

        //     05/06	01	01/02	1	通过
        passList.add("05,01,01");
        passList.add("05,01,02");
        passList.add("06,01,01");
        passList.add("06,01,02");
        List<String> easyList = new ArrayList<>();


        //01/02	01	03/05	2	简单验证
        easyList.add("01,01,03");
        easyList.add("01,01,05");
        easyList.add("02,01,03");
        easyList.add("02,01,05");
        // 03/04	01	03/05	2	简单验证
        easyList.add("03,01,03");
        easyList.add("03,01,05");
        easyList.add("04,01,03");
        easyList.add("04,01,05");
        // 05/06	01	03/05	2	简单验证
        easyList.add("05,01,03");
        easyList.add("05,01,05");
        easyList.add("06,01,03");
        easyList.add("06,01,05");
        List<String> refuseList = new ArrayList<>();

        //01/02	02/03	04	5	拒绝
        refuseList.add("01,02,04");
        refuseList.add("01,03,04");
        refuseList.add("02,02,04");
        refuseList.add("02,03,04");
        // 03/04	02/03	04	5	拒绝
        refuseList.add("03,02,04");
        refuseList.add("03,03,04");
        refuseList.add("04,02,04");
        refuseList.add("04,03,04");
        //05/06	02/03	04	5	拒绝
        refuseList.add("05,02,04");
        refuseList.add("05,03,04");
        refuseList.add("06,02,04");
        refuseList.add("06,03,04");
        List<String> hardList = new ArrayList<>();
        // 01/02	01	04	4	复杂验证
        hardList.add("01,01,04");
        hardList.add("02,01,04");
        //01/02	02/03	01/02	4	复杂验证
        hardList.add("01,02,01");
        hardList.add("01,02,02");
        hardList.add("01,03,01");
        hardList.add("01,03,02");
        hardList.add("02,02,01");
        hardList.add("02,02,02");
        hardList.add("02,03,01");
        hardList.add("02,03,02");
        // 01/02	02/03	03/05	4	复杂验证
        hardList.add("01,02,03");
        hardList.add("01,02,05");
        hardList.add("01,03,03");
        hardList.add("01,03,05");
        hardList.add("02,02,03");
        hardList.add("02,02,05");
        hardList.add("02,03,03");
        hardList.add("02,03,05");
        // 03/04	01	04	4	复杂验证
        hardList.add("03,01,04");
        hardList.add("04,01,04");
        // 03/04	02/03	01/02	4	复杂验证
        hardList.add("03,02,01");
        hardList.add("03,02,02");
        hardList.add("03,03,01");
        hardList.add("03,03,02");
        hardList.add("04,02,01");
        hardList.add("04,02,02");
        hardList.add("04,03,01");
        hardList.add("04,03,02");
        // 03/04	02/03	03/05	4	复杂验证
        hardList.add("03,02,03");
        hardList.add("03,02,05");
        hardList.add("03,03,03");
        hardList.add("03,03,05");
        hardList.add("04,02,03");
        hardList.add("04,02,05");
        hardList.add("04,03,03");
        hardList.add("04,03,05");
        //05/06	01	04	4	复杂验证
        hardList.add("05,01,04");
        hardList.add("06,01,04");
        //05/06	02/03	01/02	4	复杂验证
        hardList.add("05,02,01");
        hardList.add("05,02,02");
        hardList.add("05,03,01");
        hardList.add("05,03,02");
        hardList.add("06,02,01");
        hardList.add("06,02,02");
        hardList.add("06,03,01");
        hardList.add("06,03,02");
        // 05/06	02/03	03/05	4	复杂验证
        hardList.add("05,02,03");
        hardList.add("05,02,05");
        hardList.add("05,03,03");
        hardList.add("05,03,05");
        hardList.add("06,02,03");
        hardList.add("06,02,05");
        hardList.add("06,03,03");
        hardList.add("06,03,05");
        for (String imei : imeiArr) {
            for (String change : changeArr) {
                for (String history : historyChangeArr) {
                    String resultStr = history + "," + imei + "," + change;

                    String resultCheck = "";
                    if (passList.contains(resultStr)) {
                        resultCheck = "1";
                    }
                    if (easyList.contains(resultStr)) {
                        resultCheck = "2";
                    }
                    if (hardList.contains(resultStr)) {
                        resultCheck = "4";
                    }
                    if (refuseList.contains(resultStr)) {
                        resultCheck = "5";
                    }
                    System.out.println("imei打标结果为" + imei + "change打标结果为" + change + "history打标结果为" + history + "风控打标结果=" + resultCheck);

                }

                //System.out.println();

            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));
    }

    @Test
    public void testTry78() {
        long startTime = System.currentTimeMillis();
        //System.out.println(System.currentTimeMillis());
        //打标结果
        String[] imeiArr = new String[]{"01", "02", "03"};
        String[] changeArr = new String[]{"01", "02", "03", "04", "05"};
        String[] historyChangeArr = new String[]{"01", "02", "03", "04", "05", "06"};

        HashMap<String, String> fkRiskMap = new HashMap();

        //     01/02	01	01/02	1	通过
        fkRiskMap.put("01,01,01", "1");
        fkRiskMap.put("01,01,02", "1");
        fkRiskMap.put("02,01,01", "1");
        fkRiskMap.put("02,01,02", "1");
        //     03/04	01	01/02	1	通过
        fkRiskMap.put("03,01,01", "1");
        fkRiskMap.put("03,01,02", "1");
        fkRiskMap.put("04,01,01", "1");
        fkRiskMap.put("04,01,02", "1");

        //     05/06	01	01/02	1	通过
        fkRiskMap.put("05,01,01", "1");
        fkRiskMap.put("05,01,02", "1");
        fkRiskMap.put("06,01,01", "1");
        fkRiskMap.put("06,01,02", "1");


        //01/02	01	03/05	2	简单验证
        fkRiskMap.put("01,01,03", "2");
        fkRiskMap.put("01,01,05", "2");
        fkRiskMap.put("02,01,03", "2");
        fkRiskMap.put("02,01,05", "2");
        // 03/04	01	03/05	2	简单验证
        fkRiskMap.put("03,01,03", "2");
        fkRiskMap.put("03,01,05", "2");
        fkRiskMap.put("04,01,03", "2");
        fkRiskMap.put("04,01,05", "2");
        // 05/06	01	03/05	2	简单验证
        fkRiskMap.put("05,01,03", "2");
        fkRiskMap.put("05,01,05", "2");
        fkRiskMap.put("06,01,03", "2");
        fkRiskMap.put("06,01,05", "2");

        //01/02	02/03	04	5	拒绝
        fkRiskMap.put("01,02,04", "5");
        fkRiskMap.put("01,03,04", "5");
        fkRiskMap.put("02,02,04", "5");
        fkRiskMap.put("02,03,04", "5");
        // 03/04	02/03	04	5	拒绝
        fkRiskMap.put("03,02,04", "5");
        fkRiskMap.put("03,03,04", "5");
        fkRiskMap.put("04,02,04", "5");
        fkRiskMap.put("04,03,04", "5");
        //05/06	02/03	04	5	拒绝
        fkRiskMap.put("05,02,04", "5");
        fkRiskMap.put("05,03,04", "5");
        fkRiskMap.put("06,02,04", "5");
        fkRiskMap.put("06,03,04", "5");
        // 01/02	01	04	4	复杂验证
        fkRiskMap.put("01,01,04", "4");
        fkRiskMap.put("02,01,04", "4");
        //01/02	02/03	01/02	4	复杂验证
        fkRiskMap.put("01,02,01", "4");
        fkRiskMap.put("01,02,02", "4");
        fkRiskMap.put("01,03,01", "4");
        fkRiskMap.put("01,03,02", "4");
        fkRiskMap.put("02,02,01", "4");
        fkRiskMap.put("02,02,02", "4");
        fkRiskMap.put("02,03,01", "4");
        fkRiskMap.put("02,03,02", "4");
        // 01/02	02/03	03/05	4	复杂验证
        fkRiskMap.put("01,02,03", "4");
        fkRiskMap.put("01,02,05", "4");
        fkRiskMap.put("01,03,03", "4");
        fkRiskMap.put("01,03,05", "4");
        fkRiskMap.put("02,02,03", "4");
        fkRiskMap.put("02,02,05", "4");
        fkRiskMap.put("02,03,03", "4");
        fkRiskMap.put("02,03,05", "4");
        // 03/04	01	04	4	复杂验证
        fkRiskMap.put("03,01,04", "4");
        fkRiskMap.put("04,01,04", "4");
        // 03/04	02/03	01/02	4	复杂验证
        fkRiskMap.put("03,02,01", "4");
        fkRiskMap.put("03,02,02", "4");
        fkRiskMap.put("03,03,01", "4");
        fkRiskMap.put("03,03,02", "4");
        fkRiskMap.put("04,02,01", "4");
        fkRiskMap.put("04,02,02", "4");
        fkRiskMap.put("04,03,01", "4");
        fkRiskMap.put("04,03,02", "4");
        // 03/04	02/03	03/05	4	复杂验证
        fkRiskMap.put("03,02,03", "4");
        fkRiskMap.put("03,02,05", "4");
        fkRiskMap.put("03,03,03", "4");
        fkRiskMap.put("03,03,05", "4");
        fkRiskMap.put("04,02,03", "4");
        fkRiskMap.put("04,02,05", "4");
        fkRiskMap.put("04,03,03", "4");
        fkRiskMap.put("04,03,05", "4");
        //05/06	01	04	4	复杂验证
        fkRiskMap.put("05,01,04", "4");
        fkRiskMap.put("06,01,04", "4");
        //05/06	02/03	01/02	4	复杂验证
        fkRiskMap.put("05,02,01", "4");
        fkRiskMap.put("05,02,02", "4");
        fkRiskMap.put("05,03,01", "4");
        fkRiskMap.put("05,03,02", "4");
        fkRiskMap.put("06,02,01", "4");
        fkRiskMap.put("06,02,02", "4");
        fkRiskMap.put("06,03,01", "4");
        fkRiskMap.put("06,03,02", "4");
        // 05/06	02/03	03/05	4	复杂验证
        fkRiskMap.put("05,02,03", "4");
        fkRiskMap.put("05,02,05", "4");
        fkRiskMap.put("05,03,03", "4");
        fkRiskMap.put("05,03,05", "4");
        fkRiskMap.put("06,02,03", "4");
        fkRiskMap.put("06,02,05", "4");
        fkRiskMap.put("06,03,03", "4");
        fkRiskMap.put("06,03,05", "4");
        for (String imei : imeiArr) {
            for (String change : changeArr) {
                for (String history : historyChangeArr) {
                    String resultStr = history + "," + imei + "," + change;
                    String resultCheck = "";
                    if (fkRiskMap.containsKey(resultStr)) {
                        resultCheck = fkRiskMap.get(resultStr);
                    }
                   /* String resultCheck = "";
                    if("".equals(resultCheck) && passList.contains(resultStr)){
                        resultCheck="1";
                    }
                    if("".equals(resultCheck) &&easyList.contains(resultStr)){
                        resultCheck="2";
                    }
                    if("".equals(resultCheck) &&hardList.contains(resultStr)){
                        resultCheck="4";
                    }
                    if("".equals(resultCheck) &&refuseList.contains(resultStr)){
                        resultCheck="5";
                    }*/
                    System.out.println("imei打标结果为" + imei + "change打标结果为" + change + "history打标结果为" + history + "风控打标结果=" + resultCheck);

                }

                //System.out.println();

            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("StringUtils.isEmpty(resultCheck) &&总耗时：" + (endTime - startTime));
    }

    @Test
    public void testTry1955() {
        String provinceIp = "河北省";
        String cityIp = "保定";
        String provinceGps = "河北省1";
        String cityGps = "保定1";
        String checkResult = "";

        //对比结果
        if (org.apache.commons.lang3.StringUtils.isEmpty(provinceIp) || org.apache.commons.lang3.StringUtils.isEmpty(cityIp) || org.apache.commons.lang3.StringUtils.isEmpty(provinceGps) || org.apache.commons.lang3.StringUtils.isEmpty(cityGps)) {
            checkResult = "-1";
        } else {
            //如果调逆地理接口 如果是直辖市， 省份字段可能为市， 地市字段为空 ， 将这种情况的做特殊处理
            if (provinceIp.equals(provinceGps) && cityIp.equals(cityGps)) {
                checkResult = "0";
            } else if (!provinceIp.equals(provinceGps)) {
                //如果省份不同返回1
                checkResult = "1";

            } else if (!cityIp.equals(cityGps)) {
                //如果地市不同返回1
                checkResult = "2";
            }
        }
        System.out.println(checkResult);
    }


    @Test
    public void testTry1956() {
        int n = 3;
        int j = (int) Math.floor(Math.sqrt(n));
        System.out.println(j);
    }

    /**
     * 　　Object src : 原数组
     * int srcPos : 从元数据的起始位置开始
     * 　　Object dest : 目标数组
     * 　　int destPos : 目标数组的开始起始位置
     * 　　int length  : 要copy的数组的长度    "3", "4", "5", "6", "7", "8",
     */
    @Test
    public void testTry1957() {
        String[] elementData = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
        String[] elementData1 = new String[]{"100", "200", "300", "400", "500", "600", "700", "800", "900", "1000", "110", "120", "130", "140", "150", "160", "170", "180", "190", "200"};


        int index = 2;
        int numNew = 3;
        int numMoved = 6;
        System.arraycopy(elementData, 0, elementData1, 0,
                20);
        for (String str : elementData1) {
            System.out.print("-" + str + "-");
        }
    /*    {"1", "2",
                "3", "4", "5", "6", "7", "8",
                "9", "10","11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};*/
    /*    //-1--2--3--4--5         --6--7--8--9--10--11-  -12--13--14--15--16--17--18--19--20-

        //-1--2--3--4--5--          3--4--5--6--7--8-   -12--13--14--15--16--17--18--19--20-*/
        //-100--200--300--400--500--3--4--5--6--7--8--120--130--140--150--160--170--180--190--200-

    }

    @Test
    public void testTry1958() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list = Arrays.asList(arr);
        List<Integer> list1 = new ArrayList<>();
        list1.addAll(list);
        list1.add(2);
        //list.add(2);
        //List<Integer> list = new ArrayList<>();

    }

    /**
     * 安徽 030
     * 山西 019
     * 黑龙江 097
     * 上海 031
     * 福建 038
     * 贵州 085
     * 吉林 090
     * 陕西 084
     * 重庆 083
     * 内蒙古 010
     * 天津 013
     * 新疆 089
     * 广西 059
     * 云南 086
     * 甘肃 087
     */
    @Test
    public void testTry1959() throws ParseException {
        String proStr = "073,030,019,097,031,038,085,090,084,083,010,013,089,059,086,087";
        String[] proArr = proStr.split(",");
        //获取近7日时间
        List<String> aimTimeList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();
        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
        for (int i = 0; i < proArr.length; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, i);
            String aimTime = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            aimTimeList.add(aimTime);
        }
        //System.out.println(aimTimeList);
        Map<String, String> timeMap = new HashMap<>();
        for (int i = 0; i < aimTimeList.size(); i++) {
            String time = aimTimeList.get(i);
            String province = proArr[i];
            timeMap.put(time, province);
        }
        for (String key : timeMap.keySet()) {
            System.err.println("时间为=" + key + "=对应的省份是" + timeMap.get(key));
        }
        //判断当前时间是否大于4点
        long changeProvinceTime = getTime(0, 16);
        //模拟当前时间
        long time = getTime(0, 23);
        if (time > changeProvinceTime) {
            //如果大于4点就要获取明日日期
            Date startTime = new SimpleDateFormat("yyyyMMdd").parse("20211117");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startTime);
            String tomorrow = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            System.err.println("tomorrow=" + tomorrow);
            //根据明日日期，拿到对应的省份
            String dealProvince = timeMap.containsKey(tomorrow) ? timeMap.get(tomorrow) : null;
            //如果是最后一个明日日期不在map中， 则087省份
            if (dealProvince == null) {
                dealProvince = "087";
            }
            System.out.println("----准备处理的省份-----" + dealProvince);

        } else {
            Calendar calendar = Calendar.getInstance();
            String today = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            System.err.println("today=" + today);
            //根据明日日期，拿到对应的省份
            String dealProvince = timeMap.containsKey(today) ? timeMap.get(today) : null;
            //如果是最后一个明日日期不在map中， 则087省份
            if (dealProvince == null) {
                dealProvince = "087";
            }
            System.out.println("----准备处理的省份111-----" + dealProvince);

        }




       /* Map<String, String> map = new HashMap<>();
        map.*/

    }

    @Test
    public void testTry19519() throws ParseException {
        String proStr = "030,019,097,031,038,085,090,084,083,010,013,089,059,086,087";
        String[] proArr = proStr.split(",");
        //获取近7日时间
        Map<String, String> map = new HashMap();

        for (int i = 0; i < proArr.length; i++) {
            Date startTime = new SimpleDateFormat("yyyyMMdd").parse("20211117");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startTime);
            calendar.add(Calendar.DAY_OF_MONTH, i);
            String aimTime = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            System.out.println(aimTime + "---" + proArr[i]);
            //aimTimeList.add(aimTime);
            map.put(aimTime, proArr[i]);
        }
        Calendar calendar1 = Calendar.getInstance();
        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
        String today = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar1.getTimeInMillis()));
        String aimProvince = map.containsKey(today) ? map.get(today) : "087";
        System.out.println(aimProvince);
    }
    //获取 0 点 4点  8点

    /**
     * @param day  0 表示 今天, 1 表示明天
     * @param hour 填写需要获取的小时
     */
    public long getTime(int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }

    @Test
    public void testTry1960() {
/**
 * 1	USER_ID	用户号码	M	登录日志获取
 * 2	IMEI	用户IMEI	M	登录日志获取
 * 3	LOGIN_TIME	登录时间	M	登录日志获取
 * 样例：2021-01-30 00:00:08
 * 4	LOGIN_TYPE	登录方式	N	登录日志获取
 * 5	CHANGE_TYPE	近30天换机行为	M	取3.2.10.【近30天换机行为】打标结果
 * 6	IMEI_BLACKLIST_TYPE	IMEI黑名单类别	M	取3.2.3.【IMEI黑名单】打标结果
 * 7	CHECK_TYPE	本次换机异地登录核验结果	M	取3.2.4-3.2.9【实时换机】打标结果
 * 8	RETURN_CODE	风控返回编码	M	按3类打标结果组合判断，仅推送编码为2、4、5的数据
 */

        JSONObject object = new JSONObject();
        object.put("USER_ID", "1");
        object.put("IMEI", "1");
        object.put("LOGIN_TIME", "1");
        object.put("LOGIN_TYPE", "1");
        object.put("CHANGE_TYPE", "1");
        object.put("IMEI_BLACKLIST_TYPE", "1");
        object.put("CHECK_TYPE", "1");
        object.put("RETURN_CODE", "1");


    }

    @Test
    public void testTry19520() {
        String thirdErrorRate = "0.38";
        Double thirdErrorRateDouble = Double.parseDouble(thirdErrorRate);

        System.err.println(thirdErrorRateDouble);
        Double thirdRightRateDouble = 100 - thirdErrorRateDouble;
        System.err.println("-----" + thirdRightRateDouble);
        System.err.println("---1111--" + String.valueOf(thirdRightRateDouble));

        BigDecimal bigDecimal = new BigDecimal(Double.parseDouble(thirdErrorRate));
        System.out.println(bigDecimal);
    }

    @Test
    public void testTry19521() {

        String str = "Dida-Production_v8.18.0_20211119-1410_196936c8_arm32.apk";

        String str1 = "Dida-Production_v8.18.0_20211119-1410_196936c8.apk";

        String str2 = "Dida-Production_v8.18.0_20211119-1410_196936c8_arm64.apk";


        String pattern = "/Dida-Production/g";

        boolean isMatch = Pattern.matches(pattern, str);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    @Test
    public void testTry19522() {
        String ip = "100.256.1.10";
        System.out.println(Strings.isNotEmpty(ip));
        System.out.println(String.format("1-{}-2", ip));
    }

    /**
     * 获取浏览器端IP.
     * 参考：http://xuechenyoyo.iteye.com/blog/586007。
     * x-cluster-client-ip/x-forwarded-for/WL-Proxy-Client-IP/Proxy-Client-IP
     *
     * @param request
     * @return
     */
/*    public static String getRemoteAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-real-ip");
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return StringUtils.substringBefore(ip, ",");
    }*/
    @Test
    public void testTry19523() throws ParseException {
        String time = "2021-12-25 15:48:26";
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(time);
        //String dateStr = new SimpleDateFormat("yyyy-MMddHHmmssSSS").format(parse);
        String dateStr = new SimpleDateFormat("YYYY-MMddHHmmssSSS").format(parse);
        Calendar instance = Calendar.getInstance();
       // Calendar.YEAR
        System.err.println(Calendar.YEAR);
        System.out.println("--"+instance.getWeekYear());
       // System.err.println(Calendar.W);
        //instance.set
        System.out.println(dateStr);
    }


    @Test
    public void testTry19524() {

        //经纬度是已知垃圾数据的直接打标03：换机异地登录未授权采集经纬度，不调高德
        String lon = "0.0001000";
        String lat = "";
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"4.9E-324", "0.000000", "0.000001e"}));
        if (list.contains(lon) || list.contains(lat)) {
            System.out.println("11111");
        }

    }

    @Test
    public void testTry19525() {
        int i = 30 * 24 * 60 * 60;
        //System.err.println(i);
        //String num ="2592000000";
        long num = 2592000000L;
        Integer num2 = 0;
        try {
            num2 = Integer.valueOf((int) num);
            if (num2 < 0) {
                // num/1000;
            }
        } catch (Exception e) {

        }
        System.out.println(num2);
    }

    @Test
    public void testTry19526() {
        int i = UUID.randomUUID().hashCode();
        System.out.println(i);
        Collections2.asMap("importId", String.valueOf(i));
    }

    @Test
    public void testTry19527() {
        int i = 1241288880;
        System.out.println(i);
    }

    public boolean getOrderSucessBoolean(String orderStatus) {
        List<String> sucessList = new ArrayList<>();
        sucessList.add("01");
        sucessList.add("02");

        if (sucessList.contains(orderStatus)) {
            return true;
        }
        return false;
    }

    @Test
    public void testTry19528() { //getOrderSucessBoolean();
    }


    public Boolean testTry19529() { //getOrderSucessBoolean();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if ("6".equals(String.valueOf(i))) {

                System.err.println("-------" + i);

                return true;
            }
        }
        return false;
    }

    @Test
    public void testTry19530() { //getOrderSucessBoolean();
        System.err.println(testTry19529());
    }

    @Test
    public void testTry19531() { //getOrderSucessBoolean();
        String str="2021-";
      Date date= new Date( System.currentTimeMillis());
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(System.currentTimeMillis()));
        System.out.println("PT"+dateStr);
    }
}


//1128893976749  162 632 035 6279
//1187478209716
