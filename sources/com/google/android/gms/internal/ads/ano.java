package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class ano {

    /* renamed from: a, reason: collision with root package name */
    private int f1990a = 1000;
    private int[] b;
    private long[] c;
    private int[] d;
    private int[] e;
    private long[] f;
    private zznx[] g;
    private zzlh[] h;
    private int i;
    private int j;
    private int k;
    private int l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private zzlh q;

    public ano() {
        int i = this.f1990a;
        this.b = new int[i];
        this.c = new long[i];
        this.f = new long[i];
        this.e = new int[i];
        this.d = new int[i];
        this.g = new zznx[i];
        this.h = new zzlh[i];
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
        this.p = true;
        this.o = true;
    }

    public final void a() {
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.i = 0;
        this.o = true;
    }

    public final void b() {
        this.m = Long.MIN_VALUE;
        this.n = Long.MIN_VALUE;
    }

    public final int c() {
        return this.j + this.i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean d() {
        return this.i != 0;
    }

    public final synchronized zzlh e() {
        if (this.p) {
            return null;
        }
        return this.q;
    }

    public final synchronized long f() {
        return Math.max(this.m, this.n);
    }

    public final synchronized int a(zzlj zzljVar, zznd zzndVar, boolean z, boolean z2, zzlh zzlhVar, zzqs zzqsVar) {
        if (!d()) {
            if (z2) {
                zzndVar.setFlags(4);
                return -4;
            }
            if (this.q == null || (!z && this.q == zzlhVar)) {
                return -3;
            }
            zzljVar.zzaue = this.q;
            return -5;
        }
        if (!z && this.h[this.k] == zzlhVar) {
            if (zzndVar.zzde == null) {
                return -3;
            }
            zzndVar.zzaga = this.f[this.k];
            zzndVar.setFlags(this.e[this.k]);
            zzqsVar.size = this.d[this.k];
            zzqsVar.zzajx = this.c[this.k];
            zzqsVar.zzbbj = this.g[this.k];
            this.m = Math.max(this.m, zzndVar.zzaga);
            this.i--;
            this.k++;
            this.j++;
            if (this.k == this.f1990a) {
                this.k = 0;
            }
            zzqsVar.zzbkd = this.i > 0 ? this.c[this.k] : zzqsVar.zzajx + zzqsVar.size;
            return -4;
        }
        zzljVar.zzaue = this.h[this.k];
        return -5;
    }

    public final synchronized long g() {
        if (!d()) {
            return -1L;
        }
        int i = ((this.k + this.i) - 1) % this.f1990a;
        this.k = (this.k + this.i) % this.f1990a;
        this.j += this.i;
        this.i = 0;
        return this.c[i] + this.d[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized long a(long j, boolean z) {
        if (d() && j >= this.f[this.k]) {
            if (j > this.n && !z) {
                return -1L;
            }
            int i = this.k;
            int i2 = -1;
            int i3 = 0;
            while (i != this.l && this.f[i] <= j) {
                if ((this.e[i] & 1) != 0) {
                    i2 = i3;
                }
                i = (i + 1) % this.f1990a;
                i3++;
            }
            if (i2 == -1) {
                return -1L;
            }
            this.k = (this.k + i2) % this.f1990a;
            this.j += i2;
            this.i -= i2;
            return this.c[this.k];
        }
        return -1L;
    }

    public final synchronized boolean a(zzlh zzlhVar) {
        if (zzlhVar == null) {
            this.p = true;
            return false;
        }
        this.p = false;
        if (zzsy.zza(zzlhVar, this.q)) {
            return false;
        }
        this.q = zzlhVar;
        return true;
    }

    public final synchronized void a(long j, int i, long j2, int i2, zznx zznxVar) {
        if (this.o) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.o = false;
            }
        }
        zzsk.checkState(!this.p);
        a(j);
        this.f[this.l] = j;
        this.c[this.l] = j2;
        this.d[this.l] = i2;
        this.e[this.l] = i;
        this.g[this.l] = zznxVar;
        this.h[this.l] = this.q;
        this.b[this.l] = 0;
        this.i++;
        if (this.i == this.f1990a) {
            int i3 = this.f1990a + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            zznx[] zznxVarArr = new zznx[i3];
            zzlh[] zzlhVarArr = new zzlh[i3];
            int i4 = this.f1990a - this.k;
            System.arraycopy(this.c, this.k, jArr, 0, i4);
            System.arraycopy(this.f, this.k, jArr2, 0, i4);
            System.arraycopy(this.e, this.k, iArr2, 0, i4);
            System.arraycopy(this.d, this.k, iArr3, 0, i4);
            System.arraycopy(this.g, this.k, zznxVarArr, 0, i4);
            System.arraycopy(this.h, this.k, zzlhVarArr, 0, i4);
            System.arraycopy(this.b, this.k, iArr, 0, i4);
            int i5 = this.k;
            System.arraycopy(this.c, 0, jArr, i4, i5);
            System.arraycopy(this.f, 0, jArr2, i4, i5);
            System.arraycopy(this.e, 0, iArr2, i4, i5);
            System.arraycopy(this.d, 0, iArr3, i4, i5);
            System.arraycopy(this.g, 0, zznxVarArr, i4, i5);
            System.arraycopy(this.h, 0, zzlhVarArr, i4, i5);
            System.arraycopy(this.b, 0, iArr, i4, i5);
            this.c = jArr;
            this.f = jArr2;
            this.e = iArr2;
            this.d = iArr3;
            this.g = zznxVarArr;
            this.h = zzlhVarArr;
            this.b = iArr;
            this.k = 0;
            this.l = this.f1990a;
            this.i = this.f1990a;
            this.f1990a = i3;
            return;
        }
        this.l++;
        if (this.l == this.f1990a) {
            this.l = 0;
        }
    }

    public final synchronized void a(long j) {
        this.n = Math.max(this.n, j);
    }
}
