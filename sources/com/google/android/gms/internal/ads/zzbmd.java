package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbmd implements zzbro {

    /* renamed from: a, reason: collision with root package name */
    private final zzcxo f2929a;
    private final zzcxu b;
    private final zzdae c;

    public zzbmd(zzcxu zzcxuVar, zzdae zzdaeVar) {
        this.b = zzcxuVar;
        this.c = zzdaeVar;
        this.f2929a = zzcxuVar.zzgky.zzgku;
    }

    @Override // com.google.android.gms.internal.ads.zzbro
    public final void onAdFailedToLoad(int i) {
        this.c.zza(this.b, null, this.f2929a.zzdfh);
    }
}
