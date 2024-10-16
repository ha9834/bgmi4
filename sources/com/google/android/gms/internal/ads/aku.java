package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aku implements zzkv {

    /* renamed from: a, reason: collision with root package name */
    private final zzlo[] f1941a;
    private final zzrp b;
    private final zzro c;
    private final Handler d;
    private final akw e;
    private final CopyOnWriteArraySet<zzkw> f;
    private final zzlu g;
    private final zzlt h;
    private boolean i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private zzlr p;
    private Object q;
    private zzrb r;
    private zzro s;
    private zzln t;
    private zzle u;
    private int v;
    private int w;
    private long x;

    @SuppressLint({"HandlerLeak"})
    public aku(zzlo[] zzloVarArr, zzrp zzrpVar, zzll zzllVar) {
        String str = zzsy.zzbnq;
        StringBuilder sb = new StringBuilder(String.valueOf("Init ExoPlayerLib/2.4.2 [").length() + 1 + String.valueOf(str).length());
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzsk.checkState(zzloVarArr.length > 0);
        this.f1941a = (zzlo[]) zzsk.checkNotNull(zzloVarArr);
        this.b = (zzrp) zzsk.checkNotNull(zzrpVar);
        this.j = false;
        this.k = 0;
        this.l = 1;
        this.f = new CopyOnWriteArraySet<>();
        this.c = new zzro(new zzrm[zzloVarArr.length]);
        this.p = zzlr.zzaum;
        this.g = new zzlu();
        this.h = new zzlt();
        this.r = zzrb.zzbkw;
        this.s = this.c;
        this.t = zzln.zzaug;
        this.d = new akv(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.u = new zzle(0, 0L);
        this.e = new akw(zzloVarArr, zzrpVar, zzllVar, this.j, 0, this.d, this.u, this);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zza(zzkw zzkwVar) {
        this.f.add(zzkwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzb(zzkw zzkwVar) {
        this.f.remove(zzkwVar);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final int getPlaybackState() {
        return this.l;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zza(zzql zzqlVar) {
        if (!this.p.isEmpty() || this.q != null) {
            this.p = zzlr.zzaum;
            this.q = null;
            Iterator<zzkw> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().zza(this.p, this.q);
            }
        }
        if (this.i) {
            this.i = false;
            this.r = zzrb.zzbkw;
            this.s = this.c;
            this.b.zzd(null);
            Iterator<zzkw> it2 = this.f.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.r, this.s);
            }
        }
        this.n++;
        this.e.a(zzqlVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzd(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.a(z);
            Iterator<zzkw> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.l);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final boolean zzdm() {
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.zzkv
    public final void seekTo(long j) {
        int a2 = a();
        if (a2 < 0 || (!this.p.isEmpty() && a2 >= this.p.zzhf())) {
            throw new zzlk(this.p, a2, j);
        }
        this.m++;
        this.v = a2;
        if (this.p.isEmpty()) {
            this.w = 0;
        } else {
            this.p.zza(a2, this.g, false);
            if (j != -9223372036854775807L) {
                zzkt.zzea(j);
            }
            this.p.zza(0, this.h, false);
            this.w = 0;
        }
        if (j == -9223372036854775807L) {
            this.x = 0L;
            this.e.a(this.p, a2, -9223372036854775807L);
            return;
        }
        this.x = j;
        this.e.a(this.p, a2, zzkt.zzea(j));
        Iterator<zzkw> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().zzgt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void stop() {
        this.e.a();
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void release() {
        this.e.b();
        this.d.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zza(zzky... zzkyVarArr) {
        this.e.a(zzkyVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final void zzb(zzky... zzkyVarArr) {
        this.e.b(zzkyVarArr);
    }

    private final int a() {
        if (this.p.isEmpty() || this.m > 0) {
            return this.v;
        }
        this.p.zza(this.u.zzatb, this.h, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long getDuration() {
        if (this.p.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzkt.zzdz(this.p.zza(a(), this.g, false).zzack);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long zzdn() {
        if (this.p.isEmpty() || this.m > 0) {
            return this.x;
        }
        this.p.zza(this.u.zzatb, this.h, false);
        return this.h.zzhh() + zzkt.zzdz(this.u.zzacl);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final long getBufferedPosition() {
        if (this.p.isEmpty() || this.m > 0) {
            return this.x;
        }
        this.p.zza(this.u.zzatb, this.h, false);
        return this.h.zzhh() + zzkt.zzdz(this.u.zzacm);
    }

    @Override // com.google.android.gms.internal.ads.zzkv
    public final int zzgs() {
        return this.f1941a.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Message message) {
        switch (message.what) {
            case 0:
                this.n--;
                return;
            case 1:
                this.l = message.arg1;
                Iterator<zzkw> it = this.f.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.j, this.l);
                }
                return;
            case 2:
                this.o = message.arg1 != 0;
                Iterator<zzkw> it2 = this.f.iterator();
                while (it2.hasNext()) {
                    it2.next().zzh(this.o);
                }
                return;
            case 3:
                if (this.n == 0) {
                    zzrr zzrrVar = (zzrr) message.obj;
                    this.i = true;
                    this.r = zzrrVar.zzbly;
                    this.s = zzrrVar.zzblz;
                    this.b.zzd(zzrrVar.zzbma);
                    Iterator<zzkw> it3 = this.f.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.r, this.s);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.m - 1;
                this.m = i;
                if (i == 0) {
                    this.u = (zzle) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzkw> it4 = this.f.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzgt();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.m == 0) {
                    this.u = (zzle) message.obj;
                    Iterator<zzkw> it5 = this.f.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzgt();
                    }
                    return;
                }
                return;
            case 6:
                zzlg zzlgVar = (zzlg) message.obj;
                this.m -= zzlgVar.zzatk;
                if (this.n == 0) {
                    this.p = zzlgVar.zzary;
                    this.q = zzlgVar.zzarz;
                    this.u = zzlgVar.zzasd;
                    Iterator<zzkw> it6 = this.f.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.p, this.q);
                    }
                    return;
                }
                return;
            case 7:
                zzln zzlnVar = (zzln) message.obj;
                if (this.t.equals(zzlnVar)) {
                    return;
                }
                this.t = zzlnVar;
                Iterator<zzkw> it7 = this.f.iterator();
                while (it7.hasNext()) {
                    it7.next().zza(zzlnVar);
                }
                return;
            case 8:
                zzku zzkuVar = (zzku) message.obj;
                Iterator<zzkw> it8 = this.f.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzkuVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
