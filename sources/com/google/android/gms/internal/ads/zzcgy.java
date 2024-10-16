package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcgy implements zzdti<zzbbh<zzarx>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3250a;
    private final zzdtu<zzbbh<Bundle>> b;
    private final zzdtu<zzbai> c;
    private final zzdtu<ApplicationInfo> d;
    private final zzdtu<String> e;
    private final zzdtu<List<String>> f;
    private final zzdtu<PackageInfo> g;
    private final zzdtu<zzbbh<String>> h;
    private final zzdtu<zzaxb> i;
    private final zzdtu<String> j;

    private zzcgy(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<ApplicationInfo> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<List<String>> zzdtuVar6, zzdtu<PackageInfo> zzdtuVar7, zzdtu<zzbbh<String>> zzdtuVar8, zzdtu<zzaxb> zzdtuVar9, zzdtu<String> zzdtuVar10) {
        this.f3250a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
        this.e = zzdtuVar5;
        this.f = zzdtuVar6;
        this.g = zzdtuVar7;
        this.h = zzdtuVar8;
        this.i = zzdtuVar9;
        this.j = zzdtuVar10;
    }

    public static zzcgy zza(zzdtu<zzczt> zzdtuVar, zzdtu<zzbbh<Bundle>> zzdtuVar2, zzdtu<zzbai> zzdtuVar3, zzdtu<ApplicationInfo> zzdtuVar4, zzdtu<String> zzdtuVar5, zzdtu<List<String>> zzdtuVar6, zzdtu<PackageInfo> zzdtuVar7, zzdtu<zzbbh<String>> zzdtuVar8, zzdtu<zzaxb> zzdtuVar9, zzdtu<String> zzdtuVar10) {
        return new zzcgy(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4, zzdtuVar5, zzdtuVar6, zzdtuVar7, zzdtuVar8, zzdtuVar9, zzdtuVar10);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzczt zzcztVar = this.f3250a.get();
        final zzbbh<Bundle> zzbbhVar = this.b.get();
        final zzbai zzbaiVar = this.c.get();
        final ApplicationInfo applicationInfo = this.d.get();
        final String str = this.e.get();
        final List<String> list = this.f.get();
        final PackageInfo packageInfo = this.g.get();
        final zzbbh<String> zzbbhVar2 = this.h.get();
        final zzaxb zzaxbVar = this.i.get();
        final String str2 = this.j.get();
        return (zzbbh) zzdto.zza(zzcztVar.zza((zzczt) zzczs.REQUEST_PARCEL, zzbbhVar, zzbbhVar2).zzc(new Callable(zzbbhVar, zzbaiVar, applicationInfo, str, list, packageInfo, zzbbhVar2, zzaxbVar, str2) { // from class: com.google.android.gms.internal.ads.ti

            /* renamed from: a, reason: collision with root package name */
            private final zzbbh f2516a;
            private final zzbai b;
            private final ApplicationInfo c;
            private final String d;
            private final List e;
            private final PackageInfo f;
            private final zzbbh g;
            private final zzaxb h;
            private final String i;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f2516a = zzbbhVar;
                this.b = zzbaiVar;
                this.c = applicationInfo;
                this.d = str;
                this.e = list;
                this.f = packageInfo;
                this.g = zzbbhVar2;
                this.h = zzaxbVar;
                this.i = str2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbbh zzbbhVar3 = this.f2516a;
                zzbai zzbaiVar2 = this.b;
                ApplicationInfo applicationInfo2 = this.c;
                String str3 = this.d;
                List list2 = this.e;
                PackageInfo packageInfo2 = this.f;
                zzbbh zzbbhVar4 = this.g;
                zzaxb zzaxbVar2 = this.h;
                return new zzarx((Bundle) zzbbhVar3.get(), zzbaiVar2, applicationInfo2, str3, list2, packageInfo2, (String) zzbbhVar4.get(), zzaxbVar2.zzvp(), this.i);
            }
        }).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
