package com.google.android.gms.internal.ads;

import android.os.Looper;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public final class zzjz {

    /* renamed from: a, reason: collision with root package name */
    private final ExecutorService f3668a;
    private aks b;
    private boolean c;

    public zzjz(String str) {
        this.f3668a = zzkq.zzax(str);
    }

    public final void zza(zzkc zzkcVar, zzka zzkaVar) {
        Looper myLooper = Looper.myLooper();
        zzkh.checkState(myLooper != null);
        zzkh.checkState(!this.c);
        this.c = true;
        this.b = new aks(this, myLooper, zzkcVar, zzkaVar, 0);
        this.f3668a.submit(this.b);
    }

    public final boolean isLoading() {
        return this.c;
    }

    public final void zzgb() {
        zzkh.checkState(this.c);
        this.b.a();
    }

    public final void release() {
        if (this.c) {
            zzgb();
        }
        this.f3668a.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean a(zzjz zzjzVar, boolean z) {
        zzjzVar.c = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ aks a(zzjz zzjzVar, aks aksVar) {
        zzjzVar.b = null;
        return null;
    }
}
