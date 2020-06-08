package com.example.mybatis.model.temp;

import lombok.Data;

/**
 * @author zhouqiang
 */
@Data
public class BasePage {
    private long total;
    private int pageIndex;
    private int pageSize;
    public void init(){
        this.pageIndex =  1;
        this.pageSize =  1;
    }
}
