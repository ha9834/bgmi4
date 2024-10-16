package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzchg implements zzdti<PackageInfo> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f3258a;
    private final zzdtu<ApplicationInfo> b;

    private zzchg(zzdtu<Context> zzdtuVar, zzdtu<ApplicationInfo> zzdtuVar2) {
        this.f3258a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzchg zzac(zzdtu<Context> zzdtuVar, zzdtu<ApplicationInfo> zzdtuVar2) {
        return new zzchg(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    @Nullable
    public final /* synthetic */ Object get() {
        return zzcgt.zza(this.f3258a.get(), this.b.get());
    }
}
