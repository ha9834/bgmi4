package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbnn implements zzdti<zzbso> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2952a;
    private final zzdtu<Set<zzbuz<zzbsr>>> b;

    public zzbnn(zzbnk zzbnkVar, zzdtu<Set<zzbuz<zzbsr>>> zzdtuVar) {
        this.f2952a = zzbnkVar;
        this.b = zzdtuVar;
    }

    public static zzbso zza(zzbnk zzbnkVar, Set<zzbuz<zzbsr>> set) {
        return (zzbso) zzdto.zza(zzbnkVar.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2952a, this.b.get());
    }
}
