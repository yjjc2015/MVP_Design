package com.wxj.mvp_design.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wxj.mvp_design.R;
import com.wxj.mvp_design.bean.WorkerInfo;
import com.wxj.mvp_design.presenter.WorkerLoginPresenter;
import com.wxj.mvp_design.view.IWorkerLoginView;

/**
 * Created by chen on 2016/7/7 0007.
 */
public class WorkerLoginActivity extends AppCompatActivity implements IWorkerLoginView {
    private android.widget.EditText userName;
    private android.widget.EditText password;
    private android.widget.Button btnLogin;

    private ProgressDialog progressDialog;
    private WorkerLoginPresenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_login);
        initViews();
        initEvents();
    }

    private void initViews() {
        this.btnLogin = (Button) findViewById(R.id.btnLogin);
        this.password = (EditText) findViewById(R.id.password);
        this.userName = (EditText) findViewById(R.id.userName);

        presenter = new WorkerLoginPresenter(this);
    }

    private void initEvents() {
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return this.userName.getText().toString();
    }

    @Override
    public String getPassword() {
        return this.password.getText().toString();
    }

    @Override
    public void showLoading() {
        if (progressDialog == null) {
            progressDialog = ProgressDialog.show(this, null, "登录中...");
        } else {
            progressDialog.show();
        }
    }

    @Override
    public void hideLoading() {
        progressDialog.dismiss();
    }

    @Override
    public void showError(String error) {
        Toast.makeText(WorkerLoginActivity.this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess(WorkerInfo workerInfo) {
        Toast.makeText(WorkerLoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }
}
