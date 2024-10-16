package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
public final class zzbvh implements zzbvg {

    /* renamed from: a, reason: collision with root package name */
    private final List<String> f3070a;
    private final zzdae b;
    private boolean c;

    public zzbvh(zzcxm zzcxmVar, zzdae zzdaeVar) {
        this.f3070a = zzcxmVar.zzdnl;
        this.b = zzdaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvg
    public final void zzagx() {
        if (this.c) {
            return;
        }
        this.b.zzh(this.f3070a);
        this.c = true;
    }
}
