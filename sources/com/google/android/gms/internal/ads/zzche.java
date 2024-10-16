package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;

/* loaded from: classes2.dex */
public final class zzche implements zzdti<ApplicationInfo> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3256a;

    private zzche(zzdtu<Context> zzdtuVar) {
        this.f3256a = zzdtuVar;
    }

    public static zzche zzac(zzdtu<Context> zzdtuVar) {
        return new zzche(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (ApplicationInfo) zzdto.zza(this.f3256a.get().getApplicationInfo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
