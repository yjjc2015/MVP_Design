package com.wxj.mvp_design.http;

/**
 * Created by chen on 2016/7/8 0008.
 */
public interface EventListener {
    void onStart();
    void onFinish();
    void onSuccess(String response);
    void onFailure(String error);
}
