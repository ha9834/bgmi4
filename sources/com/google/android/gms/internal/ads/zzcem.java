package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;

/* loaded from: classes2.dex */
public final class zzcem implements zzdti<zzcez> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcem f3209a = new zzcem();

    public static zzcem zzajq() {
        return f3209a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.zza(new zzcez(zzwl.zza.zzb.REQUEST_WILL_RENDER, zzwl.zza.zzb.REQUEST_DID_RENDER, zzwl.zza.zzb.REQUEST_FAILED_TO_RENDER), "Cannot return null from a non-@Nullable @Provides method");
    }
}
