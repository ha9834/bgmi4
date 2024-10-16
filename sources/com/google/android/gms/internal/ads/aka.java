package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class aka {

    /* renamed from: a, reason: collision with root package name */
    private int f1926a = 1000;
    private long[] b;
    private int[] c;
    private int[] d;
    private long[] e;
    private byte[][] f;
    private int g;
    private int h;
    private int i;
    private int j;

    public aka() {
        int i = this.f1926a;
        this.b = new long[i];
        this.e = new long[i];
        this.d = new int[i];
        this.c = new int[i];
        this.f = new byte[i];
    }

    public final void a() {
        this.h = 0;
        this.i = 0;
        this.j = 0;
        this.g = 0;
    }

    public final synchronized boolean a(zzhm zzhmVar, akb akbVar) {
        if (this.g == 0) {
            return false;
        }
        zzhmVar.zzaga = this.e[this.i];
        zzhmVar.size = this.c[this.i];
        zzhmVar.flags = this.d[this.i];
        akbVar.f1927a = this.b[this.i];
        akbVar.b = this.f[this.i];
        return true;
    }

    public final synchronized long b() {
        this.g--;
        int i = this.i;
        this.i = i + 1;
        this.h++;
        if (this.i == this.f1926a) {
            this.i = 0;
        }
        if (this.g > 0) {
            return this.b[this.i];
        }
        return this.c[i] + this.b[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized long a(long j) {
        if (this.g != 0 && j >= this.e[this.i]) {
            if (j > this.e[(this.j == 0 ? this.f1926a : this.j) - 1]) {
                return -1L;
            }
            int i = this.i;
            int i2 = -1;
            int i3 = 0;
            while (i != this.j && this.e[i] <= j) {
                if ((this.d[i] & 1) != 0) {
                    i2 = i3;
                }
                i = (i + 1) % this.f1926a;
                i3++;
            }
            if (i2 == -1) {
                return -1L;
            }
            this.g -= i2;
            this.i = (this.i + i2) % this.f1926a;
            this.h += i2;
            return this.b[this.i];
        }
        return -1L;
    }

    public final synchronized void a(long j, int i, long j2, int i2, byte[] bArr) {
        this.e[this.j] = j;
        this.b[this.j] = j2;
        this.c[this.j] = i2;
        this.d[this.j] = i;
        this.f[this.j] = bArr;
        this.g++;
        if (this.g == this.f1926a) {
            int i3 = this.f1926a + 1000;
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr = new int[i3];
            int[] iArr2 = new int[i3];
            byte[][] bArr2 = new byte[i3];
            int i4 = this.f1926a - this.i;
            System.arraycopy(this.b, this.i, jArr, 0, i4);
            System.arraycopy(this.e, this.i, jArr2, 0, i4);
            System.arraycopy(this.d, this.i, iArr, 0, i4);
            System.arraycopy(this.c, this.i, iArr2, 0, i4);
            System.arraycopy(this.f, this.i, bArr2, 0, i4);
            int i5 = this.i;
            System.arraycopy(this.b, 0, jArr, i4, i5);
            System.arraycopy(this.e, 0, jArr2, i4, i5);
            System.arraycopy(this.d, 0, iArr, i4, i5);
            System.arraycopy(this.c, 0, iArr2, i4, i5);
            System.arraycopy(this.f, 0, bArr2, i4, i5);
            this.b = jArr;
            this.e = jArr2;
            this.d = iArr;
            this.c = iArr2;
            this.f = bArr2;
            this.i = 0;
            this.j = this.f1926a;
            this.g = this.f1926a;
            this.f1926a = i3;
            return;
        }
        this.j++;
        if (this.j == this.f1926a) {
            this.j = 0;
        }
    }
}
