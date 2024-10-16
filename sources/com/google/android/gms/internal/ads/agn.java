package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class agn<T> implements agx<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdpk f1866a;
    private final aho<?, ?> b;
    private final boolean c;
    private final afh<?> d;

    private agn(aho<?, ?> ahoVar, afh<?> afhVar, zzdpk zzdpkVar) {
        this.b = ahoVar;
        this.c = afhVar.a(zzdpkVar);
        this.d = afhVar;
        this.f1866a = zzdpkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> agn<T> a(aho<?, ?> ahoVar, afh<?> afhVar, zzdpk zzdpkVar) {
        return new agn<>(ahoVar, afhVar, zzdpkVar);
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final T a() {
        return (T) this.f1866a.zzaxu().zzaxz();
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final void b(T t, T t2) {
        agz.a(this.b, t, t2);
        if (this.c) {
            agz.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final void a(T t, aib aibVar) throws IOException {
        Iterator<Map.Entry<?, Object>> e = this.d.a(t).e();
        while (e.hasNext()) {
            Map.Entry<?, Object> next = e.next();
            zzdnu zzdnuVar = (zzdnu) next.getKey();
            if (zzdnuVar.zzaxm() != zzdrn.MESSAGE || zzdnuVar.zzaxn() || zzdnuVar.zzaxo()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof aft) {
                aibVar.a(zzdnuVar.zzac(), (Object) ((aft) next).a().zzavf());
            } else {
                aibVar.a(zzdnuVar.zzac(), next.getValue());
            }
        }
        aho<?, ?> ahoVar = this.b;
        ahoVar.b((aho<?, ?>) ahoVar.b(t), aibVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0070. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00aa  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.ads.aep r13) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.ads.zzdob r0 = (com.google.android.gms.internal.ads.zzdob) r0
            com.google.android.gms.internal.ads.zzdqu r1 = r0.zzhhd
            com.google.android.gms.internal.ads.zzdqu r2 = com.google.android.gms.internal.ads.zzdqu.zzazz()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.ads.zzdqu r1 = com.google.android.gms.internal.ads.zzdqu.a()
            r0.zzhhd = r1
        L11:
            com.google.android.gms.internal.ads.zzdob$zzc r9 = (com.google.android.gms.internal.ads.zzdob.zzc) r9
            com.google.android.gms.internal.ads.afk<java.lang.Object> r0 = r9.zzhhj
            boolean r0 = r0.d()
            if (r0 == 0) goto L25
            com.google.android.gms.internal.ads.afk<java.lang.Object> r0 = r9.zzhhj
            java.lang.Object r0 = r0.clone()
            com.google.android.gms.internal.ads.afk r0 = (com.google.android.gms.internal.ads.afk) r0
            r9.zzhhj = r0
        L25:
            com.google.android.gms.internal.ads.afk<java.lang.Object> r9 = r9.zzhhj
            r9 = 0
            r0 = r9
        L29:
            if (r11 >= r12) goto Lb3
            int r4 = com.google.android.gms.internal.ads.aeo.a(r10, r11, r13)
            int r2 = r13.f1835a
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L62
            r11 = r2 & 7
            if (r11 != r3) goto L5d
            com.google.android.gms.internal.ads.afh<?> r11 = r8.d
            com.google.android.gms.internal.ads.zzdno r0 = r13.d
            com.google.android.gms.internal.ads.zzdpk r3 = r8.f1866a
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.a(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.ads.zzdob$zzd r0 = (com.google.android.gms.internal.ads.zzdob.zzd) r0
            if (r0 != 0) goto L54
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.ads.aeo.a(r2, r3, r4, r5, r6, r7)
            goto L29
        L54:
            com.google.android.gms.internal.ads.ags.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L5d:
            int r11 = com.google.android.gms.internal.ads.aeo.a(r2, r10, r4, r12, r13)
            goto L29
        L62:
            r11 = 0
            r2 = r9
        L64:
            if (r4 >= r12) goto La8
            int r4 = com.google.android.gms.internal.ads.aeo.a(r10, r4, r13)
            int r5 = r13.f1835a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            switch(r6) {
                case 2: goto L8a;
                case 3: goto L74;
                default: goto L73;
            }
        L73:
            goto L9f
        L74:
            if (r0 != 0) goto L81
            if (r7 != r3) goto L9f
            int r4 = com.google.android.gms.internal.ads.aeo.e(r10, r4, r13)
            java.lang.Object r2 = r13.c
            com.google.android.gms.internal.ads.zzdmr r2 = (com.google.android.gms.internal.ads.zzdmr) r2
            goto L64
        L81:
            com.google.android.gms.internal.ads.ags.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L8a:
            if (r7 != 0) goto L9f
            int r4 = com.google.android.gms.internal.ads.aeo.a(r10, r4, r13)
            int r11 = r13.f1835a
            com.google.android.gms.internal.ads.afh<?> r0 = r8.d
            com.google.android.gms.internal.ads.zzdno r5 = r13.d
            com.google.android.gms.internal.ads.zzdpk r6 = r8.f1866a
            java.lang.Object r0 = r0.a(r5, r6, r11)
            com.google.android.gms.internal.ads.zzdob$zzd r0 = (com.google.android.gms.internal.ads.zzdob.zzd) r0
            goto L64
        L9f:
            r6 = 12
            if (r5 == r6) goto La8
            int r4 = com.google.android.gms.internal.ads.aeo.a(r5, r10, r4, r12, r13)
            goto L64
        La8:
            if (r2 == 0) goto Lb0
            int r11 = r11 << 3
            r11 = r11 | r3
            r1.a(r11, r2)
        Lb0:
            r11 = r4
            goto L29
        Lb3:
            if (r11 != r12) goto Lb6
            return
        Lb6:
            com.google.android.gms.internal.ads.zzdok r9 = com.google.android.gms.internal.ads.zzdok.g()
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.agn.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.aep):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads.agx
    public final void a(T t, agw agwVar, zzdno zzdnoVar) throws IOException {
        boolean z;
        aho<?, ?> ahoVar = this.b;
        afh<?> afhVar = this.d;
        Object c = ahoVar.c(t);
        afk<?> b = afhVar.b(t);
        do {
            try {
                if (agwVar.a() == Integer.MAX_VALUE) {
                    return;
                }
                int b2 = agwVar.b();
                if (b2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdmr zzdmrVar = null;
                    while (agwVar.a() != Integer.MAX_VALUE) {
                        int b3 = agwVar.b();
                        if (b3 == 16) {
                            i = agwVar.o();
                            obj = afhVar.a(zzdnoVar, this.f1866a, i);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                afhVar.a(agwVar, obj, zzdnoVar, b);
                            } else {
                                zzdmrVar = agwVar.n();
                            }
                        } else if (!agwVar.c()) {
                            break;
                        }
                    }
                    if (agwVar.b() != 12) {
                        throw zzdok.e();
                    }
                    if (zzdmrVar != null) {
                        if (obj != null) {
                            afhVar.a(zzdmrVar, obj, zzdnoVar, b);
                        } else {
                            ahoVar.a((aho<?, ?>) c, i, zzdmrVar);
                        }
                    }
                } else if ((b2 & 7) == 2) {
                    Object a2 = afhVar.a(zzdnoVar, this.f1866a, b2 >>> 3);
                    if (a2 != null) {
                        afhVar.a(agwVar, a2, zzdnoVar, b);
                    } else {
                        z = ahoVar.a((aho<?, ?>) c, agwVar);
                    }
                } else {
                    z = agwVar.c();
                }
                z = true;
            } finally {
                ahoVar.b((Object) t, (T) c);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final void c(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final boolean d(T t) {
        return this.d.a(t).g();
    }

    @Override // com.google.android.gms.internal.ads.agx
    public final int b(T t) {
        aho<?, ?> ahoVar = this.b;
        int e = ahoVar.e(ahoVar.b(t)) + 0;
        return this.c ? e + this.d.a(t).i() : e;
    }
}
