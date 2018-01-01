package com.wj.mvp.repository;


import com.wj.mvp.repository.callback.RepoCallBack;
import com.wj.mvp.utils.Constant;

import org.json.JSONObject;

/**
 * 登陆repo
 * Created by wangjiong on 2017/12/27.
 */

public class LoginRepo extends BaseRepo {
    /**
     * 登陆交易
     */
    public void login(JSONObject jsonObject, Class<?> t, RepoCallBack baseRepoCallBack) {
        LoginRepo.get(Constant.Ip, t, new BaseRepoCallBack() {
            @Override
            public <T> void onSuccess(T response) {
                baseRepoCallBack.onSuccess(response);
            }

            @Override
            public void onFailed(String response) {
                baseRepoCallBack.onFailed(response);
            }

            @Override
            public void onError(String response) {
                baseRepoCallBack.onError(response);
            }
        });
    }
}
