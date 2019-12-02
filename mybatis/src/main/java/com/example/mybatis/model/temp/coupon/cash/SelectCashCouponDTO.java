package com.example.mybatis.model.temp.coupon.cash;

import lombok.Data;

/**
 * @author zhouqiang
 */
@Data
public class SelectCashCouponDTO{
    /**
     * 礼券配置Id
     */
    private Long couponId;
    /**
     * 现金券类型 0 抵金券， 1 打折券
     */
    private Long type;
    /**
     * 礼券面值  单位:分
     */
    private Long denomination;
    /**
     * 礼券折扣百分比
     */
    private Double discount;
    /**
     * 是否是全部商品 0:否 1:是
     */
    private Long isAllGoods;
    /**
     * 订单使用金额 单位:分
     */
    private Long orderEnableMoney;
    /**
     * 是否仅抵扣运费 0:否 1:是
     */
    private Long isFreightDeduction;
    /**
     * 单笔订单使用券数量
     */
    private Long restrictNumber;
}
