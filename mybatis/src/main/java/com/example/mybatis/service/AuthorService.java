package com.example.mybatis.service;


import com.example.mybatis.model.po.Author;

import java.util.List;

/**
 * AuthorService.
 * java类作用描述
 * @author       zhouqiang
 * @date   2018/7/5 11:18
 * */
public interface AuthorService {

    /**
     * 添加一条author记录
     * @author       zhouqiang
     * @param        author     author
     * @return       影响行数
     * */
    int add(Author author);

    /**
     * 更新一条author记录
     * @author       zhouqiang
     * @param        author     author
     * @return       影响行数
     * */
    int update(Author author);

    /**
     * 删除一条记录
     * @author       zhouqiang
     * @param        id         author 编号
     * @return       影响行数
     * */
    int delete(Long id);

    /**
     * 查询author根据author id
     * @author       zhouqiang
     * @param        id         author 编号
     * @return       author     Author
     * */
    Author findAuthor(Long id);

    /**
     * 添加一条author记录
     * @author       zhouqiang
     * @return       author     List
     * */
    List<Author> findAuthorList();

    /**
     * findAuthorsByRealName.
     * @author       zhouqiang
     * @param        realName   真实姓名
     * @return       author     list
     * @date   2018/7/12 17:54
     * */
    List<Author> findAuthorsByRealName(String realName);

    /**
     * findAuthorByRealNameAndNickName.
     * @author       zhouqiang
     * @param        realName   真实姓名
     * @param        nickName   昵称
     * @return       author
     * @date   2018/7/12 17:55
     * */
    Author findAuthorByRealNameAndNickName(String realName, String nickName);


}
