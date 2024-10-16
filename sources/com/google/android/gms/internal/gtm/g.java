package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzae f4362a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzae zzaeVar) {
        this.f4362a = zzaeVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Void call() throws Exception {
        n nVar;
        nVar = this.f4362a.f4384a;
        nVar.u();
        return null;
    }
}
