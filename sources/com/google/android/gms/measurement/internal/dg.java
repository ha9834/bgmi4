package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dg implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final String f4804a;
    private final /* synthetic */ zzfc b;

    public dg(zzfc zzfcVar, String str) {
        this.b = zzfcVar;
        Preconditions.checkNotNull(str);
        this.f4804a = str;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.b.zzab().zzgk().zza(this.f4804a, th);
    }
}
