package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcyv implements zzdti<Executor> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzcyv f3508a = new zzcyv();

    public static zzcyv zzamu() {
        return f3508a;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Executor) zzdto.zza(zzbbm.zzeae, "Cannot return null from a non-@Nullable @Provides method");
    }
}
