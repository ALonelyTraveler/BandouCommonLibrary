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
import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Assets操作
 *
 * @author venshine
 */
public class AssetsUtils {

    private static final String ENCODING = "UTF-8";

    /**
     * Get file from assets
     *
     * @param context  the context
     * @param fileName the file name
     * @return file from assets
     * @throws IOException the io exception
     */
    public static InputStream getFileFromAssets(Context context, String fileName) throws IOException {
        AssetManager am = context.getAssets();
        return am.open(fileName);
    }

    /**
     * Get text file from assets
     *
     * @param context  the context
     * @param fileName the file name
     * @return text from assets
     */
    public static String getTextFromAssets(Context context, String fileName) {
        try {
            InputStreamReader inputReader = new InputStreamReader(getFileFromAssets(context, fileName));
            BufferedReader bufReader = new BufferedReader(inputReader);
            String line = "";
            StringBuilder result = new StringBuilder();
            while ((line = bufReader.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
