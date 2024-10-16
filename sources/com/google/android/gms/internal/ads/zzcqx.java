package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcqx implements zzdti<Set<String>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcqt f3385a;

    public zzcqx(zzcqt zzcqtVar) {
        this.f3385a = zzcqtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3385a.zzalj(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
