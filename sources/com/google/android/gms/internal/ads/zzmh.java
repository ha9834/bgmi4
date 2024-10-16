package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class zzmh {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f3684a;
    private static boolean b;
    private int A;
    private int B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private Method G;
    private int H;
    private long I;
    private long J;
    private int K;
    private long L;
    private long M;
    private int N;
    private int O;
    private long P;
    private long Q;
    private long R;
    private float S;
    private zzlx[] T;
    private ByteBuffer[] U;
    private ByteBuffer V;
    private ByteBuffer W;
    private byte[] X;
    private int Y;
    private int Z;
    private boolean aa;
    private boolean ab;
    private int ac;
    private boolean ad;
    private boolean ae;
    private long af;
    private final all d;
    private final zzmx e;
    private final zzlx[] f;
    private final zzmn g;
    private final long[] i;
    private final ali j;
    private final LinkedList<alk> k;
    private AudioTrack l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private boolean r;
    private int s;
    private long t;
    private zzln u;
    private zzln v;
    private long w;
    private long x;
    private ByteBuffer y;
    private int z;
    private final zzlw c = null;
    private final ConditionVariable h = new ConditionVariable(true);

    public zzmh(zzlw zzlwVar, zzlx[] zzlxVarArr, zzmn zzmnVar) {
        alh alhVar = null;
        this.g = zzmnVar;
        if (zzsy.SDK_INT >= 18) {
            try {
                this.G = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzsy.SDK_INT >= 19) {
            this.j = new alj();
        } else {
            this.j = new ali(alhVar);
        }
        this.d = new all();
        this.e = new zzmx();
        this.f = new zzlx[zzlxVarArr.length + 3];
        this.f[0] = new alo();
        zzlx[] zzlxVarArr2 = this.f;
        zzlxVarArr2[1] = this.d;
        System.arraycopy(zzlxVarArr, 0, zzlxVarArr2, 2, zzlxVarArr.length);
        this.f[zzlxVarArr.length + 2] = this.e;
        this.i = new long[10];
        this.S = 1.0f;
        this.O = 0;
        this.q = 3;
        this.ac = 0;
        this.v = zzln.zzaug;
        this.Z = -1;
        this.T = new zzlx[0];
        this.U = new ByteBuffer[0];
        this.k = new LinkedList<>();
    }

    public final boolean zzaz(String str) {
        zzlw zzlwVar = this.c;
        return zzlwVar != null && zzlwVar.zzaf(a(str));
    }

    public final long zzf(boolean z) {
        long j;
        long j2;
        if (!(d() && this.O != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.l.getPlayState() == 3) {
            long c = this.j.c();
            if (c != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.D >= 30000) {
                    long[] jArr = this.i;
                    int i = this.A;
                    jArr[i] = c - nanoTime;
                    this.A = (i + 1) % 10;
                    int i2 = this.B;
                    if (i2 < 10) {
                        this.B = i2 + 1;
                    }
                    this.D = nanoTime;
                    this.C = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.B;
                        if (i3 >= i4) {
                            break;
                        }
                        this.C += this.i[i3] / i4;
                        i3++;
                    }
                }
                if (!g() && nanoTime - this.F >= 500000) {
                    this.E = this.j.d();
                    if (this.E) {
                        long e = this.j.e() / 1000;
                        long f = this.j.f();
                        if (e < this.Q) {
                            this.E = false;
                        } else if (Math.abs(e - nanoTime) > 5000000) {
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
                            this.E = false;
                        } else if (Math.abs(b(f) - c) > 5000000) {
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
                            this.E = false;
                        }
                    }
                    if (this.G != null && !this.r) {
                        try {
                            this.R = (((Integer) r1.invoke(this.l, null)).intValue() * 1000) - this.t;
                            this.R = Math.max(this.R, 0L);
                            if (this.R > 5000000) {
                                long j3 = this.R;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j3);
                                Log.w("AudioTrack", sb3.toString());
                                this.R = 0L;
                            }
                        } catch (Exception unused) {
                            this.G = null;
                        }
                    }
                    this.F = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.E) {
            j = b(this.j.f() + c(nanoTime2 - (this.j.e() / 1000)));
        } else {
            if (this.B == 0) {
                j = this.j.c();
            } else {
                j = nanoTime2 + this.C;
            }
            if (!z) {
                j -= this.R;
            }
        }
        long j4 = this.P;
        while (!this.k.isEmpty() && j >= alk.b(this.k.getFirst())) {
            alk remove = this.k.remove();
            this.v = alk.a(remove);
            this.x = alk.b(remove);
            this.w = alk.c(remove) - this.P;
        }
        if (this.v.zzauh == 1.0f) {
            j2 = (j + this.w) - this.x;
        } else if (this.k.isEmpty() && this.e.zzia() >= 1024) {
            j2 = zzsy.zza(j - this.x, this.e.zzhz(), this.e.zzia()) + this.w;
        } else {
            long j5 = this.w;
            double d = this.v.zzauh;
            double d2 = j - this.x;
            Double.isNaN(d);
            Double.isNaN(d2);
            j2 = ((long) (d * d2)) + j5;
        }
        return j4 + j2;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzml {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmh.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    private final void a() {
        ArrayList arrayList = new ArrayList();
        for (zzlx zzlxVar : this.f) {
            if (zzlxVar.isActive()) {
                arrayList.add(zzlxVar);
            } else {
                zzlxVar.flush();
            }
        }
        int size = arrayList.size();
        this.T = (zzlx[]) arrayList.toArray(new zzlx[size]);
        this.U = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzlx zzlxVar2 = this.T[i];
            zzlxVar2.flush();
            this.U[i] = zzlxVar2.zzhm();
        }
    }

    public final void play() {
        this.ab = true;
        if (d()) {
            this.Q = System.nanoTime() / 1000;
            this.l.play();
        }
    }

    public final void zzeq() {
        if (this.O == 1) {
            this.O = 2;
        }
    }

    public final boolean zza(ByteBuffer byteBuffer, long j) throws zzmm, zzmp {
        int i;
        int zzj;
        ByteBuffer byteBuffer2 = this.V;
        zzsk.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!d()) {
            this.h.block();
            if (this.ad) {
                this.l = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.n).setEncoding(this.p).setSampleRate(this.m).build(), this.s, 1, this.ac);
            } else {
                int i2 = this.ac;
                if (i2 == 0) {
                    this.l = new AudioTrack(this.q, this.m, this.n, this.p, this.s, 1);
                } else {
                    this.l = new AudioTrack(this.q, this.m, this.n, this.p, this.s, 1, i2);
                }
            }
            int state = this.l.getState();
            if (state != 1) {
                try {
                    this.l.release();
                } catch (Exception unused) {
                } finally {
                    this.l = null;
                }
                throw new zzmm(state, this.m, this.n, this.s);
            }
            int audioSessionId = this.l.getAudioSessionId();
            if (this.ac != audioSessionId) {
                this.ac = audioSessionId;
                this.g.zzag(audioSessionId);
            }
            this.j.a(this.l, g());
            c();
            this.ae = false;
            if (this.ab) {
                play();
            }
        }
        if (g()) {
            if (this.l.getPlayState() == 2) {
                this.ae = false;
                return false;
            }
            if (this.l.getPlayState() == 1 && this.j.b() != 0) {
                return false;
            }
        }
        boolean z = this.ae;
        this.ae = zzer();
        if (z && !this.ae && this.l.getPlayState() != 1) {
            this.g.zze(this.s, zzkt.zzdz(this.t), SystemClock.elapsedRealtime() - this.af);
        }
        if (this.V == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.r && this.N == 0) {
                int i3 = this.p;
                if (i3 == 7 || i3 == 8) {
                    zzj = zzmr.zzj(byteBuffer);
                } else if (i3 == 5) {
                    zzj = zzlv.zzhi();
                } else if (i3 == 6) {
                    zzj = zzlv.zzh(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.N = zzj;
            }
            if (this.u != null) {
                if (!b()) {
                    return false;
                }
                this.k.add(new alk(this.u, Math.max(0L, j), b(e()), null));
                this.u = null;
                a();
            }
            if (this.O == 0) {
                this.P = Math.max(0L, j);
                this.O = 1;
            } else {
                long b2 = this.P + b(this.r ? this.J : this.I / this.H);
                if (this.O != 1) {
                    i = 2;
                } else if (Math.abs(b2 - j) > 200000) {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(b2);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.O = 2;
                } else {
                    i = 2;
                }
                if (this.O == i) {
                    this.P += j - b2;
                    this.O = 1;
                    this.g.zzgt();
                }
            }
            if (this.r) {
                this.J += this.N;
            } else {
                this.I += byteBuffer.remaining();
            }
            this.V = byteBuffer;
        }
        if (this.r) {
            a(this.V, j);
        } else {
            a(j);
        }
        if (this.V.hasRemaining()) {
            return false;
        }
        this.V = null;
        return true;
    }

    private final void a(long j) throws zzmp {
        ByteBuffer byteBuffer;
        int length = this.T.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.U[i - 1];
            } else {
                byteBuffer = this.V;
                if (byteBuffer == null) {
                    byteBuffer = zzlx.zzavh;
                }
            }
            if (i == length) {
                a(byteBuffer, j);
            } else {
                zzlx zzlxVar = this.T[i];
                zzlxVar.zzi(byteBuffer);
                ByteBuffer zzhm = zzlxVar.zzhm();
                this.U[i] = zzhm;
                if (zzhm.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private final boolean a(ByteBuffer byteBuffer, long j) throws zzmp {
        int write;
        if (!byteBuffer.hasRemaining()) {
            return true;
        }
        ByteBuffer byteBuffer2 = this.W;
        if (byteBuffer2 != null) {
            zzsk.checkArgument(byteBuffer2 == byteBuffer);
        } else {
            this.W = byteBuffer;
            if (zzsy.SDK_INT < 21) {
                int remaining = byteBuffer.remaining();
                byte[] bArr = this.X;
                if (bArr == null || bArr.length < remaining) {
                    this.X = new byte[remaining];
                }
                int position = byteBuffer.position();
                byteBuffer.get(this.X, 0, remaining);
                byteBuffer.position(position);
                this.Y = 0;
            }
        }
        int remaining2 = byteBuffer.remaining();
        if (zzsy.SDK_INT < 21) {
            int b2 = this.s - ((int) (this.L - (this.j.b() * this.K)));
            if (b2 > 0) {
                write = this.l.write(this.X, this.Y, Math.min(remaining2, b2));
                if (write > 0) {
                    this.Y += write;
                    byteBuffer.position(byteBuffer.position() + write);
                }
            } else {
                write = 0;
            }
        } else if (this.ad) {
            zzsk.checkState(j != -9223372036854775807L);
            AudioTrack audioTrack = this.l;
            if (this.y == null) {
                this.y = ByteBuffer.allocate(16);
                this.y.order(ByteOrder.BIG_ENDIAN);
                this.y.putInt(1431633921);
            }
            if (this.z == 0) {
                this.y.putInt(4, remaining2);
                this.y.putLong(8, j * 1000);
                this.y.position(0);
                this.z = remaining2;
            }
            int remaining3 = this.y.remaining();
            if (remaining3 > 0) {
                int write2 = audioTrack.write(this.y, remaining3, 1);
                if (write2 < 0) {
                    this.z = 0;
                    write = write2;
                } else if (write2 < remaining3) {
                    write = 0;
                }
            }
            int write3 = audioTrack.write(byteBuffer, remaining2, 1);
            if (write3 < 0) {
                this.z = 0;
            } else {
                this.z -= write3;
            }
            write = write3;
        } else {
            write = this.l.write(byteBuffer, remaining2, 1);
        }
        this.af = SystemClock.elapsedRealtime();
        if (write < 0) {
            throw new zzmp(write);
        }
        if (!this.r) {
            this.L += write;
        }
        if (write != remaining2) {
            return false;
        }
        if (this.r) {
            this.M += this.N;
        }
        this.W = null;
        return true;
    }

    public final void zzho() throws zzmp {
        if (!this.aa && d() && b()) {
            this.j.a(e());
            this.z = 0;
            this.aa = true;
        }
    }

    private final boolean b() throws zzmp {
        boolean z;
        if (this.Z == -1) {
            this.Z = this.r ? this.T.length : 0;
            z = true;
        } else {
            z = false;
        }
        while (true) {
            int i = this.Z;
            zzlx[] zzlxVarArr = this.T;
            if (i < zzlxVarArr.length) {
                zzlx zzlxVar = zzlxVarArr[i];
                if (z) {
                    zzlxVar.zzhl();
                }
                a(-9223372036854775807L);
                if (!zzlxVar.zzdx()) {
                    return false;
                }
                this.Z++;
                z = true;
            } else {
                ByteBuffer byteBuffer = this.W;
                if (byteBuffer != null) {
                    a(byteBuffer, -9223372036854775807L);
                    if (this.W != null) {
                        return false;
                    }
                }
                this.Z = -1;
                return true;
            }
        }
    }

    public final boolean zzdx() {
        if (d()) {
            return this.aa && !zzer();
        }
        return true;
    }

    public final boolean zzer() {
        if (d()) {
            if (e() <= this.j.b()) {
                if (g() && this.l.getPlayState() == 2 && this.l.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzln zzb(zzln zzlnVar) {
        if (this.r) {
            this.v = zzln.zzaug;
            return this.v;
        }
        zzln zzlnVar2 = new zzln(this.e.zzb(zzlnVar.zzauh), this.e.zzc(zzlnVar.zzaui));
        zzln zzlnVar3 = this.u;
        if (zzlnVar3 == null) {
            if (!this.k.isEmpty()) {
                zzlnVar3 = alk.a(this.k.getLast());
            } else {
                zzlnVar3 = this.v;
            }
        }
        if (!zzlnVar2.equals(zzlnVar3)) {
            if (d()) {
                this.u = zzlnVar2;
            } else {
                this.v = zzlnVar2;
            }
        }
        return this.v;
    }

    public final zzln zzhq() {
        return this.v;
    }

    public final void setStreamType(int i) {
        if (this.q == i) {
            return;
        }
        this.q = i;
        if (this.ad) {
            return;
        }
        reset();
        this.ac = 0;
    }

    public final void zzai(int i) {
        zzsk.checkState(zzsy.SDK_INT >= 21);
        if (this.ad && this.ac == i) {
            return;
        }
        this.ad = true;
        this.ac = i;
        reset();
    }

    public final void zzhr() {
        if (this.ad) {
            this.ad = false;
            this.ac = 0;
            reset();
        }
    }

    public final void setVolume(float f) {
        if (this.S != f) {
            this.S = f;
            c();
        }
    }

    private final void c() {
        if (d()) {
            if (zzsy.SDK_INT >= 21) {
                this.l.setVolume(this.S);
                return;
            }
            AudioTrack audioTrack = this.l;
            float f = this.S;
            audioTrack.setStereoVolume(f, f);
        }
    }

    public final void pause() {
        this.ab = false;
        if (d()) {
            f();
            this.j.a();
        }
    }

    public final void reset() {
        if (d()) {
            this.I = 0L;
            this.J = 0L;
            this.L = 0L;
            this.M = 0L;
            this.N = 0;
            zzln zzlnVar = this.u;
            if (zzlnVar != null) {
                this.v = zzlnVar;
                this.u = null;
            } else if (!this.k.isEmpty()) {
                this.v = alk.a(this.k.getLast());
            }
            this.k.clear();
            this.w = 0L;
            this.x = 0L;
            this.V = null;
            this.W = null;
            int i = 0;
            while (true) {
                zzlx[] zzlxVarArr = this.T;
                if (i >= zzlxVarArr.length) {
                    break;
                }
                zzlx zzlxVar = zzlxVarArr[i];
                zzlxVar.flush();
                this.U[i] = zzlxVar.zzhm();
                i++;
            }
            this.aa = false;
            this.Z = -1;
            this.y = null;
            this.z = 0;
            this.O = 0;
            this.R = 0L;
            f();
            if (this.l.getPlayState() == 3) {
                this.l.pause();
            }
            AudioTrack audioTrack = this.l;
            this.l = null;
            this.j.a(null, false);
            this.h.close();
            new alh(this, audioTrack).start();
        }
    }

    public final void release() {
        reset();
        for (zzlx zzlxVar : this.f) {
            zzlxVar.reset();
        }
        this.ac = 0;
        this.ab = false;
    }

    private final boolean d() {
        return this.l != null;
    }

    private final long b(long j) {
        return (j * 1000000) / this.m;
    }

    private final long c(long j) {
        return (j * this.m) / 1000000;
    }

    private final long e() {
        return this.r ? this.M : this.L / this.K;
    }

    private final void f() {
        this.C = 0L;
        this.B = 0;
        this.A = 0;
        this.D = 0L;
        this.E = false;
        this.F = 0L;
    }

    private final boolean g() {
        if (zzsy.SDK_INT >= 23) {
            return false;
        }
        int i = this.p;
        return i == 5 || i == 6;
    }

    private static int a(String str) {
        char c;
        int hashCode = str.hashCode();
        if (hashCode == -1095064472) {
            if (str.equals("audio/vnd.dts")) {
                c = 2;
            }
            c = 65535;
        } else if (hashCode == 187078296) {
            if (str.equals("audio/ac3")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 1504578661) {
            if (hashCode == 1505942594 && str.equals("audio/vnd.dts.hd")) {
                c = 3;
            }
            c = 65535;
        } else {
            if (str.equals("audio/eac3")) {
                c = 1;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
                return 5;
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 8;
            default:
                return 0;
        }
    }
}
