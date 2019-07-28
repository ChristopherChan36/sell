package com.pisces.sell.utils;

import java.util.Random;

/**
 * <p>Title: KeyUtil </p>
 * <p>Description: 生成key的工具类 </p>
 *
 * @author christopher
 * @version 1.0
 * @date 2019-3-4 23:31
 */
public class KeyUtil {

    /**
     * 生成唯一主键 key, 加锁
     * 格式： 时间戳 + 6位随机数
     *
     * @return key 唯一主键
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
