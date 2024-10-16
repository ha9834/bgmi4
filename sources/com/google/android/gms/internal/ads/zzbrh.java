package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbrh implements zzdti<zzavb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbrg f3028a;
    private final zzdtu<Context> b;
    private final zzdtu<zzbai> c;
    private final zzdtu<zzcxm> d;
    private final zzdtu<zzavd> e;

    private zzbrh(zzbrg zzbrgVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzavd> zzdtuVar4) {
        this.f3028a = zzbrgVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
        this.d = zzdtuVar3;
        this.e = zzdtuVar4;
    }

    public static zzbrh zza(zzbrg zzbrgVar, zzdtu<Context> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<zzcxm> zzdtuVar3, zzdtu<zzavd> zzdtuVar4) {
        return new zzbrh(zzbrgVar, zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Context context = this.b.get();
        zzbai zzbaiVar = this.c.get();
        zzcxm zzcxmVar = this.d.get();
        zzavd zzavdVar = this.e.get();
        if (zzcxmVar.zzgki != null) {
            return new zzauq(context, zzbaiVar, zzcxmVar.zzgki, zzcxmVar.zzgke.zzdkn, zzavdVar);
        }
        return null;
    }
}
