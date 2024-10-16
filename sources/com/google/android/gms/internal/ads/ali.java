package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class ali {

    /* renamed from: a, reason: collision with root package name */
    protected AudioTrack f1953a;
    private boolean b;
    private int c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private long i;

    private ali() {
    }

    public boolean d() {
        return false;
    }

    public void a(AudioTrack audioTrack, boolean z) {
        this.f1953a = audioTrack;
        this.b = z;
        this.g = -9223372036854775807L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
        if (audioTrack != null) {
            this.c = audioTrack.getSampleRate();
        }
    }

    public final void a(long j) {
        this.h = b();
        this.g = SystemClock.elapsedRealtime() * 1000;
        this.i = j;
        this.f1953a.stop();
    }

    public final void a() {
        if (this.g != -9223372036854775807L) {
            return;
        }
        this.f1953a.pause();
    }

    public final long b() {
        if (this.g != -9223372036854775807L) {
            return Math.min(this.i, this.h + ((((SystemClock.elapsedRealtime() * 1000) - this.g) * this.c) / 1000000));
        }
        int playState = this.f1953a.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & this.f1953a.getPlaybackHeadPosition();
        if (this.b) {
            if (playState == 2 && playbackHeadPosition == 0) {
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
    public /* synthetic */ ali(alh alhVar) {
        this();
    }
}
