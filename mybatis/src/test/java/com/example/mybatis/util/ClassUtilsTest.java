package com.example.mybatis.util;

import com.example.mybatis.model.po.Author;
import org.junit.Test;

public class ClassUtilsTest {

    @Test
    public void getAllFieldsTest() {
    }

    @Test
    public void getAllFieldsUpperCaseNameStringTest() {
        ClassUtils.getAllFieldsUpperCaseNameString(Author.class);
    }
}