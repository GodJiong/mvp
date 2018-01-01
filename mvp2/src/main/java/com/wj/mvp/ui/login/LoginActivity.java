package com.wj.mvp.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.wj.mvp.R;
import com.wj.mvp.repository.LoginRepo;
import com.wj.mvp.ui.AbstractMvpActivity;
import com.wj.mvp.utils.EmptyUtils;
import com.orhanobut.logger.Logger;

/**
 * MVP层中的View层
 * Created by wj on 2018/1/1 12:51
 */
public class LoginActivity extends AbstractMvpActivity<LoginActivity, LoginPresenter> implements LoginContract.View {
    private EditText mEtName, mEtPwd;
    private LinearLayout mLayoutLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mEtName = (EditText) findViewById(R.id.et_name);// 用户名
        mEtPwd = (EditText) findViewById(R.id.et_pwd);// 密码
        mLayoutLoading = (LinearLayout) findViewById(R.id.layout_loading);// 遮罩层
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {// 登陆按钮
            @Override
            public void onClick(View view) {// 点击登陆不是直接请求网络，而是通过presenter请求网络，然后将请求回来的数据交给view来更新
                getPresenter().login(mEtName.getText().toString().trim(), mEtPwd.getText().toString().trim());
            }
        });
        Logger.e("绑定的view为空吗？" + EmptyUtils.isEmpty(getPresenter().getMvpView()));
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(new LoginRepo());
    }

    @Override
    public void showLoading() {// 展示遮罩层
        mLayoutLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {// 隐藏遮罩层
        mLayoutLoading.setVisibility(View.GONE);
    }

    @Override
    public void showLoginInfo(String msg) {// 吐司登陆信息
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getPresenter().interruptHttp();
        Logger.e("解绑之后view为空吗？" + EmptyUtils.isEmpty(getPresenter().getMvpView()));

    }
}
