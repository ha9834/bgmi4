package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzceo implements zzdti<Set<zzbuz<zzczz>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Executor> f3211a;
    private final zzdtu<zzcex> b;

    private zzceo(zzdtu<Executor> zzdtuVar, zzdtu<zzcex> zzdtuVar2) {
        this.f3211a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzceo zzq(zzdtu<Executor> zzdtuVar, zzdtu<zzcex> zzdtuVar2) {
        return new zzceo(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        Set emptySet;
        Executor executor = this.f3211a.get();
        zzcex zzcexVar = this.b.get();
        if (((Boolean) zzyt.zzpe().zzd(zzacu.zzcul)).booleanValue()) {
            emptySet = Collections.singleton(new zzbuz(zzcexVar, executor));
        } else {
            emptySet = Collections.emptySet();
        }
        return (Set) zzdto.zza(emptySet, "Cannot return null from a non-@Nullable @Provides method");
    }
}
