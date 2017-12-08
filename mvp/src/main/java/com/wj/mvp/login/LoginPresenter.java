package com.wj.mvp.login;

import com.wj.mvp.api.LoginApi;
import com.wj.mvp.bean.LoginBean;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MVP中的P层
 * Created by wangjiong on 2017/12/7
 */

public class LoginPresenter implements LoginContract.Presenter {
    private LoginContract.View mView;

    public LoginPresenter(LoginContract.View view) {// 获取到view的实例化对象
        this.mView = view;
    }

    @Override
    public void login(String userId, String password) {
        mView.showLoading();// 调用view的展示遮罩方法（view用来更新具体的UI）
        // 网络请求（可以自己封装一个网络库）
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.1.101:8080/merclienttest/")// 请求的url
                .addConverterFactory(GsonConverterFactory.create())// 设置Gson为实体类解析工具
                .build();
        LoginApi loginApi = retrofit.create(LoginApi.class);// 传入一个接口类并返回此类的实例对象
        Call<LoginBean> call = loginApi.login(userId, password);// 调用类中定义的login方法
        call.enqueue(new Callback<LoginBean>() {// retrofit异步请求
            @Override
            public void onResponse(Call<LoginBean> call, Response<LoginBean> response) {
                mView.hideLoading();// 调用view的隐藏遮罩方法（view用来更新具体的UI）
                mView.showLoginInfo(response.body().getMsg());// 调用view的吐司方法（view用来更新具体的UI）
            }

            @Override
            public void onFailure(Call<LoginBean> call, Throwable t) {
                mView.hideLoading();
            }
        });
    }
}
