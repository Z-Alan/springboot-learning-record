package com.example.mybatis.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author 实体的 SQL 工具类，可以动态编写SQL
 *
 * @author zhouqiang
 */
public class AuthorSqlProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorSqlProvider.class);

    /*
     * 主要用途：根据复杂的业务需求来动态生成SQL.
     * <p>
     * 目标：使用Java工具类来替代传统的XML文件.(例如：UserSqlProvider.java <-- UserMapper.xml)
     */

    /*
     * 方式1：在工具类的方法里,可以自己手工编写SQL。
     */

    /**
     * listByRealName.
     * <p>
     * SQL: 根据realName查找Author
     *
     * @param realName  真实姓名
     * @return sql  String
     * @author zhouqiang
     * @date 2018/7/12 17:00
     */
    public String listByRealName(String realName) {
        LOGGER.info("[- 参数 -] 根据realName查找Author --- [- {} -]", realName);
        String sql = "select * from t_author where real_name = #{realName}";
        LOGGER.info("[- SQL -] 根据realName查找Author --- [- {} -]", sql);
        return sql;
    }

    /*
     * 方式2：使用官方提供的API来编写动态SQL.
     *
     * 这里的参数同AuthorDAO中说明一样。多参数或引用数据类型需要用@Param注解说明。
     * 自己测试了一下，使用工具类编写SQL，多参数或引用数据类型DAO和provider方法都需要添加@Param注解。
     *
     */

    /**
     * selectAuthor.
     *
     * SQL. 根据realName,nickName模糊查找Author
     *
     * @author       zhouqiang
     * @param        realName   真实姓名
     * @param        nickName   昵称
     * @return       sql String
     * @date   2018/7/12 17:16
     * */
    public String selectAuthor(@Param("realName")String realName,@Param("nickName")String nickName){
        LOGGER.info("[- 参数 -] 模糊查找Author --- [- {} -],[- {} -]",realName, nickName);
        SQL sql = new SQL();
        sql.SELECT("*");
        sql.FROM("t_author");
        if (realName != null && nickName != null) {
            sql.WHERE("real_name like #{realName} and nick_name like #{nickName}");
        } else {
            sql.WHERE("1 = 2");
        }
        LOGGER.info("[- SQL -] 模糊查找Author --- [- {} -]",sql);
        return sql.toString();
    }

}
