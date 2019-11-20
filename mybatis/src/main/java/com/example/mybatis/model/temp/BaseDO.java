package com.example.mybatis.model.temp;

import lombok.Data;

/**
 * className:  BaseDo
 * description:
 * date:  2019/11/20  11:54
 *
 * @author wuqiang
 * @version 1.0
 */
@Data
class BaseDO{
    private Long isDeleted;
    private String createSource;
    private String createTime;
    private String updateSource;
    private String updateTime;
}
