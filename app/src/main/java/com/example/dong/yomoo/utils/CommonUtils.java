package com.example.dong.yomoo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dong on 22/12/2017.
 */

public class CommonUtils {
    /**
     * 验证手机号码
     *
     * @param phone
     * @return 是否符合手机号规则
     */
    public static boolean checkMobileNumber(String phone) {
        boolean flag;
        try {
            Pattern regex = Pattern.compile("^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$");
            Matcher matcher = regex.matcher(phone);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
}
