package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcjx {

    /* renamed from: a, reason: collision with root package name */
    private zzbrt f3291a;
    private zzcxm b;

    public zzcjx(zzcxm zzcxmVar) {
        this.b = zzcxmVar;
    }

    public final void zzakq() {
        if (this.f3291a != null && this.b.zzgkp == 2) {
            this.f3291a.onAdImpression();
        }
    }

    public final void zza(zzbrt zzbrtVar) {
        this.f3291a = zzbrtVar;
    }
}
