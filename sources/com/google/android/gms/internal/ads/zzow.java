package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class zzow implements zznn, zznu {

    /* renamed from: a, reason: collision with root package name */
    private static final zznq f3698a = new amr();
    private static final int b = zzsy.zzay("qt  ");
    private int g;
    private int h;
    private long i;
    private int j;
    private zzst k;
    private int l;
    private int m;
    private zznp n;
    private ams[] o;
    private long p;
    private boolean q;
    private final zzst e = new zzst(16);
    private final Stack<amg> f = new Stack<>();
    private final zzst c = new zzst(zzsq.zzaqt);
    private final zzst d = new zzst(4);

    @Override // com.google.android.gms.internal.ads.zznn
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final boolean zzfc() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final boolean zza(zzno zznoVar) throws IOException, InterruptedException {
        return amt.a(zznoVar);
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zza(zznp zznpVar) {
        this.n = zznpVar;
    }

    @Override // com.google.android.gms.internal.ads.zznn
    public final void zzd(long j, long j2) {
        this.f.clear();
        this.j = 0;
        this.l = 0;
        this.m = 0;
        if (j == 0) {
            a();
            return;
        }
        ams[] amsVarArr = this.o;
        if (amsVarArr != null) {
            for (ams amsVar : amsVarArr) {
                amu amuVar = amsVar.b;
                int a2 = amuVar.a(j2);
                if (a2 == -1) {
                    a2 = amuVar.b(j2);
                }
                amsVar.d = a2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:151:0x019a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0006 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zznn
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int zza(com.google.android.gms.internal.ads.zzno r25, com.google.android.gms.internal.ads.zznt r26) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzow.zza(com.google.android.gms.internal.ads.zzno, com.google.android.gms.internal.ads.zznt):int");
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long getDurationUs() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zznu
    public final long zzdq(long j) {
        long j2 = Long.MAX_VALUE;
        for (ams amsVar : this.o) {
            amu amuVar = amsVar.b;
            int a2 = amuVar.a(j);
            if (a2 == -1) {
                a2 = amuVar.b(j);
            }
            long j3 = amuVar.b[a2];
            if (j3 < j2) {
                j2 = j3;
            }
        }
        return j2;
    }

    private final void a() {
        this.g = 0;
        this.j = 0;
    }

    private final void a(long j) throws zzlm {
        zzpa a2;
        while (!this.f.isEmpty() && this.f.peek().az == j) {
            amg pop = this.f.pop();
            if (pop.ay == amf.v) {
                long j2 = -9223372036854775807L;
                ArrayList arrayList = new ArrayList();
                zzpo zzpoVar = null;
                zznr zznrVar = new zznr();
                amh d = pop.d(amf.ak);
                if (d != null && (zzpoVar = ami.a(d, this.q)) != null) {
                    zznrVar.zzb(zzpoVar);
                }
                for (int i = 0; i < pop.aB.size(); i++) {
                    amg amgVar = pop.aB.get(i);
                    if (amgVar.ay == amf.x && (a2 = ami.a(amgVar, pop.d(amf.w), -9223372036854775807L, (zzne) null, this.q)) != null) {
                        amu a3 = ami.a(a2, amgVar.e(amf.y).e(amf.z).e(amf.A), zznrVar);
                        if (a3.f1977a != 0) {
                            ams amsVar = new ams(a2, a3, this.n.zzd(i, a2.type));
                            zzlh zzae = a2.zzaue.zzae(a3.d + 30);
                            if (a2.type == 1) {
                                if (zznrVar.zzii()) {
                                    zzae = zzae.zzc(zznrVar.zzaty, zznrVar.zzatz);
                                }
                                if (zzpoVar != null) {
                                    zzae = zzae.zza(zzpoVar);
                                }
                            }
                            amsVar.c.zze(zzae);
                            j2 = Math.max(j2, a2.zzack);
                            arrayList.add(amsVar);
                        }
                    }
                }
                this.p = j2;
                this.o = (ams[]) arrayList.toArray(new ams[arrayList.size()]);
                this.n.zzfi();
                this.n.zza(this);
                this.f.clear();
                this.g = 2;
            } else if (!this.f.isEmpty()) {
                this.f.peek().aB.add(pop);
            }
        }
        if (this.g != 2) {
            a();
        }
    }
}
