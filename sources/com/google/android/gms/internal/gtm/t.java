package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class t implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbh f4375a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(zzbh zzbhVar) {
        this.f4375a = zzbhVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String r;
        r = this.f4375a.r();
        return r;
    }
}
