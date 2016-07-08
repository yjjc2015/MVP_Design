package com.wxj.mvp_design.view;

import com.wxj.mvp_design.bean.WorkerInfo;

/**
 * Created by chen on 2016/7/8 0008.
 */
public interface IWorkerLoginView {
    String getUserName();
    String getPassword();
    void showLoading();
    void hideLoading();
    void showError(String error);
    void onSuccess(WorkerInfo workerInfo);
}
