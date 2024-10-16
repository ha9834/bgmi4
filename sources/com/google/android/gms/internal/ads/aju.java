package com.google.android.gms.internal.ads;

import android.media.AudioTrack;

/* loaded from: classes2.dex */
class aju {

    /* renamed from: a, reason: collision with root package name */
    protected AudioTrack f1922a;
    private boolean b;
    private int c;
    private long d;
    private long e;
    private long f;

    private aju() {
    }

    public boolean d() {
        return false;
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.f1922a = audioTrack;
        this.b = z;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        if (audioTrack != null) {
            this.c = audioTrack.getSampleRate();
        }
    }

    public final boolean a() {
        return zzkq.SDK_INT <= 22 && this.b && this.f1922a.getPlayState() == 2 && this.f1922a.getPlaybackHeadPosition() == 0;
    }

    public final long b() {
        long playbackHeadPosition = this.f1922a.getPlaybackHeadPosition() & 4294967295L;
        if (zzkq.SDK_INT <= 22 && this.b) {
            if (this.f1922a.getPlayState() == 1) {
                this.d = playbackHeadPosition;
            } else if (this.f1922a.getPlayState() == 2 && playbackHeadPosition == 0) {
                this.f = this.d;
            }
            playbackHeadPosition += this.f;
        }
        if (this.d > playbackHeadPosition) {
            this.e++;
        }
        this.d = playbackHeadPosition;
        return playbackHeadPosition + (this.e << 32);
    }

    public final long c() {
        return (b() * 1000000) / this.c;
    }

    public long e() {
        throw new UnsupportedOperationException();
    }

    public long f() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aju(ajt ajtVar) {
        this();
    }
}
