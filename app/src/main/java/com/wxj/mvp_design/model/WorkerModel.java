package com.wxj.mvp_design.model;

import com.wxj.mvp_design.global.Constant;
import com.wxj.mvp_design.http.EventListener;
import com.wxj.mvp_design.http.NoHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by chen on 2016/7/8 0008.
 */
public class WorkerModel {
    public void login(String userName, String passWord, EventListener eventListener) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", userName);
        params.put("passWord", passWord);
        NoHttpUtils.post(Constant.WORKER_LOGIN, params, eventListener);
    }
}
