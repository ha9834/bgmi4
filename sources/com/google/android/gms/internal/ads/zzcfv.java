package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcfv implements zzdti<Set<zzbuz<AppEventListener>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzcfp f3240a;
    private final zzdtu<zzcfz> b;
    private final zzdtu<Executor> c;

    private zzcfv(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        this.f3240a = zzcfpVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    public static zzcfv zzf(zzcfp zzcfpVar, zzdtu<zzcfz> zzdtuVar, zzdtu<Executor> zzdtuVar2) {
        return new zzcfv(zzcfpVar, zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(zzcfp.zzb(this.b.get(), this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
