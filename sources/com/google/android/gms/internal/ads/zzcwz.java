package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* loaded from: classes2.dex */
public final class zzcwz implements zzdti<ApplicationInfo> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcwx f3486a;

    public zzcwz(zzcwx zzcwxVar) {
        this.f3486a = zzcwxVar;
    }

    public static ApplicationInfo zzc(zzcwx zzcwxVar) {
        return (ApplicationInfo) zzdto.zza(zzcwxVar.zzamh(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzc(this.f3486a);
    }
}
