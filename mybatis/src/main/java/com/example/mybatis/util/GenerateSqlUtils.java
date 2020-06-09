package com.example.mybatis.util;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 生成sql语句
 *
 * @author zhouqiang
 */
@Slf4j
public class GenerateSqlUtils {
    public static void generateInsertSql(Class<?> origin, String tableName) {
        Field[] fields = ClassUtils.getAllFields(origin);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ");
        stringBuilder.append(tableName);
        stringBuilder.append("(");
        for (Field field : fields) {
            String property = field.getName();
            String column = StringUtils.getMethodName(property);
            stringBuilder.append(String.format("%s,", column));
        }
        stringBuilder.append(") values(");
        for (Field field : fields) {
            String property = field.getName();
            stringBuilder.append(String.format("#{%s},", property));
        }
        stringBuilder.append(")");
        log.info("[- SQL -] 目标表insert语句 --- [-\n{}\n-]", stringBuilder.toString());
    }

    public static void generateSelectSql(Class<?> origin, String tableName) {
        Field[] fields = ClassUtils.getAllFields(origin);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("select %s %n from %s %n", ClassUtils.getAllFieldsUpperCaseNameString(origin),tableName));
        stringBuilder.append("<where>");
        for (Field field : fields) {
            String property = field.getName();
            String column = StringUtils.getMethodName(property);
            stringBuilder.append(String.format("<if test=\"%s != null\">%n %s = #{%s} %n</if>%n",property,column,property));
        }
        stringBuilder.append("</where>");
        log.info("[- SQL -] 目标表select语句 --- [-\n{}\n-]", stringBuilder.toString());
    }

    public static void generateSelectWhereSql(Class<?> origin) {
        Field[] fields = ClassUtils.getAllFields(origin);
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fields) {
            String property = field.getName();
            String column = StringUtils.getMethodName(property);
            stringBuilder.append(String.format("if (%s.get%s() != null) {%n" +
                    "            sql.AND();%n" +
                    "            sql.WHERE(\"%s=#{%s}\");%n" +
                    "        }", origin.getName(), column, column, property));
        }
        log.info("[- SQL -] select where语句 --- [- \n{}\n -]", stringBuilder.toString());
    }

    public static void generateUpdateSetSql(Class<?> origin) {
        Field[] fields = ClassUtils.getAllFields(origin);
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fields) {
            String property = field.getName();
            String column = StringUtils.getMethodName(property);
            stringBuilder.append(String.format("sql.SET(\"%s = #{%s}\");%n", column, property));
        }
        log.info("[- SQL -] update set语句 --- [-\n{}\n-]", stringBuilder.toString());
    }
}
