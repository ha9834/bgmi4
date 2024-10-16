package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbty implements zzdti<Set<zzbuz<zzbrx>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3047a;

    private zzbty(zzbtv zzbtvVar) {
        this.f3047a = zzbtvVar;
    }

    public static zzbty zze(zzbtv zzbtvVar) {
        return new zzbty(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
