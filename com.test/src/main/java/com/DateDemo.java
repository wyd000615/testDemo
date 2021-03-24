package com;

import net.sf.json.JSONObject;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    @Test
    public void tets(){
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

           String dateStr="{\"date\":26,\"day\":4,\"hours\":15,\"minutes\":40,\"month\":10,\"nanos\":449000000,\"seconds\":32,\"time\":1606376432449,\"timezoneOffset\":-480,\"year\":120}";
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


}
