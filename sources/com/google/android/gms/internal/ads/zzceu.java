package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;

/* loaded from: classes2.dex */
public final class zzceu implements zzdti<zzcez> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzceu f3216a = new zzceu();

    public static zzceu zzaju() {
        return f3216a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.zza(new zzcez(zzwl.zza.zzb.REQUEST_WILL_MAKE_NETWORK_REQUEST, zzwl.zza.zzb.REQUEST_DID_RECEIVE_NETWORK_RESPONSE, zzwl.zza.zzb.REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST), "Cannot return null from a non-@Nullable @Provides method");
    }
}
