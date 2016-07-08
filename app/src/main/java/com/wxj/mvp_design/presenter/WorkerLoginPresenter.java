package com.wxj.mvp_design.presenter;

import com.google.gson.GsonBuilder;
import com.wxj.mvp_design.bean.WorkerInfo;
import com.wxj.mvp_design.http.EventListener;
import com.wxj.mvp_design.model.WorkerModel;
import com.wxj.mvp_design.view.IWorkerLoginView;

/**
 * Created by chen on 2016/7/8 0008.
 */
public class WorkerLoginPresenter {
    private IWorkerLoginView loginView;
    private WorkerModel workerModel;

    public WorkerLoginPresenter(IWorkerLoginView loginView) {
        this.loginView = loginView;
        workerModel = new WorkerModel();
    }

    public void login() {
        workerModel.login(loginView.getUserName(), loginView.getPassword(), new EventListener() {
            @Override
            public void onStart() {
                loginView.showLoading();
            }

            @Override
            public void onFinish() {
                loginView.hideLoading();
            }

            @Override
            public void onSuccess(String response) {
                try {
                    WorkerInfo workerInfo = new GsonBuilder().create().fromJson(response, WorkerInfo.class);
                    loginView.onSuccess(workerInfo);
                }catch (Exception e) {}
            }

            @Override
            public void onFailure(String error) {
                loginView.showError(error);
            }
        });
    }
}
