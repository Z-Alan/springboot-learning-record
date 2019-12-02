package com.example.mybatis.util;

import com.example.mybatis.model.Author;
import com.example.mybatis.model.temp.coupon.PolicyCouponDO;
import com.example.mybatis.model.temp.PolicyDO;
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
        String s = GenerateMybatisAnnotationUtils.getResultsStrWithFirstWordsUp(PolicyCouponDO.class);
        assertNotNull(s);
    }

    @Test
    public void getColumnAnnotationTest() {
        String s = GenerateMybatisAnnotationUtils.getColumnAnnotation(PolicyDO.class);
        assertNotNull(s);
    }
}