package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gt implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzn f4893a;
    private final /* synthetic */ zzjg b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gt(zzjg zzjgVar, zzn zznVar) {
        this.b = zzjgVar;
        this.f4893a = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        de e;
        e = this.b.e(this.f4893a);
        if (e == null) {
            this.b.zzab().zzgn().zzao("App info was null when attempting to get app instance id");
            return null;
        }
        return e.c();
    }
}
