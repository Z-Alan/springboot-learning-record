package com.example.mybatis.model.temp.order;

import lombok.Data;

/**
 * 订单列表.
 *
 * mapper 返回结果集映射对象
 * service 返回类型
 *
 * @author zhouqiang
 * @date 2020/6/6  物流撤单查询订单结果
 */
@Data
public class OrderListForLogisticsDTO {
    /**
     * 订单id
     */
    private Long id;

    /**
     * 订单类型
     */
    private Integer orderType;

    /**
     * 订单类型名称
     */
    private String orderTypeName;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 客户编号
     */
    private String customerCode;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 订单状态
     */
    private Integer status;


    /**
     * 制单人Id
     */
    private Long userId;

    /**
     * 制单人名称
     */
    private String userName;

    /**
     * 制单时间
     */
    private String orderTime;

    /**
     * 财务审核人Id
     */
    private Long financeReviewId;

    /**
     * 财务审核人名称
     */
    private String financeReviewName;
    /**
     * 合规审单人Id
     */
    private Long reviewId;
    /**
     * 合规审单人
     */
    private String reviewName;
}
