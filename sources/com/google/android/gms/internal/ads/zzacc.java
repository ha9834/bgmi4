package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* loaded from: classes2.dex */
public final class zzacc extends zzaav {

    /* renamed from: a, reason: collision with root package name */
    private final VideoController.VideoLifecycleCallbacks f2695a;

    public zzacc(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.f2695a = videoLifecycleCallbacks;
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoStart() {
        this.f2695a.onVideoStart();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPlay() {
        this.f2695a.onVideoPlay();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoPause() {
        this.f2695a.onVideoPause();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoEnd() {
        this.f2695a.onVideoEnd();
    }

    @Override // com.google.android.gms.internal.ads.zzaau
    public final void onVideoMute(boolean z) {
        this.f2695a.onVideoMute(z);
    }
}
