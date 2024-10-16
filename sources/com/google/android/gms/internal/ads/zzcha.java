package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcha implements zzdti<zzbbh<Bundle>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzczt> f3252a;
    private final zzdtu<zzcvb<Bundle>> b;

    private zzcha(zzdtu<zzczt> zzdtuVar, zzdtu<zzcvb<Bundle>> zzdtuVar2) {
        this.f3252a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    public static zzcha zzz(zzdtu<zzczt> zzdtuVar, zzdtu<zzcvb<Bundle>> zzdtuVar2) {
        return new zzcha(zzdtuVar, zzdtuVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzbbh) zzdto.zza(this.f3252a.get().zzv(zzczs.SIGNALS).zzb(this.b.get().zzu(new Bundle())).zzane(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
