package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbnt implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2958a;
    private final zzdtu<zzbov> b;

    public zzbnt(zzbnk zzbnkVar, zzdtu<zzbov> zzdtuVar) {
        this.f2958a = zzbnkVar;
        this.b = zzdtuVar;
    }

    public static Set<zzbuz<zzbsr>> zza(zzbnk zzbnkVar, zzbov zzbovVar) {
        return (Set) zzdto.zza(Collections.singleton(new zzbuz(zzbovVar, zzbbm.zzeaf)), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2958a, this.b.get());
    }
}
