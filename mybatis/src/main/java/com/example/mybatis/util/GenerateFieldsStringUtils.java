package com.example.mybatis.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * @author zhouqiang
 */
@Slf4j
class GenerateFieldsStringUtils {

    private GenerateFieldsStringUtils() {
    }

    static String generateNameString(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (Field field : ClassUtils.getAllFields(origin)) {
            String property = field.getName();
            stringBuilder.append(String.format("%s,", property));
        }
        stringBuilder.append(" ]");
        log.info("[- name String -] name string 生成 --- [- {} -]", stringBuilder.toString());
        return stringBuilder.toString();
    }

}
