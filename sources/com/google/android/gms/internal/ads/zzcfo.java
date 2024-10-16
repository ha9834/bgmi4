package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* loaded from: classes2.dex */
public final class zzcfo implements zzdti<zzcfn> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Clock> f3234a;

    public zzcfo(zzdtu<Clock> zzdtuVar) {
        this.f3234a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzcfn(this.f3234a.get());
    }
}
