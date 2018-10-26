package com.example.jdbctemplate.dao;


import com.example.jdbctemplate.model.Author;

import java.util.List;

/**
 * AuthorDAO.
 * author 数据持久接口
 *
 * @author zhouqiang
 */
public interface AuthorDAO {
    /**
     * add.
     * @author       zhouqiang
     * @param        author     作者
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    int add(Author author);
    /**
     * update.
     * @author       zhouqiang
     * @param        author     作者
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    int update(Author author);
    /**
     * add.
     * @author       zhouqiang
     * @param        id         作者编号
     * @return       影响行数     int
     * @date   2018/7/5 10:51
     * */
    int delete(Long id);
    /**
     * findAuthor.
     * @author       zhouqiang
     * @param        id         作者编号
     * @return       author     Author
     * @date   2018/7/5 10:51
     * */
    Author findAuthor(long id);
    /**
     * findAuthorList.
     * @author       zhouqiang
     * @return       author     List
     * @date   2018/7/5 10:51
     * */
    List<Author> findAuthorList();
}
