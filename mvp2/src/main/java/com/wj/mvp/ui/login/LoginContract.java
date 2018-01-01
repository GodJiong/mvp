package com.wj.mvp.ui.login;

import com.wj.mvp.ui.BasePresenter;
import com.wj.mvp.ui.BaseView;

/**
 * 包含View和Presenter的契约接口
 * Created by wangjiong on 2017/12/7.
 */
public interface LoginContract {
    /**
     * 与UI相关，与view相关操作
     */
    interface View extends BaseView {
        // 展示等待加载页面
        void showLoading();

        // 隐藏等待加载页面
        void hideLoading();

        // 显示登陆信息
        void showLoginInfo(String msg);
    }

    /**
     * 与业务相关
     */
    abstract class Presenter extends BasePresenter {
        /**
         * 登陆
         *
         * @param userId       用户id
         * @param userPassword 密码
         */
        abstract void login(String userId, String userPassword);
    }
}
