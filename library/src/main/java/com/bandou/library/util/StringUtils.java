/*
 * Copyright (C) 2016 venshine.cn@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bandou.library.util;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.Formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 字符串操作
 *
 * @author venshine
 */
public class StringUtils {

    private StringUtils() {
        throw new AssertionError();
    }

    /**
     * Judge whether a string is whitespace, empty ("") or null.
     *
     * @param str the str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0 || str.equalsIgnoreCase("null")) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == false)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns true if a and b are equal, including if they are both null.
     *
     * @param a the a
     * @param b the b
     * @return boolean
     */
    public static boolean equals(CharSequence a, CharSequence b) {
        return TextUtils.equals(a, b);
    }

    /**
     * Converts this string to lower case, using the rules of {@code locale}.
     *
     * @param s the s
     * @return string
     */
    public static String toLowerCase(String s) {
        return s.toLowerCase(Locale.getDefault());
    }

    /**
     * Converts this this string to upper case, using the rules of {@code locale}.
     *
     * @param s the s
     * @return string
     */
    public static String toUpperCase(String s) {
        return s.toUpperCase(Locale.getDefault());
    }

    /**
     * capitalize first letter
     * 首字母大写
     * <pre>
     * capitalizeFirstLetter(null)     =   null;
     * capitalizeFirstLetter("")       =   "";
     * capitalizeFirstLetter("2ab")    =   "2ab"
     * capitalizeFirstLetter("a")      =   "A"
     * capitalizeFirstLetter("ab")     =   "Ab"
     * capitalizeFirstLetter("Abc")    =   "Abc"
     * </pre>
     *
     * @param str the str
     * @return string
     */
    public static String capitalizeFirstLetter(String str) {
        if (isEmpty(str)) {
            return str;
        }

        char c = str.charAt(0);
        return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str : new StringBuilder(str.length())
                .append(Character.toUpperCase(c)).append(str.substring(1)).toString();
    }

    /**
     * 字符串省略截取
     * 字符串截取到指定长度size+...的形式
     *
     * @param subject the subject
     * @param size    the size
     * @return string
     */
    public static String subStringOmit(String subject, int size) {
        if (subject != null && subject.length() > size) {
            subject = subject.substring(0, size) + "...";
        }
        return subject;
    }

    /**
     * 根据指定的字符把源字符串分割成一个数组
     *
     * @param str    the str
     * @param symbol the symbol
     * @return list
     */
    public static List<String> str2List(String str, String symbol) {

        if (str == null)
            return null;
        List<String> list = new ArrayList<String>();
        String[] result = str.split(symbol);
        for (int i = 0; i < result.length; i++) {
            list.add(result[i]);
        }
        return list;
    }

    /**
     * 将list 用传入的分隔符组装为String
     *
     * @param list   the list
     * @param symbol the symbol
     * @return the string
     */
    public static String list2Str(List list, String symbol) {
        StringBuffer returnStr = new StringBuffer();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                returnStr.append(list.get(i)).append(symbol);
            }
        }
        if (returnStr.toString().length() > 0) {
            return returnStr.toString().substring(0, returnStr.toString().lastIndexOf(symbol));
        } else {
            return "";
        }
    }

    /**
     * 截取字符串左侧指定长度的字符串
     *
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串 string
     */
    public static String left(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(0, count);
    }

    /**
     * 截取字符串右侧指定长度的字符串
     *
     * @param input 输入字符串
     * @param count 截取长度
     * @return 截取字符串 string
     */
    public static String right(String input, int count) {
        if (isEmpty(input)) {
            return "";
        }
        count = (count > input.length()) ? input.length() : count;
        return input.substring(input.length() - count, input.length());
    }

    /**
     * 获取字符串str在String中出现的次数
     *
     * @param string the string
     * @param str    the str
     * @return int
     */
    public static int countSubStr(String string, String str) {
        if ((str == null) || (str.length() == 0) || (string == null) || (string.length() == 0)) {
            return 0;
        }
        int count = 0;
        int index = 0;
        while ((index = string.indexOf(str, index)) != -1) {
            count++;
            index += string.length();
        }
        return count;
    }

    /**
     * transform half width char to full width char
     * 字符串全角转半角
     * <pre>
     * fullWidthToHalfWidth(null) = null;
     * fullWidthToHalfWidth("") = "";
     * fullWidthToHalfWidth(new String(new char[] {12288})) = " ";
     * </pre>
     *
     * @param s the s
     * @return string
     */
    public static String fullWidthToHalfWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == 12288) {
                source[i] = ' ';
                // } else if (source[i] == 12290) {
                // source[i] = '.';
            } else if (source[i] >= 65281 && source[i] <= 65374) {
                source[i] = (char) (source[i] - 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * transform full width char to half width char
     * 字符串半角转全角
     * <pre>
     * halfWidthToFullWidth(null) = null;
     * halfWidthToFullWidth("") = "";
     * halfWidthToFullWidth(" ") = new String(new char[] {12288});
     * </pre>
     *
     * @param s the s
     * @return string
     */
    public static String halfWidthToFullWidth(String s) {
        if (isEmpty(s)) {
            return s;
        }

        char[] source = s.toCharArray();
        for (int i = 0; i < source.length; i++) {
            if (source[i] == ' ') {
                source[i] = (char) 12288;
                // } else if (source[i] == '.') {
                // source[i] = (char)12290;
            } else if (source[i] >= 33 && source[i] <= 126) {
                source[i] = (char) (source[i] + 65248);
            } else {
                source[i] = source[i];
            }
        }
        return new String(source);
    }

    /**
     * 将size格式化成储存格式输出，即M/G/kb等
     *
     * @param context the context
     * @param size    the size
     * @return the string
     */
    public static String formatSize(Context context, long size) {
        return Formatter.formatFileSize(context, size);
    }
}