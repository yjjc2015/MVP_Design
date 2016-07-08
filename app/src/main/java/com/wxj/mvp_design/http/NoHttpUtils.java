package com.wxj.mvp_design.http;

import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import java.util.Map;

/**
 * Created by chen on 2016/7/8 0008.
 */
public class NoHttpUtils {
    private static RequestQueue requestQueue;

    private static RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = NoHttp.newRequestQueue();
        }
        return requestQueue;
    }

    public static void post(String url, Map<String, String> params, final EventListener eventListener) {
        Request<String> request = NoHttp.createStringRequest(url);
        request.add(params);
        getRequestQueue().add(0, request, new OnResponseListener<String>() {
            @Override
            public void onStart(int what) {
                eventListener.onStart();
            }

            @Override
            public void onSucceed(int what, Response<String> response) {
                eventListener.onSuccess(response.get());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                eventListener.onFailure(exception.getMessage());
            }

            @Override
            public void onFinish(int what) {
                eventListener.onFinish();
            }
        });
    }
}
