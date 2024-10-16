package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
public final class zzbno implements zzdti<View> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbnk f2953a;

    public zzbno(zzbnk zzbnkVar) {
        this.f2953a = zzbnkVar;
    }

    public static View zza(zzbnk zzbnkVar) {
        return (View) zzdto.zza(zzbnkVar.zzafi(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zza(this.f2953a);
    }
}
