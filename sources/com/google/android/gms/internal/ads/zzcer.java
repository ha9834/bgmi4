package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcer implements zzdti<zzcep> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzwj> f3213a;

    private zzcer(zzdtu<zzwj> zzdtuVar) {
        this.f3213a = zzdtuVar;
    }

    public static zzcer zzab(zzdtu<zzwj> zzdtuVar) {
        return new zzcer(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcep(this.f3213a.get());
    }
}
