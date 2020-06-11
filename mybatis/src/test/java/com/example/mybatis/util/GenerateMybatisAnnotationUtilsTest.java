package com.example.mybatis.util;

import com.example.mybatis.model.po.Author;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GenerateMybatisAnnotationUtilsTest {

    @Test
    public void getResultsStrTest() {
        String s = GenerateMybatisAnnotationUtils.getResultsStr(Author.class);
        assertNotNull(s);
    }

    @Test
    public void getResultsStrWithFirstWordsUpTest() {
        String s = GenerateMybatisAnnotationUtils.getResultsStrWithFirstWordsUp(Author.class);
        assertNotNull(s);
    }

    @Test
    public void getColumnAnnotationTest() {
        String s = GenerateMybatisAnnotationUtils.getColumnAnnotation(Author.class);
        assertNotNull(s);
    }
}