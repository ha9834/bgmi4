package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzdab implements zzdti<aau> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzczz>>> f3524a;

    private zzdab(zzdtu<Set<zzbuz<zzczz>>> zzdtuVar) {
        this.f3524a = zzdtuVar;
    }

    public static zzdab zzan(zzdtu<Set<zzbuz<zzczz>>> zzdtuVar) {
        return new zzdab(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new aau(this.f3524a.get());
    }
}
