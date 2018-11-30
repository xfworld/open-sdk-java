package com.gat.open.sdk.util;


import com.gat.open.sdk.exception.GATException;

/**
 * 参数校验工具类
 *
 * @author xin.hua
 * @date 2017/7/18
 */
public class ParamValidator {

    public static <T> T requireNonNull(T obj, String message) {
        if (obj == null) {
            throw new GATException(message);
        }
        return obj;
    }

    public static String requireNonEmpty(String obj, String message) {
        if (obj == null || obj.isEmpty() || obj.trim().isEmpty()) {
            throw new GATException(message);
        }
        return obj;
    }

    public static String requireMobile(String mobile) {
        if (!checkMobile(mobile)) {
            throw new GATException("手机号格式不匹配");
        }
        return mobile;
    }

    public static boolean contains(int[] intVals, int val) {
        if (intVals == null || intVals.length <= 0) {
            return false;
        }
        for (int intVal : intVals) {
            if (intVal == val) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkMobile(String mobile) {
        if (mobile == null || mobile.isEmpty() || mobile.trim().isEmpty()) {
            return false;
        }
        if (mobile.length() > 11) {
            return false;
        }
        return mobile.matches("^1\\d{10}$");
    }


}
