package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbsl implements zzdti<zzbse> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzbrl>>> f3034a;

    private zzbsl(zzdtu<Set<zzbuz<zzbrl>>> zzdtuVar) {
        this.f3034a = zzdtuVar;
    }

    public static zzbsl zzp(zzdtu<Set<zzbuz<zzbrl>>> zzdtuVar) {
        return new zzbsl(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbse(this.f3034a.get());
    }
}
