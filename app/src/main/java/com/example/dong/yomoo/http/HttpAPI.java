package com.example.dong.yomoo.http;

/**
 * Created by dong on 20/12/2017.
 */

public class HttpAPI {
    public static final int TIME_OUT = 20 * 1000;
    public static final int RESULT_OK = 200;


    public static final String SCHEMA = "http://";
    public static final String DOMAIN = SCHEMA + "10.0.2.2:8080/";

    public static final String REGISTER = DOMAIN + "register/";
    public static final String LOGIN = DOMAIN + "login/";
    public static final String COMPLETE_INFO = DOMAIN + "complete_info/";


    public static final String FARMER_INFO = DOMAIN + "farmer/";

}
