package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcru implements zzdti<yb> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<String>> f3400a;

    private zzcru(zzdtu<Set<String>> zzdtuVar) {
        this.f3400a = zzdtuVar;
    }

    public static zzcru zzak(zzdtu<Set<String>> zzdtuVar) {
        return new zzcru(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new yb(this.f3400a.get());
    }
}
