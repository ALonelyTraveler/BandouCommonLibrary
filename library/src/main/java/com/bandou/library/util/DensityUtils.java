/*
 *   Copyright (C)  2016 android@19code.com
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.bandou.library.util;

import android.content.Context;

/**
 * Create by h4de5ing 2016/5/7 007
 * checked
 */
public class DensityUtils {

    /**
     * Dip 2 px int.
     *
     * @param c       the c
     * @param dpValue the dp value
     * @return the int
     */
    public static int dip2px(Context c, float dpValue) {
        final float scale = c.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * Px 2 dip int.
     *
     * @param c       the c
     * @param pxValue the px value
     * @return the int
     */
    public static int px2dip(Context c, float pxValue) {
        final float scale = c.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    /**
     * Px 2 sp int.
     *
     * @param c       the c
     * @param pxValue the px value
     * @return the int
     */
    public static int px2sp(Context c, float pxValue) {
        float fontScale = c.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    /**
     * Sp 2 px int.
     *
     * @param c       the c
     * @param spValue the sp value
     * @return the int
     */
    public static int sp2px(Context c, float spValue) {
        float fontScale = c.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
