package com.google.android.gms.internal.firebase_remote_config;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final /* synthetic */ class aq implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final zzex f4033a;

    private aq(zzex zzexVar) {
        this.f4033a = zzexVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable a(zzex zzexVar) {
        return new aq(zzexVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f4033a.zzdc();
    }
}
