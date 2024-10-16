package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.SystemClock;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzig implements zzhn, zzif, zzka {
    private IOException A;
    private boolean B;
    private int C;
    private long D;
    private boolean E;
    private int F;
    private int G;

    /* renamed from: a, reason: collision with root package name */
    private final zzid f3656a;
    private final zzjr b;
    private final int c;
    private final SparseArray<ajx> d;
    private final int e;
    private final boolean f;
    private final Uri g;
    private final zzjp h;
    private volatile boolean i;
    private volatile zzio j;
    private volatile zzhw k;
    private boolean l;
    private int m;
    private zzho[] n;
    private long o;
    private boolean[] p;
    private boolean[] q;
    private boolean[] r;
    private int s;
    private long t;
    private long u;
    private long v;
    private boolean w;
    private long x;
    private zzjz y;
    private ajw z;

    public zzig(Uri uri, zzjp zzjpVar, zzid zzidVar, int i, int i2) {
        this(uri, zzjpVar, zzidVar, 2, i2, -1);
    }

    private zzig(Uri uri, zzjp zzjpVar, zzid zzidVar, int i, int i2, int i3) {
        this.g = uri;
        this.h = zzjpVar;
        this.f3656a = zzidVar;
        this.s = 2;
        this.c = i2;
        this.e = -1;
        this.d = new SparseArray<>();
        this.b = new zzjr(262144);
        this.v = -1L;
        this.f = true;
        zzidVar.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean zzdg(long j) throws IOException {
        boolean z;
        if (this.l) {
            return true;
        }
        if (this.y == null) {
            this.y = new zzjz("Loader:ExtractorSampleSource");
        }
        a();
        if (this.j != null && this.i) {
            int i = 0;
            while (true) {
                if (i >= this.d.size()) {
                    z = true;
                    break;
                }
                if (!this.d.valueAt(i).zzfd()) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                int size = this.d.size();
                this.r = new boolean[size];
                this.q = new boolean[size];
                this.p = new boolean[size];
                this.n = new zzho[size];
                this.o = -1L;
                for (int i2 = 0; i2 < size; i2++) {
                    zzhj zzfe = this.d.valueAt(i2).zzfe();
                    this.n[i2] = new zzho(zzfe.mimeType, zzfe.zzack);
                    if (zzfe.zzack != -1 && zzfe.zzack > this.o) {
                        this.o = zzfe.zzack;
                    }
                }
                this.l = true;
                return true;
            }
        }
        c();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int getTrackCount() {
        return this.d.size();
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final zzho zzo(int i) {
        zzkh.checkState(this.l);
        return this.n[i];
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void zza(int i, long j) {
        zzkh.checkState(this.l);
        zzkh.checkState(!this.r[i]);
        this.m++;
        this.r[i] = true;
        this.p[i] = true;
        if (this.m == 1) {
            zzdi(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void zzp(int i) {
        zzkh.checkState(this.l);
        zzkh.checkState(this.r[i]);
        this.m--;
        this.r[i] = false;
        this.q[i] = false;
        if (this.m == 0) {
            if (this.y.isLoading()) {
                this.y.zzgb();
            } else {
                e();
                this.b.zzz(0);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final boolean zzdh(long j) throws IOException {
        zzkh.checkState(this.l);
        zzkh.checkState(this.m > 0);
        this.t = j;
        long j2 = this.t;
        int i = 0;
        while (true) {
            boolean[] zArr = this.r;
            if (i >= zArr.length) {
                break;
            }
            if (!zArr[i]) {
                this.d.valueAt(i).zzdr(j2);
            }
            i++;
        }
        return this.E || a();
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final int zza(int i, long j, zzhk zzhkVar, zzhm zzhmVar, boolean z) throws IOException {
        this.t = j;
        boolean[] zArr = this.q;
        if (zArr[i]) {
            zArr[i] = false;
            return -5;
        }
        if (z || f()) {
            c();
            return -2;
        }
        ajx valueAt = this.d.valueAt(i);
        if (this.p[i]) {
            zzhkVar.zzado = valueAt.zzfe();
            zzhkVar.zzadp = this.k;
            this.p[i] = false;
            return -4;
        }
        if (valueAt.zza(zzhmVar)) {
            zzhmVar.flags |= this.f && (zzhmVar.zzaga > this.u ? 1 : (zzhmVar.zzaga == this.u ? 0 : -1)) < 0 ? 134217728 : 0;
            zzhmVar.zzaga += this.x;
            return -3;
        }
        if (this.E) {
            return -1;
        }
        c();
        return -2;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void zzdi(long j) {
        zzkh.checkState(this.l);
        int i = 0;
        zzkh.checkState(this.m > 0);
        this.j.zzfc();
        this.u = j;
        if ((f() ? this.v : this.t) == j) {
            return;
        }
        this.t = j;
        boolean z = !f();
        for (int i2 = 0; z && i2 < this.d.size(); i2++) {
            z &= this.d.valueAt(i2).zzds(j);
        }
        if (!z) {
            a(j);
        }
        while (true) {
            boolean[] zArr = this.q;
            if (i >= zArr.length) {
                return;
            }
            zArr[i] = true;
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final long zzdu() {
        if (this.E) {
            return -3L;
        }
        if (f()) {
            return this.v;
        }
        long j = Long.MIN_VALUE;
        for (int i = 0; i < this.d.size(); i++) {
            j = Math.max(j, this.d.valueAt(i).zzff());
        }
        return j == Long.MIN_VALUE ? this.t : j;
    }

    @Override // com.google.android.gms.internal.ads.zzhn
    public final void release() {
        zzjz zzjzVar;
        zzkh.checkState(this.s > 0);
        int i = this.s - 1;
        this.s = i;
        if (i != 0 || (zzjzVar = this.y) == null) {
            return;
        }
        zzjzVar.release();
        this.y = null;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar) {
        this.E = true;
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zzb(zzkc zzkcVar) {
        if (this.m > 0) {
            a(this.v);
        } else {
            e();
            this.b.zzz(0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzka
    public final void zza(zzkc zzkcVar, IOException iOException) {
        this.A = iOException;
        this.C = this.F <= this.G ? 1 + this.C : 1;
        this.D = SystemClock.elapsedRealtime();
        b();
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final zzip zzs(int i) {
        ajx ajxVar = this.d.get(i);
        if (ajxVar != null) {
            return ajxVar;
        }
        ajx ajxVar2 = new ajx(this, this.b);
        this.d.put(i, ajxVar2);
        return ajxVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void zzfi() {
        this.i = true;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void zza(zzio zzioVar) {
        this.j = zzioVar;
    }

    @Override // com.google.android.gms.internal.ads.zzif
    public final void zzb(zzhw zzhwVar) {
        this.k = zzhwVar;
    }

    private final boolean a() throws IOException {
        boolean z;
        b();
        boolean z2 = false;
        if (f()) {
            return false;
        }
        if (this.l) {
            int i = 0;
            while (true) {
                boolean[] zArr = this.r;
                if (i >= zArr.length) {
                    z = false;
                    break;
                }
                if (zArr[i] && !this.d.valueAt(i).isEmpty()) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                z2 = true;
            }
        }
        if (!z2) {
            c();
        }
        return z2;
    }

    private final void a(long j) {
        this.v = j;
        this.E = false;
        if (this.y.isLoading()) {
            this.y.zzgb();
        } else {
            e();
            b();
        }
    }

    private final void b() {
        if (this.E || this.y.isLoading()) {
            return;
        }
        if (this.A != null) {
            zzkh.checkState(this.z != null);
            if (SystemClock.elapsedRealtime() - this.D >= Math.min((this.C - 1) * 1000, 5000L)) {
                this.A = null;
                if (!this.l) {
                    for (int i = 0; i < this.d.size(); i++) {
                        this.d.valueAt(i).clear();
                    }
                    this.z = d();
                } else {
                    this.j.zzfc();
                }
                this.G = this.F;
                this.y.zza(this.z, this);
                return;
            }
            return;
        }
        this.x = 0L;
        this.w = false;
        if (!this.l) {
            this.z = d();
        } else {
            zzkh.checkState(f());
            long j = this.o;
            if (j != -1 && this.v >= j) {
                this.E = true;
                this.v = -1L;
                return;
            } else {
                this.z = new ajw(this.g, this.h, this.f3656a, this.b, this.c, this.j.zzdq(this.v));
                this.v = -1L;
            }
        }
        this.G = this.F;
        this.y.zza(this.z, this);
    }

    private final void c() throws IOException {
        if (this.A == null) {
            return;
        }
        int i = this.e;
        if (i == -1) {
            if (this.j != null) {
                this.j.zzfc();
            }
            i = 3;
        }
        if (this.C > i) {
            throw this.A;
        }
    }

    private final ajw d() {
        return new ajw(this.g, this.h, this.f3656a, this.b, this.c, 0L);
    }

    private final void e() {
        for (int i = 0; i < this.d.size(); i++) {
            this.d.valueAt(i).clear();
        }
        this.z = null;
        this.A = null;
        this.C = 0;
        this.B = false;
    }

    private final boolean f() {
        return this.v != -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int a(zzig zzigVar) {
        int i = zzigVar.F;
        zzigVar.F = i + 1;
        return i;
    }
}
