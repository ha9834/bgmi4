package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.gms.nearby.messages.BleSignal;
import com.tencent.imsdk.android.tools.log.LogUtils;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class ane implements zznp, zzqj, zzqv, zzsf<anj> {
    private boolean[] A;
    private boolean B;
    private long D;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: a */
    private final Uri f1980a;
    private final zzrv b;
    private final int c;
    private final Handler d;
    private final zzqi e;
    private final zzqm f;
    private final zzrt g;
    private final String h;
    private final long i;
    private final ank k;
    private zzqk q;
    private zznu r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private zzrb x;
    private long y;
    private boolean[] z;
    private final zzse j = new zzse("Loader:ExtractorMediaPeriod");
    private final zzsm l = new zzsm();
    private final Runnable m = new anf(this);
    private final Runnable n = new ang(this);
    private final Handler o = new Handler();
    private long E = -9223372036854775807L;
    private final SparseArray<zzqt> p = new SparseArray<>();
    private long C = -1;

    public ane(Uri uri, zzrv zzrvVar, zznn[] zznnVarArr, int i, Handler handler, zzqi zzqiVar, zzqm zzqmVar, zzrt zzrtVar, String str, int i2) {
        this.f1980a = uri;
        this.b = zzrvVar;
        this.c = i;
        this.d = handler;
        this.e = zzqiVar;
        this.f = zzqmVar;
        this.g = zzrtVar;
        this.h = str;
        this.i = i2;
        this.k = new ank(zznnVarArr, this);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zzem(long j) {
    }

    public final void a() {
        this.j.zza(new anh(this, this.k));
        this.o.removeCallbacksAndMessages(null);
        this.H = true;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zza(zzqk zzqkVar, long j) {
        this.q = zzqkVar;
        this.l.zzjx();
        d();
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final void zziy() throws IOException {
        this.j.zzbm(BleSignal.UNKNOWN_TX_POWER);
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final zzrb zziz() {
        return this.x;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zza(zzrm[] zzrmVarArr, boolean[] zArr, zzqw[] zzqwVarArr, boolean[] zArr2, long j) {
        int i;
        zzsk.checkState(this.t);
        for (int i2 = 0; i2 < zzrmVarArr.length; i2++) {
            if (zzqwVarArr[i2] != null && (zzrmVarArr[i2] == null || !zArr[i2])) {
                i = ((anl) zzqwVarArr[i2]).f1987a;
                zzsk.checkState(this.z[i]);
                this.w--;
                this.z[i] = false;
                this.p.valueAt(i).disable();
                zzqwVarArr[i2] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzrmVarArr.length; i3++) {
            if (zzqwVarArr[i3] == null && zzrmVarArr[i3] != null) {
                zzrm zzrmVar = zzrmVarArr[i3];
                zzsk.checkState(zzrmVar.length() == 1);
                zzsk.checkState(zzrmVar.zzbh(0) == 0);
                int zza = this.x.zza(zzrmVar.zzjr());
                zzsk.checkState(!this.z[zza]);
                this.w++;
                this.z[zza] = true;
                zzqwVarArr[i3] = new anl(this, zza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.u) {
            int size = this.p.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.z[i4]) {
                    this.p.valueAt(i4).disable();
                }
            }
        }
        if (this.w == 0) {
            this.v = false;
            if (this.j.isLoading()) {
                this.j.zzgb();
            }
        } else if (!this.u ? j != 0 : z) {
            j = zzen(j);
            for (int i5 = 0; i5 < zzqwVarArr.length; i5++) {
                if (zzqwVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.u = true;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final boolean zzel(long j) {
        if (this.G) {
            return false;
        }
        if (this.t && this.w == 0) {
            return false;
        }
        boolean zzjx = this.l.zzjx();
        if (this.j.isLoading()) {
            return zzjx;
        }
        d();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqj, com.google.android.gms.internal.ads.zzqx
    public final long zzix() {
        if (this.w == 0) {
            return Long.MIN_VALUE;
        }
        return zzdu();
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zzja() {
        if (!this.v) {
            return -9223372036854775807L;
        }
        this.v = false;
        return this.D;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zzdu() {
        long f;
        if (this.G) {
            return Long.MIN_VALUE;
        }
        if (g()) {
            return this.E;
        }
        if (this.B) {
            f = Long.MAX_VALUE;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                if (this.A[i]) {
                    f = Math.min(f, this.p.valueAt(i).zzje());
                }
            }
        } else {
            f = f();
        }
        return f == Long.MIN_VALUE ? this.D : f;
    }

    @Override // com.google.android.gms.internal.ads.zzqj
    public final long zzen(long j) {
        if (!this.r.zzfc()) {
            j = 0;
        }
        this.D = j;
        int size = this.p.size();
        boolean z = !g();
        for (int i = 0; z && i < size; i++) {
            if (this.z[i]) {
                z = this.p.valueAt(i).zzh(j, false);
            }
        }
        if (!z) {
            this.E = j;
            this.G = false;
            if (this.j.isLoading()) {
                this.j.zzgb();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.p.valueAt(i2).zzk(this.z[i2]);
                }
            }
        }
        this.v = false;
        return j;
    }

    public final boolean a(int i) {
        if (this.G) {
            return true;
        }
        return !g() && this.p.valueAt(i).zzjk();
    }

    public final void b() throws IOException {
        this.j.zzbm(BleSignal.UNKNOWN_TX_POWER);
    }

    public final int a(int i, zzlj zzljVar, zznd zzndVar, boolean z) {
        if (this.v || g()) {
            return -3;
        }
        return this.p.valueAt(i).zza(zzljVar, zzndVar, z, this.G, this.D);
    }

    public final void a(int i, long j) {
        zzqt valueAt = this.p.valueAt(i);
        if (this.G && j > valueAt.zzje()) {
            valueAt.zzjn();
        } else {
            valueAt.zzh(j, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final zznw zzd(int i, int i2) {
        zzqt zzqtVar = this.p.get(i);
        if (zzqtVar != null) {
            return zzqtVar;
        }
        zzqt zzqtVar2 = new zzqt(this.g);
        zzqtVar2.zza(this);
        this.p.put(i, zzqtVar2);
        return zzqtVar2;
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zzfi() {
        this.s = true;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zznp
    public final void zza(zznu zznuVar) {
        this.r = zznuVar;
        this.o.post(this.m);
    }

    @Override // com.google.android.gms.internal.ads.zzqv
    public final void zzf(zzlh zzlhVar) {
        this.o.post(this.m);
    }

    public final void c() {
        if (this.H || this.t || this.r == null || !this.s) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            if (this.p.valueAt(i).zzjl() == null) {
                return;
            }
        }
        this.l.zzjy();
        zzra[] zzraVarArr = new zzra[size];
        this.A = new boolean[size];
        this.z = new boolean[size];
        this.y = this.r.getDurationUs();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 < size) {
                zzlh zzjl = this.p.valueAt(i2).zzjl();
                zzraVarArr[i2] = new zzra(zzjl);
                String str = zzjl.zzatq;
                if (!zzsp.zzbf(str) && !zzsp.zzav(str)) {
                    z = false;
                }
                this.A[i2] = z;
                this.B = z | this.B;
                i2++;
            } else {
                this.x = new zzrb(zzraVarArr);
                this.t = true;
                this.f.zzb(new zzqz(this.y, this.r.zzfc()), null);
                this.q.zza((zzqj) this);
                return;
            }
        }
    }

    private final void a(anj anjVar) {
        long j;
        if (this.C == -1) {
            j = anjVar.i;
            this.C = j;
        }
    }

    private final void d() {
        zznu zznuVar;
        anj anjVar = new anj(this, this.f1980a, this.b, this.k, this.l);
        if (this.t) {
            zzsk.checkState(g());
            long j = this.y;
            if (j != -9223372036854775807L && this.E >= j) {
                this.G = true;
                this.E = -9223372036854775807L;
                return;
            } else {
                anjVar.a(this.r.zzdq(this.E), this.E);
                this.E = -9223372036854775807L;
            }
        }
        this.F = e();
        int i = this.c;
        if (i == -1) {
            i = (this.t && this.C == -1 && ((zznuVar = this.r) == null || zznuVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.j.zza(anjVar, this, i);
    }

    private final int e() {
        int size = this.p.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.p.valueAt(i2).zzjj();
        }
        return i;
    }

    private final long f() {
        int size = this.p.size();
        long j = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            j = Math.max(j, this.p.valueAt(i).zzje());
        }
        return j;
    }

    private final boolean g() {
        return this.E != -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzsf
    public final /* synthetic */ int zza(anj anjVar, long j, long j2, IOException iOException) {
        zznu zznuVar;
        anj anjVar2 = anjVar;
        a(anjVar2);
        Handler handler = this.d;
        if (handler != null && this.e != null) {
            handler.post(new ani(this, iOException));
        }
        if (iOException instanceof zzrc) {
            return 3;
        }
        boolean z = e() > this.F;
        if (this.C == -1 && ((zznuVar = this.r) == null || zznuVar.getDurationUs() == -9223372036854775807L)) {
            this.D = 0L;
            this.v = this.t;
            int size = this.p.size();
            for (int i = 0; i < size; i++) {
                this.p.valueAt(i).zzk(!this.t || this.z[i]);
            }
            anjVar2.a(0L, 0L);
        }
        this.F = e();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzsf
    public final /* synthetic */ void zza(anj anjVar, long j, long j2, boolean z) {
        a(anjVar);
        if (z || this.w <= 0) {
            return;
        }
        int size = this.p.size();
        for (int i = 0; i < size; i++) {
            this.p.valueAt(i).zzk(this.z[i]);
        }
        this.q.zza((zzqk) this);
    }

    @Override // com.google.android.gms.internal.ads.zzsf
    public final /* synthetic */ void zza(anj anjVar, long j, long j2) {
        a(anjVar);
        this.G = true;
        if (this.y == -9223372036854775807L) {
            long f = f();
            this.y = f == Long.MIN_VALUE ? 0L : f + LogUtils.LOG_FUSE_TIME;
            this.f.zzb(new zzqz(this.y, this.r.zzfc()), null);
        }
        this.q.zza((zzqk) this);
    }
}
