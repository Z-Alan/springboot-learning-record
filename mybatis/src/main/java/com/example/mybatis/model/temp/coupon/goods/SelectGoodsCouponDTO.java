package com.example.mybatis.model.temp.coupon.goods;

import lombok.Data;

/**
 * @author zhouqiang
 */
@Data
public class SelectGoodsCouponDTO  {
    /**
     * 券配置id
     */
    private Long couponId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 可兑换数量
     */
    private Long exchangeNumber;
}
