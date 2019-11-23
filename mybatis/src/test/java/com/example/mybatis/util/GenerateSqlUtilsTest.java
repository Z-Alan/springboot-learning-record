package com.example.mybatis.util;

import com.example.mybatis.model.temp.UpdatePolicyStrategyDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateSqlUtilsTest {

    private GenerateSqlUtils generateSqlUtils = new GenerateSqlUtils();

    @Test
    public void generateInsertSqlTest() {
    }

    @Test
    public void generateUpdateSetSqlTest() {
        generateSqlUtils.generateUpdateSetSql(UpdatePolicyStrategyDTO.class);
    }
}