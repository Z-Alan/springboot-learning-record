package com.example.mybatis.util;

import com.example.mybatis.model.Author;
import com.example.mybatis.model.temp.PolicyDO;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class GenerateMybatisAnnotationUtilsTest {

    @Test
    public void getResultsStrTest() {
        String s = GenerateMybatisAnnotationUtils.getResultsStr(Author.class);
        assertNotNull(s);
    }

    @Test
    public void getResultsStrWithFirstWordsUpTest() {
        String s = GenerateMybatisAnnotationUtils.getResultsStrWithFirstWordsUp(PolicyDO.class);
        assertNotNull(s);
    }
}