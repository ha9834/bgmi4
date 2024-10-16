package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzcwl implements zzdti<zzcwj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzawe> f3475a;
    private final zzdtu<zzbbl> b;
    private final zzdtu<String> c;

    public zzcwl(zzdtu<zzawe> zzdtuVar, zzdtu<zzbbl> zzdtuVar2, zzdtu<String> zzdtuVar3) {
        this.f3475a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcwj(this.f3475a.get(), this.b.get(), this.c.get());
    }
}
