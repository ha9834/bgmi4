package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbul implements zzdti<Set<zzbuz<zzue>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3060a;

    private zzbul(zzbtv zzbtvVar) {
        this.f3060a = zzbtvVar;
    }

    public static zzbul zzs(zzbtv zzbtvVar) {
        return new zzbul(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
