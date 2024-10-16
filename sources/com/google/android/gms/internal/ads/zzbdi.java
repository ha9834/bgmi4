package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;

@zzard
@TargetApi(14)
/* loaded from: classes2.dex */
public final class zzbdi implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final AudioManager f2860a;
    private final ip b;
    private boolean c;
    private boolean d;
    private boolean e;
    private float f = 1.0f;

    public zzbdi(Context context, ip ipVar) {
        this.f2860a = (AudioManager) context.getSystemService("audio");
        this.b = ipVar;
    }

    public final void setMuted(boolean z) {
        this.e = z;
        a();
    }

    public final void setVolume(float f) {
        this.f = f;
        a();
    }

    public final float getVolume() {
        float f = this.e ? 0.0f : this.f;
        if (this.c) {
            return f;
        }
        return 0.0f;
    }

    public final void zzyl() {
        this.d = true;
        a();
    }

    public final void zzym() {
        this.d = false;
        a();
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.c = i > 0;
        this.b.zzxk();
    }

    private final void a() {
        boolean z;
        boolean z2;
        boolean z3 = this.d && !this.e && this.f > 0.0f;
        if (z3 && !(z2 = this.c)) {
            AudioManager audioManager = this.f2860a;
            if (audioManager != null && !z2) {
                this.c = audioManager.requestAudioFocus(this, 3, 2) == 1;
            }
            this.b.zzxk();
            return;
        }
        if (z3 || !(z = this.c)) {
            return;
        }
        AudioManager audioManager2 = this.f2860a;
        if (audioManager2 != null && z) {
            this.c = audioManager2.abandonAudioFocus(this) == 0;
        }
        this.b.zzxk();
    }
}
