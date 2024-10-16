package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

@zzard
/* loaded from: classes2.dex */
public final class zzagp extends zzafs {

    /* renamed from: a, reason: collision with root package name */
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener f2725a;

    public zzagp(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.f2725a = onCustomTemplateAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    public final void zzb(zzafe zzafeVar) {
        this.f2725a.onCustomTemplateAdLoaded(zzafh.zza(zzafeVar));
    }
}
