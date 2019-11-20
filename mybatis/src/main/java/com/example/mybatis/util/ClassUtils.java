package com.example.mybatis.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类工具
 *
 * @author zhouqiang
 */
class ClassUtils {
    private ClassUtils() {
    }

    /**
     *
     * 获取类所有属性包括所有继承类
     *
     * @param origin 类
     * @return 类声明的属性集合
     */
    static Field[] getAllFields(Class origin) {
        List<Field> fieldList = new ArrayList<>();
        while (origin != null) {
            fieldList.addAll(new ArrayList<>(Arrays.asList(origin.getDeclaredFields())));
            origin = origin.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
