package com.wxj.mvp_design.util;

import android.content.Context;

import com.wxj.mvp_design.bean.ActivityAmount;
import com.wxj.mvp_design.bean.CartItem;
import com.wxj.mvp_design.bean.GoodRule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by chen on 2016/6/27 0027.
 */
public class OrderTools {

    /**
     * double 相加
     * @param d1
     * @param d2
     * @return
     */
    public static double sum(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.add(bd2).doubleValue();
    }

    /**
     * double 相减
     * @param d1
     * @param d2
     * @return
     */
    public static double sub(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.subtract(bd2).doubleValue();
    }

    /**
     * double 乘法
     * @param d1
     * @param d2
     * @return
     */
    public static double mul(double d1,double d2){
        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.multiply(bd2).doubleValue();
    }


    /**
     * double 除法
     * @param d1
     * @param d2
     * @param scale 四舍五入 小数点位数
     * @return
     */
    public static double div(double d1,double d2,int scale){
        //  当然在此之前，你要判断分母是否为0，
        //  为0你可以根据实际需求做相应的处理

        BigDecimal bd1 = new BigDecimal(Double.toString(d1));
        BigDecimal bd2 = new BigDecimal(Double.toString(d2));
        return bd1.divide(bd2,scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static double formatToDouble (double val) {
        return BigDecimal.valueOf(val).stripTrailingZeros().doubleValue();
    }

    /**最多保留double小数点后2位,并去除末尾的0*/
    public static String formatDouble (double val) {
        //方法一：展示￥56,345
//        int scale = 2;
//        if (val%1.0 == 0) {
//            scale = 0;
//        } else if (val%0.1 == 0) {
//            scale = 1;
//        }
//        NumberFormat nFormat = NumberFormat.getInstance();
//        nFormat.setMaximumFractionDigits(scale);
//        return nFormat.format(val);

        //方法二：展示￥56345，当val为0时展示'￥0'
//        DecimalFormat df;
//        if (val % 1.0 == 0) {
//            df = new DecimalFormat("###");
//        } else if (val % 0.1 == 0) {
//            df = new DecimalFormat("###.0");
//        } else {
//            df = new DecimalFormat("###.00");
//        }
//        return df.format(val);

        //方法三：展示￥56345，当val为0时展示'￥0.0'
        return BigDecimal.valueOf(val).stripTrailingZeros().toPlainString();
    }

//    public static double round(double value, int scale) {
//        return round(value, scale, BigDecimal.ROUND_HALF_UP);
//    }
    /**
     * 对double数据进行取精度.
     * @param value  double数据.
     * @param scale  精度位数(保留的小数位数).
     * @param roundingMode  精度取值方式.
     * @return 精度计算后的数据.
     */
//    public static double round(double value, int scale, int roundingMode) {
//        BigDecimal bd = new BigDecimal(value);
//        bd = bd.setScale(scale, roundingMode);
//        double d = bd.doubleValue();
//        bd = null;
//        return d;
//    }

    /**根据原价和卖价，计算折扣*/
    public static String calculateDiscount (double originnalPrice, double appPrice) {
        BigDecimal bd1 = new BigDecimal(originnalPrice);
        BigDecimal bd2 = new BigDecimal(appPrice);
        double discount = bd1.divide(bd2, 1, BigDecimal.ROUND_HALF_UP).doubleValue();
        return formatDouble(discount);
    }

    /**
     * 计算商品活动的较少的价格（立减）
     */
    public static double getActivityDiscount(double total, String ruleType, List<GoodRule> ruleList) {
        double discount = total;
        if (discount > 0 && ruleType!=null &&  ruleType.equalsIgnoreCase("MAN_JIAN")) {
            if (ruleList != null) {
                for (int i=ruleList.size()-1; i>=0; i--) {
                    if (discount > ruleList.get(i).getPara1()) {
                        discount = ruleList.get(i).getPara2();
                        break;
                    }
                }
            }
        }
        return discount;
    }

    public static ActivityAmount getActivityDiscountByBrand(List<CartItem> cartList) {
        double hejimoney = 0;//原始总价
        double li_jian = 0;//总共减少的价格（立减）
        CartItem lastCartItem = null;//保存上一个参与不同活动的活动的购物车
        double lastActivityTotalPrice = 0;//保存上一个活动的所有商品的总价
        List<Integer> ruleIdList = new ArrayList<>();
        for (CartItem cartItem : cartList) {
            hejimoney = hejimoney + cartItem.getTotalPrice();
            if (cartItem.isRuleActive()) {
                //控制活动促销的显示，并且计算参与活动减少的总金额
                if (lastCartItem == null || lastCartItem.getActivityRuleId() != cartItem.getActivityRuleId()) {
                    if (lastCartItem != null && lastCartItem.getActivityRuleType() != null) {
                        double discount = OrderTools.getActivityDiscount(lastActivityTotalPrice,
                                lastCartItem.getActivityRuleType(), lastCartItem.getRuleList());
                        if (discount > 0) {
                            ruleIdList.add(lastCartItem.getActivityRuleId());
                            li_jian += discount;
                        }
                    }
                    if (cartItem.getActivityRuleId() > 0) {
                        lastActivityTotalPrice = cartItem.getTotalPrice();
                        lastCartItem = cartItem;
                    } else {
                        lastActivityTotalPrice = 0;
                    }
                } else {
                    lastActivityTotalPrice += cartItem.getTotalPrice();
                }
            }
        }
        if (lastActivityTotalPrice > 0) {
            double discount = OrderTools.getActivityDiscount(lastActivityTotalPrice,
                    lastCartItem.getActivityRuleType(), lastCartItem.getRuleList());
            if (discount > 0) {
                ruleIdList.add(lastCartItem.getActivityRuleId());
                li_jian += discount;
            }
        }
        return new ActivityAmount(hejimoney, li_jian, ruleIdList);
    }

    /**
     * 建材团：得到全部购物车的返现---立减（优惠价格）
     * @param cartList:购物车列表
     * */
    public static ActivityAmount getActivityDiscount(List<CartItem> cartList) {
        double hejimoney = 0;//原始总价
        double li_jian = 0;//总共减少的价格（立减）
        CartItem lastCartItem = null;//保存上一个参与不同活动的活动的购物车
        double lastActivityTotalPrice = 0;//保存上一个活动的所有商品的总价
        List<Integer> ruleIdList = new ArrayList<>();
        for (CartItem cartItem : cartList) {
            if (cartItem.isChecked()) {
                hejimoney = hejimoney + cartItem.getTotalPrice();
                if (cartItem.isRuleActive()) {
                    //控制活动促销的显示，并且计算参与活动减少的总金额
                    if (lastCartItem == null || lastCartItem.getActivityRuleId() != cartItem.getActivityRuleId()) {
                        if (lastCartItem != null && lastCartItem.getActivityRuleType() != null) {
                            double discount = OrderTools.getActivityDiscount(lastActivityTotalPrice,
                                    lastCartItem.getActivityRuleType(), lastCartItem.getRuleList());
                            if (discount > 0) {
                                ruleIdList.add(lastCartItem.getActivityRuleId());
                                li_jian += discount;
                            }
                        }
                        if (cartItem.getActivityRuleId() > 0) {
                            lastActivityTotalPrice = cartItem.getTotalPrice();
                            lastCartItem = cartItem;
                        } else {
                            lastActivityTotalPrice = 0;
                        }
                    } else {
                        lastActivityTotalPrice += cartItem.getTotalPrice();
                    }
                }
            }
        }
        if (lastActivityTotalPrice > 0) {
            double discount = OrderTools.getActivityDiscount(lastActivityTotalPrice,
                    lastCartItem.getActivityRuleType(), lastCartItem.getRuleList());
            if (discount > 0) {
                ruleIdList.add(lastCartItem.getActivityRuleId());
                li_jian += discount;
            }
        }
        return new ActivityAmount(hejimoney, li_jian, ruleIdList);
    }

    /**
     * 友盟统计支付
     * @param type:支付的订单类型（建材、工地、辅料）
     * @param realPay:实际支付
     * */
    public static void analysisPurchase (Context context, String type, String orderNumber, String realPay) {
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("orderNumber", orderNumber);
        map.put("realPay", realPay);
    }

}
