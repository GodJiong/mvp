package com.wj.mvp.repository.callback;

/**
 * repo回调
 * Created by wangjiong on 2017/12/27.
 */

public interface RepoCallBack {
    /**
     * 交易成功
     */
    <T> void onSuccess(T response);

    /**
     * 交易失败
     */
    void onFailed(String response);

    /**
     * 网络错误
     */
    void onError(String response);
}
