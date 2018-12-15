package com.assesment.topan.anews.util;

/*************************************************
 * Author     : Topan E.                         *
 * Contact    : topan.xt@gmail.com               *
 * Created on : Nov 26, 2018.                    *
 *************************************************/
public class StringUtils {
    public static String tailTrim(String string, int count) {
        return string.substring(0, string.length() - count);
    }
}
