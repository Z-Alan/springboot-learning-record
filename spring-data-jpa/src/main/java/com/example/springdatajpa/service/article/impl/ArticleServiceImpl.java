package com.example.springdatajpa.service.article.impl;

import com.example.springdatajpa.domain.Article;
import com.example.springdatajpa.domain.dto.ArticleDTO;
import com.example.springdatajpa.domain.dto.UserDTO;
import com.example.springdatajpa.repository.ArticleRepository;
import com.example.springdatajpa.repository.dto.ArticleDTORepository;
import com.example.springdatajpa.service.article.ArticleService;
import com.example.springdatajpa.service.article.condition.ArticleConditionSpec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.*;

/**
 * @author zhouqiang
 */
@Service
@Slf4j
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDTORepository articleDTORepository;
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public void innerJoinExample() {
        // 根据查询结果，声明返回值对象，这里要查询用户的文章列表，所以声明返回对象为ArticleDTO
        // Root<X>;  根查询，默认与声明相同
        Specification<ArticleDTO> spec = (Specification<ArticleDTO>) (root, criteriaQuery, criteriaBuilder) -> {
            // 声明并创建ArticleDTO的CriteriaQuery对象
            CriteriaQuery<ArticleDTO> query = criteriaBuilder.createQuery(ArticleDTO.class);
            // 连接的时候，要以声明的根查询对象（这里是root，也可以自己创建）进行join
            // Join<Z,X>;是Join生成的对象，这里的Z是被连接的对象，X是目标对象，
            // 连接的属性字段是被连接的对象在目标对象的属性，这里是我们在ArticleDTO内声明的user
            // join的第二个参数是可选的，默认是JoinType.INNER(内连接 inner join)，也可以是JoinType.LEFT（左外连接 left join）
            Join<UserDTO, ArticleDTO> articleDTOJoin = root.join("user", JoinType.INNER);
            // 用CriteriaQuery对象拼接查询条件，这里只增加了一个查询条件，userId=1
            query.select(articleDTOJoin).where(criteriaBuilder.equal(root.get("userId"), 1));
            Predicate p1;
            // 通过getRestriction获得Predicate对象
            p1 = query.getRestriction();
            return p1;
        };
        articleDTOResultPrint(spec);
    }

    @Override
    public void singleDynamicConditionExample(Article condition) {
        Specification<Article> spec = ArticleConditionSpec.getArticleSpec(condition);
        articleResultPrint(spec);
    }

    @Override
    public void singleDynamicConditionExample(ArticleDTO condition) {
        Specification<ArticleDTO> spec = ArticleConditionSpec.getArticleDTOSpec(condition);
        articleDTOResultPrint(spec);
    }

    @Override
    public void singleDynamicConditionLikeExample(ArticleDTO condition) {
        Specification<ArticleDTO> spec = ArticleConditionSpec.getArticleDTOLikeSpec(condition);
        articleDTOResultPrint(spec);
    }

    /**
     * 输出分页信息 测试用
     *
     * @param spec 复杂条件关联查询对象
     */
    private void articleDTOResultPrint(Specification<ArticleDTO> spec) {
        //分页查询
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "id");
        //查询的分页结果
        Page<ArticleDTO> page = articleDTORepository.findAll(spec, pageable);
        log.info("分页结果 ----- [---- {} ----]", page);
        log.info("分页结果统计 ----- [---- {} ----]", page.getTotalElements());
        log.info("分页结果页数 ----- [---- {} ----]", page.getTotalPages());
        for (ArticleDTO c : page.getContent()) {
            log.info("分页内容 ----- [---- {} ----]", c.toString());
        }
    }

    /**
     * 输出分页信息 测试用
     *
     * @param spec 复杂条件关联查询对象
     */
    private void articleResultPrint(Specification<Article> spec) {
        /* 注意
        Pageable pageable = new Pageable(page, size, sort)已经过时，
        可以使用Pageable pageable = PageRequest.of(page, size, sort)代替
        注意参数的类型，其中size要大于等于1，page则是从0开始算起。
         */
        //分页查询
        Pageable pageable = PageRequest.of(0, 10, Sort.Direction.DESC, "id");
        //查询的分页结果
        Page<Article> page;
        page = articleRepository.findAll(spec, pageable);
        log.info("分页结果 ----- [---- {} ----]", page);
        log.info("分页结果统计 ----- [---- {} ----]", page.getTotalElements());
        log.info("分页结果页数 ----- [---- {} ----]", page.getTotalPages());
        for (Article c : page.getContent()) {
            log.info("分页内容 ----- [---- {} ----]", c.toString());
        }
    }
}
