package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzbxs implements zzdti<zzbbh<zzbph>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3109a;
    private final zzdtu<zzbbh<zzcxu>> b;
    private final zzdtu<zzblq> c;
    private final zzdtu<zzcmx<zzbph>> d;

    public zzbxs(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<zzcxu>> zzdtuVar2, zzdtu<zzblq> zzdtuVar3, zzdtu<zzcmx<zzbph>> zzdtuVar4) {
        this.f3109a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(zzbqq.zza(this.f3109a.get(), this.b.get(), this.c.get(), this.d.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
