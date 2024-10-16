package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes2.dex */
public final class zzbnx implements zzdti<zzavf> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2962a;
    private final zzdtu<Context> b;
    private final zzdtu<zzcxv> c;

    public zzbnx(zzbnk zzbnkVar, zzdtu<Context> zzdtuVar, zzdtu<zzcxv> zzdtuVar2) {
        this.f2962a = zzbnkVar;
        this.b = zzdtuVar;
        this.c = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzavf) zzdto.zza(new zzavf(this.b.get(), this.c.get().zzglb), "Cannot return null from a non-@Nullable @Provides method");
    }
}
