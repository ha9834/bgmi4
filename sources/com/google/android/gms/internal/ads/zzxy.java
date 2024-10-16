package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

@zzard
/* loaded from: classes2.dex */
public final class zzxy extends zzzq {

    /* renamed from: a, reason: collision with root package name */
    private final AdMetadataListener f3778a;

    public zzxy(AdMetadataListener adMetadataListener) {
        this.f3778a = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzzp
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.f3778a;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
