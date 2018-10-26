package com.example.springdatajpa.service.article.condition;

import com.example.springdatajpa.domain.Article;
import com.example.springdatajpa.domain.dto.ArticleDTO;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 文章条件查询组装类
 *
 * @author zhouqiang
 */
public class ArticleConditionSpec {

    /**
     * specification.
     * id, userId 条件组装
     * @return Specification
     * @author zhou
     */
    public static Specification<Article> getArticleSpec(Article condition){
        return (Specification<Article>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            predicate.getExpressions().add(
                    criteriaBuilder.equal(root.get("id").as(Long.class),condition.getId())
            );
            /*
            查询条件 userId in (?)
             */
            if (!StringUtils.isEmpty(condition.getUserId())) {
                predicate.getExpressions().add(
                        criteriaBuilder.and(root.<String>get("userId").in(condition.getCreateTime()))
                );
            }
            return predicate;
        };
    }

    /**
     * specification.
     * id,userId,title(精确查找) 条件组装
     * @param condition 查询条件
     * @return specification
     */
    public static Specification<ArticleDTO> getArticleDTOSpec(ArticleDTO condition){
        return (Specification<ArticleDTO>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            predicate.getExpressions().add(
                    criteriaBuilder.equal(root.get("id").as(Long.class),condition.getId())
            );
            /*
            查询条件 userId in (?)
             */
            if (!StringUtils.isEmpty(condition.getUserId())) {
                predicate.getExpressions().add(
                        criteriaBuilder.and(root.<String>get("userId").in(condition.getCreateTime()))
                );
            }
            /*
            查询条件 title in (?)
             */
            if(!StringUtils.isEmpty(condition.getTitle())){
                predicate.getExpressions().add(
                        criteriaBuilder.and(root.<String>get("title").in(condition.getTitle()))
                );
            }
            return predicate;
        };
    }

    /**
     * specification.
     * id,userId,title(尾部模糊) 条件组装
     * @param condition 查询条件
     * @return specification
     */
    public static Specification<ArticleDTO> getArticleDTOLikeSpec(ArticleDTO condition){
        return (Specification<ArticleDTO>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
            predicate.getExpressions().add(
                    criteriaBuilder.equal(root.get("id").as(Long.class),condition.getId())
            );
            /*
            查询条件 userId in (?)
             */
            if (!StringUtils.isEmpty(condition.getUserId())) {
                predicate.getExpressions().add(
                        criteriaBuilder.and(root.<String>get("userId").in(condition.getCreateTime()))
                );
            }
            /*
            模糊查询 title like ?
             */
            if (!StringUtils.isEmpty(condition.getTitle())) {
                predicate.getExpressions().add(
                        // like：模糊匹配，跟SQL是一样的
                        criteriaBuilder.like(
                                // article表里面有个String类型的title
                                root.get("title").as(String.class),
                                // 映射规则
                                condition.getTitle()  + "%")
                );
            }
            return predicate;
        };
    }
}
