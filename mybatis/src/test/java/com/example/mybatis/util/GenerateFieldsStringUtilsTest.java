package com.example.mybatis.util;

import com.example.mybatis.model.temp.SavePolicyStrategyReqVo;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateFieldsStringUtilsTest {

    @Test
    public void generateNameStringTest() {
        GenerateFieldsStringUtils.generateNameString(SavePolicyStrategyReqVo.class);
    }
}