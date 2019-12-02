package com.example.mybatis.model.temp.coupon;

import com.xjjk.ec.Core.vo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * className:  PolicyCouponDO
 * description: 礼券实体
 * date:  2019/11/25
 *
 * @author zhouqiang
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PolicyCouponDO extends BaseDO {
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
