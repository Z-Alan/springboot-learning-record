package com.example.mybatis.util;

import com.example.mybatis.model.temp.PolicyDO;
import org.junit.Test;

public class GenerateFieldsStringUtilsTest {

    @Test
    public void generateNameStringTest() {
        GenerateFieldsStringUtils.generateNameString(PolicyDO.class);
    }
}