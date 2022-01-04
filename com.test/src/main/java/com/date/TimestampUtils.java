package com.date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimestampUtils {

    public static final String DATE_TIME = "yyyyMMddHHmmss";
    public static final String DATE_TIME_FAR = "yyyyMMddHHmmssSSS";
    public static final String DATE_NORMAL_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TO_MINUTE = "yyyyMMddHHmm";
    public static final String DATE_TO_HOUR = "yyyyMMddHH";
    public static final String DATE = "yyyyMMdd";
    public static final String DATE2 = "yyyy-MM-dd";
    public static final String YEAR_MONTH = "yyyyMM";
    public static final String TIME = "HHmmss";

    public static final String EEEE="EEEE";



    /**
     * 字符串转日期
     *
     * @param date
     * @param pattern
     * @return
     * @throws ParseException
     */

    public static Timestamp parse(String date, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return new Timestamp(sdf.parse(date).getTime());
    }

    /**
     * 日期转字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }

    /**
     * 计算给定日期偏移指定年数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移年数，正值增加，负值减少
     * @return
     */
    public static Timestamp addYears(Date date, int amount) {
        return new Timestamp(DateUtils.addYears(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定月数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移月数，正值增加，负值减少
     * @return
     */
    public static Timestamp addMonths(Date date, int amount) {
        return new Timestamp(DateUtils.addMonths(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定星期数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移星期数，正值增加，负值减少
     * @return
     */
    public static Timestamp addWeeks(Date date, int amount) {
        return new Timestamp(DateUtils.addWeeks(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定日数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移日数，正值增加，负值减少
     * @return
     */
    public static Timestamp addDays(Date date, int amount) {
        return new Timestamp(DateUtils.addDays(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定小时数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移小时数，正值增加，负值减少
     * @return
     */

    public static Timestamp addHours(Date date, int amount) {
        return new Timestamp(DateUtils.addHours(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定分钟数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移分钟数，正值增加，负值减少
     * @return
     */

    public static Timestamp addMinutes(Date date, int amount) {
        return new Timestamp(DateUtils.addMinutes(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定秒数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移秒数，正值增加，负值减少
     * @return
     */

    public static Timestamp addSeconds(Date date, int amount) {
        return new Timestamp(DateUtils.addSeconds(date, amount).getTime());
    }

    /**
     * 计算给定日期偏移指定毫秒数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移毫秒数，正值增加，负值减少
     * @return
     */

    public static Timestamp addMilliseconds(Date date, int amount) {
        return new Timestamp(DateUtils.addMilliseconds(date, amount).getTime());
    }

    /**
     * 日期截断
     *
     * @param date  给定日期
     * @param field
     * @return
     * @see Calendar
     * @see DateUtils
     */
    public static Timestamp truncate(Date date, int field) {
        return new Timestamp(DateUtils.truncate(date, field).getTime());
    }

    /**
     * 日期向上取整
     *
     * @param date  给定日期
     * @param field
     * @return
     * @see Calendar
     * @see DateUtils
     */
    public static Timestamp ceiling(Date date, int field) {
        return new Timestamp(DateUtils.ceiling(date, field).getTime());
    }

    /**
     * 日期四舍五入
     *
     * @param date  给定日期
     * @param field
     * @return
     * @see Calendar
     * @see DateUtils
     */
    public static Timestamp round(Date date, int field) {
        return new Timestamp(DateUtils.round(date, field).getTime());
    }

    /**
     * 计算星期
     *
     * @param timestamp 给定日期
     * @return 周一 = 1 周日 = 7
     */
    public static int getDayOfWeek(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        int num = calendar.get(Calendar.DAY_OF_WEEK);
        if (1 == num)
            num = 7;
        else
            num = num - 1;
        return num;
    }

    /**
     * 获取日期的年,格式: YYYY, 例如: 2016
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getYear(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取日期的年,格式: YYYYMM, 例如: 201601
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getYearMonth(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.YEAR) * 100 + calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的月份,格式: 1 - 12
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getMonth(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期的天,格式: 1 - 31
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getDay(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期的小时,格式: 0 - 23
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getHour(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获取日期的分钟,格式: 0 - 59
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getMinute(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 获取日期的秒,格式: 0 - 60
     *
     * @param timestamp 给定日期
     * @return
     */
    public static int getSecond(Timestamp timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        return calendar.get(Calendar.SECOND);
    }

    /**
     * 是否同一天
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean isSameDay(Timestamp left, Timestamp right) {
        return TimestampUtils.isSameDay(left, right);
    }

    /**
     * 是否同一月
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean isSameMonth(Timestamp left, Timestamp right) {
        final Calendar cal1 = Calendar.getInstance();
        cal1.setTime(left);
        final Calendar cal2 = Calendar.getInstance();
        cal2.setTime(right);

        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH));
    }

    /**
     * 获取给定日期之间月数，不包含当前月（非整月算一个月,精确到月）
     *
     * @param beginTime 起始时间
     * @param endTime   结束时间
     * @return 月数
     */
    public static int monthsBetween(Timestamp beginTime, Timestamp endTime) {
        int years = TimestampUtils.getYear(endTime) - TimestampUtils.getYear(beginTime);
        int months = TimestampUtils.getMonth(endTime) - TimestampUtils.getMonth(beginTime);
        return years * 12 + months;
    }

    public static int daysBetween(Timestamp beginTime, Timestamp endTime) {
        int rawOffset = TimeZone.getDefault().getRawOffset();
        return (int) ((endTime.getTime() + rawOffset) / 86400000 - (beginTime.getTime() + rawOffset) / 86400000);
    }

    public static int hoursBetween(Timestamp beginTime, Timestamp endTime) {
        return (int) (endTime.getTime() / 3600000 - beginTime.getTime() / 3600000);
    }

    public static int minutesBetween(Timestamp beginTime, Timestamp endTime) {
        return (int) (endTime.getTime() / 60000 - beginTime.getTime() / 60000);
    }

    public static int secondsBetween(Timestamp beginTime, Timestamp endTime) {
        return (int) (endTime.getTime() / 1000 - beginTime.getTime() / 1000);
    }

    /**
     * 判断日期是否有效(effDate <= timestamp < expDate
     *
     * @param timestamp 时间戳
     * @param effDate   生效时间
     * @param expDate   失效时间
     * @return
     */
    public static boolean valid(Timestamp timestamp, Timestamp effDate, Timestamp expDate) {
        return timestamp.compareTo(effDate) >= 0 && (expDate == null || timestamp.compareTo(expDate) < 0);
    }

    /**
     * 判断日期是否有效(effDate < timestamp < expDate
     *
     * @param timestamp 时间戳
     * @param effDate   生效时间
     * @param expDate   失效时间
     * @return
     */
    public static boolean validO(Timestamp timestamp, Timestamp effDate, Timestamp expDate) {
        return timestamp.compareTo(effDate) > 0 && (expDate == null || timestamp.compareTo(expDate) < 0);
    }

    /**
     * 判断日期是否在前
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean before(Timestamp left, Timestamp right) {
        if (left == null)
            return false;
        else if (right == null)
            return true;
        else
            return left.before(right);
    }

    /**
     * 判断日期是否在后
     *
     * @param left
     * @param right
     * @return
     */
    public static boolean after(Timestamp left, Timestamp right) {
        if (left == null)
            return true;
        else if (right == null)
            return false;
        else
            return left.after(right);
    }

    /**
     * 判断账期是否有效:
     * effDate(yyyymm) <= acctCycle <= expDate(yyyymm，减1秒)
     * effDate(yyyymmdd) <= acctCycle <= expDate(yyyymmdd，减1秒)
     *
     * @param acctCycle 账期 yyyymm(dd)
     * @param effDate   生效时间
     * @param expDate   失效时间
     * @return
     */
    public static boolean valid(String acctCycle, Timestamp effDate, Timestamp expDate) {
        String pattern = acctCycle.length() == 6 ? TimestampUtils.YEAR_MONTH : TimestampUtils.DATE;

        String effCycle = TimestampUtils.format(effDate, pattern);
        if (acctCycle.compareTo(effCycle) < 0)
            return false;

        if (expDate == null)
            return true;

        String expCycle = TimestampUtils.format(TimestampUtils.addSeconds(expDate, -1), pattern);
        return (acctCycle.compareTo(expCycle) <= 0);
    }

    /**
     * 获取下个月1号时间
     *
     * @param nowMonthFirst
     * @return
     */
    public static Timestamp getNextMonthFirst(Timestamp nowMonthFirst) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowMonthFirst);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取上个月1号时间
     *
     * @param nowMonthFirst
     * @return
     */
    public static Timestamp getLastMonthFirst(Timestamp nowMonthFirst) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowMonthFirst);
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取下下个月1号时间
     *
     * @param nowMonthFirst
     * @return
     */
    public static Timestamp getSecondMonthFirst(Timestamp nowMonthFirst) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowMonthFirst);
        calendar.add(Calendar.MONTH, 2);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取下下个月1号时间
     *
     * @param nowMonthFirst
     * @return
     */
    public static Timestamp getMonthSecond(Timestamp nowMonthFirst) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowMonthFirst);
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 2);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getExpDate(Timestamp now, int monthAdd) {
        return addMonths(truncate(now, Calendar.MONTH), monthAdd);
    }

    public static Timestamp now() {
        return new Timestamp(new Date().getTime());
    }

    /**
     * 计算给定日期偏移指定月数后的日期
     *
     * @param date   给定日期
     * @param amount 偏移月数，正值增加，负值减少
     * @return
     */
    public static Timestamp add(Date date, int amount, String unit) {
        Timestamp timestamp = null;
        try {
            switch (unit) {
                case "year":
                    timestamp = addYears(date, amount);
                    break;
                case "month":
                    timestamp = addMonths(date, amount);
                    break;
                case "day":
                    timestamp = addDays(date, amount);
                    break;
                case "week":
                    timestamp = addWeeks(date, amount);
                    break;
                case "hour":
                    timestamp = addHours(date, amount);
                    break;
                case "minute":
                    timestamp = addMinutes(date, amount);
                    break;
                case "second":
                    timestamp = addSeconds(date, amount);
                    break;
                case "millisecond":
                    timestamp = addMilliseconds(date, amount);
                    break;
                default:
                    timestamp = addMonths(date, 1);
                    break;
            }
        }catch (Exception e){
            Timestamp now = new Timestamp(Calendar.getInstance(TimeZone.getTimeZone("GMT+8")).getTimeInMillis());
            timestamp=addMonths(now,1);
        }
        return timestamp;
    }

    /**
     * 比较时间先后
     * 和当前时间作比较
     * 小于当前时间返回true 否则返回false
     * 为空返回true
     *
     * @param beginStr   开始时间
     * @return
     */
    public static boolean compareTime(String beginStr) {
        if (StringUtils.isEmpty(beginStr)) {
            return true;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_NORMAL_TIME);
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
    /**
     * 判断当前时间是否在指定范围时间内
     *
     * @param businessTime 时间段  12:00--13:00
     * @return true-在  false-不在
     */
    public static Boolean judgeTheTimeRange(String businessTime) {
        try {
            String[] times = businessTime.split("--");
            String[] time1 = times[0].split(":");
            String[] time2 = times[1].split(":");
            //当前时间
            Calendar currentDate = Calendar.getInstance();
            currentDate.setTime(new Date());
            //开始时间
            Calendar min = Calendar.getInstance();
            min.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
            min.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
            min.set(Calendar.DAY_OF_MONTH, currentDate.get(Calendar.DAY_OF_MONTH));
            min.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time1[0]));
            min.set(Calendar.MINUTE, Integer.parseInt(time1[1]));
            min.set(Calendar.SECOND, 0);
            min.set(Calendar.MILLISECOND, 0);
            //结束时间
            Calendar max = Calendar.getInstance();
            max.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
            max.set(Calendar.MONTH, currentDate.get(Calendar.MONTH));
            max.set(Calendar.DAY_OF_MONTH, currentDate.get(Calendar.DAY_OF_MONTH));
            max.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time2[0]));
            max.set(Calendar.MINUTE, Integer.parseInt(time2[1]));
            max.set(Calendar.SECOND, 0);
            max.set(Calendar.MILLISECOND, 0);

            if (max.getTimeInMillis() >= min.getTimeInMillis()) {
                if (currentDate.getTimeInMillis() >= min.getTimeInMillis() && currentDate.getTimeInMillis() <= max.getTimeInMillis()) {
                    return true;
                } else {
                    return false;
                }
            } else {
                max.set(Calendar.DAY_OF_MONTH, currentDate.get(Calendar.DAY_OF_MONTH) + 1);
                if (currentDate.getTimeInMillis() >= min.getTimeInMillis() && currentDate.getTimeInMillis() <= max.getTimeInMillis()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(compareTime(""));
    }

}
