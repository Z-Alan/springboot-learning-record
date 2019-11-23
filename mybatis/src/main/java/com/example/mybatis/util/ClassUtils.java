package com.example.mybatis.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类工具
 *
 * @author zhouqiang
 */
@Slf4j
public class ClassUtils {

    /**
     *
     * 获取类所有属性包括所有继承类
     *
     * @param origin 类
     * @return 类声明的属性集合
     */
    public static Field[] getAllFields(Class origin) {
        List<Field> fieldList = new ArrayList<>();
        while (origin != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(origin.getDeclaredFields())));
            origin = origin.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
    /**
     * 获取类所有对应的表字段
     * @param   origin class
     * @return  origin 类声明的属性对应的表字段
     * @author  zhouqiang
     * @date    2019/11/23
     */
    public static String getAllFieldsUpperCaseNameString(Class origin){
        String flag = "";
        StringBuilder stringBuilder = new StringBuilder();
        Field[] fields = getAllFields(origin);
        for (Field field : fields) {
            stringBuilder.append(flag);
            String property = field.getName();
            String column = StringUtils.getMethodName(property);
            stringBuilder.append(column);
            flag = ",";
        }
        log.info(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
