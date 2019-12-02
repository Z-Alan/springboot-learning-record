package com.example.mybatis.model.temp.coupon.grant;

import lombok.Data;

/**
 * @author zhouqiang
 */
@Data
public class SelectCouponGrantDTO{
    /**
     * 礼券id
     */
    private Long couponId;

    /**
     * 是否循环发券 0:不循环;1:循环
     */
    private Long isLoopGift;

    /**
     * 每月发放礼券日期
     */
    private Long monthGrantDate;

    /**
     * 发放开始时间
     */
    private String grantStartDate;

    /**
     * 发放对象
     */
    private String grantTarget;
}
