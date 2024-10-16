package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class ajf implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final Handler f1910a;
    private final HandlerThread b;
    private final Handler c;
    private final ajg d;
    private final boolean[] e;
    private final List<zzhp> h;
    private zzhp[] i;
    private zzhp j;
    private boolean k;
    private boolean l;
    private boolean m;
    private int n;
    private long q;
    private volatile long r;
    private volatile long s;
    private volatile long t;
    private int o = 0;
    private int p = 0;
    private final long f = 2500000;
    private final long g = 5000000;

    public ajf(Handler handler, boolean z, boolean[] zArr, int i, int i2) {
        this.c = handler;
        this.l = z;
        this.e = new boolean[zArr.length];
        for (int i3 = 0; i3 < zArr.length; i3++) {
            this.e[i3] = zArr[i3];
        }
        this.n = 1;
        this.r = -1L;
        this.t = -1L;
        this.d = new ajg();
        this.h = new ArrayList(zArr.length);
        this.b = new zzko(String.valueOf(getClass().getSimpleName()).concat(":Handler"), -16);
        this.b.start();
        this.f1910a = new Handler(this.b.getLooper(), this);
    }

    public final long a() {
        return this.s / 1000;
    }

    public final long b() {
        if (this.t == -1) {
            return -1L;
        }
        return this.t / 1000;
    }

    public final long c() {
        if (this.r == -1) {
            return -1L;
        }
        return this.r / 1000;
    }

    public final void a(zzhp... zzhpVarArr) {
        this.f1910a.obtainMessage(1, zzhpVarArr).sendToTarget();
    }

    public final void a(boolean z) {
        this.f1910a.obtainMessage(3, z ? 1 : 0, 0).sendToTarget();
    }

    public final void a(long j) {
        this.f1910a.obtainMessage(6, Long.valueOf(j)).sendToTarget();
    }

    public final void d() {
        this.f1910a.sendEmptyMessage(4);
    }

    public final void a(int i, boolean z) {
        this.f1910a.obtainMessage(8, 0, z ? 1 : 0).sendToTarget();
    }

    public final void a(zzgf zzgfVar, int i, Object obj) {
        this.o++;
        this.f1910a.obtainMessage(9, 1, 0, Pair.create(zzgfVar, obj)).sendToTarget();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void b(zzgf zzgfVar, int i, Object obj) {
        if (this.k) {
            StringBuilder sb = new StringBuilder(57);
            sb.append("Sent message(1");
            sb.append(") after release. Message ignored.");
            Log.w("ExoPlayerImplInternal", sb.toString());
            return;
        }
        int i2 = this.o;
        this.o = i2 + 1;
        this.f1910a.obtainMessage(9, 1, 0, Pair.create(zzgfVar, obj)).sendToTarget();
        while (this.p <= i2) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void e() {
        if (this.k) {
            return;
        }
        this.f1910a.sendEmptyMessage(5);
        while (!this.k) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.b.quit();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        zzhp zzhpVar;
        int o;
        try {
            switch (message.what) {
                case 1:
                    zzhp[] zzhpVarArr = (zzhp[]) message.obj;
                    j();
                    this.i = zzhpVarArr;
                    for (int i = 0; i < zzhpVarArr.length; i++) {
                        if (zzhpVarArr[i].a()) {
                            zzkh.checkState(this.j == null);
                            this.j = zzhpVarArr[i];
                        }
                    }
                    a(2);
                    this.f1910a.sendEmptyMessage(2);
                    return true;
                case 2:
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    boolean z = true;
                    for (int i2 = 0; i2 < this.i.length; i2++) {
                        if (this.i[i2].o() == 0 && this.i[i2].c(this.s) == 0) {
                            z = false;
                        }
                    }
                    if (!z) {
                        a(2, elapsedRealtime, 10L);
                        return true;
                    }
                    long j = 0;
                    boolean z2 = true;
                    boolean z3 = true;
                    for (int i3 = 0; i3 < this.i.length; i3++) {
                        zzhp zzhpVar2 = this.i[i3];
                        if (this.e[i3] && zzhpVar2.o() == 1) {
                            zzhpVar2.b(this.s, false);
                            this.h.add(zzhpVar2);
                            z2 = z2 && zzhpVar2.d();
                            z3 = z3 && a(zzhpVar2);
                            if (j != -1) {
                                long l = zzhpVar2.l();
                                if (l == -1) {
                                    j = -1;
                                } else if (l != -2) {
                                    j = Math.max(j, l);
                                }
                            }
                        }
                    }
                    this.r = j;
                    if (z2) {
                        a(5);
                    } else {
                        a(z3 ? 4 : 3);
                        if (this.l && this.n == 4) {
                            f();
                        }
                    }
                    this.f1910a.sendEmptyMessage(7);
                    return true;
                case 3:
                    boolean z4 = message.arg1 != 0;
                    try {
                        this.m = false;
                        this.l = z4;
                        if (!z4) {
                            g();
                            h();
                        } else if (this.n == 4) {
                            f();
                            this.f1910a.sendEmptyMessage(7);
                        } else if (this.n == 3) {
                            this.f1910a.sendEmptyMessage(7);
                        }
                        this.c.obtainMessage(2).sendToTarget();
                        return true;
                    } catch (Throwable th) {
                        this.c.obtainMessage(2).sendToTarget();
                        throw th;
                    }
                case 4:
                    i();
                    return true;
                case 5:
                    j();
                    a(1);
                    synchronized (this) {
                        this.k = true;
                        notifyAll();
                    }
                    return true;
                case 6:
                    long longValue = ((Long) message.obj).longValue();
                    this.m = false;
                    this.s = longValue * 1000;
                    this.d.b();
                    this.d.a(this.s);
                    if (this.n != 1 && this.n != 2) {
                        for (int i4 = 0; i4 < this.h.size(); i4++) {
                            zzhp zzhpVar3 = this.h.get(i4);
                            b(zzhpVar3);
                            zzhpVar3.a(this.s);
                        }
                        a(3);
                        this.f1910a.sendEmptyMessage(7);
                        return true;
                    }
                    return true;
                case 7:
                    zzkp.beginSection("doSomeWork");
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j2 = this.r != -1 ? this.r : Long.MAX_VALUE;
                    h();
                    long j3 = j2;
                    boolean z5 = true;
                    boolean z6 = true;
                    for (int i5 = 0; i5 < this.h.size(); i5++) {
                        zzhp zzhpVar4 = this.h.get(i5);
                        zzhpVar4.a(this.s, this.q);
                        z5 = z5 && zzhpVar4.d();
                        z6 = z6 && a(zzhpVar4);
                        if (j3 != -1) {
                            long l2 = zzhpVar4.l();
                            long m = zzhpVar4.m();
                            if (m == -1) {
                                j3 = -1;
                            } else if (m != -3 && (l2 == -1 || l2 == -2 || m < l2)) {
                                j3 = Math.min(j3, m);
                            }
                        }
                    }
                    this.t = j3;
                    if (z5) {
                        a(5);
                        g();
                    } else if (this.n == 3 && z6) {
                        a(4);
                        if (this.l) {
                            f();
                        }
                    } else if (this.n == 4 && !z6) {
                        this.m = this.l;
                        a(3);
                        g();
                    }
                    this.f1910a.removeMessages(7);
                    if ((this.l && this.n == 4) || this.n == 3) {
                        a(7, elapsedRealtime2, 10L);
                    } else if (!this.h.isEmpty()) {
                        a(7, elapsedRealtime2, 1000L);
                    }
                    zzkp.endSection();
                    return true;
                case 8:
                    int i6 = message.arg1;
                    boolean z7 = message.arg2 != 0;
                    if (this.e[i6] != z7) {
                        this.e[i6] = z7;
                        if (this.n != 1 && this.n != 2 && ((o = (zzhpVar = this.i[i6]).o()) == 1 || o == 2 || o == 3)) {
                            if (z7) {
                                boolean z8 = this.l && this.n == 4;
                                zzhpVar.b(this.s, z8);
                                this.h.add(zzhpVar);
                                if (z8) {
                                    zzhpVar.p();
                                }
                                this.f1910a.sendEmptyMessage(7);
                            } else {
                                if (zzhpVar == this.j) {
                                    this.d.a(zzhpVar.f());
                                }
                                b(zzhpVar);
                                this.h.remove(zzhpVar);
                                zzhpVar.r();
                            }
                        }
                    }
                    return true;
                case 9:
                    int i7 = message.arg1;
                    try {
                        Pair pair = (Pair) message.obj;
                        ((zzgf) pair.first).zza(i7, pair.second);
                        synchronized (this) {
                            this.p++;
                            notifyAll();
                        }
                        if (this.n != 1 && this.n != 2) {
                            this.f1910a.sendEmptyMessage(7);
                        }
                        return true;
                    } catch (Throwable th2) {
                        synchronized (this) {
                            this.p++;
                            notifyAll();
                            throw th2;
                        }
                    }
                default:
                    return false;
            }
        } catch (zzgd e) {
            Log.e("ExoPlayerImplInternal", "Internal track renderer error.", e);
            this.c.obtainMessage(3, e).sendToTarget();
            i();
            return true;
        } catch (RuntimeException e2) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e2);
            this.c.obtainMessage(3, new zzgd(e2, true)).sendToTarget();
            i();
            return true;
        }
    }

    private final void a(int i) {
        if (this.n != i) {
            this.n = i;
            this.c.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final boolean a(zzhp zzhpVar) {
        if (zzhpVar.d()) {
            return true;
        }
        if (!zzhpVar.e()) {
            return false;
        }
        if (this.n == 4) {
            return true;
        }
        long l = zzhpVar.l();
        long m = zzhpVar.m();
        long j = this.m ? this.g : this.f;
        return j <= 0 || m == -1 || m == -3 || m >= this.s + j || !(l == -1 || l == -2 || m < l);
    }

    private final void f() throws zzgd {
        this.m = false;
        this.d.a();
        for (int i = 0; i < this.h.size(); i++) {
            this.h.get(i).p();
        }
    }

    private final void g() throws zzgd {
        this.d.b();
        for (int i = 0; i < this.h.size(); i++) {
            b(this.h.get(i));
        }
    }

    private final void h() {
        zzhp zzhpVar = this.j;
        if (zzhpVar != null && this.h.contains(zzhpVar) && !this.j.d()) {
            this.s = this.j.f();
            this.d.a(this.s);
        } else {
            this.s = this.d.c();
        }
        this.q = SystemClock.elapsedRealtime() * 1000;
    }

    private final void a(int i, long j, long j2) {
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f1910a.sendEmptyMessage(i);
        } else {
            this.f1910a.sendEmptyMessageDelayed(i, elapsedRealtime);
        }
    }

    private final void i() {
        j();
        a(1);
    }

    private final void j() {
        this.f1910a.removeMessages(7);
        this.f1910a.removeMessages(2);
        int i = 0;
        this.m = false;
        this.d.b();
        if (this.i == null) {
            return;
        }
        while (true) {
            zzhp[] zzhpVarArr = this.i;
            if (i < zzhpVarArr.length) {
                zzhp zzhpVar = zzhpVarArr[i];
                try {
                    b(zzhpVar);
                    if (zzhpVar.o() == 2) {
                        zzhpVar.r();
                    }
                } catch (zzgd e) {
                    Log.e("ExoPlayerImplInternal", "Stop failed.", e);
                } catch (RuntimeException e2) {
                    Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
                }
                try {
                    zzhpVar.s();
                } catch (zzgd e3) {
                    Log.e("ExoPlayerImplInternal", "Release failed.", e3);
                } catch (RuntimeException e4) {
                    Log.e("ExoPlayerImplInternal", "Release failed.", e4);
                }
                i++;
            } else {
                this.i = null;
                this.j = null;
                this.h.clear();
                return;
            }
        }
    }

    private static void b(zzhp zzhpVar) throws zzgd {
        if (zzhpVar.o() == 3) {
            zzhpVar.q();
        }
    }
}
