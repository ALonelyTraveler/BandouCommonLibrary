package com.bandou.library.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期操作工具类
 */
public class DateUtils {

    /**
     * The constant DATE_FORMAT_1.
     */
    public static final String DATE_FORMAT_1 = "yyyy-MM-dd";

    /**
     * The constant DATE_FORMAT_2.
     */
    public static final String DATE_FORMAT_2 = "yyyy/MM/dd";

    /**
     * The constant TIME_FORMAT_1.
     */
    public static final String TIME_FORMAT_1 = DATE_FORMAT_1 + " HH:mm:ss";

    /**
     * The constant TIME_FORMAT_2.
     */
    public static final String TIME_FORMAT_2 = DATE_FORMAT_2 + " HH:mm:ss";

    /**
     * 将时间字符串转换成Date
     *
     * @param str    the str
     * @param format the format
     * @return the date
     */
    public static Date strToDate(String str, String format) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (format == null || format.length() == 0) {
            return null;
        }
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;

    }

    /**
     * 将时间字符串转换成Calendar
     *
     * @param str    the str
     * @param format the format
     * @return calendar
     */
    public static Calendar strToCalendar(String str, String format) {

        Date date = strToDate(str, format);
        if (date == null) {
            return null;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c;
    }

    /**
     * Date to str string.
     * 日历时间转成指定格式字符串
     *
     * @param c      the c
     * @param format the format
     * @return the string
     */
    public static String dateToStr(Calendar c, String format) {
        if (c == null) {
            return null;
        }
        return dateToStr(c.getTime(), format);
    }


    /**
     * Date to str string.
     * Date时间转成指定格式字符串
     *
     * @param d      the d
     * @param format the format
     * @return the string
     */
    public static String dateToStr(Date d, String format) {
        if (d == null) {
            return null;
        }
        if (format == null || format.length() == 0) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String s = sdf.format(d);
        return s;
    }

    /**
     * Format millon to str string.
     * 毫秒数转换成指定格式字符串
     *
     * @param time   the time
     * @param format the format
     * @return the string
     */
    public static String formatMillonToStr(long time, String format) {

        return new SimpleDateFormat(format).format(time);

    }

    /**
     * 获取昨天 Data
     *
     * @param date the date
     * @return lastday date
     */
    public static Date getLastdayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        return calendar.getTime();
    }

    /**
     * 获取明天Date
     *
     * @param date the date
     * @return nextday date
     */
    public static Date getNextdayDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        return calendar.getTime();
    }

}
