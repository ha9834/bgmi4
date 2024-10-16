package com.google.android.gms.internal.gtm;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class s implements Callable<String> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbh f4374a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(zzbh zzbhVar) {
        this.f4374a = zzbhVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        return this.f4374a.c();
    }
}
