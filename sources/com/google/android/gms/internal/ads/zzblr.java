package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblr implements zzdti<zzblq> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Map<String, zzbls>> f2917a;

    private zzblr(zzdtu<Map<String, zzbls>> zzdtuVar) {
        this.f2917a = zzdtuVar;
    }

    public static zzblr zzb(zzdtu<Map<String, zzbls>> zzdtuVar) {
        return new zzblr(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzblq(this.f2917a.get());
    }
}
