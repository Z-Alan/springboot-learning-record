package com.example.mybatis.model.temp.strategy;

import lombok.Data;

/**
 * 商品策略查询参数DTO
 *
 * @author zhouqiang
 */
@Data
public class SelectPolicyStrategyDTO {
    private Long policyId;
    private Long policyCategoryId;
}
