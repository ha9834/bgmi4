package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbue implements zzdti<Set<zzbuz<zzbrs>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3053a;

    public zzbue(zzbtv zzbtvVar) {
        this.f3053a = zzbtvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3053a.zzago(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
