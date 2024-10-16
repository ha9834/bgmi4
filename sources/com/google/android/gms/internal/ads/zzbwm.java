package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbwm implements zzdti<Set<zzbuz<zzbuu>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbxe> f3085a;

    private zzbwm(zzdtu<zzbxe> zzdtuVar) {
        this.f3085a = zzdtuVar;
    }

    public static zzbwm zzz(zzdtu<zzbxe> zzdtuVar) {
        return new zzbwm(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.singleton(zzbuz.zzb(this.f3085a.get(), zzbbm.zzeaf)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
