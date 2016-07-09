package com.wxj.mvp_design.bean;

import com.wxj.mvp_design.util.OrderTools;

import java.io.Serializable;
import java.util.List;

/**建材团--购物车*/
public class CartItem extends BaseBean implements Serializable {
    //请求数据，UI展示
    private int cartId;
    private int userId;
    private int productId;
    private String productName;
    private String frontCoverUrl;//封面
    private int count;//数量
    private double productPrice;//原价
    private double productAppPrice;//卖价
    private int brandId;//品牌Id
    private String brandName;//品牌名称
    //=======活动(家具特卖)============
    private int activityRuleId;//活动Id
    private boolean isRuleActive;//是否参与活动
    private String activityRuleType;//活动类型
    private String condition;//活动规则字符串
    private String activityUrl;//活动跳转网页的url

    //请求数据
    private List<CartItem> data;

    //UI展示
    private boolean isChecked;
    private List<GoodRule> ruleList;//具体活动规则
    private String ruleText;//具体活动规则的文字描述

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFrontCoverUrl() {
        return frontCoverUrl;
    }

    public void setFrontCoverUrl(String frontCoverUrl) {
        this.frontCoverUrl = frontCoverUrl;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductAppPrice() {
        return productAppPrice;
    }

    public void setProductAppPrice(double productAppPrice) {
        this.productAppPrice = productAppPrice;
    }

    public int getActivityRuleId() {
        return activityRuleId;
    }

    public void setActivityRuleId(int activityRuleId) {
        this.activityRuleId = activityRuleId;
    }

    public boolean isRuleActive() {
        return isRuleActive;
    }

    public void setRuleActive(boolean ruleActive) {
        isRuleActive = ruleActive;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public List<CartItem> getData() {
        return data;
    }

    public void setData(List<CartItem> data) {
        this.data = data;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getActivityRuleType() {
        return activityRuleType;
    }

    public void setActivityRuleType(String activityRuleType) {
        this.activityRuleType = activityRuleType;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getActivityUrl() {
        return activityUrl;
    }

    public void setActivityUrl(String activityUrl) {
        this.activityUrl = activityUrl;
    }

    public List<GoodRule> getRuleList() {
        if (ruleList == null) {//若不存在，则根据condition字段转换
            ruleList = GoodRule.getRuleList(this.condition);
        }
        return ruleList;
    }

    public void setRuleList(List<GoodRule> ruleList) {
        this.ruleList = ruleList;
    }

    public String getRuleText() {
        if (ruleText == null) {
            ruleText = GoodRule.getRuleText(this.activityRuleType, getRuleList());
        }
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }

    /**用于显示总原价*/
    public double getTotalPrice() {
        return OrderTools.mul(productAppPrice, count);
    }

    /**
     * 得到商品活动后的价格
     */
    public double getActivityPrice() {
        double res = this.getProductAppPrice() * this.getCount();
        if (this.isRuleActive()) {
            if (this.getActivityRuleType().equalsIgnoreCase("MAN_JIAN")) {
                for (GoodRule rule : this.getRuleList()) {
                    if (res > rule.getPara1()) {
                        res -= rule.getPara2();
                    }
                }
            }
        }
        return OrderTools.formatToDouble(res);
    }
}
