package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aiv implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ int f1900a;
    private final /* synthetic */ boolean b;
    private final /* synthetic */ zzdy c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aiv(zzdy zzdyVar, int i, boolean z) {
        this.c = zzdyVar;
        this.f1900a = i;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean b;
        zzbp.zza b2 = this.c.b(this.f1900a, this.b);
        this.c.l = b2;
        b = zzdy.b(this.f1900a, b2);
        if (b) {
            this.c.a(this.f1900a + 1, this.b);
        }
    }
}
