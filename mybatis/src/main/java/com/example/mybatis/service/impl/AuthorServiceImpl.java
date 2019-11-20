package com.example.mybatis.service.impl;

import com.example.mybatis.dao.AuthorDAO;
import com.example.mybatis.model.Author;
import com.example.mybatis.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * author service 实现
 *
 * @author zhouqiang
 */
@Service("authorService")
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDAO authorDAO;

    @Autowired
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public int add(Author author) {
        return this.authorDAO.add(author);
    }

    @Override
    public int update(Author author) {
        return this.authorDAO.update(author);
    }

    @Override
    public int delete(Long id) {
        return this.authorDAO.delete(id);
    }

    @Override
    public Author findAuthor(Long id) {
        return this.authorDAO.findAuthor(id);
    }

    @Override
    public List<Author> findAuthorList() {
        return this.authorDAO.findAuthorList();
    }

    @Override
    public List<Author> findAuthorsByRealName(String realName) {
        return this.authorDAO.listByRealName(realName);
    }

    @Override
    public Author findAuthorByRealNameAndNickName(String realName,String nickName) {
        return this.authorDAO.selectAuthor(realName,nickName);
    }
}
