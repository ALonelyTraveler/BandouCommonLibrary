package com.bandou.library.util;

import java.util.UUID;

/**
 * The type Uuid utils.
 */
public class UUIDUtils {

    /**
     * Gets uuid.
     * 生成随机的UUID
     *
     * @return the uuid
     */
    public static String getUUID() {
		return UUID.randomUUID().toString();
	}
}