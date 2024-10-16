package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class db<T> implements dm<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzim f4072a;
    private final ec<?, ?> b;
    private final boolean c;
    private final by<?> d;

    private db(ec<?, ?> ecVar, by<?> byVar, zzim zzimVar) {
        this.b = ecVar;
        this.c = byVar.a(zzimVar);
        this.d = byVar;
        this.f4072a = zzimVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> db<T> a(ec<?, ?> ecVar, by<?> byVar, zzim zzimVar) {
        return new db<>(ecVar, byVar, zzimVar);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final T a() {
        return (T) this.f4072a.zzhb().zzgv();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final void b(T t, T t2) {
        Cdo.a(this.b, t, t2);
        if (this.c) {
            Cdo.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final void a(T t, eo eoVar) throws IOException {
        Iterator<Map.Entry<?, Object>> d = this.d.a(t).d();
        while (d.hasNext()) {
            Map.Entry<?, Object> next = d.next();
            zzhc zzhcVar = (zzhc) next.getKey();
            if (zzhcVar.zzgp() != zzkr.MESSAGE || zzhcVar.zzgq() || zzhcVar.zzgr()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof ck) {
                eoVar.a(zzhcVar.zzgn(), (Object) ((ck) next).a().zzeo());
            } else {
                eoVar.a(zzhcVar.zzgn(), next.getValue());
            }
        }
        ec<?, ?> ecVar = this.b;
        ecVar.b((ec<?, ?>) ecVar.b(t), eoVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x005f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.firebase_remote_config.bd r13) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.firebase_remote_config.zzhh r0 = (com.google.android.gms.internal.firebase_remote_config.zzhh) r0
            com.google.android.gms.internal.firebase_remote_config.zzjw r1 = r0.zztg
            com.google.android.gms.internal.firebase_remote_config.zzjw r2 = com.google.android.gms.internal.firebase_remote_config.zzjw.zziz()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.firebase_remote_config.zzjw r1 = com.google.android.gms.internal.firebase_remote_config.zzjw.a()
            r0.zztg = r1
        L11:
            com.google.android.gms.internal.firebase_remote_config.zzhh$zzb r9 = (com.google.android.gms.internal.firebase_remote_config.zzhh.zzb) r9
            r9.a()
            r9 = 0
            r0 = r9
        L18:
            if (r11 >= r12) goto La2
            int r4 = com.google.android.gms.internal.firebase_remote_config.be.a(r10, r11, r13)
            int r2 = r13.f4042a
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L51
            r11 = r2 & 7
            if (r11 != r3) goto L4c
            com.google.android.gms.internal.firebase_remote_config.by<?> r11 = r8.d
            com.google.android.gms.internal.firebase_remote_config.zzgu r0 = r13.d
            com.google.android.gms.internal.firebase_remote_config.zzim r3 = r8.f4072a
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.a(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.firebase_remote_config.zzhh$zze r0 = (com.google.android.gms.internal.firebase_remote_config.zzhh.zze) r0
            if (r0 != 0) goto L43
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.firebase_remote_config.be.a(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.firebase_remote_config.di.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L4c:
            int r11 = com.google.android.gms.internal.firebase_remote_config.be.a(r2, r10, r4, r12, r13)
            goto L18
        L51:
            r11 = 0
            r2 = r9
        L53:
            if (r4 >= r12) goto L97
            int r4 = com.google.android.gms.internal.firebase_remote_config.be.a(r10, r4, r13)
            int r5 = r13.f4042a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            switch(r6) {
                case 2: goto L79;
                case 3: goto L63;
                default: goto L62;
            }
        L62:
            goto L8e
        L63:
            if (r0 != 0) goto L70
            if (r7 != r3) goto L8e
            int r4 = com.google.android.gms.internal.firebase_remote_config.be.e(r10, r4, r13)
            java.lang.Object r2 = r13.c
            com.google.android.gms.internal.firebase_remote_config.zzfx r2 = (com.google.android.gms.internal.firebase_remote_config.zzfx) r2
            goto L53
        L70:
            com.google.android.gms.internal.firebase_remote_config.di.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L79:
            if (r7 != 0) goto L8e
            int r4 = com.google.android.gms.internal.firebase_remote_config.be.a(r10, r4, r13)
            int r11 = r13.f4042a
            com.google.android.gms.internal.firebase_remote_config.by<?> r0 = r8.d
            com.google.android.gms.internal.firebase_remote_config.zzgu r5 = r13.d
            com.google.android.gms.internal.firebase_remote_config.zzim r6 = r8.f4072a
            java.lang.Object r0 = r0.a(r5, r6, r11)
            com.google.android.gms.internal.firebase_remote_config.zzhh$zze r0 = (com.google.android.gms.internal.firebase_remote_config.zzhh.zze) r0
            goto L53
        L8e:
            r6 = 12
            if (r5 == r6) goto L97
            int r4 = com.google.android.gms.internal.firebase_remote_config.be.a(r5, r10, r4, r12, r13)
            goto L53
        L97:
            if (r2 == 0) goto L9f
            int r11 = r11 << 3
            r11 = r11 | r3
            r1.a(r11, r2)
        L9f:
            r11 = r4
            goto L18
        La2:
            if (r11 != r12) goto La5
            return
        La5:
            com.google.android.gms.internal.firebase_remote_config.zzhm r9 = com.google.android.gms.internal.firebase_remote_config.zzhm.h()
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_remote_config.db.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.firebase_remote_config.bd):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final void a(T t, dj djVar, zzgu zzguVar) throws IOException {
        boolean z;
        ec<?, ?> ecVar = this.b;
        by<?> byVar = this.d;
        Object c = ecVar.c(t);
        cd<?> b = byVar.b(t);
        do {
            try {
                if (djVar.a() == Integer.MAX_VALUE) {
                    return;
                }
                int b2 = djVar.b();
                if (b2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzfx zzfxVar = null;
                    while (djVar.a() != Integer.MAX_VALUE) {
                        int b3 = djVar.b();
                        if (b3 == 16) {
                            i = djVar.o();
                            obj = byVar.a(zzguVar, this.f4072a, i);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                byVar.a(djVar, obj, zzguVar, b);
                            } else {
                                zzfxVar = djVar.n();
                            }
                        } else if (!djVar.c()) {
                            break;
                        }
                    }
                    if (djVar.b() != 12) {
                        throw zzhm.e();
                    }
                    if (zzfxVar != null) {
                        if (obj != null) {
                            byVar.a(zzfxVar, obj, zzguVar, b);
                        } else {
                            ecVar.a((ec<?, ?>) c, i, zzfxVar);
                        }
                    }
                } else if ((b2 & 7) == 2) {
                    Object a2 = byVar.a(zzguVar, this.f4072a, b2 >>> 3);
                    if (a2 != null) {
                        byVar.a(djVar, a2, zzguVar, b);
                    } else {
                        z = ecVar.a((ec<?, ?>) c, djVar);
                    }
                } else {
                    z = djVar.c();
                }
                z = true;
            } finally {
                ecVar.b((Object) t, (T) c);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final void c(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final boolean d(T t) {
        return this.d.a(t).f();
    }

    @Override // com.google.android.gms.internal.firebase_remote_config.dm
    public final int b(T t) {
        ec<?, ?> ecVar = this.b;
        int e = ecVar.e(ecVar.b(t)) + 0;
        return this.c ? e + this.d.a(t).g() : e;
    }
}
