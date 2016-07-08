package com.wxj.mvp_design.global;

import com.yolanda.nohttp.NoHttp;

/**
 * Created by chen on 2016/7/8 0008.
 */
public class Application extends android.app.Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NoHttp.initialize(this);
    }
}
