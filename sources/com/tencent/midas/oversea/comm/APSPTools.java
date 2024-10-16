package com.tencent.midas.oversea.comm;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class APSPTools {
    public static final String SP_IP_INFO = "MidasOverseaIP";
    public static final String SP_NAME = "TencentUnipay";

    public static String getString(Context context, String str) {
        return context.getSharedPreferences(SP_NAME, 0).getString(str, "");
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(str, 0).getString(str2, "");
    }

    public static void putString(Context context, String str, String str2) {
        context.getSharedPreferences(SP_NAME, 0).edit().putString(str, str2).apply();
    }

    public static void putString(Context context, String str, String str2, String str3) {
        context.getSharedPreferences(str, 0).edit().putString(str2, str3).apply();
    }

    public static int getInt(Context context, String str) {
        return context.getSharedPreferences(SP_NAME, 0).getInt(str, 0);
    }

    public static void putInt(Context context, String str, int i) {
        context.getSharedPreferences(SP_NAME, 0).edit().putInt(str, i).apply();
    }

    public static SharedPreferences getSP(Context context, String str) {
        return context.getSharedPreferences(str, 0);
    }
}
