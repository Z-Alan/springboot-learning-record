package com.example.mybatis.model.temp;

import com.xjjk.ec.Core.vo.BaseVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * className:  PolicyDO
 * description: 政策实体
 * date:  2019/11/19
 *
 * @author zhouqiang
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PolicyDO extends BaseVo {
    private String name;
    private Long departmentId;
    private Integer startMonth;
    private Integer endMonth;
    private String startTime;
    private String endTime;
    private Integer status;
}
