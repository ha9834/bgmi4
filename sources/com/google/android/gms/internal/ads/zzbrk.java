package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbrk implements zzdti<zzbri> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzxr>>> f3029a;

    private zzbrk(zzdtu<Set<zzbuz<zzxr>>> zzdtuVar) {
        this.f3029a = zzdtuVar;
    }

    public static zzbrk zzm(zzdtu<Set<zzbuz<zzxr>>> zzdtuVar) {
        return new zzbrk(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbri(this.f3029a.get());
    }
}
