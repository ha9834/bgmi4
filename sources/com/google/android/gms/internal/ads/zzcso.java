package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzcso implements zzdti<zzcxk> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Clock> f3414a;

    public zzcso(zzdtu<Clock> zzdtuVar) {
        this.f3414a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzcxk) zzdto.zza(new zzcxk(this.f3414a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
