package com.example.mybatis.util;

import com.example.mybatis.model.Author;
import com.example.mybatis.model.temp.LogisticsSfDO;
import org.junit.Test;

public class GenerateSqlUtilsTest {


    @Test
    public void generateInsertSqlTest() {
        GenerateSqlUtils.generateInsertSql(LogisticsSfDO.class,"logistics_sf");
    }

    @Test
    public void generateUpdateSetSqlTest() {
        GenerateSqlUtils.generateUpdateSetSql(Author.class);
    }

    @Test
    public void generateSelectWhereSqlTest() {
        GenerateSqlUtils.generateSelectWhereSql(Author.class);
    }

    @Test
    public void generateSelectSqlTest() {
        GenerateSqlUtils.generateSelectSql(Author.class,"policy_coupon_flow");
    }
}