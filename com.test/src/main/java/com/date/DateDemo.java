package com.date;

import net.sf.json.JSONObject;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class DateDemo {
    public static boolean compareTime(String beginStr) {
        if (org.apache.commons.lang3.StringUtils.isEmpty(beginStr)) {
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
        System.out.println(new java.sql.Timestamp(calendar.getTimeInMillis()));
    }

    /*
     *
     * 获取上个月1号  00:00:00
     * */
    @Test
    public void getLastMonthMinTime() {

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
    public void getLastMonthMaxTime() {

        Calendar newCal = Calendar.getInstance();// 获取当前日期
        newCal.add(Calendar.MONTH, -1);
        newCal.set(Calendar.DATE, newCal.getActualMaximum(Calendar.DATE));
        newCal.set(Calendar.HOUR_OF_DAY, newCal.getActualMaximum(Calendar.HOUR_OF_DAY));
        newCal.set(Calendar.MINUTE, newCal.getActualMaximum(Calendar.MINUTE));
        newCal.set(Calendar.SECOND, newCal.getActualMaximum(Calendar.SECOND));
        newCal.set(Calendar.MILLISECOND, newCal.getActualMaximum(Calendar.MILLISECOND));

        System.out.println(newCal.getTime());
    }

    @Test
    public void getTen() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String nowTenMinutes = sdf.format(date).substring(0, 11);//当前的10分钟串
        System.out.println(nowTenMinutes);
    }

    private List<String> makeKeys(String sourceKey, Integer days) {
        List<String> keys = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());
        now.set(Calendar.DATE, now.get(Calendar.DATE) - 0);
        keys.add("sc" + sdf.format(now.getTime()) + sourceKey);
        for (int i = 1; i < days; i++) {
            now.set(Calendar.DATE, now.get(Calendar.DATE) - 1);
            System.out.println("===========" + "sc" + sdf.format(now.getTime()) + sourceKey);
            keys.add("sc" + sdf.format(now.getTime()) + sourceKey);
        }
        return keys;
    }

    @Test
    public void getTen1() {
        makeKeys("---", 90);
    }

    @Test
    public void tets() {
        String str = new java.text.SimpleDateFormat("yyyyMMdd").format(new Date());
        Timestamp curMonthTimestamp = getCurMonthTimestamp("0");
        System.out.println(curMonthTimestamp);

        System.out.println(new Date(curMonthTimestamp.getTime()));
        System.out.println(str);
    }

    public Timestamp getCurMonthTimestamp(String type) { //0 代表是 月底23:59:59  1 代表是次月0000
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
        if ("0".equals(type)) {
            calendar.add(Calendar.MILLISECOND, -1);
        }
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        return timestamp;
    }

    @Test
    public void tets2() throws ParseException {
    /*    String dateStr="{\"date\":26,\"day\":4,\"hours\":15,\"minutes\":40,\"month\":10,\"nanos\":449000000,\"seconds\":32,\"time\":1606376432449,\"timezoneOffset\":-480,\"year\":120}";
        System.out.println(dateStr);
        SimpleDateFormat sdf = new  SimpleDateFormat("yyyyMMdd");
        Date parse = sdf.parse(dateStr);
        System.out.println("date:"+parse);
*/

        String dateStr = "{\"date\":26,\"day\":4,\"hours\":15,\"minutes\":40,\"month\":10,\"nanos\":449000000,\"seconds\":32,\"time\":1606376432449,\"timezoneOffset\":-480,\"year\":120}";
        JSONObject jsonObj = JSONObject.fromObject(dateStr);
        Long time = (Long) jsonObj.get("time");
        // 1606376432449

        Timestamp timestamp = new Timestamp(time);
        System.out.println(timestamp);
    }

    @Test
    public void tets3() {
        //yyyy-MM-dd HH:mm:ss
        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);
        String date = new SimpleDateFormat("yyyy-MM-dd").format(time.getTime());  // 获取只有年月日的时间
        String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time.getTime());  // 获取年月日时分秒
        System.out.println(datetime);
    }

    @Test
    public void tets4() {
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

        System.out.println(sdate.getTime());

    }

    @Test
    public void tets5() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        System.out.println(sdf.format(date));

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis())));

    }

    @Test
    public void tets6() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 4);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 0);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月第一天
        Date date = calendar.getTime();

        System.out.println(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
        System.out.println(sdf.format(date));
    }

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
    public void tets7() {
        long freeTime = getTime(0, 0);
        long secondFreeTime = getTime(0, 4);
        long busyTime_start = getTime(0, 11);
        long busyTime_end = getTime(1, 0);
        long nowTime = System.currentTimeMillis();
        System.out.println("==freeTime==" + freeTime);
        System.out.println("==secondFreeTime==" + secondFreeTime);

        System.out.println("==busyTime_start==" + busyTime_start);

        System.out.println("==busyTime_end==" + busyTime_end);

        System.out.println("==nowTime==" + nowTime);

        int i = 0;
        //左闭右开
        if (freeTime <= nowTime && nowTime < secondFreeTime) {
            System.out.println("1");
        } else if (secondFreeTime <= nowTime && nowTime < busyTime_start) {
            System.out.println("2");

        } else if (busyTime_start <= nowTime && nowTime < busyTime_end) {
            System.out.println("3");

        }

/*
==freeTime==1620835200000
                ==secondFreeTime==1620849600000
                ==busyTime_start==1620864000000
                ==busyTime_end==1620921600000
                ==nowTime==1620874279566
        3
*/

    }

    //计算近五日的值
    @Test
    public void tets8() {
        //获取近几日的时间戳
        List<String> aimTimeList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();

        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
        for (int i = 1; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis()));
            aimTime = aimTime.substring(0, 11);
            System.out.println("i为=" + aimTime);
            aimTimeList.add("'" + aimTime + "'");
        }
        System.out.println(aimTimeList.toString());


    }

    @Test
    public void tets9() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmm");
        String dateString = "202105111330";
        Date date = df.parse(dateString);
        System.out.println(df.format(date));
        System.out.println(date);
    }

    //字符串转时间
    @Test
    public void tets10() throws ParseException {
        //获取 前5 10 20 30 的日期  (不包含今天)
        List<String> dateList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        Date date = null;
        // 注意格式需要与上面一致，不然会出现异常
        //date = sdf.parse("202105081620");
        //System.out.println(date);

        //获取近几日的时间戳
        List<String> aimTimeList = new ArrayList<String>();
        for (int i = 0; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();

            // calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis()));
            aimTime = aimTime.substring(0, 11);
            // System.out.println("i为=" + aimTime);
            aimTimeList.add(aimTime);
            System.out.println("前" + i + "天" + aimTime.toString());
            if (i == 5 || i == 10 || i == 20 || i == 30) {
                dateList.add(aimTime);
            }
        }
        System.err.println(dateList.toString());

    }

    //根据当前时间获取 10 分钟, 30 分钟  1个小时 之前的时间戳
    @Test
    public void tets11() {
        //获取近几日的时间戳
        List<String> aimTimeStartList = new ArrayList<String>();
        List<String> aimTimeEndList = new ArrayList<String>();
        for (int i = 0; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTimeStart = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() - 3 * 600000)).substring(0, 11);
            String aimTimeEnd = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 11);
            //System.out.println("i为=" + aimTimeStart+"==="+aimTimeEnd);
            aimTimeStartList.add(aimTimeStart);
            aimTimeEndList.add(aimTimeEnd);
        }
        System.out.println(aimTimeStartList.toString());
        System.out.println(aimTimeEndList.toString());
        //and ( stat_time >=20210509113 and stat_time<20210509173
        StringBuffer wherePreDataSqlResult = new StringBuffer(" and ( ");
        for (int i = 0; i <= 30; i++) {
            wherePreDataSqlResult.append(" ( stat_time >= ").append(aimTimeStartList.get(i)).append(" and stat_time < ").append(aimTimeEndList.get(i)).append(" ) or ");
        }
        wherePreDataSqlResult.append(" 1=0 ) ");
        System.out.println(wherePreDataSqlResult.toString());
    }

    @Test
    public void tets12() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat aimSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("202105121630");
        String format = aimSdf.format(date);
        System.out.println(format);
        String format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new SimpleDateFormat("yyyyMMddHHmm").parse("202105121630"));
        System.out.println(format1);
        String s = String.valueOf((int) (1.5 * 100)) + "%";
        System.out.println(s);
    }

    //  //获取 前5 10 20 30 的日期  (不包含今天)
    @Test
    public void tets13() throws ParseException {
        //获取 前5 10 20 30 的日期  (不包含今天)
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() - 1 * 600000)).substring(0, 11);
            //String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 11);
            if (i == 0 || i == 5 || i == 10 || i == 20 || i == 30) {
                dateList.add(aimTime);
            }
        }
        System.err.println(dateList.toString());

    }

    //获取 前5 10 20 30 的日期  (不包含今天)
    public List<String> getQueryDate() {
        //获取 前5 10 20 30 的日期  (不包含今天)
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 11);
            if (i == 5 || i == 10 || i == 20 || i == 30) {
                dateList.add(aimTime);
            }
        }
        System.err.println(dateList.toString());
        return dateList;
    }

    @Test
    public void getRecentTimeList() throws ParseException {
        List<String> recentTimeList = new ArrayList<>();
        for (int i = 0; i <= 30; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
            //Date date = null;
            // 注意格式需要与上面一致，不然会出现异常
            //date = sdf.parse(time);
            Calendar calendar = Calendar.getInstance();
            //calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String recentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
            recentTimeList.add(recentTime);
        }
        System.out.println(recentTimeList.toString());
    }

    @Test
    public void getDealTimeCondition() throws ParseException {
        int type = 1;
        // SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        // Date date = null;
        // 注意格式需要与上面一致，不然会出现异常
        // date = sdf.parse(time);
        //获取近几日的时间戳
        List<String> aimTimeStartList = new ArrayList<String>();
        List<String> aimTimeEndList = new ArrayList<String>();
        for (int i = 0; i <= 30; i++) {
            Calendar calendar = Calendar.getInstance();
            //calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTimeStart = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() - type * 600000)).substring(0, 11);
            String aimTimeEnd = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 11);
            aimTimeStartList.add(aimTimeStart);
            aimTimeEndList.add(aimTimeEnd);
        }
        //拼接条件
        StringBuffer wherePreDataSqlResult = new StringBuffer(" and ( ");
        for (int i = 0; i <= 30; i++) {
            wherePreDataSqlResult.append(" ( stat_time >= ").append(aimTimeStartList.get(i)).append(" and stat_time < ").append(aimTimeEndList.get(i)).append(" ) or ");
        }
        wherePreDataSqlResult.append(" 1=0 ) ");
        System.out.println(wherePreDataSqlResult.toString());
        //logger.error("===wherePreDataSqlResult=" + wherePreDataSqlResult.toString());

        // return wherePreDataSqlResult.toString();
    }

    @Test
    public void getDealTimeCondition2() throws InterruptedException, ParseException {
        Timestamp engineEndTime = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        Thread.sleep(1000);
        Timestamp engineEndTime2 = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());

        System.out.println(new Date(engineEndTime.getTime()));
        System.err.println(engineEndTime.getTime());

        long date1 = engineEndTime.getTime();
        String yyyyMMddHHmmssSSS = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date(engineEndTime2.getTime()));
        long date2 = new SimpleDateFormat("yyyyMMddHHmmssSSS").parse(yyyyMMddHHmmssSSS).getTime();

        System.out.println(date2 - date1);
        /////////
      /*  2021-05-19 18:43:20.096
        2021-05-19 18:43:19.174*/
        Timestamp loadKafkaTime = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        //1607094541009   1607094541009      2021-05-19 19:02:46.594  2021-05-19 19:02:46.594 -- 2021-05-19 19:02:49.004  1607094541009
        //1607094541009
        // 1621422166594   1607094541009
    }

    @Test
    public void getDealTimeCondition3() {
        Date date = new Date(1621422793309L);
        //1621422793309

        System.out.println(date);
        System.out.println(new Date().getTime());
    }

    @Test
    public void getDealTimeCondition4() {
        TimeUnit days = TimeUnit.DAYS;
        System.out.println(days);
    }

    @Test
    public void getDealTimeCondition5() {
        //Calendar calendar = Calendar.getInstance();
        String aimTime = new SimpleDateFormat("yyyyMMdd").format(new Date(Calendar.getInstance().getTimeInMillis()));
        System.out.println(aimTime);
    }

    //获取包含今天的30天数据
    @Test
    public void getDealTimeCondition6() throws ParseException {
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            // String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis() - 1 * 600000)).substring(0, 11);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
            dateList.add(aimTime);
        }
        System.err.println(dateList.toString());

    }
    //获取近几日的时间list

    @Test
    public void getDealTimeCondition7() {
        long nowTime = System.currentTimeMillis();
        long beforeTime = nowTime - 10 * 60 * 1000;
        if (Long.parseLong("1619884807000") < beforeTime) {
            System.out.println("ssss");
        }
        System.out.println(beforeTime);
        System.out.println(System.currentTimeMillis());
        //1622629306056
        //1619884807000


    }

    public void getDealTimeCondition8(int day) {
        List<String> dateList = new ArrayList<>();
        for (int i = 0; i < day; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
            dateList.add(aimTime);
        }
        System.err.println(dateList.toString());

    }

    @Test
    public void getDealTimeCondition9() throws ParseException {
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        String aimTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
        System.out.println(aimTime);
        calendar.add(Calendar.DAY_OF_MONTH, -2);
        String aimTime2 = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
        System.out.println(aimTime2);
    }

    @Test
    public void getDealTimeCondition10() {
        int day = 1;
        day = day > 0 ? day -= 1 : day;
        String[] queryTimeArr = new String[2];
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        String currTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
        queryTimeArr[0] = currTime;
        calendar.add(Calendar.DAY_OF_MONTH, -day);
        String lastDayTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(calendar.getTimeInMillis())).substring(0, 8);
        queryTimeArr[1] = lastDayTime;
        System.out.println(queryTimeArr.toString());
        for (int i = 0; i < queryTimeArr.length; i++) {
            System.out.println(queryTimeArr[i]);
        }
    }

    @Test
    public void getDealTimeCondition11() {
        Date date = new Date();
        Date date1 = new Date(date.getTime() - 600000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        String nowTenMinutes = sdf.format(date).substring(0, 11);//当前的10分钟串
        String lastTenMinutes = sdf.format(date1).substring(0, 11);//上一10分钟串
        System.out.println(lastTenMinutes);
    }

    @Test
    public void getDealTimeCondition12() throws ParseException {
        String str = "2021-06-22T09:21:06.124+00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date parse = sdf.parse(str);
        String format = sdf2.format(parse);
        System.out.println(format);
    }    //计算近五日的值

    @Test
    public void tets111() {
        //获取近几日的时间戳
        List<String> aimTimeList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();

        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
        for (int i = 0; i < 30; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            //aimTime = aimTime.substring(0, 11);
            //System.out.println("i为=" + aimTime);
            aimTimeList.add(aimTime);
        }
        System.out.println(aimTimeList.toString());
        System.out.println(aimTimeList.size());


    }

    @Test
    public void tets112() throws ParseException {
        String dateStr = "2022-09-13 00:00:00";
        // String dealTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        System.out.println(compareTime(dateStr));
    }

    @Test
    public void tets113() {
        Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
        Date date = DateUtils.addHours(new Date(now.getTime()), 24);
        System.out.println(date);
    }

    @Test
    public void tets114(){
        Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());

        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(now.getTime())));
        System.out.println("30天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(now.getTime()-30 * 24 * 60 * 60*1000L)));

    }

    @Test
    public void tets115() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        Date zero = calendar.getTime();
        //获取生效时间(今日0点)
        String todayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(zero.getTime());  // 获取年月日时分秒
        String today = new SimpleDateFormat("yyyyMMdd").format(zero.getTime());  // 获取年月日时分秒
        Date date = new Date(zero.getTime() + (7 * 24 * 60 * 60 -1)* 1000L);
        String todayTime2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);  // 获取年月日时分秒
        System.out.println(todayTime2);

    }

    @Test
    public void tets116() {
        ArrayList userActionBlackUserList = new ArrayList<>();
        //List<String> userActionList = logUserActionResultMapper.queryLevel6BlackUser(yesterday);
        //获取近7日时间
        //获取近几日的时间戳
        List<String> aimTimeList = new ArrayList<String>();
        Calendar calendar1 = Calendar.getInstance();
        System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
        for (int i = 0; i < 7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_MONTH, -i);
            String aimTime = new SimpleDateFormat("yyyyMMdd").format(new Date(calendar.getTimeInMillis()));
            System.out.println(aimTime);
            aimTimeList.add(aimTime);
        }

    }


    @Test
    public void tets117() {
        System.out.println(new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis() - 30 * 24 * 60 * 60 * 1000L)));
        String str = "\n" +
                "  select  DISTINCT  a.svcNumber\n" +
                "            from ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210901' and length(svcNumber) =11 and   t.click_size ='0' ) a \n" +
                "            all left JOIN ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210902' and length(svcNumber) =11 and   t.click_size ='0' ) a1\n" +
                "            on a.svcNumber=a1.svcNumber\n" +
                "            \n" +
                "            all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210903' and length(svcNumber) =11 and   t.click_size ='0' ) a2\n" +
                "             on a1.svcNumber=a2.svcNumber\n" +
                "             \n" +
                "               all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210904' and length(svcNumber) =11 and   t.click_size ='0' ) a3\n" +
                "             on a2.svcNumber=a3.svcNumber\n" +
                "               all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210905' and length(svcNumber) =11 and   t.click_size ='0' ) a4\n" +
                "             on a3.svcNumber=a4.svcNumber\n" +
                "                      all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210906' and length(svcNumber) =11 and   t.click_size ='0' ) a5\n" +
                "             on a4.svcNumber=a5.svcNumber\n" +
                "                      all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210907' and length(svcNumber) =11 and   t.click_size ='0' ) a6\n" +
                "             on a5.svcNumber=a6.svcNumber\n" +
                "                      all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210908' and length(svcNumber) =11 and   t.click_size ='0' ) a7\n" +
                "             on a6.svcNumber=a7.svcNumber\n" +
                "                      all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210909' and length(svcNumber) =11 and   t.click_size ='0' ) a8\n" +
                "             on a7.svcNumber=a8.svcNumber\n" +
                "                      all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210910' and length(svcNumber) =11 and   t.click_size ='0' ) a9\n" +
                "             on a8.svcNumber=a9.svcNumber\n" +
                "                      all left JOIN\n" +
                "            ( select    svc_number   as svcNumber from fk_prod.log_user_action_result_all t where toYYYYMMDD(insert_time)='20210911' and length(svcNumber) =11 and   t.click_size ='0' ) a10\n" +
                "             on a9.svcNumber=a10.svcNumber\n" +
                "             \n" +
                "             where a.svcNumber=a1.svcNumber and \n" +
                "             a1.svcNumber=a2.svcNumber and \n" +
                "                a2.svcNumber=a3.svcNumber and \n" +
                "                   a3.svcNumber=a4.svcNumber and \n" +
                "                      a4.svcNumber=a5.svcNumber and \n" +
                "                         a5.svcNumber=a6.svcNumber and \n" +
                "                            a6.svcNumber=a7.svcNumber and \n" +
                "                               a7.svcNumber=a8.svcNumber and \n" +
                "                                 a8.svcNumber=a9.svcNumber and \n" +
                "                            a9.svcNumber=a10.svcNumber \n" +
                "                            \n" +
                "                            \n" +
                "                            \n" +
                "                            ";
    }


    public long getTime2(int day, int hour,int minute) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, day);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        //将分钟至0
        calendar.set(Calendar.MINUTE, minute);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis();
    }
    @Test
    public void tets118() {
      /*  long time2 = getTime2(0, 1,0);
        Date date = new Date(time2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        //System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));
*/
        long time2 = getTime2(-1, 23,50);
        Date date = new Date(time2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);
        //System.out.println("今天为=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(calendar1.getTimeInMillis())));



    }

    @Test
    public void tets119() {

        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Timestamp(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(logFkRzZzLoginUser.getInertTime()).getTime()))

    }



}
