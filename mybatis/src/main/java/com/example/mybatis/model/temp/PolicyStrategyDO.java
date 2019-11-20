package com.example.mybatis.model.temp;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * className:  PolicyStrategyDO
 * description: 商品策略实体
 * date:  2019/11/19
 *
 * @author zhouqiang
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PolicyStrategyDO extends BaseDO {

    private Long id;
    /**
     * 策略名称
     */
    private String name;
    /**
     * 所属政策ID
     */
    private Long policyId;
    /**
     * 政策分类ID
     */
    private Long policyCategoryId;
    /**
     * 策略类型ID
     */
    private Long strategyCategoryId;
    /**
     * 客户限购个数
     */
    private Long limitNumber;
    /**
     * 每单限购
     */
    private Long singleLimit;
    /**
     * 客户限购开始时间
     */
    private String startTime;
    /**
     * 客户限购结束时间
     */
    private String endTime;
    /**
     * 是否控制员工奖励
     */
    private Integer isControlReward;
    /**
     * 员工奖励级别
     */
    private String rewardLevel;
    /**
     * 员工奖励金额 单位：分
     */
    private Long rewardMoney;
    /**
     * 是否享受会员折扣
     */
    private Integer isEnjoyMemberDiscount;
    /**
     * 是否享受额外赠品
     */
    private Integer isEnjoyExtraGifts;
    /**
     * 是否享受满额赠品
     */
    private Long isEnjoyFullGift;
    /**
     * 是否享受升级赠品
     */
    private Long isEnjoyUpGradeGifts;
    /**
     * 是否计入完成率
     */
    private Long isIncludedCompleteRate;
    /**
     * 提成比例
     */
    private Double royaltyRate;
    /**
     * 积分比例
     */
    private Double integralRate;
    /**
     * x产品任选数量
     */
    private Long xProductOptionalNumber;
    /**
     * y产品任选数量
     */
    private Long yProductOptionalNumber;
    /**
     * z产品任选数量
     */
    private Long zProductOptionalNumber;
    /**
     * z产品额外金额
     */
    private Double zProductExtraMoney;
    /**
     * 产品套餐奖
     */
    private Double productPackageAward;
    /**
     * 激活奖
     */
    private Double activationAward;
}
