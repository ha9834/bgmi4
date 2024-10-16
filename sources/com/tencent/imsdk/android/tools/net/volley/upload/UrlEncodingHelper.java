package com.tencent.imsdk.android.tools.net.volley.upload;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* loaded from: classes.dex */
public class UrlEncodingHelper {
    public static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
