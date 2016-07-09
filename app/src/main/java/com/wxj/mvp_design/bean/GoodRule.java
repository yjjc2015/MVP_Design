package com.wxj.mvp_design.bean;

import android.text.TextUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 建材团(家居特卖)商品的活动规则
 * Created by chen on 2016/6/16 0016.
 */
public class GoodRule implements Serializable {
    private int para1;
    private double para2;

    public int getPara1() {
        return para1;
    }

    public void setPara1(int para1) {
        this.para1 = para1;
    }

    public double getPara2() {
        return para2;
    }

    public void setPara2(double para2) {
            this.para2 = para2;
    }

    /**
     * 得到活动规则
     * @return
     */
    public static String getRuleText(String activityRuleType, List<GoodRule> ruleList) {
        if (ruleList == null || ruleList.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        boolean isFirstItem = true;
        if (activityRuleType.equalsIgnoreCase("MAN_JIAN")) {
            for (GoodRule ruleItem : ruleList) {
                if (isFirstItem) {
                    isFirstItem = false;
                } else {
                    sb.append(", ");
                }
                sb.append("满").append(ruleItem.getPara1()).append("减").append(ruleItem.getPara2());
            }
        }
        return sb.toString();
    }

    public static List<GoodRule> getRuleList(String ruleStr) {
        if (TextUtils.isEmpty(ruleStr)) {
            return null;
        }
        List<GoodRule> ruleList = new ArrayList<>();
        try {
            String[] array = ruleStr.split(",");
            GoodRule temp = null;
            for (String item : array) {
                if (!TextUtils.isEmpty(item.trim())) {
                    temp = new GoodRule();
                    String[] params = item.split(":");
                    temp.setPara1(Integer.parseInt(params[0]));
                    temp.setPara2(Double.parseDouble(params[1]));
                    ruleList.add(temp);
                }
            }
            Collections.sort(ruleList, new GoodRuleComparator());
        } catch(Exception e) {}
        return ruleList;
    }
}
