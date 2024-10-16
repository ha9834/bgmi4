package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcsb implements zzdti<zzcrz> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<String> f3404a;
    private final zzdtu<String> b;
    private final zzdtu<zzbqe> c;
    private final zzdtu<zzcyi> d;
    private final zzdtu<zzcxv> e;

    private zzcsb(zzdtu<String> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbqe> zzdtuVar3, zzdtu<zzcyi> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        this.f3404a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    public static zzcsb zzh(zzdtu<String> zzdtuVar, zzdtu<String> zzdtuVar2, zzdtu<zzbqe> zzdtuVar3, zzdtu<zzcyi> zzdtuVar4, zzdtu<zzcxv> zzdtuVar5) {
        return new zzcsb(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcrz(this.f3404a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
