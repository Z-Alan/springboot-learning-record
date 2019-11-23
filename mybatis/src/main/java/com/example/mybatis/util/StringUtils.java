package com.example.mybatis.util;

/**
 * 字符串工具类
 *
 * @author zhouqiang
 */
public class StringUtils {
    /**
     * 把一个字符串的第一个字母大写、效率是最高的
     */
    public static String getMethodName(String fieldName) {
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
}
