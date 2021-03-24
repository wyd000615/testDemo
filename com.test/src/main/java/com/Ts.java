package com;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ts {
    /*
        @Test
        public void test2() throws ParseException {
            HashMap<String, String> hashMap = new HashMap<String,String>();
            hashMap.put("1",null);
            JSONObject json = JSONObject.fromObject(hashMap);
            System.out.println(json.toString());
            Object obj = json.get("1");
            String obj1 =  json.getString("1");
            System.out.println(obj.toString());
            System.out.println(obj1.toString());
            //String keyRsp2 = (String) (json.getString("1")+" ");
            String keyRsp =  json.getString("1")==null?"":json.getString("1");
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//设定格式
            dateFormat.setLenient(false);
            //java.util.Date timeDate = dateFormat.parse((String) json.get("1"));//util类型
            java.util.Date timeDate = dateFormat.parse("1");//util类型
            System.out.println(timeDate);
        }
        @Test
        public void test3() throws ParseException {
            hexStr.substring(i * 2, i * 2 + 1)
        }
    */
    @Test
    public void test1() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2099, 0, 1);

        System.out.println(calendar.getTimeInMillis());
    }

    @Test
    public void test2() {
        Date date = new Date();
        System.out.println(date.getTime());
    }

    @Test
    public void test3() {
        Timestamp timestamp = new Timestamp(1593418046679L);
        System.out.println(timestamp);
        Timestamp timestamp1 = new Timestamp(4070938309190L);
        System.out.println(timestamp1.toString().substring(0, 10).replace("-", ""));
        Timestamp timestamp2 = new Timestamp(1593532800000L);
        Date date = new Date();
        date.setTime(timestamp2.getTime());
        System.out.println(date.toString());
        Timestamp timestamp3 = new Timestamp(4070880000000L);
        Date date1 = new Date();
        date1.setTime(timestamp3.getTime());
        System.out.println(date1.toString());
    }

    @Test
    public void test4() {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int maxDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DATE, maxDate);

        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        String curDate = s.format(cal.getTime());
        System.out.println(cal.getTimeInMillis());
        System.out.println(curDate);
    }

    @Test
    public void test5() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
//将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
//将分钟至0
        calendar.set(Calendar.MINUTE, 0);
//将秒至0
        calendar.set(Calendar.SECOND, 0);
//将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
//获得当前月第一天
        Date sdate = calendar.getTime();
//将当前月加1；
        calendar.add(Calendar.MONTH, 1);
//在当前月的下一月基础上减去1毫秒
        //calendar.add(Calendar.MILLISECOND, -1);
//获得当前月最后一天
        Date edate = calendar.getTime();

        System.out.println("last day:" + edate.getTime());
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println(timestamp.getTime());

//1593532799999
    }
    @Test
    public void test6() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2099, 0, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
//将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 0);
//将分钟至0
        calendar.set(Calendar.MINUTE, 0);
//将秒至0
        calendar.set(Calendar.SECOND, 0);
//将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
//获得当前月第一天
        Date sdate = calendar.getTime();
//将当前月加1；
       // calendar.add(Calendar.MONTH, 1);
//在当前月的下一月基础上减去1毫秒
        //calendar.add(Calendar.MILLISECOND, -1);
//获得当前月最后一天
        Date edate = calendar.getTime();

        System.out.println("last day:" + edate.getTime());
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println(timestamp.getTime());

//1593532799999
    }
}
