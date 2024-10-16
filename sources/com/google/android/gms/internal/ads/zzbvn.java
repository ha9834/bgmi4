package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbvn implements zzdti<zzbvj> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzahy>>> f3072a;

    public zzbvn(zzdtu<Set<zzbuz<zzahy>>> zzdtuVar) {
        this.f3072a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbvj(this.f3072a.get());
    }
}
