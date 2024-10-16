package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzbxw implements zzdti<zzbpe<zzbnf>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbjm> f3113a;
    private final zzdtu<zzbqy.zza> b;
    private final zzdtu<zzbtv> c;
    private final zzdtu<zzbxk> d;
    private final zzdtu<zzbtb> e;

    public zzbxw(zzdtu<zzbjm> zzdtuVar, zzdtu<zzbqy.zza> zzdtuVar2, zzdtu<zzbtv> zzdtuVar3, zzdtu<zzbxk> zzdtuVar4, zzdtu<zzbtb> zzdtuVar5) {
        this.f3113a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbjm zzbjmVar = this.f3113a.get();
        zzbqy.zza zzaVar = this.b.get();
        zzbtv zzbtvVar = this.c.get();
        return (zzbpe) zzdto.zza(zzbjmVar.zzacj().zzb(zzaVar.zzagh()).zzb(zzbtvVar).zzb(this.d.get()).zza(new zzcow(null)).zza(new zzbox(this.e.get())).zza(new zzbnc(null)).zzads().zzadv(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
