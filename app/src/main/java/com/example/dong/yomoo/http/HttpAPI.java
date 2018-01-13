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

    public static final String FARMER_LIST = DOMAIN + "farmers/";

    // 获取某个养殖户信息
    public static final String FARMER_INFO = DOMAIN + "farmer/";

    public static final String VENDOR_INFO = DOMAIN + "vendor/";

    // 获取用户列表
    public static final String USER_LIST = DOMAIN + "users/";

    // 销售商发布养殖技术信息
    public static final String POST_BREEDING_INFO = DOMAIN + "post_breeding_info/";

    // 养殖户发布养殖技术需求
    public static final String POST_BREEDING_INFO_DEMAND = DOMAIN + "post_breeding_info_demand/";
    // 养殖户获取养殖技术信息列表
    public static final String FARMER_GET_BREEDING_INFO_LIST = "breeding_info_list/";

    public static final String VENDOR_GET_HISTORY_ORDER_LIST = "orders/";

    public static final String FARMER_GET_HISTORY_ORDER_LIST = "orders/";

    // 获取经销商的饲料列表
    public static final String FODDER_Of_VENDOR_LIST = DOMAIN + "fv_list/";

    // 养殖户查看饲料详情页
    public static final String GET_FODDER_DETAIL = DOMAIN + "fodder_of_vendor/";

    // 养殖户提交饲料订单
    public static final String FARMER_POST_ORDER = "order_fodder/";

    // 养殖户查看牲畜需求列表
    public static final String GET_LIVESTOCK_DEMAND_LIST = DOMAIN + "livestock_demand_list/";
    public static final String GET_LIVESTOCK_DEMAND_DETAIL = DOMAIN + "livestock_demand/";

    // 销售商增加进货记录
    public static final String VENDOR_POST_PURCHASE = DOMAIN + "add_purchase/";

    // 肉品加工商发布牲畜需求
    public static final String POST_LIVESTOCK_DEMAND = DOMAIN + "post_livestock_demand/";

}
