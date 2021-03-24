package com.until;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DataUntil {
    public static  Timestamp getCurrMonthLastDayTimestamp() {

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 24);
        //将小时至0
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        //将分钟至0
        calendar.set(Calendar.MINUTE, 05);
        //将秒至0
        calendar.set(Calendar.SECOND, 0);
        //将毫秒至0
        calendar.set(Calendar.MILLISECOND, 0);
        //获得当前月第一天
        Date sdate = calendar.getTime();
        //获得当前月最后一天
        Date edate = calendar.getTime();
        Timestamp timestamp = new Timestamp(edate.getTime());
        return timestamp;

    }
}
