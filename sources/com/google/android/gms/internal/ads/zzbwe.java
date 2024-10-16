package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbwe implements zzdti<Set<zzbuz<zzbrl>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3079a;
    private final zzdtu<zzbxc> b;

    private zzbwe(zzbvz zzbvzVar, zzdtu<zzbxc> zzdtuVar) {
        this.f3079a = zzbvzVar;
        this.b = zzdtuVar;
    }

    public static zzbwe zza(zzbvz zzbvzVar, zzdtu<zzbxc> zzdtuVar) {
        return new zzbwe(zzbvzVar, zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3079a.zza(this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
