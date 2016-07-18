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

import java.io.*;

/**
 * 序列化和反序列化操作
 *
 * @author venshine
 */
public class SerializableUtils {

    /**
     * 序列化数据
     *
     * @param fileName the file name
     * @param obj      the obj
     * @throws IOException the io exception
     */
    public static void serializeData(String fileName, Object obj) throws IOException {
        if (!(obj instanceof Serializable) && !(obj instanceof Externalizable)) {
            throw new InvalidClassException("Object must be serialized!");
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream ostream = new ObjectOutputStream(fos);
        ostream.writeObject(obj);
        ostream.flush();
        ostream.close();
        fos.close();
    }

    /**
     * 反序列化数据
     *
     * @param <T>      the type parameter
     * @param fileName the file name
     * @return t t
     * @throws ClassNotFoundException the class not found exception
     * @throws IOException            the io exception
     */
    public static <T> T deserializeData(String fileName) throws ClassNotFoundException, IOException {
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream s = new ObjectInputStream(fis);
        T obj = (T) s.readObject();
        s.close();
        fis.close();
        return obj;
    }
}