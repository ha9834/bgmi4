package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;

/* loaded from: classes2.dex */
public final class zzcuc implements zzdti<zzcub> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<ApplicationInfo> f3439a;
    private final zzdtu<PackageInfo> b;

    private zzcuc(zzdtu<ApplicationInfo> zzdtuVar, zzdtu<PackageInfo> zzdtuVar2) {
        this.f3439a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcuc zzap(zzdtu<ApplicationInfo> zzdtuVar, zzdtu<PackageInfo> zzdtuVar2) {
        return new zzcuc(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcub(this.f3439a.get(), this.b.get());
    }
}
