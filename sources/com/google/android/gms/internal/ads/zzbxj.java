package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbxj implements zzdti<pw> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Map<String, zzcjv<zzbph>>> f3103a;
    private final zzdtu<Map<String, zzcjv<zzbyn>>> b;
    private final zzdtu<Map<String, zzclw<zzbyn>>> c;
    private final zzdtu<zzbpe<zzbnf>> d;
    private final zzdtu<zzbzc> e;

    public zzbxj(zzdtu<Map<String, zzcjv<zzbph>>> zzdtuVar, zzdtu<Map<String, zzcjv<zzbyn>>> zzdtuVar2, zzdtu<Map<String, zzclw<zzbyn>>> zzdtuVar3, zzdtu<zzbpe<zzbnf>> zzdtuVar4, zzdtu<zzbzc> zzdtuVar5) {
        this.f3103a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new pw(this.f3103a.get(), this.b.get(), this.c.get(), this.d, this.e.get());
    }
}
