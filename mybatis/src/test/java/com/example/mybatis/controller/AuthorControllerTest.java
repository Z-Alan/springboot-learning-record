package com.example.mybatis.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class AuthorControllerTest extends BaseControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getAuthorListTest() {
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/author"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
            //.andExpect(MockMvcResultMatchers.content().string("365"));  //测试接口返回内容
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteTest() {
    }
}