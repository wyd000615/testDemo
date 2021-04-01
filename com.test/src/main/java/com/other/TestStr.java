package com.other;

import org.junit.Test;
import sun.misc.BASE64Decoder;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;
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
        String content = "I am noob " +"from runoob.com.";
        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }


    public Integer method( int i) {

        try{
            if(i++ > 0)
                throw new IOException();
            return i++;
        }catch (IOException e){
            i++;
            return i++;
        }catch (Exception e){
            i++;
            return i++;
        }finally {
            return i++;
        }
    }
    @Test
    public void RegexExample1() {
        System.out.println(method(0));
        String s = new String(new char[] {'没','人','比','我','更','懂','j','a','v','a'});
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
    static void cnn() {
        System.out.print("CNN ");
    }
    @Test
    public void RegexExample3() {
    String str =" businessStatus";
        System.out.println(str);
        System.out.println("测试git切分支");
        System.out.println("测试git切分支2222");
        System.out.println("测试git切分支33333");
    }
}
