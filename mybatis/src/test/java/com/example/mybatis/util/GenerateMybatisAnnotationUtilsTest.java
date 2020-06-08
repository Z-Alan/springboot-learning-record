package com.example.mybatis.util;

import com.example.mybatis.model.temp.PolicyDO;
import com.example.mybatis.model.temp.order.OrderListForLogisticsDTO;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GenerateMybatisAnnotationUtilsTest {

    @Test
    public void getResultsStrTest() {
        String s = GenerateMybatisAnnotationUtils.getResultsStr(OrderListForLogisticsDTO.class);
        assertNotNull(s);
    }

    @Test
    public void getResultsStrWithFirstWordsUpTest() {
        String s = GenerateMybatisAnnotationUtils.getResultsStrWithFirstWordsUp(OrderListForLogisticsDTO.class);
        assertNotNull(s);
    }

    @Test
    public void getColumnAnnotationTest() {
        String s = GenerateMybatisAnnotationUtils.getColumnAnnotation(PolicyDO.class);
        assertNotNull(s);
    }
}