package com.wj.mvp.api;

import com.wj.mvp.bean.LoginBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * 登陆接口
 * Created by wangjiong on 2017/12/7.
 */

public interface LoginApi {
    @GET("login")//get请求login接口（接口名需要后台提供）
    Call<LoginBean> login(@Query("userId") String userId, @Query("password") String password);  // 声明一个login的方法（随便写），两个string形参，并返回一个实体类LoginBean
}
