package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbua implements zzdti<Set<zzbuz<com.google.android.gms.ads.internal.overlay.zzo>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3049a;

    private zzbua(zzbtv zzbtvVar) {
        this.f3049a = zzbtvVar;
    }

    public static zzbua zzh(zzbtv zzbtvVar) {
        return new zzbua(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
