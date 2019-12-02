package com.example.mybatis.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 时间工具类
 *
 * @author zhouqiang
 */
public class DateTimeUtils {
    /**
     * 生成当前时间字符串
     *
     * @return 当前时间字符串
     * @author zhouqiang
     * @date 2019/11/25
     */
    public static String now() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
    }
}
