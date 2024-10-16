package com.google.android.gms.internal.gtm;

import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ y f4379a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(y yVar) {
        this.f4379a = yVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzap zzapVar;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            boolean c = this.f4379a.c();
            y.a(this.f4379a, 0L);
            if (c) {
                this.f4379a.a();
                return;
            }
            return;
        }
        zzapVar = this.f4379a.f4378a;
        zzapVar.zzcq().zza(this);
    }
}
