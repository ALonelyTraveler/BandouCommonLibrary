package com.bandou.library.util;

import java.util.Map;

/**
 * Created by dell on 2016/5/20.
 */
public class MapUtils {

    private MapUtils() {
        throw new AssertionError();
    }

    /**
     * is null or its size is 0
     * <pre>
     * isEmpty(null)   =   true;
     * isEmpty({})     =   true;
     * isEmpty({1, 2})    =   false;
     * </pre>
     *
     * @param <K>       the type parameter
     * @param <V>       the type parameter
     * @param sourceMap the source map
     * @return if map is null or its size is 0, return true, else return false.
     */
    public static <K, V> boolean isEmpty(Map<K, V> sourceMap) {
        return (sourceMap == null || sourceMap.size() == 0);
    }

    /**
     * get key by value, match the first entry front to back
     * <ul>
     * <li>for HashMap, the order of entry not same to put order, so you may need to use TreeMap</li>
     * </ul>
     *
     * @param <K>   the type parameter
     * @param <V>   the type parameter
     * @param map   the map
     * @param value the value
     * @return <ul>         <li>if map is null, return null</li>         <li>if value exist, return key</li>         <li>return null</li>         </ul>
     */
    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        if (isEmpty(map)) {
            return null;
        }

        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (ObjectUtils.isEquals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null;
    }

}
