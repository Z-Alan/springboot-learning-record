package com.example.mybatis.util;

import com.example.mybatis.model.temp.PolicyStrategyDO;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

/**
 * 生成sql语句
 *
 * @author zhouqiang
 */
@Slf4j
class GenerateSqlUtils {
    private GenerateSqlUtils() {
    }

    static String generateInsertSql(Class origin, String tableName) {
        Field[] fields = ClassUtils.getAllFields(origin);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("insert into ");
        stringBuilder.append(tableName);
        stringBuilder.append("(");
        for (Field field : fields) {
            String property = field.getName();
            String column =  StringUtils.getMethodName(property);
            stringBuilder.append(String.format("%s,", column));
        }
        stringBuilder.append(") values(");
        for (Field field : fields) {
            String property = field.getName();
            stringBuilder.append(String.format("#{%s},", property));
        }
        stringBuilder.append(")");
        log.info("[- SQL -] 目标表insert语句 --- [- {} -]", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        generateInsertSql(PolicyStrategyDO.class,"policy_strategy");
    }
}
