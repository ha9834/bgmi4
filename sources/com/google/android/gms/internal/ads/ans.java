package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ans implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ String f1992a;
    private final /* synthetic */ long b;
    private final /* synthetic */ zzr c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ans(zzr zzrVar, String str, long j) {
        this.c = zzrVar;
        this.f1992a = str;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzag.a aVar;
        zzag.a aVar2;
        aVar = this.c.f3715a;
        aVar.a(this.f1992a, this.b);
        aVar2 = this.c.f3715a;
        aVar2.a(this.c.toString());
    }
}
