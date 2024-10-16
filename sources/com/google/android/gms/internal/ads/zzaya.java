package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;

@zzard
/* loaded from: classes2.dex */
public final class zzaya {

    /* renamed from: a, reason: collision with root package name */
    private boolean f2826a = false;
    private float b = 1.0f;

    public final synchronized void setAppVolume(float f) {
        this.b = f;
    }

    public final synchronized float zzpq() {
        if (!a()) {
            return 1.0f;
        }
        return this.b;
    }

    public final synchronized void setAppMuted(boolean z) {
        this.f2826a = z;
    }

    public final synchronized boolean zzpr() {
        return this.f2826a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final synchronized boolean a() {
        return this.b >= 0.0f;
    }

    public static float zzba(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager == null) {
            return 0.0f;
        }
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        int streamVolume = audioManager.getStreamVolume(3);
        if (streamMaxVolume == 0) {
            return 0.0f;
        }
        return streamVolume / streamMaxVolume;
    }
}
