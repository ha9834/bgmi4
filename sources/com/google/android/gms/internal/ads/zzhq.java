package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import com.shieldtunnel.svpn.common.ErrorCode;
import java.lang.reflect.Method;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzhq {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3648a;
    private int A;
    private boolean B;
    private int C;
    private final ConditionVariable b = new ConditionVariable(true);
    private final long[] c;
    private final aju d;
    private AudioTrack e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private long n;
    private long o;
    private boolean p;
    private long q;
    private Method r;
    private long s;
    private int t;
    private long u;
    private long v;
    private long w;
    private float x;
    private byte[] y;
    private int z;

    public zzhq() {
        ajt ajtVar = null;
        if (zzkq.SDK_INT >= 18) {
            try {
                this.r = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzkq.SDK_INT >= 19) {
            this.d = new ajv();
        } else {
            this.d = new aju(ajtVar);
        }
        this.c = new long[10];
        this.x = 1.0f;
        this.t = 0;
    }

    public final boolean isInitialized() {
        return this.e != null;
    }

    public final long zzf(boolean z) {
        long j;
        if (!(isInitialized() && this.u != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.e.getPlayState() == 3) {
            long c = this.d.c();
            if (c != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.o >= 30000) {
                    long[] jArr = this.c;
                    int i = this.l;
                    jArr[i] = c - nanoTime;
                    this.l = (i + 1) % 10;
                    int i2 = this.m;
                    if (i2 < 10) {
                        this.m = i2 + 1;
                    }
                    this.o = nanoTime;
                    this.n = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.m;
                        if (i3 >= i4) {
                            break;
                        }
                        this.n += this.c[i3] / i4;
                        i3++;
                    }
                }
                if (!this.B && nanoTime - this.q >= 500000) {
                    this.p = this.d.d();
                    if (this.p) {
                        long e = this.d.e() / 1000;
                        long f = this.d.f();
                        if (e < this.v) {
                            this.p = false;
                        } else if (Math.abs(e - nanoTime) > 5000000) {
                            this.p = false;
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(f);
                            sb.append(", ");
                            sb.append(e);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(c);
                            Log.w("AudioTrack", sb.toString());
                        } else if (Math.abs(b(f) - c) > 5000000) {
                            this.p = false;
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(f);
                            sb2.append(", ");
                            sb2.append(e);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(c);
                            Log.w("AudioTrack", sb2.toString());
                        }
                    }
                    if (this.r != null) {
                        try {
                            this.w = (((Integer) r1.invoke(this.e, null)).intValue() * 1000) - b(a(this.k));
                            this.w = Math.max(this.w, 0L);
                            if (this.w > 5000000) {
                                long j2 = this.w;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j2);
                                Log.w("AudioTrack", sb3.toString());
                                this.w = 0L;
                            }
                        } catch (Exception unused) {
                            this.r = null;
                        }
                    }
                    this.q = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.p) {
            return b(this.d.f() + c(nanoTime2 - (this.d.e() / 1000))) + this.u;
        }
        if (this.m == 0) {
            j = this.d.c() + this.u;
        } else {
            j = nanoTime2 + this.n + this.u;
        }
        return !z ? j - this.w : j;
    }

    public final int zzq(int i) throws zzhu {
        this.b.block();
        if (i == 0) {
            this.e = new AudioTrack(3, this.f, this.g, this.h, this.k, 1);
        } else {
            this.e = new AudioTrack(3, this.f, this.g, this.h, this.k, 1, i);
        }
        int state = this.e.getState();
        if (state != 1) {
            try {
                this.e.release();
            } catch (Exception unused) {
            } finally {
                this.e = null;
            }
            throw new zzhu(state, this.f, this.g, this.k);
        }
        int audioSessionId = this.e.getAudioSessionId();
        this.d.a(this.e, this.B);
        setVolume(this.x);
        return audioSessionId;
    }

    public final void zza(MediaFormat mediaFormat, int i) {
        int i2;
        int i3;
        int integer = mediaFormat.getInteger("channel-count");
        if (integer == 6) {
            i2 = 252;
        } else if (integer != 8) {
            switch (integer) {
                case 1:
                    i2 = 4;
                    break;
                case 2:
                    i2 = 12;
                    break;
                default:
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unsupported channel count: ");
                    sb.append(integer);
                    throw new IllegalArgumentException(sb.toString());
            }
        } else {
            i2 = ErrorCode.SOCKET_REGISTER_ERROR;
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        String string = mediaFormat.getString("mime");
        if ("audio/ac3".equals(string)) {
            i3 = 5;
        } else if ("audio/eac3".equals(string)) {
            i3 = 6;
        } else {
            i3 = zzkl.zzav(string) ? 2 : 0;
        }
        boolean z = i3 == 5 || i3 == 6;
        if (isInitialized() && this.f == integer2 && this.g == i2 && !this.B && !z) {
            return;
        }
        reset();
        this.h = i3;
        this.f = integer2;
        this.g = i2;
        this.B = z;
        this.C = 0;
        this.i = integer * 2;
        this.j = AudioTrack.getMinBufferSize(integer2, i2, i3);
        zzkh.checkState(this.j != -2);
        int i4 = this.j << 2;
        int c = ((int) c(250000L)) * this.i;
        int max = (int) Math.max(this.j, c(750000L) * this.i);
        if (i4 < c) {
            i4 = c;
        } else if (i4 > max) {
            i4 = max;
        }
        this.k = i4;
    }

    public final void play() {
        if (isInitialized()) {
            this.v = System.nanoTime() / 1000;
            this.e.play();
        }
    }

    public final void zzeq() {
        if (this.t == 1) {
            this.t = 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(java.nio.ByteBuffer r11, int r12, int r13, long r14) throws com.google.android.gms.internal.ads.zzhv {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhq.zza(java.nio.ByteBuffer, int, int, long):int");
    }

    public final boolean zzer() {
        if (isInitialized()) {
            return a(this.s) > this.d.b() || this.d.a();
        }
        return false;
    }

    public final boolean zzes() {
        return this.s > ((long) ((this.j * 3) / 2));
    }

    public final void setVolume(float f) {
        this.x = f;
        if (isInitialized()) {
            if (zzkq.SDK_INT >= 21) {
                this.e.setVolume(f);
            } else {
                this.e.setStereoVolume(f, f);
            }
        }
    }

    public final void pause() {
        if (isInitialized()) {
            a();
            this.e.pause();
        }
    }

    public final void reset() {
        if (isInitialized()) {
            this.s = 0L;
            this.A = 0;
            this.u = 0L;
            this.w = 0L;
            a();
            if (this.e.getPlayState() == 3) {
                this.e.pause();
            }
            AudioTrack audioTrack = this.e;
            this.e = null;
            this.d.a(null, false);
            this.b.close();
            new ajt(this, audioTrack).start();
        }
    }

    private final long a(long j) {
        if (this.B) {
            if (this.C == 0) {
                return 0L;
            }
            return ((j << 3) * this.f) / (r0 * 1000);
        }
        return j / this.i;
    }

    private final long b(long j) {
        return (j * 1000000) / this.f;
    }

    private final long c(long j) {
        return (j * this.f) / 1000000;
    }

    private final void a() {
        this.n = 0L;
        this.m = 0;
        this.l = 0;
        this.o = 0L;
        this.p = false;
        this.q = 0L;
    }
}
