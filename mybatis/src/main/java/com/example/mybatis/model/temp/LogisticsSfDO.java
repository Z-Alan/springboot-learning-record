package com.example.mybatis.model.temp;

import com.xjjk.ec.Core.vo.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * className:  LogisticsSfDO
 * description:
 * date:  2019/11/28
 *
 * @author zhouqiang
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "logistics_sf")
public class LogisticsSfDO extends BaseDO {

    @Id
    @Column(name = "Id", insertable = false, updatable = false)
    @KeySql(useGeneratedKeys = true)
    private Long id;

    /**
     * 路由编号，每一个id代表一条不同的路由
     */
    @Column(name = "MailId")
    private Long mailId;

    /**
     * 运单号
     */
    @Column(name = "MailNo")
    private String mailNo;

    /**
     * 订单号
     */
    @Column(name = "OrderId")
    private String orderId;

    /**
     * 路由产生时间
     */
    @Column(name = "AcceptTime")
    private String acceptTime;

    /**
     * 路由发生城市
     */
    @Column(name = "AcceptAddress")
    private String acceptAddress;

    /**
     * 路由说明
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 操作码
     */
    @Column(name = "OpCode")
    private String opCode;

}
