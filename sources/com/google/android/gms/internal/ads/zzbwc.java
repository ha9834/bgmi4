package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
public final class zzbwc implements zzdti<View> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbvz f3077a;

    private zzbwc(zzbvz zzbvzVar) {
        this.f3077a = zzbvzVar;
    }

    public static zzbwc zza(zzbvz zzbvzVar) {
        return new zzbwc(zzbvzVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return this.f3077a.zzahb();
    }
}
