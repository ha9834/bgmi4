package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzard
/* loaded from: classes2.dex */
public final class zzago extends zzafp {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCustomTemplateAd.OnCustomClickListener f2724a;

    public zzago(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.f2724a = onCustomClickListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafo
    public final void zza(zzafe zzafeVar, String str) {
        this.f2724a.onCustomClick(zzafh.zza(zzafeVar), str);
    }
}
