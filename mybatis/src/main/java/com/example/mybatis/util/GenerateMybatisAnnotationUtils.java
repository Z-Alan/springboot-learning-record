package com.example.mybatis.util;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * GenerateMybatisAnnotationUtils 生成mybatis的注解
 *
 * @author zhouqiang
 * @date 2018/7/3 13:43
 */
@Slf4j
public class GenerateMybatisAnnotationUtils {
    /**
     * 用于获取结果集的映射关系.
     *
     * @param origin 源实体类
     * @return 结果集的映射关系
     * @author zhouqiang
     */
    public static String getResultsStr(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : ClassUtils.getAllFields(origin)) {
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
    public static String getResultsStrWithFirstWordsUp(Class origin) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("@Results({\n");
        for (Field field : ClassUtils.getAllFields(origin)) {
            String property = field.getName();
            // 映射关系：对象属性(驼峰)->数据库字段(首字母大写)
            String column = StringUtils.getMethodName(field.getName());
            stringBuilder.append(String.format("@Result(property = \"%s\", column = \"%s\"),%n", property, column));
        }
        stringBuilder.append("})");
        log.info("[- 结果集映射 -] 目标实体类的结果集映射 --- [-\n{}\n-]", stringBuilder.toString());
        return stringBuilder.toString();
    }

}
