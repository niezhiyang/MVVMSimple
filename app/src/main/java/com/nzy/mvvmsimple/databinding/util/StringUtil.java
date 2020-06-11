package com.nzy.mvvmsimple.databinding.util;

/**
 * @author niezhiyang
 * since 2020/6/10
 */
public class StringUtil {
    public static boolean isEmpty(String s) {
        if (s == null) {
            return true;
        } else {
            return s.length() > 0;
        }
    }
}
