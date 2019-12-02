package com.example.mybatis.model.temp.coupon;

import lombok.Data;

/**
 * @author zhouqiang
 */
@Data
public class SelectPolicyCouponDTO {
    private Long id;
    /**
     * 礼券名称
     */
    private String name;
    /**
     * 归属部门id
     */
    private Long departmentId;
    /**
     * 是否发布 1已发布 0未发布
     */
    private Integer isPublish;
    /**
     * 礼券类型
     * 0 现金券 1产品券
     */
    private Integer giftType;
    /**
     * 生效开始时间
     */
    private String startTime;
    /**
     * 生效结束时间
     */
    private String endTime;
}
