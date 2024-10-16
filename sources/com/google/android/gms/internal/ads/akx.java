package com.google.android.gms.internal.ads;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class akx {

    /* renamed from: a, reason: collision with root package name */
    public final zzqj f1944a;
    public final Object b;
    public final int c;
    public final zzqw[] d;
    public final long e;
    public int f;
    public long g;
    public boolean h;
    public boolean i;
    public boolean j;
    public akx k;
    public zzrr l;
    private final boolean[] m;
    private final zzlo[] n;
    private final zzlp[] o;
    private final zzrp p;
    private final zzll q;
    private final zzql r;
    private zzrr s;

    public akx(zzlo[] zzloVarArr, zzlp[] zzlpVarArr, long j, zzrp zzrpVar, zzll zzllVar, zzql zzqlVar, Object obj, int i, int i2, boolean z, long j2) {
        this.n = zzloVarArr;
        this.o = zzlpVarArr;
        this.e = j;
        this.p = zzrpVar;
        this.q = zzllVar;
        this.r = zzqlVar;
        this.b = zzsk.checkNotNull(obj);
        this.c = i;
        this.f = i2;
        this.h = z;
        this.g = j2;
        this.d = new zzqw[zzloVarArr.length];
        this.m = new boolean[zzloVarArr.length];
        this.f1944a = zzqlVar.zza(i2, zzllVar.zzhe());
    }

    public final long a() {
        return this.e - this.g;
    }

    public final void a(int i, boolean z) {
        this.f = i;
        this.h = z;
    }

    public final boolean b() {
        if (this.i) {
            return !this.j || this.f1944a.zzdu() == Long.MIN_VALUE;
        }
        return false;
    }

    public final boolean c() throws zzku {
        boolean z;
        zzrr zza = this.p.zza(this.o, this.f1944a.zziz());
        zzrr zzrrVar = this.s;
        if (zzrrVar != null) {
            int i = 0;
            while (true) {
                if (i >= zza.zzblz.length) {
                    z = true;
                    break;
                }
                if (!zza.zza(zzrrVar, i)) {
                    z = false;
                    break;
                }
                i++;
            }
        } else {
            z = false;
        }
        if (z) {
            return false;
        }
        this.l = zza;
        return true;
    }

    public final long a(long j, boolean z) {
        return a(j, false, new boolean[this.n.length]);
    }

    public final long a(long j, boolean z, boolean[] zArr) {
        zzro zzroVar = this.l.zzblz;
        int i = 0;
        while (true) {
            boolean z2 = true;
            if (i >= zzroVar.length) {
                break;
            }
            boolean[] zArr2 = this.m;
            if (z || !this.l.zza(this.s, i)) {
                z2 = false;
            }
            zArr2[i] = z2;
            i++;
        }
        long zza = this.f1944a.zza(zzroVar.zzjs(), this.m, this.d, zArr, j);
        this.s = this.l;
        this.j = false;
        int i2 = 0;
        while (true) {
            zzqw[] zzqwVarArr = this.d;
            if (i2 < zzqwVarArr.length) {
                if (zzqwVarArr[i2] != null) {
                    zzsk.checkState(zzroVar.zzbi(i2) != null);
                    this.j = true;
                } else {
                    zzsk.checkState(zzroVar.zzbi(i2) == null);
                }
                i2++;
            } else {
                this.q.zza(this.n, this.l.zzbly, zzroVar);
                return zza;
            }
        }
    }

    public final void d() {
        try {
            this.r.zzb(this.f1944a);
        } catch (RuntimeException e) {
            Log.e("ExoPlayerImplInternal", "Period release failed.", e);
        }
    }
}
