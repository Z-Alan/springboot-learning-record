package com.example.mybatis.model.temp.coupon.flow;

import com.xjjk.ec.Core.vo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author zhouqiang
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SelectPolicyCouponFlowDTO extends BaseDO {

    private String customerNo;

    private Long couponId;

    private String remarks;

    private Long orderId;

    private String orderNo;

    private Long status;
}
