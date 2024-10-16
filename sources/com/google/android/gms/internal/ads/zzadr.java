package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;

@zzard
/* loaded from: classes2.dex */
public final class zzadr extends zzadp {

    /* renamed from: a, reason: collision with root package name */
    private final OnCustomRenderedAdLoadedListener f2709a;

    public zzadr(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.f2709a = onCustomRenderedAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void zza(zzadl zzadlVar) {
        this.f2709a.onCustomRenderedAdLoaded(new zzadk(zzadlVar));
    }
}
