package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzccu implements zzdti<zzccr> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbri> f3183a;
    private final zzdtu<zzbse> b;
    private final zzdtu<zzbss> c;
    private final zzdtu<zzbsv> d;
    private final zzdtu<zzbtp> e;

    public zzccu(zzdtu<zzbri> zzdtuVar, zzdtu<zzbse> zzdtuVar2, zzdtu<zzbss> zzdtuVar3, zzdtu<zzbsv> zzdtuVar4, zzdtu<zzbtp> zzdtuVar5) {
        this.f3183a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzccr(this.f3183a.get(), this.b.get(), this.c.get(), this.d.get(), this.e.get());
    }
}
