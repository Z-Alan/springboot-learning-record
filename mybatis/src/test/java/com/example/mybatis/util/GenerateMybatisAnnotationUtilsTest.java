package com.example.mybatis.util;

import com.example.mybatis.model.Author;
import com.example.mybatis.model.temp.PolicyStrategyDO;
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
        String s = GenerateMybatisAnnotationUtils.getResultsStrWithFirstWordsUp(PolicyStrategyDO.class);
        assertNotNull(s);
    }
}