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

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 集合操作
 *
 * @author venshine
 */
public class CollectionUtils {

    private static final String DELIMITER = ",";

    /**
     * Judge whether a collection is null or size is 0
     *
     * @param <V> the type parameter
     * @param c   the c
     * @return boolean
     */
    public static <V> boolean isEmpty(Collection<V> c) {
        return (c == null || c.size() == 0);
    }

    /**
     * Join collection to string, separator is {@link #DELIMITER}
     *
     * @param tokens the tokens
     * @return string
     */
    public static String join(Iterable tokens) {
        return join(tokens,DELIMITER);
    }

    /**
     * Join string.
     *
     * @param tokens    the tokens
     * @param joinSplit the join split
     * @return the string
     */
    public static String join(Iterable tokens, String joinSplit) {
        return tokens == null ? "" : TextUtils.join(joinSplit, tokens);
    }

    /**
     * Convert array to list
     *
     * @param <T>   the type parameter
     * @param array the array
     * @return list
     */
    public static <T> List<T> arrayToList(T... array) {
        return Arrays.asList(array);
    }

    /**
     * Convert array to set
     *
     * @param <T>   the type parameter
     * @param array the array
     * @return set
     */
    public static <T> Set<T> arrayToSet(T... array) {
        return new HashSet<T>(arrayToList(array));
    }

    /**
     * Convert collection to array
     *
     * @param c the c
     * @return object [ ]
     */
    public static Object[] listToArray(Collection<?> c) {
        if (!isEmpty(c)) {
            return c.toArray();
        }
        return null;
    }

    /**
     * Convert list to set
     *
     * @param <T>  the type parameter
     * @param list the list
     * @return set
     */
    public static <T> Set<T> listToSet(List<T> list) {
        return new HashSet<T>(list);
    }

    /**
     * Convert set to list
     *
     * @param <T> the type parameter
     * @param set the set
     * @return to list
     */
    public static <T> List<T> setToList(Set<T> set) {
        return new ArrayList<T>(set);
    }

}
