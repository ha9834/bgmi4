package com.tencent.mtt.common.utils;

/* loaded from: classes.dex */
public class UrlUtility {
    public static boolean urlSupportedByX5CoreSp(String str) {
        return isHttpUrl(str) || isHttpsUrl(str) || str.startsWith("about:blank") || isJavascript(str);
    }

    public static boolean isHttpUrl(String str) {
        return str != null && str.length() > 6 && str.substring(0, 7).equalsIgnoreCase("http://");
    }

    public static boolean isHttpsUrl(String str) {
        return str != null && str.length() > 7 && str.substring(0, 8).equalsIgnoreCase("https://");
    }

    public static boolean isJavascript(String str) {
        return str != null && str.length() > 10 && str.substring(0, 11).equalsIgnoreCase("javascript:");
    }
}
