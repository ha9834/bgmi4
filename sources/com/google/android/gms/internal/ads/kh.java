package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
final class kh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbfq f2289a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kh(zzbfq zzbfqVar) {
        this.f2289a = zzbfqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzk.zzmc().zzb(this.f2289a);
    }
}
