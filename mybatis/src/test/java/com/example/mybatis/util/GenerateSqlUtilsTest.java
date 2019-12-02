package com.example.mybatis.util;

import com.example.mybatis.model.temp.coupon.PolicyCouponDO;
import com.example.mybatis.model.temp.coupon.SelectPolicyCouponDTO;
import com.example.mybatis.model.temp.coupon.cash.SelectCashCouponDTO;
import com.example.mybatis.model.temp.coupon.goods.SelectGoodsCouponDTO;
import com.example.mybatis.model.temp.coupon.grant.SelectCouponGrantDTO;
import com.example.mybatis.model.temp.strategy.PolicyStrategyDO;
import com.example.mybatis.model.temp.strategy.SelectPolicyStrategyDTO;
import org.junit.Test;

public class GenerateSqlUtilsTest {


    @Test
    public void generateInsertSqlTest() {
        GenerateSqlUtils.generateInsertSql(PolicyCouponDO.class,"policy_coupon");
    }

    @Test
    public void generateUpdateSetSqlTest() {
        GenerateSqlUtils.generateUpdateSetSql(PolicyCouponDO.class);
    }

    @Test
    public void generateSelectWhereSqlTest() {
        GenerateSqlUtils.generateSelectWhereSql(PolicyCouponDO.class);
    }

    @Test
    public void generateSelectSqlTest() {
        GenerateSqlUtils.generateSelectSql(SelectCouponGrantDTO.class,"policy_coupon_grant");
    }
}