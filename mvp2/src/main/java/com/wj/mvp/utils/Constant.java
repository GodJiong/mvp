package com.wj.mvp.utils;

import com.wj.mvp.model.bean.LoginBean;

import org.json.JSONObject;

/**
 * Created by wj on 2017/11/8 23:01
 */
public class Constant {
    public static final String fileProvider = "com.csii.mobpieces.FileProvider";// 7.0 FileProvider路径（要和清单文件配置的一样）
    public static String FIRST_OPEN;  // 判断是否是第一次开启应用
    public static LoginBean UserInfo;// 用户信息（登陆之后赋值）
    public static JSONObject json = new JSONObject();// 用来传递和保存商户录入信息
    public static boolean checkMerId;//判断是否是从商户管理-修改进来的，如果是那么需要填充数据
    public static String Ip;

    static {
        Ip = "http://gank.io/api/data/福利/10/1";// 测试地址
    }


    /**
     * 正则：手机号（精确）
     * <p>移动：134(0-8)、135、136、137、138、139、147、150、151、152、157、158、159、178、182、183、184、187、188</p>
     * <p>联通：130、131、132、145、155、156、171、175、176、185、186</p>
     * <p>电信：133、153、173、177、180、181、189</p>
     * <p>全球星：1349</p>
     * <p>虚拟运营商：170</p>
     */
    public static final String REGEX_MOBILE_EXACT = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,1,3,5-8])|(18[0-9])|(147))\\d{8}$";
    /**
     * 正则：邮箱
     */
    public static final String REGEX_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
}
