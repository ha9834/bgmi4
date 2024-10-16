package com.google.android.gms.internal.gtm;

import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class h implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzap f4363a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(zzap zzapVar) {
        this.f4363a = zzapVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzci zzdd = this.f4363a.zzdd();
        if (zzdd != null) {
            zzdd.zze("Job execution failed", th);
        }
    }
}
