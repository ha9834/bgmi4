package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbnw implements zzdti<Set<zzbuz<zzue>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2961a;
    private final zzdtu<zzbov> b;

    public zzbnw(zzbnk zzbnkVar, zzdtu<zzbov> zzdtuVar) {
        this.f2961a = zzbnkVar;
        this.b = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.singleton(new zzbuz(this.b.get(), zzbbm.zzeaf)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
