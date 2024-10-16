package com.tencent.mid.util;

import android.content.Context;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static d f6278a = Util.getLogger();
    private static String b = null;
    private static String c = "";
    private static String d = "";

    public static String a(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            f6278a.f(th);
        }
        return str == null ? "" : str;
    }
}
