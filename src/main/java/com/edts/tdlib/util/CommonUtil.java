package com.edts.tdlib.util;

import org.apache.commons.lang3.ClassUtils;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Collections of common utility functions.
 */
public final class CommonUtil {

    /**
     * Check if object is array or iterable object
     * will return false if null
     *
     * @param obj object to be check
     * @return true if object is array or iterable
     */
    public static boolean isArrayOrCollection(Object obj) {
        if (null != obj) {
            if (obj.getClass().isArray()) {
                return true;
            } else {
                return ClassUtils.isAssignable(obj.getClass(), Collection.class);
            }
        }
        return false;
    }

    // Generate 4 digits OTP
    public static String generateOTP() {
        int randomNum = (int) (Math.random() * 9000) + 1000;
        String otp = String.valueOf(randomNum);
        return otp; //returning value of otp
    }


    public static boolean checkPhoneNumberFormatAndDigit(String param, int type) {
        String regex = "[0-9]+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(param);
        if (param == null) {
            return false;
        }

        if (!m.matches()) {
            return false;
        }

        if (m.matches() && type == 0) {
            int l = param.length();
            return l >= 10 && l <= 14;
        } else if (m.matches() && type == 1) {
            int l = param.length();
            return l == 16;
        }
        return true;
    }

}