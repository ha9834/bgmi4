package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzchh implements zzdti<String> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3259a;

    private zzchh(zzdtu<Context> zzdtuVar) {
        this.f3259a = zzdtuVar;
    }

    public static zzchh zzad(zzdtu<Context> zzdtuVar) {
        return new zzchh(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (String) zzdto.zza(this.f3259a.get().getPackageName(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
