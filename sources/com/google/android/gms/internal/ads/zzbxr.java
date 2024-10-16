package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbxr implements zzdti<Set<String>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbzc> f3108a;

    public zzbxr(zzdtu<zzbzc> zzdtuVar) {
        this.f3108a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set emptySet;
        if (this.f3108a.get().zzail() != null) {
            emptySet = Collections.singleton("banner");
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzdto.zza(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
