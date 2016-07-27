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
import android.content.SharedPreferences;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;


/**
 * The type Preferences utils.
 * SharedPreferences工具类
 */
public class PreferencesUtils {
    private static String sPreferencesName = "preferences";

    /**
     * Init preferences name.
     *
     * @param preferencesName the preferences name
     */
    public void initPreferencesName(String preferencesName) {
        sPreferencesName = preferencesName;
    }

    /**
     * 保存数据的方法，我们需要拿到保存数据的具体类型，然后根据类型调用不同的保存方法
     *
     * @param context         the context
     * @param preferencesName the preferences name
     * @param key             the key
     * @param object          the object
     */
    public static void put(Context context,String preferencesName, String key, Object object) {
        SharedPreferences sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Integer) {
            editor.putInt(key, (Integer) object);
        } else if (object instanceof Boolean) {
            editor.putBoolean(key, (Boolean) object);
        } else if (object instanceof Float) {
            editor.putFloat(key, (Float) object);
        } else if (object instanceof Long) {
            editor.putLong(key, (Long) object);
        } else {
            editor.putString(key, object.toString());
        }

        SharedPreferencesCompat.apply(editor);
    }

    /**
     * Put.
     *
     * @param context the context
     * @param key     the key
     * @param object  the object
     */
    public static void put(Context context, String key, Object object) {
        put(context,sPreferencesName,key,object);
    }

    /**
     * 得到保存数据的方法，我们根据默认值得到保存的数据的具体类型，然后调用相对于的方法获取值
     *
     * @param context         the context
     * @param preferencesName the preferences name
     * @param key             the key
     * @param defaultObject   the default object
     * @return the object
     */
    public static Object get(Context context,String preferencesName, String key, Object defaultObject) {
        SharedPreferences sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);

        if (defaultObject instanceof String) {
            return sp.getString(key, (String) defaultObject);
        } else if (defaultObject instanceof Integer) {
            return sp.getInt(key, (Integer) defaultObject);
        } else if (defaultObject instanceof Boolean) {
            return sp.getBoolean(key, (Boolean) defaultObject);
        } else if (defaultObject instanceof Float) {
            return sp.getFloat(key, (Float) defaultObject);
        } else if (defaultObject instanceof Long) {
            return sp.getLong(key, (Long) defaultObject);
        } else {
            return null;
        }
    }

    /**
     * Get.
     *
     * @param context       the context
     * @param key           the key
     * @param defaultObject the default object
     * @return the object
     */
    public static Object get(Context context, String key, Object defaultObject) {
        return get(context,sPreferencesName,key,defaultObject);
    }

    /**
     * 移除某个key值已经对应的值
     *
     * @param context         the context
     * @param preferencesName the preferences name
     * @param key             the key
     */
    public static void removeKey(Context context,String preferencesName, String key) {
        SharedPreferences sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * Remove key.
     *
     * @param context the context
     * @param key     the key
     */
    public static void removeKey(Context context, String key) {
        removeKey(context, sPreferencesName, key);
    }

    /**
     * 清除所有数据
     *
     * @param context         the context
     * @param preferencesName the preferences name
     */
    public static void clearAll(Context context,String preferencesName) {
        SharedPreferences sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    /**
     * Clear all.
     *
     * @param context the context
     */
    public static void clearAll(Context context) {
        clearAll(context,sPreferencesName);
    }

    /**
     * 查询某个key是否已经存在
     *
     * @param context         the context
     * @param preferencesName the preferences name
     * @param key             the key
     * @return the boolean
     */
    public static boolean containsKey(Context context,String preferencesName, String key) {
        SharedPreferences sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        return sp.contains(key);
    }

    /**
     * Contains key boolean.
     *
     * @param context the context
     * @param key     the key
     * @return the boolean
     */
    public static boolean containsKey(Context context, String key) {
        return containsKey(context, sPreferencesName, key);
    }

    /**
     * 返回所有的键值对
     *
     * @param context         the context
     * @param preferencesName the preferences name
     * @return the all key value
     */
    public static Map<String, ?> getAllKeyValue(Context context,String preferencesName) {
        SharedPreferences sp = context.getSharedPreferences(preferencesName, Context.MODE_PRIVATE);
        return sp.getAll();
    }

    /**
     * Gets all key value.
     *
     * @param context the context
     * @return the all key value
     */
    public static Map<String, ?> getAllKeyValue(Context context) {
        return getAllKeyValue(context, sPreferencesName);
    }

    /**
     * 创建一个解决SharedPreferencesCompat.apply方法的一个兼容类
     *
     * @author zhy
     */
    private static class SharedPreferencesCompat {

        private static final Method sApplyMethod = findApplyMethod();

        /**
         * 反射查找apply的方法
         */
        @SuppressWarnings({"unchecked", "rawtypes"})
        private static Method findApplyMethod() {
            try {
                Class clz = SharedPreferences.Editor.class;
                return clz.getMethod("apply");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * 如果找到则使用apply执行，否则使用commit
         *
         * @param editor the editor
         */
        public static void apply(SharedPreferences.Editor editor) {
            try {
                if (sApplyMethod != null) {
                    sApplyMethod.invoke(editor);
                    return;
                }
            } catch (IllegalArgumentException expected) {
                expected.printStackTrace();
            } catch (IllegalAccessException expected) {
                expected.printStackTrace();
            } catch (InvocationTargetException expected) {
                expected.printStackTrace();
            }
            editor.commit();
        }
    }

}
