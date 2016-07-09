package com.wxj.mvp_design.bean;

import java.util.List;

/**
 * 展示：家具特卖活动的总价和立减
 * Created by chen on 2016/6/29 0029.
 */
public class ActivityAmount {
    private double total;//展示总价
    private double cashBack;//展示立减（优惠价格）
    private List<Integer> ruleIdList;

    public ActivityAmount(double total, double cashBack, List<Integer> ruleIdList) {
        this.total = total;
        this.cashBack = cashBack;
        this.ruleIdList = ruleIdList;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCashBack() {
        return cashBack;
    }

    public void setCashBack(double cashBack) {
        this.cashBack = cashBack;
    }

    public List<Integer> getRuleIdList() {
        return ruleIdList;
    }

    public void setRuleIdList(List<Integer> ruleIdList) {
        this.ruleIdList = ruleIdList;
    }
}
