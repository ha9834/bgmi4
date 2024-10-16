package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbub implements zzdti<Set<zzbuz<zzbto>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3050a;

    private zzbub(zzbtv zzbtvVar) {
        this.f3050a = zzbtvVar;
    }

    public static zzbub zzi(zzbtv zzbtvVar) {
        return new zzbub(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
