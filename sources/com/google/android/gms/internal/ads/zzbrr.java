package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbrr implements zzdti<zzbrp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzbrs>>> f3030a;

    public zzbrr(zzdtu<Set<zzbuz<zzbrs>>> zzdtuVar) {
        this.f3030a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbrp(this.f3030a.get());
    }
}
