package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: classes2.dex */
final class ajy {

    /* renamed from: a, reason: collision with root package name */
    private final zzjl f1925a;
    private final int b;
    private final aka c = new aka();
    private final LinkedBlockingDeque<zzjk> d = new LinkedBlockingDeque<>();
    private final akb e = new akb();
    private final zzkm f = new zzkm(32);
    private long g;
    private long h;
    private zzjk i;
    private int j;

    public ajy(zzjl zzjlVar) {
        this.f1925a = zzjlVar;
        this.b = zzjlVar.zzfz();
        this.j = this.b;
    }

    public final void a() {
        this.c.a();
        while (!this.d.isEmpty()) {
            this.f1925a.zza(this.d.remove());
        }
        this.g = 0L;
        this.h = 0L;
        this.i = null;
        this.j = this.b;
    }

    public final boolean a(zzhm zzhmVar) {
        return this.c.a(zzhmVar, this.e);
    }

    public final void b() {
        b(this.c.b());
    }

    public final boolean a(long j) {
        long a2 = this.c.a(j);
        if (a2 == -1) {
            return false;
        }
        b(a2);
        return true;
    }

    public final boolean b(zzhm zzhmVar) {
        int i;
        if (!this.c.a(zzhmVar, this.e)) {
            return false;
        }
        if (zzhmVar.zzeo()) {
            akb akbVar = this.e;
            long j = akbVar.f1927a;
            a(j, this.f.data, 1);
            long j2 = j + 1;
            byte b = this.f.data[0];
            boolean z = (b & 128) != 0;
            int i2 = b & Byte.MAX_VALUE;
            if (zzhmVar.zzafz.iv == null) {
                zzhmVar.zzafz.iv = new byte[16];
            }
            a(j2, zzhmVar.zzafz.iv, i2);
            long j3 = j2 + i2;
            if (z) {
                a(j3, this.f.data, 2);
                j3 += 2;
                this.f.setPosition(0);
                i = this.f.readUnsignedShort();
            } else {
                i = 1;
            }
            int[] iArr = zzhmVar.zzafz.numBytesOfClearData;
            int[] iArr2 = (iArr == null || iArr.length < i) ? new int[i] : iArr;
            int[] iArr3 = zzhmVar.zzafz.numBytesOfEncryptedData;
            int[] iArr4 = (iArr3 == null || iArr3.length < i) ? new int[i] : iArr3;
            if (z) {
                int i3 = i * 6;
                zzkm zzkmVar = this.f;
                if (zzkmVar.limit() < i3) {
                    zzkmVar.zzb(new byte[i3], i3);
                }
                a(j3, this.f.data, i3);
                j3 += i3;
                this.f.setPosition(0);
                for (int i4 = 0; i4 < i; i4++) {
                    iArr2[i4] = this.f.readUnsignedShort();
                    iArr4[i4] = this.f.zzgg();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzhmVar.size - ((int) (j3 - akbVar.f1927a));
            }
            zzhmVar.zzafz.set(i, iArr2, iArr4, akbVar.b, zzhmVar.zzafz.iv, 1);
            int i5 = (int) (j3 - akbVar.f1927a);
            akbVar.f1927a += i5;
            zzhmVar.size -= i5;
        }
        if (zzhmVar.zzde == null || zzhmVar.zzde.capacity() < zzhmVar.size) {
            int i6 = zzhmVar.size;
        }
        if (zzhmVar.zzde != null) {
            long j4 = this.e.f1927a;
            ByteBuffer byteBuffer = zzhmVar.zzde;
            int i7 = zzhmVar.size;
            while (i7 > 0) {
                b(j4);
                int i8 = (int) (j4 - this.g);
                int min = Math.min(i7, this.b - i8);
                byteBuffer.put(this.d.peek().data, i8 + 0, min);
                j4 += min;
                i7 -= min;
            }
        }
        b(this.c.b());
        return true;
    }

    private final void a(long j, byte[] bArr, int i) {
        long j2 = j;
        int i2 = 0;
        while (i2 < i) {
            b(j2);
            int i3 = (int) (j2 - this.g);
            int min = Math.min(i - i2, this.b - i3);
            System.arraycopy(this.d.peek().data, i3 + 0, bArr, i2, min);
            j2 += min;
            i2 += min;
        }
    }

    private final void b(long j) {
        int i = ((int) (j - this.g)) / this.b;
        for (int i2 = 0; i2 < i; i2++) {
            this.f1925a.zza(this.d.remove());
            this.g += this.b;
        }
    }

    public final long c() {
        return this.h;
    }

    public final int a(zzie zzieVar, int i) throws IOException, InterruptedException {
        d();
        int min = Math.min(i, this.b - this.j);
        byte[] bArr = this.i.data;
        zzjk zzjkVar = this.i;
        zzieVar.readFully(bArr, this.j + 0, min);
        this.j += min;
        this.h += min;
        return min;
    }

    public final void a(zzkm zzkmVar, int i) {
        int i2 = i;
        while (i2 > 0) {
            d();
            int min = Math.min(i2, this.b - this.j);
            byte[] bArr = this.i.data;
            zzjk zzjkVar = this.i;
            zzkmVar.zzb(bArr, this.j + 0, min);
            this.j += min;
            i2 -= min;
        }
        this.h += i;
    }

    public final void a(long j, int i, long j2, int i2, byte[] bArr) {
        this.c.a(j, i, j2, i2, bArr);
    }

    private final void d() {
        if (this.j == this.b) {
            this.j = 0;
            this.i = this.f1925a.zzfy();
            this.d.add(this.i);
        }
    }
}
