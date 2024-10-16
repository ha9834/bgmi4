package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* loaded from: classes2.dex */
public final class zzaaj extends zzaah {

    /* renamed from: a, reason: collision with root package name */
    private final MuteThisAdListener f2680a;

    public zzaaj(MuteThisAdListener muteThisAdListener) {
        this.f2680a = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaag
    public final void onAdMuted() {
        this.f2680a.onAdMuted();
    }
}
