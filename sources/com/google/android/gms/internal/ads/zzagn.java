package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeContentAd;

@zzard
/* loaded from: classes2.dex */
public final class zzagn extends zzafm {

    /* renamed from: a, reason: collision with root package name */
    private final NativeContentAd.OnContentAdLoadedListener f2723a;

    public zzagn(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.f2723a = onContentAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafl
    public final void zza(zzafa zzafaVar) {
        this.f2723a.onContentAdLoaded(new zzafd(zzafaVar));
    }
}
