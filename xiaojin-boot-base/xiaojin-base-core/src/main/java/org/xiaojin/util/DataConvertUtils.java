package org.xiaojin.util;

import org.xiaojin.common.constant.CommonConstant;

import java.math.BigDecimal;

/**
 * @author Jaywatson
 * @version 1.0.0
 * @ClassName DataconvertUtils.java
 * @Description TODO
 * @createTime 2024年05月24日 15:11:00
 */
public class DataConvertUtils {

    public static boolean isEmpty(Object object) {
        if (object == null) {
            return (true);
        }
        if ("".equals(object)) {
            return (true);
        }
        if (CommonConstant.STRING_NULL.equals(object)) {
            return (true);
        }
        return (false);
    }

    public static boolean isNotEmpty(Object object) {
        if (object != null && !"".equals(object) && !object.equals(CommonConstant.STRING_NULL)) {
            return (true);
        }
        return (false);
    }

    public static int getInt(String s, int defval) {
        if (s == null || "".equals(s)) {
            return (defval);
        }
        try {
            return (Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static int getInt(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        try {
            return (Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getInt(String s, Integer df) {
        if (s == null || "".equals(s)) {
            return df;
        }
        try {
            return (Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int getInt(Object object, int defval) {
        if (isEmpty(object)) {
            return (defval);
        }
        try {
            return (Integer.parseInt(object.toString()));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static int getInt(BigDecimal s, int defval) {
        if (s == null) {
            return (defval);
        }
        return s.intValue();
    }

    public static Integer[] getInts(String[] s) {
        if (s == null) {
            return null;
        }
        Integer[] integer = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            integer[i] = Integer.parseInt(s[i]);
        }
        return integer;

    }

    public static double getDouble(String s, double defval) {
        if (s == null || "".equals(s)) {
            return (defval);
        }
        try {
            return (Double.parseDouble(s));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static double getDouble(Double s, double defval) {
        if (s == null) {
            return (defval);
        }
        return s;
    }

    public static Integer getInteger(Object object, Integer defval) {
        if (isEmpty(object)) {
            return (defval);
        }
        try {
            return (Integer.parseInt(object.toString()));
        } catch (NumberFormatException e) {
            return (defval);
        }
    }

    public static Integer getInteger(Object object) {
        if (isEmpty(object)) {
            return null;
        }
        try {
            return (Integer.parseInt(object.toString()));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String getString(String s) {
        return (getString(s, ""));
    }

    public static String getString(Object object) {
        if (isEmpty(object)) {
            return "";
        }
        return (object.toString().trim());
    }

    public static String getString(int i) {
        return (String.valueOf(i));
    }

    public static String getString(float i) {
        return (String.valueOf(i));
    }

    public static String getString(String s, String defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s.trim());
    }

    public static String getString(Object s, String defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s.toString().trim());
    }

    public static long stringToLong(String str) {
        Long test = new Long(0);
        try {
            test = Long.valueOf(str);
        } catch (Exception e) {
        }
        return test.longValue();
    }
}
