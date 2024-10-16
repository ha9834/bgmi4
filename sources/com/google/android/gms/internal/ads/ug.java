package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final /* synthetic */ class ug implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private final zzcja f2538a;

    private ug(zzcja zzcjaVar) {
        this.f2538a = zzcjaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Callable a(zzcja zzcjaVar) {
        return new ug(zzcjaVar);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.f2538a.getWritableDatabase();
    }
}
