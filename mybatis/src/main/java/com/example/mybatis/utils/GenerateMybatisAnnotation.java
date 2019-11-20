package com.example.mybatis.utils;

import com.example.mybatis.model.Author;
import com.example.mybatis.model.temp.PolicyDO;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * GenerateMybatisAnnotation 生成mybatis的注解
 *
 * @author zhouqiang
 * @date 2018/7/3 13:43
 */
@Slf4j
public class GenerateMybatisAnnotation {
    /**
     * 用于获取结果集的映射关系.
     *
     * @param origin 源实体类
     * @return 结果集的映射关系
     * @author zhouqiang
     */
    private static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : GenerateMybatisAnnotation.getAllFields(origin)) {
            String property = field.getName();
            // 映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(field.getName());
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),%n", property, column));
        }
        stringBuilder.append("})");
        log.info("[- 结果集映射 -] 目标实体类的结果集映射 --- [- {} -]", stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * 用于获取结果集的映射关系.
     *
     * @param origin 源实体类
     * @return 结果集的映射关系
     * @author zhouqiang
     */
    private static String getResultsStrWithFirstWordsUp(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : GenerateMybatisAnnotation.getAllFields(origin)) {
            String property = field.getName();
            // 映射关系：对象属性(驼峰)->数据库字段(首字母大写)
            String column = GenerateMybatisAnnotation.getMethodName(field.getName());
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),%n", property, column));
        }
        stringBuilder.append("})");
        log.info("[- 结果集映射 -] 目标实体类的结果集映射 --- [- {} -]", stringBuilder.toString());
        return stringBuilder.toString();
    }
    /**
     * 获取类所有属性包括所有继承类
     * @param origin 类
     * @return 类声明的属性集合
     */
    private static Field[] getAllFields(Class origin){
        List<Field> fieldList = new ArrayList<>();
        while (origin != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(origin.getDeclaredFields())));
            origin = origin.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
    /**
     * 把一个字符串的第一个字母大写、效率是最高的
     */
    private static String getMethodName(String fieldName) {
        byte[] items = fieldName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return new String(items);
    }
    public static void main(String[] args) {
        GenerateMybatisAnnotation.getResultsStr(Author.class);
        GenerateMybatisAnnotation.getResultsStrWithFirstWordsUp(PolicyDO.class);
    }
}
