package com.example.dong.yomoo.http;

/**
 * URL列表
 */

public class HttpAPI {
    public static final int TIME_OUT = 20 * 1000;
    public static final int RESULT_OK = 200;


    public static final String SCHEMA = "http://";
    public static final String DOMAIN = SCHEMA + "10.0.2.2:8080/";

    public static final String REGISTER = DOMAIN + "register/";
    public static final String LOGIN = DOMAIN + "login/";
    public static final String COMPLETE_INFO = DOMAIN + "complete_info/";
    public static final String LOGOUT = DOMAIN + "logout/";

    //获取某个养殖户信息
    public static final String FARMER_INFO = DOMAIN + "farmer/";

    //获取用户列表
    public static final String VENDOR_LIST = DOMAIN + "users/";

    //获取某个经销商的饲料列表
    public static final String FODDER_LIST = DOMAIN + "fodder/";


    public static final String POST_LIVESTOCK_DEMAND = DOMAIN + "post_livestock_demand/";

    public static final String POST_BREEDING_INFO = DOMAIN + "post_breeding_info/";

    public static final String POST_BREEDING_INFO_DEMAND = DOMAIN + "post_breeding_info_demand/";


}
