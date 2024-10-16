package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbqy;

/* loaded from: classes2.dex */
public final class zzbrf implements zzdti<zzbqy.zza> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbqy f3027a;

    private zzbrf(zzbqy zzbqyVar) {
        this.f3027a = zzbqyVar;
    }

    public static zzbrf zzj(zzbqy zzbqyVar) {
        return new zzbrf(zzbqyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbqy.zza) zzdto.zza(this.f3027a.a(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
