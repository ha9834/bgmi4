package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcod implements zzdti<zzcoc> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzclc> f3344a;

    private zzcod(zzdtu<zzclc> zzdtuVar) {
        this.f3344a = zzdtuVar;
    }

    public static zzcod zzai(zzdtu<zzclc> zzdtuVar) {
        return new zzcod(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcoc(this.f3344a.get());
    }
}
