package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* loaded from: classes2.dex */
final class ajt extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ AudioTrack f1921a;
    private final /* synthetic */ zzhq b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ajt(zzhq zzhqVar, AudioTrack audioTrack) {
        this.b = zzhqVar;
        this.f1921a = audioTrack;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            this.f1921a.release();
        } finally {
            this.b.b.open();
        }
    }
}
