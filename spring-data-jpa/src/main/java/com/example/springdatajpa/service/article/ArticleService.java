package com.example.springdatajpa.service.article;

import com.example.springdatajpa.domain.Article;
import com.example.springdatajpa.domain.dto.ArticleDTO;

/**
 * 动态sql条件查询，分页，以及表关联查询 示例
 *
 * @author zhouqiang
 */

public interface ArticleService {

    /**
     * example.
     * 仅查询单表数据
     * 单表 动态条件查询
     * @param condition  查询条件
     */
    void singleDynamicConditionExample(Article condition);

    /**
     * example.
     * 查询文章和用户，查询实体类中关联的数据
     * 动态条件查询
     *
     * @param condition 查询条件
     */
    void singleDynamicConditionExample(ArticleDTO condition);

    /**
     * example.
     *
     * 查询文章和用户
     * 动态条件 有模糊条件
     */
    void singleDynamicConditionLikeExample(ArticleDTO condition);
    /**
     * example.
     * 关联查询 内连接(inner join ) 固定条件查询
     * @author zhou
     */
    void innerJoinExample();





}
