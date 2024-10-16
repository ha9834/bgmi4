package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzble implements zzdti<zzdan> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Context> f2905a;

    public zzble(zzdtu<Context> zzdtuVar) {
        this.f2905a = zzdtuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (zzdan) zzdto.zza(new zzdan(this.f2905a.get(), zzk.zzlu().zzwr()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
