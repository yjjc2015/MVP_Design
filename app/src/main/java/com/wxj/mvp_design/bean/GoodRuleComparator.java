package com.wxj.mvp_design.bean;

import java.util.Comparator;

/**
 * 家居特卖的活动排序
 * Created by chen on 2016/6/27 0027.
 */
public class GoodRuleComparator implements Comparator<GoodRule> {
    @Override
    public int compare(GoodRule lhs, GoodRule rhs) {
        return lhs.getPara1()-rhs.getPara1();
    }
}
