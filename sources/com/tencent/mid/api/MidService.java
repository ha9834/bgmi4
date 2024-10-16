package com.tencent.mid.api;

import android.content.Context;
import com.tencent.mid.a.g;

/* loaded from: classes.dex */
public class MidService {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f6259a = true;

    public static String getMidRequestHost() {
        return null;
    }

    public static String getMidRequestUrl() {
        return null;
    }

    public static void setMidRequestUrl(String str) {
    }

    public static void requestMid(Context context, MidCallback midCallback) {
        if (midCallback == null) {
            throw new IllegalArgumentException("error, callback is null!");
        }
        if (context == null) {
            midCallback.onFail(MidConstants.ERROR_ARGUMENT, "content is null!");
        } else {
            g.a(context.getApplicationContext(), midCallback);
        }
    }

    public static String getLocalMidOnly(Context context) {
        return com.tencent.mid.b.g.a(context).f();
    }

    public static String getMid(Context context) {
        return g.b(context);
    }

    public static long getGuid(Context context) {
        return g.c(context);
    }

    public static boolean isMidValid(String str) {
        return g.a(str);
    }

    public static void enableDebug(boolean z) {
        g.a(z);
    }

    public static boolean isEnableDebug() {
        return g.a();
    }

    public static boolean isEnableReportWifiList() {
        return f6259a;
    }

    public static void setEnableReportWifiList(boolean z) {
        f6259a = z;
    }

    public static String getNewMid(Context context) {
        return com.tencent.mid.b.g.a(context).b();
    }
}
