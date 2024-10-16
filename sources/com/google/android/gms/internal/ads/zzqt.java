package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.messages.BleSignal;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class zzqt implements zznw {

    /* renamed from: a, reason: collision with root package name */
    private final zzrt f3713a;
    private final int b;
    private final ano c = new ano();
    private final zzqs d = new zzqs();
    private final zzst e = new zzst(32);
    private final AtomicInteger f = new AtomicInteger();
    private anp g;
    private anp h;
    private zzlh i;
    private boolean j;
    private zzlh k;
    private long l;
    private int m;
    private zzqv n;

    public zzqt(zzrt zzrtVar) {
        this.f3713a = zzrtVar;
        this.b = zzrtVar.zzfz();
        int i = this.b;
        this.m = i;
        this.g = new anp(0L, i);
        this.h = this.g;
    }

    public final void zzk(boolean z) {
        int andSet = this.f.getAndSet(z ? 0 : 2);
        c();
        this.c.b();
        if (andSet == 2) {
            this.i = null;
        }
    }

    public final int zzjj() {
        return this.c.c();
    }

    public final void disable() {
        if (this.f.getAndSet(2) == 0) {
            c();
        }
    }

    public final boolean zzjk() {
        return this.c.d();
    }

    public final zzlh zzjl() {
        return this.c.e();
    }

    public final long zzje() {
        return this.c.f();
    }

    public final void zzjn() {
        long g = this.c.g();
        if (g != -1) {
            a(g);
        }
    }

    public final boolean zzh(long j, boolean z) {
        long a2 = this.c.a(j, z);
        if (a2 == -1) {
            return false;
        }
        a(a2);
        return true;
    }

    public final int zza(zzlj zzljVar, zznd zzndVar, boolean z, boolean z2, long j) {
        int i;
        switch (this.c.a(zzljVar, zzndVar, z, z2, this.i, this.d)) {
            case -5:
                this.i = zzljVar.zzaue;
                return -5;
            case -4:
                if (zzndVar.zzic()) {
                    return -4;
                }
                if (zzndVar.zzaga < j) {
                    zzndVar.zzal(BleSignal.UNKNOWN_TX_POWER);
                }
                if (zzndVar.zzeo()) {
                    zzqs zzqsVar = this.d;
                    long j2 = zzqsVar.zzajx;
                    this.e.reset(1);
                    a(j2, this.e.data, 1);
                    long j3 = j2 + 1;
                    byte b = this.e.data[0];
                    boolean z3 = (b & 128) != 0;
                    int i2 = b & Byte.MAX_VALUE;
                    if (zzndVar.zzaze.iv == null) {
                        zzndVar.zzaze.iv = new byte[16];
                    }
                    a(j3, zzndVar.zzaze.iv, i2);
                    long j4 = j3 + i2;
                    if (z3) {
                        this.e.reset(2);
                        a(j4, this.e.data, 2);
                        j4 += 2;
                        i = this.e.readUnsignedShort();
                    } else {
                        i = 1;
                    }
                    int[] iArr = zzndVar.zzaze.numBytesOfClearData;
                    int[] iArr2 = (iArr == null || iArr.length < i) ? new int[i] : iArr;
                    int[] iArr3 = zzndVar.zzaze.numBytesOfEncryptedData;
                    int[] iArr4 = (iArr3 == null || iArr3.length < i) ? new int[i] : iArr3;
                    if (z3) {
                        int i3 = i * 6;
                        this.e.reset(i3);
                        a(j4, this.e.data, i3);
                        j4 += i3;
                        this.e.setPosition(0);
                        for (int i4 = 0; i4 < i; i4++) {
                            iArr2[i4] = this.e.readUnsignedShort();
                            iArr4[i4] = this.e.zzgg();
                        }
                    } else {
                        iArr2[0] = 0;
                        iArr4[0] = zzqsVar.size - ((int) (j4 - zzqsVar.zzajx));
                    }
                    zznx zznxVar = zzqsVar.zzbbj;
                    zzndVar.zzaze.set(i, iArr2, iArr4, zznxVar.zzazq, zzndVar.zzaze.iv, zznxVar.zzazp);
                    int i5 = (int) (j4 - zzqsVar.zzajx);
                    zzqsVar.zzajx += i5;
                    zzqsVar.size -= i5;
                }
                zzndVar.zzan(this.d.size);
                long j5 = this.d.zzajx;
                ByteBuffer byteBuffer = zzndVar.zzde;
                int i6 = this.d.size;
                a(j5);
                while (i6 > 0) {
                    int i7 = (int) (j5 - this.g.f1991a);
                    int min = Math.min(i6, this.b - i7);
                    zzrs zzrsVar = this.g.d;
                    byteBuffer.put(zzrsVar.data, zzrsVar.zzbj(i7), min);
                    j5 += min;
                    i6 -= min;
                    if (j5 == this.g.b) {
                        this.f3713a.zza(zzrsVar);
                        this.g = this.g.a();
                    }
                }
                a(this.d.zzbkd);
                return -4;
            case -3:
                return -3;
            default:
                throw new IllegalStateException();
        }
    }

    private final void a(long j, byte[] bArr, int i) {
        a(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.g.f1991a);
            int min = Math.min(i - i2, this.b - i3);
            zzrs zzrsVar = this.g.d;
            System.arraycopy(zzrsVar.data, zzrsVar.zzbj(i3), bArr, i2, min);
            j += min;
            i2 += min;
            if (j == this.g.b) {
                this.f3713a.zza(zzrsVar);
                this.g = this.g.a();
            }
        }
    }

    private final void a(long j) {
        while (j >= this.g.b) {
            this.f3713a.zza(this.g.d);
            this.g = this.g.a();
        }
    }

    public final void zza(zzqv zzqvVar) {
        this.n = zzqvVar;
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zze(zzlh zzlhVar) {
        zzlh zzlhVar2 = zzlhVar == null ? null : zzlhVar;
        boolean a2 = this.c.a(zzlhVar2);
        this.k = zzlhVar;
        this.j = false;
        zzqv zzqvVar = this.n;
        if (zzqvVar == null || !a2) {
            return;
        }
        zzqvVar.zzf(zzlhVar2);
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final int zza(zzno zznoVar, int i, boolean z) throws IOException, InterruptedException {
        if (!a()) {
            int zzaq = zznoVar.zzaq(i);
            if (zzaq != -1) {
                return zzaq;
            }
            throw new EOFException();
        }
        try {
            int a2 = a(i);
            zzrs zzrsVar = this.h.d;
            int read = zznoVar.read(zzrsVar.data, zzrsVar.zzbj(this.m), a2);
            if (read == -1) {
                throw new EOFException();
            }
            this.m += read;
            this.l += read;
            return read;
        } finally {
            b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zza(zzst zzstVar, int i) {
        if (!a()) {
            zzstVar.zzac(i);
            return;
        }
        while (i > 0) {
            int a2 = a(i);
            zzrs zzrsVar = this.h.d;
            zzstVar.zzb(zzrsVar.data, zzrsVar.zzbj(this.m), a2);
            this.m += a2;
            this.l += a2;
            i -= a2;
        }
        b();
    }

    @Override // com.google.android.gms.internal.ads.zznw
    public final void zza(long j, int i, int i2, int i3, zznx zznxVar) {
        if (!a()) {
            this.c.a(j);
            return;
        }
        try {
            this.c.a(j, i, this.l - i2, i2, zznxVar);
        } finally {
            b();
        }
    }

    private final boolean a() {
        return this.f.compareAndSet(0, 1);
    }

    private final void b() {
        if (this.f.compareAndSet(1, 0)) {
            return;
        }
        c();
    }

    private final void c() {
        this.c.a();
        anp anpVar = this.g;
        if (anpVar.c) {
            boolean z = this.h.c;
            zzrs[] zzrsVarArr = new zzrs[(z ? 1 : 0) + (((int) (this.h.f1991a - anpVar.f1991a)) / this.b)];
            for (int i = 0; i < zzrsVarArr.length; i++) {
                zzrsVarArr[i] = anpVar.d;
                anpVar = anpVar.a();
            }
            this.f3713a.zza(zzrsVarArr);
        }
        this.g = new anp(0L, this.b);
        this.h = this.g;
        this.l = 0L;
        this.m = this.b;
        this.f3713a.zzn();
    }

    private final int a(int i) {
        if (this.m == this.b) {
            this.m = 0;
            if (this.h.c) {
                this.h = this.h.e;
            }
            anp anpVar = this.h;
            zzrs zzjt = this.f3713a.zzjt();
            anp anpVar2 = new anp(this.h.b, this.b);
            anpVar.d = zzjt;
            anpVar.e = anpVar2;
            anpVar.c = true;
        }
        return Math.min(i, this.b - this.m);
    }
}
