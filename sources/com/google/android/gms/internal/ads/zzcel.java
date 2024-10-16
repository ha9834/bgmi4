package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzwl;

/* loaded from: classes2.dex */
public final class zzcel implements zzdti<zzcez> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcel f3208a = new zzcel();

    public static zzcel zzajp() {
        return f3208a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcez) zzdto.zza(new zzcez(zzwl.zza.zzb.REQUEST_WILL_UPDATE_SIGNALS, zzwl.zza.zzb.REQUEST_DID_UPDATE_SIGNALS, zzwl.zza.zzb.REQUEST_FAILED_TO_UPDATE_SIGNALS), "Cannot return null from a non-@Nullable @Provides method");
    }
}
