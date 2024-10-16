package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;

/* loaded from: classes2.dex */
public final class zzces implements zzdti<zzcez> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzces f3214a = new zzces();

    public static zzces zzajs() {
        return f3214a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.zza(new zzcez(zzwl.zza.zzb.REQUEST_WILL_BUILD_URL, zzwl.zza.zzb.REQUEST_DID_BUILD_URL, zzwl.zza.zzb.REQUEST_FAILED_TO_BUILD_URL), "Cannot return null from a non-@Nullable @Provides method");
    }
}
