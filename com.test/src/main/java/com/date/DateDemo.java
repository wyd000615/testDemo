package com.date;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    @Test
    public void test() {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        System.out.println(instance.getTimeInMillis());
        Timestamp timestamp = new Timestamp(instance.getTimeInMillis());
    }

    @Test
    public void test1() {
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTime());
        System.out.println(instance.getTimeInMillis());
        Timestamp timestamp = new Timestamp(instance.getTimeInMillis());
        System.out.println("timestamp===" + timestamp);


        Calendar instance2 = Calendar.getInstance();
        System.out.println(new Date(timestamp.getTime()));
        instance2.setTime(new Date(timestamp.getTime()));
        instance2.set(Calendar.MILLISECOND, 0);


        Timestamp timestamp2 = new Timestamp(instance2.getTimeInMillis());
        System.out.println("timestamp2==" + timestamp2);
    }

    @Test
    public void test3() {
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
        if ("0".equals("1")) {
            calendar.add(Calendar.MILLISECOND, -1);
        }
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println("====" + timestamp);
        // ====2020-07-31 23:59:59.0
        //  ====2020-07-31 23:59:59.999
        //====2020-08-01 00:00:00.0

    }

    @Test
    public void test4() {
        Calendar instance = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(instance.getTimeInMillis());
        System.out.println(timestamp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(new Date(timestamp.getTime()));
        System.out.println(format);


    }

    @Test
    public void test5() throws ParseException {
        Calendar instance = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(instance.getTimeInMillis());
        System.out.println(timestamp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddhh24miss");//yyyyMMddHHmmss
        String format = simpleDateFormat.format(new Date(timestamp.getTime()));
        System.out.println(format);
        System.out.println("=================");

        Date date1 = simpleDateFormat.parse(format);
        System.out.println(date1);
    }

    @Test
    public void test6() throws ParseException {
        Calendar instance = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(instance.getTimeInMillis());

        System.out.println(timestamp);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");//yyyyMMddHHmmss
        String format = simpleDateFormat.format(new Date(timestamp.getTime()));
        System.out.println(format);
        System.out.println("=================");

        Date date1 = simpleDateFormat.parse(format);

        System.out.println(date1);
        System.out.println(date1.getTime());

        System.out.println("==" + new Timestamp(date1.getTime()));
    }

    @Test
    public void test7() throws ParseException, InterruptedException {
        long time1 = System.currentTimeMillis();
        System.out.println("time1==" + time1);
        Thread.sleep(1111);
        long time2 = System.currentTimeMillis();
        System.out.println("time2==" + time2);
        System.out.println("用时==" + (time2 - time1) + "毫秒");

    }

    @Test
    public void test8() throws ParseException, InterruptedException {
        long time1 = System.currentTimeMillis();
        Date date1 = new Date(time1);
        System.out.println("time1==" + time1);
        //Thread.sleep(1111);
        long time2 = System.currentTimeMillis();
        Date date2 = new Date(time2);

        System.out.println("time2==" + time2);
        System.out.println("用时==" + (time2 - time1) + "毫秒");
        System.out.println("====" + (date2.getTime() - date1.getTime()));

    }

    @Test
    public void test9() throws ParseException, InterruptedException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
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
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println(timestamp);
        System.out.println(timestamp.getTime());

    }

    //获取的月底
    @Test
    public void test10() throws ParseException, InterruptedException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 59);
        //将秒至0
        calendar.set(Calendar.SECOND, 59);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月第一天
        Date sdate = calendar.getTime();
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println(timestamp);
    }

    @Test
    public void test11() throws ParseException, InterruptedException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 59);
        //将秒至0
        calendar.set(Calendar.SECOND, 59);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月第一天
        Date sdate = calendar.getTime();
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println(timestamp);
    }

    @Test
    public void test12() throws ParseException, InterruptedException {
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
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        System.out.println(timestamp);
        System.out.println(timestamp.getTime());

    }

    @Test
    public void test13() throws ParseException {
        //指定日期字符串-- 转换为-- 日期格式Calendar
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date thisDate = sdf.parse("2019-09-15");
        Calendar cld = Calendar.getInstance();
        //cld.setTime(thisDate);

//月份+1，天设置为0。下个月第0天，就是这个月最后一天
        cld.add(Calendar.MONTH, 1);
        cld.set(Calendar.DAY_OF_MONTH, 0);
        String lastDay = sdf.format(cld.getTime());
        System.out.println("本月最后一天：" + lastDay); //2019-09-30

        cld.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("本月第一天：" + sdf.format(cld.getTime())); //2019-09-01
    }

    @Test
    public void test14() throws ParseException {
        //指定日期字符串-- 转换为-- 日期格式Calendar
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyymmddhh24miss");//yyyyMMddHHmmss
        // Date thisDate = sdf.parse("2019-09-15");
        Calendar cld = Calendar.getInstance();
        cld.add(Calendar.MONTH, 1);
        cld.set(Calendar.DAY_OF_MONTH, 0);
        //
        cld.set(Calendar.HOUR_OF_DAY, 18); //24小时
        cld.set(Calendar.MINUTE, 0);
        cld.set(Calendar.SECOND, 0);
        System.out.println("本月最后一天====：" + cld.getTime()); //2019-09-30

        //
        //String lastDay = sdf.format(cld.getTime());
        //System.out.println("本月最后一天：" + lastDay); //2019-09-30

        //cld.set(Calendar.DAY_OF_MONTH, 1);
        // System.out.println("本月第一天：" + sdf.format(cld.getTime())); //2019-09-01
    }


    @Test
    public void test15() throws ParseException, InterruptedException {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp);
        Timestamp timestamp2 = new Timestamp(timestamp.getTime() - 1000);
        System.out.println(timestamp2);


    }

    @Test
    public void test16() throws ParseException, InterruptedException {
        Timestamp timestamp1 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp1);
        for (int i = 0; i < 1000; i++) {
            //System.out.println(i);
        }
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp2);

        Long t = timestamp2.getTime() - timestamp1.getTime();
        System.out.println(t);


    }

    @Test
    public void test17() {
        Calendar calendar = Calendar.getInstance();
        int orderPartitionOffset = 31;
        calendar.add(Calendar.DAY_OF_YEAR, -orderPartitionOffset);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println(new java.sql.Timestamp(calendar.getTimeInMillis()));
    }
    @Test
    public void test18() {
        Calendar calendar = Calendar.getInstance();
        int orderPartitionOffset = 31;
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR, orderPartitionOffset);
        // 查询定单分区结束时间
        System.out.println( new java.sql.Timestamp(calendar.getTimeInMillis()));
    }
    /*
    *
    * 获取上个月1号  00:00:00
    * */
    @Test
    public void  getLastMonthMinTime() {

        Calendar newCal = Calendar.getInstance();// 获取当前日期
        newCal.add(Calendar.MONTH, -1);
        newCal.set(Calendar.DATE, newCal.getActualMinimum(Calendar.DATE));
        newCal.set(Calendar.HOUR_OF_DAY, newCal.getActualMinimum(Calendar.HOUR_OF_DAY));
        newCal.set(Calendar.MINUTE, newCal.getActualMinimum(Calendar.MINUTE));
        newCal.set(Calendar.SECOND, newCal.getActualMinimum(Calendar.SECOND));
        newCal.set(Calendar.MILLISECOND, newCal.getActualMinimum(Calendar.MILLISECOND));

        System.out.println(newCal.getTime());
    }
    /*
     *获取上月最大时间
     * 获取上个月月底  23:59:59
     * */
    @Test
    public void  getLastMonthMaxTime() {

        Calendar newCal = Calendar.getInstance();// 获取当前日期
        newCal.add(Calendar.MONTH, -1);
        newCal.set(Calendar.DATE, newCal.getActualMaximum(Calendar.DATE));
        newCal.set(Calendar.HOUR_OF_DAY, newCal.getActualMaximum(Calendar.HOUR_OF_DAY));
        newCal.set(Calendar.MINUTE, newCal.getActualMaximum(Calendar.MINUTE));
        newCal.set(Calendar.SECOND, newCal.getActualMaximum(Calendar.SECOND));
        newCal.set(Calendar.MILLISECOND, newCal.getActualMaximum(Calendar.MILLISECOND));

        System.out.println(newCal.getTime());
    }



}