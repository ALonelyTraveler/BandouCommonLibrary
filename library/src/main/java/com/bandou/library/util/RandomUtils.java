package com.bandou.library.util;

import java.util.Random;

/**
 * Random Utils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2012-5-12
 */
public class RandomUtils {

    /**
     * The constant NUMBERS_AND_LETTERS.
     */
    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * The constant NUMBERS.
     */
    public static final String NUMBERS             = "0123456789";
    /**
     * The constant LETTERS.
     */
    public static final String LETTERS             = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * The constant CAPITAL_LETTERS.
     */
    public static final String CAPITAL_LETTERS     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * The constant LOWER_CASE_LETTERS.
     */
    public static final String LOWER_CASE_LETTERS  = "abcdefghijklmnopqrstuvwxyz";

    private RandomUtils() {
        throw new AssertionError();
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase, lowercase letters and numbers
     *
     * @param length the length
     * @return random numbers and letters
     * RandomUtils#getRandom(String source, int length) RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomNumbersAndLetters(int length) {
        return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of numbers
     *
     * @param length the length
     * @return random numbers
     * RandomUtils#getRandom(String source, int length) RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomNumbers(int length) {
        return getRandom(NUMBERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase and lowercase letters
     *
     * @param length the length
     * @return random letters
     * RandomUtils#getRandom(String source, int length) RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomLetters(int length) {
        return getRandom(LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of uppercase letters
     *
     * @param length the length
     * @return random capital letters
     * RandomUtils#getRandom(String source, int length) RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomCapitalLetters(int length) {
        return getRandom(CAPITAL_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of lowercase letters
     *
     * @param length the length
     * @return random lower case letters
     * RandomUtils#getRandom(String source, int length) RandomUtils#getRandom(String source, int length)
     */
    public static String getRandomLowerCaseLetters(int length) {
        return getRandom(LOWER_CASE_LETTERS, length);
    }

    /**
     * get a fixed-length random string, its a mixture of chars in source
     *<ul>
     *     <li>if source is null or empty, return null</li>
     *     <li>else see {@link RandomUtils#getRandom(char[] sourceChar, int length)}</li>
     *</ul>
     * @param source the source
     * @param length the length
     * @return 返回source中的指定长度的随机字符串
     */
    public static String getRandom(String source, int length) {
        return StringUtils.isEmpty(source) ? null : getRandom(source.toCharArray(), length);
    }

    /**
     * get a fixed-length random string, its a mixture of chars in sourceChar
     *<ul>
     *     <li>if sourceChar is null or empty, return null</li>
     *     <li>if length less than 0, return null</li>
     *</ul>
     * @param sourceChar the source char
     * @param length     the length
     * @return 返回sourceChar中的指定长度的随机字符串
     */
    public static String getRandom(char[] sourceChar, int length) {
        if (sourceChar == null || sourceChar.length == 0 || length < 0) {
            return null;
        }

        StringBuilder str = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            str.append(sourceChar[random.nextInt(sourceChar.length)]);
        }
        return str.toString();
    }

    /**
     * get random int between 0 and max
     * <ul>
     *     <li>if max &le; 0, return 0</li>
     *     <li>else return random int between 0 and max</li>
     * </ul>
     * @param max the max
     * @return 返回[0,max]中的随机数
     */
    public static int getRandom(int max) {
        return getRandom(0, max);
    }

    /**
     * get random int between min and max
     * <ul>
     *     <li>if min &gt; max, return 0</li>
     *     <li>if min == max, return min</li>
     *     <li>else return random int between min and max</li>
     * </ul>
     * @param min the min
     * @param max the max
     * @return 返回[min,max]中的随机数
     */
    public static int getRandom(int min, int max) {
        if (min > max) {
            return 0;
        }
        if (min == max) {
            return min;
        }
        return min + new Random().nextInt(max - min);
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified array using a default source of randomness
     *
     * @param objArray the obj array
     * @return boolean
     */
    public static boolean shuffle(Object[] objArray) {
        if (objArray == null) {
            return false;
        }

        return shuffle(objArray, getRandom(objArray.length));
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified array
     *
     * @param objArray     the obj array
     * @param shuffleCount the shuffle count
     * @return boolean
     */
    public static boolean shuffle(Object[] objArray, int shuffleCount) {
        int length;
        if (objArray == null || shuffleCount < 0 || (length = objArray.length) < shuffleCount) {
            return false;
        }

        for (int i = 1; i <= shuffleCount; i++) {
            int random = getRandom(length - i);
            Object temp = objArray[length - i];
            objArray[length - i] = objArray[random];
            objArray[random] = temp;
        }
        return true;
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified int array using a default source of randomness
     *
     * @param intArray the int array
     * @return int [ ]
     */
    public static int[] shuffle(int[] intArray) {
        if (intArray == null) {
            return null;
        }

        return shuffle(intArray, getRandom(intArray.length));
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified int array
     *
     * @param intArray     the int array
     * @param shuffleCount the shuffle count
     * @return int [ ]
     */
    public static int[] shuffle(int[] intArray, int shuffleCount) {
        int length;
        if (intArray == null || shuffleCount < 0 || (length = intArray.length) < shuffleCount) {
            return null;
        }

        int[] out = new int[shuffleCount];
        for (int i = 1; i <= shuffleCount; i++) {
            int random = getRandom(length - i);
            out[i - 1] = intArray[random];
            int temp = intArray[length - i];
            intArray[length - i] = intArray[random];
            intArray[random] = temp;
        }
        return out;
    }
}
