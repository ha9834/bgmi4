package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

@TargetApi(19)
/* loaded from: classes2.dex */
final class ajv extends aju {
    private final AudioTimestamp b;
    private long c;
    private long d;
    private long e;

    public ajv() {
        super(null);
        this.b = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.aju
    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
    }

    @Override // com.google.android.gms.internal.ads.aju
    public final boolean d() {
        boolean timestamp = this.f1922a.getTimestamp(this.b);
        if (timestamp) {
            long j = this.b.framePosition;
            if (this.d > j) {
                this.c++;
            }
            this.d = j;
            this.e = j + (this.c << 32);
        }
        return timestamp;
    }

    @Override // com.google.android.gms.internal.ads.aju
    public final long e() {
        return this.b.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.aju
    public final long f() {
        return this.e;
    }
}
