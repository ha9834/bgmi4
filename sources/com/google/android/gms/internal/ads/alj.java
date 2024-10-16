package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTimestamp;
import android.media.AudioTrack;

/* JADX INFO: Access modifiers changed from: package-private */
@TargetApi(19)
/* loaded from: classes2.dex */
public final class alj extends ali {
    private final AudioTimestamp b;
    private long c;
    private long d;
    private long e;

    public alj() {
        super(null);
        this.b = new AudioTimestamp();
    }

    @Override // com.google.android.gms.internal.ads.ali
    public final void a(AudioTrack audioTrack, boolean z) {
        super.a(audioTrack, z);
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
    }

    @Override // com.google.android.gms.internal.ads.ali
    public final boolean d() {
        boolean timestamp = this.f1953a.getTimestamp(this.b);
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

    @Override // com.google.android.gms.internal.ads.ali
    public final long e() {
        return this.b.nanoTime;
    }

    @Override // com.google.android.gms.internal.ads.ali
    public final long f() {
        return this.e;
    }
}
