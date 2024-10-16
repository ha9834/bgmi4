package com.vk.api.sdk.utils.log;

import android.util.Log;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.api.sdk.utils.log.Logger;
import kotlin.c;
import kotlin.jvm.internal.h;

/* loaded from: classes3.dex */
public class a implements Logger {

    /* renamed from: a, reason: collision with root package name */
    private c<? extends Logger.LogLevel> f6930a;
    private final String b;

    /* renamed from: com.vk.api.sdk.utils.log.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public /* synthetic */ class C0225a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6931a;

        static {
            int[] iArr = new int[Logger.LogLevel.values().length];
            iArr[Logger.LogLevel.NONE.ordinal()] = 1;
            iArr[Logger.LogLevel.VERBOSE.ordinal()] = 2;
            iArr[Logger.LogLevel.DEBUG.ordinal()] = 3;
            iArr[Logger.LogLevel.WARNING.ordinal()] = 4;
            iArr[Logger.LogLevel.ERROR.ordinal()] = 5;
            f6931a = iArr;
        }
    }

    public a(c<? extends Logger.LogLevel> cVar, String str) {
        h.b(cVar, "logLevel");
        h.b(str, ViewHierarchyConstants.TAG_KEY);
        this.f6930a = cVar;
        this.b = str;
    }

    @Override // com.vk.api.sdk.utils.log.Logger
    public c<Logger.LogLevel> a() {
        return this.f6930a;
    }

    public String b() {
        return this.b;
    }

    @Override // com.vk.api.sdk.utils.log.Logger
    public void a(Logger.LogLevel logLevel, String str, Throwable th) {
        h.b(logLevel, FirebaseAnalytics.Param.LEVEL);
        if (a(logLevel)) {
            return;
        }
        switch (C0225a.f6931a[logLevel.ordinal()]) {
            case 1:
            default:
                return;
            case 2:
                Log.v(b(), str, th);
                return;
            case 3:
                Log.d(b(), str, th);
                return;
            case 4:
                Log.w(b(), str, th);
                return;
            case 5:
                Log.e(b(), str, th);
                return;
        }
    }

    private final boolean a(Logger.LogLevel logLevel) {
        return a().a().ordinal() > logLevel.ordinal();
    }
}
