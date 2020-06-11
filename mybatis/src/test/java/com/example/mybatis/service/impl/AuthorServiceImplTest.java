package com.example.mybatis.service.impl;

import com.example.mybatis.model.po.Author;
import com.example.mybatis.service.AuthorService;
import com.example.mybatis.service.BaseServiceTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AuthorServiceImplTest extends BaseServiceTest {

    @Autowired
    private AuthorService authorService;

    @Test
    public void addTest() {
        Author author = new Author();
        author.setNickName("格子先生i");
        author.setRealName("格子");
        int row = authorService.add(author);
        assertEquals(1,row);
    }

    @Test
    public void updateTest() {
        Author author = new Author();
        author.setId(1L);
        author.setNickName("假名字");
        author.setRealName("真名字");
        int row;
        author.setId(2L);
        author.setNickName("更远的以后");
        author.setRealName("周牧");
        row = authorService.update(author);
        assertEquals(1,row);
    }

    @Test
    public void deleteTest() {
    }

    @Test
    public void findAuthorTest() {
        Author author = authorService.findAuthor(2L);
        assertEquals("周牧",author.getRealName());
    }

    @Test
    public void findAuthorListTest() {
        List<Author> authorList = authorService.findAuthorList();
        assertEquals(5,authorList.size());
    }

    @Test
    public void findAuthorsByRealNameTest() {
        List<Author> authors = authorService.findAuthorsByRealName("周牧");
        assertEquals(1,authors.size());
    }

    @Test
    public void findAuthorByRealNameAndNickNmeTest() {
        Author author = authorService.findAuthorByRealNameAndNickName("周牧","更远的以后new");
        assertEquals("周牧",author.getRealName());
    }
}