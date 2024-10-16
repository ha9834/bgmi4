package com.google.android.gms.games.internal;

import com.google.android.gms.common.config.GservicesValue;
import com.google.android.gms.common.internal.GmsLogger;

/* loaded from: classes.dex */
public final class zzbd {

    /* renamed from: a, reason: collision with root package name */
    private static final GmsLogger f1694a = new GmsLogger("Games");
    private static final GservicesValue<Boolean> b = GservicesValue.value("games.play_games_dogfood", false);

    public static void i(String str, String str2, Throwable th) {
        f1694a.i(str, str2, th);
    }

    public static void w(String str, String str2) {
        f1694a.w(str, str2);
    }

    public static void w(String str, String str2, Throwable th) {
        f1694a.w(str, str2, th);
    }

    public static void e(String str, String str2) {
        f1694a.e(str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        f1694a.e(str, str2, th);
    }
}
