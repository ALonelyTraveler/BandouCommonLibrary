package com.bandou.library.util;

/**
 * Created by dell on 2016/5/20.
 */
public class ObjectUtils {

    private ObjectUtils() {
        throw new AssertionError();
    }

    /**
     * compare two object
     *
     * @param actual   the actual
     * @param expected the expected
     * @return <ul>         <li>if both are null, return true</li>         <li>return actual.{@link Object#equals(Object)}</li>         </ul>
     */
    public static boolean isEquals(Object actual, Object expected) {
        return actual == expected || (actual == null ? expected == null : actual.equals(expected));
    }

    /**
     * compare two object
     * <ul>
     * <li>if v1 &lt; v2, return 1</li>
     * <li>if v1 = v2, return 0</li>
     * <li>if v1 &gt; v2, return -1</li>
     * </ul>
     * <ul>
     * <li>if v1 is null, v2 is null, then return 0</li>
     * <li>if v1 is null, v2 is not null, then return -1</li>
     * <li>if v1 is not null, v2 is null, then return 1</li>
     * <li>return v1.{@link Comparable#compareTo(Object)}</li>
     * </ul>
     *
     * @param <V> the type parameter
     * @param v1  the v 1
     * @param v2  the v 2
     * @return int
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <V> int compare(V v1, V v2) {
        return v1 == null ? (v2 == null ? 0 : -1) : (v2 == null ? 1 : ((Comparable)v1).compareTo(v2));
    }
}
