package com.wj.mvp.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.csii.mvp.R;

/**
 * MVP层中的View层
 */
public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private LoginPresenter mPresenter;
    private EditText mEtName, mEtPwd;
    private LinearLayout mLayoutLoading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setPresenter();// 初始化presenter（很重要！不能说重写就不管了，一定要在view初始化调用此方法）
        mEtName = findViewById(R.id.et_name);// 用户名
        mEtPwd = findViewById(R.id.et_pwd);// 密码
        mLayoutLoading = findViewById(R.id.layout_loading);// 遮罩层
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {// 登陆按钮
            @Override
            public void onClick(View view) {// 点击登陆不是直接请求网络，而是通过presenter请求网络，然后将请求回来的数据交给view来更新
                mPresenter.login(mEtName.getText().toString().trim(), mEtPwd.getText().toString().trim());
            }
        });
    }
    @Override
    public void setPresenter() {
        mPresenter = new LoginPresenter(this);// 一是为了实例化presenter，二是通过构造方法将view实例传递给presenter
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
}
