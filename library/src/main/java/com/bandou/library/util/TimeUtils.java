package com.bandou.library.util;

import android.text.TextUtils;

/**
 * The type Time utils.
 *
 * ClassName: TimeUtils
 * Description: say something
 * @author: chenwei
 * @version: V1.0
 * Date: 16 /7/18 下午5:20
 */
public class TimeUtils {

    /**
     * The constant TIME_FORMAT_WITHOUT_ZERO_1.
     */
    public static final String TIME_FORMAT_WITHOUT_ZERO_1 = "%d:%d:%d";

    /**
     * The constant TIME_FORMAT_WITH_ZERO_1.
     */
    public static final String TIME_FORMAT_WITH_ZERO_1 = "%02d:%02d:%02d";

    /**
     * The constant TIME_FORMAT_WITH_ZERO_2.
     */
    public static final String TIME_FORMAT_WITH_ZERO_2 = "%02d:%02d";

    /**
     * The constant TIME_FORMAT_WITHOUT_ZERO_2.
     */
    public static final String TIME_FORMAT_WITHOUT_ZERO_2 = "%d:%d";

    /**
     * 不显示秒
     * The constant INVALID_SECOND.
     */
    public static final int INVALID_SECOND = -1;

    /**
     * 按指定格式格式化时间
     * @param format 格式字符串
     * @param hour 小时
     * @param min 分钟
     * @param second 秒钟
     * @return 格式化后的字符串
     */
    private static String formatTime(String format,int hour, int min, int second) {
        if (TextUtils.isEmpty(format)) {
            return null;
        }
        return second==INVALID_SECOND?String.format(format,hour,min):String.format(format, hour, min, second);
    }

    /**
     * Format with zero and second string.
     * 格式化成HH:mm:ss不足两位自动补零
     * @param millis the time
     * @return the string
     */
    public static String formatWithZeroAndSecond(long millis) {
        int hour = (int) (millis / 3600000);
        int minute = (int) (millis / 60000 - 60 * hour);
        int second = (int) ((millis / 1000) % 60);
        return formatTime(TIME_FORMAT_WITH_ZERO_1, hour, minute, second);
    }

    /**
     * Format time length without zero string.
     * 格式化成HH:mm不自动补零
     * @param millis the time
     * @return the string
     */
    public static String formatWithoutZeroNoSecond(long millis) {
        int hour = (int) (millis / 3600000);
        int minute = (int) (millis / 60000 - 60 * hour);
        int second = (int) ((millis / 1000) % 60);
        return formatTime(TIME_FORMAT_WITHOUT_ZERO_2, hour, minute, INVALID_SECOND);
    }

    /**
     * Format with zero out second string.
     * 格式化成HH:mm 不足两位自动补零
     * @param millis the millis
     * @return the string
     */
    public static String formatWithZeroNoSecond(long millis) {
        int hour = (int) (millis / 3600000);
        int minute = (int) (millis / 60000 - 60 * hour);
        int second = (int) ((millis / 1000) % 60);
        return formatTime(TIME_FORMAT_WITH_ZERO_2, hour, minute, second);
    }


    /**
     * Format without zero and second string.
     *格式化成HH:mm:ss 不自动补零
     * @param millis the millis
     * @return the string
     */
    public static String formatWithoutZeroAndSecond(long millis) {
        int hour = (int) (millis / 3600000);
        int minute = (int) (millis / 60000 - 60 * hour);
        int second = (int) ((millis / 1000) % 60);
        return formatTime(TIME_FORMAT_WITHOUT_ZERO_1, hour, minute, second);
    }
}
