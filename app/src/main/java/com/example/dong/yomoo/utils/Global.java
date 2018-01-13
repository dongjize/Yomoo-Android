package com.example.dong.yomoo.utils;

import com.example.dong.yomoo.entitiy.users.Farmer;
import com.example.dong.yomoo.entitiy.users.User;

/**
 * Created by dong on 16/12/2017.
 */

public class Global {
    public static User user = new User();
    public static Farmer farmer = new Farmer();

    public static boolean isLogin = false;
    public static boolean isExit = false;
    public static String rawCookies;
    public static String VERSION;
    public static String OBJECTNO = "";
    public static float DENSITY = 0;


    public static final int OFFSET = 20;

}
