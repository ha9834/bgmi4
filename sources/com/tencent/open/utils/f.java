package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* loaded from: classes.dex */
public class f {
    private f() {
    }

    /* loaded from: classes.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static f f6403a = new f();
    }

    public static f a() {
        return a.f6403a;
    }

    public String a(Context context) {
        if (context == null) {
            return Build.DEVICE;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String string = sharedPreferences.getString("build_device", "");
        if (string != null && !"".equals(string)) {
            return string;
        }
        String str = Build.DEVICE;
        sharedPreferences.edit().putString("build_device", str).apply();
        return str;
    }

    public String b(Context context) {
        if (context == null) {
            return Build.MODEL;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 0);
        String string = sharedPreferences.getString("build_model", "");
        if (string != null && !"".equals(string)) {
            return string;
        }
        String str = Build.MODEL;
        sharedPreferences.edit().putString("build_model", str).apply();
        return str;
    }
}
