package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fo implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Context f2176a;
    private final /* synthetic */ zzaxi b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fo(zzaxi zzaxiVar, Context context) {
        this.b = zzaxiVar;
        this.f2176a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Object obj2;
        obj = this.b.d;
        synchronized (obj) {
            this.b.e = zzaxi.a(this.f2176a);
            obj2 = this.b.d;
            obj2.notifyAll();
        }
    }
}
