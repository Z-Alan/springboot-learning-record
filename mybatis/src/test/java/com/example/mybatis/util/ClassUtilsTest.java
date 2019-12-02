package com.example.mybatis.util;

import com.example.mybatis.model.temp.PolicyDO;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassUtilsTest {

    @Test
    public void getAllFieldsTest() {
    }

    @Test
    public void getAllFieldsUpperCaseNameStringTest() {
        ClassUtils.getAllFieldsUpperCaseNameString(PolicyDO.class);
    }
}