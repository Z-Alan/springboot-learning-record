package com.example.mybatis.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

/**
 * @author zhouqiang
 */
@Slf4j
public class GenerateFieldsStringUtils {

    public static String generateNameString(Class origin) {
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

    public static void main(String[] args) {
        String str = "string";
        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }
    }
}
