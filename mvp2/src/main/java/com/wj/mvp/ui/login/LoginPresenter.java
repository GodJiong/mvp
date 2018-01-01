package com.wj.mvp.ui.login;


import com.wj.mvp.model.bean.LoginBean;
import com.wj.mvp.repository.LoginRepo;
import com.wj.mvp.repository.callback.RepoCallBack;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * MVP中的P层
 * Created by wangjiong on 2017/12/7
 */

public class LoginPresenter extends LoginContract.Presenter {
    private LoginContract.View mView;
    private LoginRepo mLoginRepo;

    public LoginPresenter(LoginRepo loginRepo) {
        this.mLoginRepo = loginRepo;
    }

    public void login(String userId, String password) {
        if (getMvpView() != null) {
            mView = (LoginContract.View) getMvpView();
        }
        // validation

        // call login

        // ???
        mView.showLoading();// 调用view的展示遮罩方法（view用来更新具体的UI）
        // 网络请求
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("trans_id", "app_mer_01");
            jsonObject.put("userName", userId);
            jsonObject.put("password", password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mLoginRepo.login(jsonObject, LoginBean.class, new RepoCallBack() {
            @Override
            public <T> void onSuccess(T response) {
                mView.hideLoading();// 调用view的隐藏遮罩方法（view用来更新具体的UI）
                mView.showLoginInfo("错误吗？"+((LoginBean) response).isError());// 调用view的吐司方法（view用来更新具体的UI）
            }

            @Override
            public void onFailed(String response) {
                mView.hideLoading();
                mView.showLoginInfo(response);// 调用view的吐司方法（view用来更新具体的UI）
            }

            @Override
            public void onError(String response) {
                mView.hideLoading();
                mView.showLoginInfo(response);// 调用view的吐司方法（view用来更新具体的UI）
            }
        });
    }

    /**
     * 取消网络请求
     */
    void interruptHttp() {
        mLoginRepo.cancelHttp();
    }
}
