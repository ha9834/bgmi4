package com.google.android.gms.internal.ads;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dx implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Thread.UncaughtExceptionHandler f2135a;
    private final /* synthetic */ zzaqx b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dx(zzaqx zzaqxVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.b = zzaqxVar;
        this.f2135a = uncaughtExceptionHandler;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        try {
            try {
                this.b.a(thread, th);
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2135a;
                if (uncaughtExceptionHandler != null) {
                    uncaughtExceptionHandler.uncaughtException(thread, th);
                }
            } catch (Throwable unused) {
                zzbad.zzen("AdMob exception reporter failed reporting the exception.");
                Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.f2135a;
                if (uncaughtExceptionHandler2 != null) {
                    uncaughtExceptionHandler2.uncaughtException(thread, th);
                }
            }
        } catch (Throwable th2) {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler3 = this.f2135a;
            if (uncaughtExceptionHandler3 != null) {
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
            throw th2;
        }
    }
}
