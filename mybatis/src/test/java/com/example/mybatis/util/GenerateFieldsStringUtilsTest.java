package com.example.mybatis.util;

import com.example.mybatis.model.po.Author;
import org.junit.Test;

public class GenerateFieldsStringUtilsTest {

    @Test
    public void generateNameStringTest() {
        GenerateFieldsStringUtils.generateNameString(Author.class);
    }
}