package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/* loaded from: classes2.dex */
public final class zzmx implements zzlx {
    private alp c;
    private long i;
    private long j;
    private boolean k;
    private float d = 1.0f;
    private float e = 1.0f;

    /* renamed from: a, reason: collision with root package name */
    private int f3686a = -1;
    private int b = -1;
    private ByteBuffer f = zzavh;
    private ShortBuffer g = this.f.asShortBuffer();
    private ByteBuffer h = zzavh;

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzhk() {
        return 2;
    }

    public final float zzb(float f) {
        this.d = zzsy.zza(f, 0.1f, 8.0f);
        return this.d;
    }

    public final float zzc(float f) {
        this.e = zzsy.zza(f, 0.1f, 8.0f);
        return f;
    }

    public final long zzhz() {
        return this.i;
    }

    public final long zzia() {
        return this.j;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean zzb(int i, int i2, int i3) throws zzly {
        if (i3 != 2) {
            throw new zzly(i, i2, i3);
        }
        if (this.b == i && this.f3686a == i2) {
            return false;
        }
        this.b = i;
        this.f3686a = i2;
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean isActive() {
        return Math.abs(this.d - 1.0f) >= 0.01f || Math.abs(this.e - 1.0f) >= 0.01f;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final int zzhj() {
        return this.f3686a;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzi(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.i += remaining;
            this.c.a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
        int b = (this.c.b() * this.f3686a) << 1;
        if (b > 0) {
            if (this.f.capacity() < b) {
                this.f = ByteBuffer.allocateDirect(b).order(ByteOrder.nativeOrder());
                this.g = this.f.asShortBuffer();
            } else {
                this.f.clear();
                this.g.clear();
            }
            this.c.b(this.g);
            this.j += b;
            this.f.limit(b);
            this.h = this.f;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void zzhl() {
        this.c.a();
        this.k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final ByteBuffer zzhm() {
        ByteBuffer byteBuffer = this.h;
        this.h = zzavh;
        return byteBuffer;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final boolean zzdx() {
        if (!this.k) {
            return false;
        }
        alp alpVar = this.c;
        return alpVar == null || alpVar.b() == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void flush() {
        this.c = new alp(this.b, this.f3686a);
        this.c.a(this.d);
        this.c.b(this.e);
        this.h = zzavh;
        this.i = 0L;
        this.j = 0L;
        this.k = false;
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final void reset() {
        this.c = null;
        this.f = zzavh;
        this.g = this.f.asShortBuffer();
        this.h = zzavh;
        this.f3686a = -1;
        this.b = -1;
        this.i = 0L;
        this.j = 0L;
        this.k = false;
    }
}
