package com;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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


    @Test
    public void test7() {
        Calendar instance = Calendar.getInstance();
        instance.set(2021, 6, 28);
        System.out.println(new Date(String.valueOf(instance.getTime())));
    }


    @Test
    public void test8() {
        List timeList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        for (int i = 0; i <24*6 ; i++) {
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis()+600000L*i)).substring(0,11);
            System.out.println(time.substring(6,8));
            System.out.println(time.substring(0,8));
            timeList.add(time);
        }

    }

    @Test
    public void test9() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)-1,0,0,0);
        String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0,8);
        System.out.println(time);
        System.out.println(time.substring(6,8));

    }

    @Test
    public void test10() throws ParseException {
        String time ="20210802";
        Date date = new SimpleDateFormat("yyyyMMdd").parse(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        String now = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0,8);
        System.out.println(now);
    }



    @Test
    public void test11() throws ParseException {
        String str ="20210803175947123";

        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyyMMddHHmmss").parse(str));
        System.out.println(format);


        String format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyyMMdd HH:mm:ss").parse("20210803 22:49:56"));
        System.out.println(format1);
        //2021-08-03 07:49:28.0
        String format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2021-08-03 07:49:28.0"));
        System.out.println(format2);

    }

    public List<String> getDealTime() {
        List<String> timeList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        for (int i = 0; i < 24 * 6; i++) {
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() + 600000L * i)).substring(0, 11);
            timeList.add(time);
        }
        return timeList;
    }

    @Test
    public void test12(){
        List<String> dealTime = getDealTime();
        for (int i = 0; i <dealTime.size() ; i++) {
            System.out.println(dealTime.get(i));

        }
    }
    @Test
    public void test13() throws ParseException {
        String time = "20210806";
        String format2 = new SimpleDateFormat("yyyy-MM-dd").format(new SimpleDateFormat("yyyyMMdd").parse(time));
        System.out.println(format2);


    }

    @Test
    public void test14() throws ParseException {
        String startTime = "20210806";
        String endTime = "20210816";
        List<String> timeList = new ArrayList<>();
        Date startDate = new SimpleDateFormat("yyyyMMdd").parse(startTime);

        for (int i = 0; i <=31 ; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH,i);
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() )).substring(0, 8);
            if(Integer.parseInt(time)<=Integer.parseInt(endTime)){
                timeList.add(time);
            }


            System.err.println(time);

        }
        System.out.println(timeList);


    }

    //获取昨天每个10分钟的list
    public List<String> getDealTime2() {
        List<String> timeList = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH) - 1, 0, 0, 0);
        for (int i = 0; i < 24 * 6; i++) {
            String time = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() + 600000L * i)).substring(0, 11);
            timeList.add(time);
        }
        return timeList;
    }

    @Test
    public void test15(){
        List<String> dealTimeList = getDealTime2();
        for (int i = 0; i < dealTimeList.size(); i++) {
           // yhLoginNewDao.saveUserServiceDayData(dealTimeList.get(i).substring(6, 8), dealTimeList.get(i), dealTimeList.get(i).substring(0, 8));
            //Thread.sleep(1000);
            //logger.error("user action data click time" + dealTimeList.get(i) + "success");
            System.out.println(dealTimeList.get(i));

        }
    }

    //获取 今天 前5 10 20 30 的日期
    public List<String> getQueryDate(int timeInterval) {
        //获取 前5 10 20 30 的日期  (不包含今天)
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() - timeInterval * 600000)).substring(0, 11);
            if (i == 0 || i == 5 || i == 10 || i == 20 || i == 30) {
                dateList.add(aimTime);
            }
        }
        System.out.println(dateList.toString());
        return dateList;
    }

    @Test
    public void test16(){
        getQueryDate(30);
    }
    @Test
    public void test17(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        calendar.getTimeInMillis();
        Date date = new Date(calendar.getTimeInMillis());
        System.out.println(date);
    }
    @Test
    public void test18() {
        String str = "1223";
        switch (str) {
            case "456":
                System.out.println("Monday1\n");
                break;
            case "123":
                System.out.println("Monday2\n");
                break;
            case "789":
                System.out.println("Monday3\n");
                break;
            default:
                System.out.println("----");
        }
    }

    public static boolean compareTime(String beginStr) {
        if (StringUtils.isEmpty(beginStr)) {
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date begin = simpleDateFormat.parse(beginStr);
            if (new Date().after(begin)) {
                return true;
            }
        } catch (Exception e) {
            return true;
        }
        return false;
    }

    @Test
    public void test19(){
        String time = "2021-08-25 09:32:14";
        boolean b = compareTime(time);
        System.out.println(b);
    }



}
