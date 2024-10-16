package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class dd<T> implements dl<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzgi f4514a;
    private final ed<?, ?> b;
    private final boolean c;
    private final ca<?> d;

    private dd(ed<?, ?> edVar, ca<?> caVar, zzgi zzgiVar) {
        this.b = edVar;
        this.c = caVar.a(zzgiVar);
        this.d = caVar;
        this.f4514a = zzgiVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> dd<T> a(ed<?, ?> edVar, ca<?> caVar, zzgi zzgiVar) {
        return new dd<>(edVar, caVar, zzgiVar);
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final T a() {
        return (T) this.f4514a.zzup().zzuf();
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final void b(T t, T t2) {
        dn.a(this.b, t, t2);
        if (this.c) {
            dn.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final void a(T t, ep epVar) throws IOException {
        Iterator<Map.Entry<?, Object>> d = this.d.a(t).d();
        while (d.hasNext()) {
            Map.Entry<?, Object> next = d.next();
            zzeq zzeqVar = (zzeq) next.getKey();
            if (zzeqVar.zztx() != zzij.MESSAGE || zzeqVar.zzty() || zzeqVar.zztz()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof cj) {
                epVar.a(zzeqVar.zzlg(), (Object) ((cj) next).a().zzrs());
            } else {
                epVar.a(zzeqVar.zzlg(), next.getValue());
            }
        }
        ed<?, ?> edVar = this.b;
        edVar.b((ed<?, ?>) edVar.b(t), epVar);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x005f. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0097 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(T r9, byte[] r10, int r11, int r12, com.google.android.gms.internal.measurement.bh r13) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            com.google.android.gms.internal.measurement.zzey r0 = (com.google.android.gms.internal.measurement.zzey) r0
            com.google.android.gms.internal.measurement.zzhs r1 = r0.zzahz
            com.google.android.gms.internal.measurement.zzhs r2 = com.google.android.gms.internal.measurement.zzhs.zzwq()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.zzhs r1 = com.google.android.gms.internal.measurement.zzhs.a()
            r0.zzahz = r1
        L11:
            com.google.android.gms.internal.measurement.zzey$zzb r9 = (com.google.android.gms.internal.measurement.zzey.zzb) r9
            r9.a()
            r9 = 0
            r0 = r9
        L18:
            if (r11 >= r12) goto La2
            int r4 = com.google.android.gms.internal.measurement.bi.a(r10, r11, r13)
            int r2 = r13.f4486a
            r11 = 11
            r3 = 2
            if (r2 == r11) goto L51
            r11 = r2 & 7
            if (r11 != r3) goto L4c
            com.google.android.gms.internal.measurement.ca<?> r11 = r8.d
            com.google.android.gms.internal.measurement.zzel r0 = r13.d
            com.google.android.gms.internal.measurement.zzgi r3 = r8.f4514a
            int r5 = r2 >>> 3
            java.lang.Object r11 = r11.a(r0, r3, r5)
            r0 = r11
            com.google.android.gms.internal.measurement.zzey$zze r0 = (com.google.android.gms.internal.measurement.zzey.zze) r0
            if (r0 != 0) goto L43
            r3 = r10
            r5 = r12
            r6 = r1
            r7 = r13
            int r11 = com.google.android.gms.internal.measurement.bi.a(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.dh.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L4c:
            int r11 = com.google.android.gms.internal.measurement.bi.a(r2, r10, r4, r12, r13)
            goto L18
        L51:
            r11 = 0
            r2 = r9
        L53:
            if (r4 >= r12) goto L97
            int r4 = com.google.android.gms.internal.measurement.bi.a(r10, r4, r13)
            int r5 = r13.f4486a
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
            int r4 = com.google.android.gms.internal.measurement.bi.e(r10, r4, r13)
            java.lang.Object r2 = r13.c
            com.google.android.gms.internal.measurement.zzdp r2 = (com.google.android.gms.internal.measurement.zzdp) r2
            goto L53
        L70:
            com.google.android.gms.internal.measurement.dh.a()
            java.lang.NoSuchMethodError r9 = new java.lang.NoSuchMethodError
            r9.<init>()
            throw r9
        L79:
            if (r7 != 0) goto L8e
            int r4 = com.google.android.gms.internal.measurement.bi.a(r10, r4, r13)
            int r11 = r13.f4486a
            com.google.android.gms.internal.measurement.ca<?> r0 = r8.d
            com.google.android.gms.internal.measurement.zzel r5 = r13.d
            com.google.android.gms.internal.measurement.zzgi r6 = r8.f4514a
            java.lang.Object r0 = r0.a(r5, r6, r11)
            com.google.android.gms.internal.measurement.zzey$zze r0 = (com.google.android.gms.internal.measurement.zzey.zze) r0
            goto L53
        L8e:
            r6 = 12
            if (r5 == r6) goto L97
            int r4 = com.google.android.gms.internal.measurement.bi.a(r5, r10, r4, r12, r13)
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
            com.google.android.gms.internal.measurement.zzfi r9 = com.google.android.gms.internal.measurement.zzfi.h()
            throw r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.dd.a(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.bh):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.dl
    public final void a(T t, dm dmVar, zzel zzelVar) throws IOException {
        boolean z;
        ed<?, ?> edVar = this.b;
        ca<?> caVar = this.d;
        Object c = edVar.c(t);
        cb<?> b = caVar.b(t);
        do {
            try {
                if (dmVar.a() == Integer.MAX_VALUE) {
                    return;
                }
                int b2 = dmVar.b();
                if (b2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdp zzdpVar = null;
                    while (dmVar.a() != Integer.MAX_VALUE) {
                        int b3 = dmVar.b();
                        if (b3 == 16) {
                            i = dmVar.o();
                            obj = caVar.a(zzelVar, this.f4514a, i);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                caVar.a(dmVar, obj, zzelVar, b);
                            } else {
                                zzdpVar = dmVar.n();
                            }
                        } else if (!dmVar.c()) {
                            break;
                        }
                    }
                    if (dmVar.b() != 12) {
                        throw zzfi.e();
                    }
                    if (zzdpVar != null) {
                        if (obj != null) {
                            caVar.a(zzdpVar, obj, zzelVar, b);
                        } else {
                            edVar.a((ed<?, ?>) c, i, zzdpVar);
                        }
                    }
                } else if ((b2 & 7) == 2) {
                    Object a2 = caVar.a(zzelVar, this.f4514a, b2 >>> 3);
                    if (a2 != null) {
                        caVar.a(dmVar, a2, zzelVar, b);
                    } else {
                        z = edVar.a((ed<?, ?>) c, dmVar);
                    }
                } else {
                    z = dmVar.c();
                }
                z = true;
            } finally {
                edVar.b((Object) t, (T) c);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final void c(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final boolean d(T t) {
        return this.d.a(t).f();
    }

    @Override // com.google.android.gms.internal.measurement.dl
    public final int b(T t) {
        ed<?, ?> edVar = this.b;
        int e = edVar.e(edVar.b(t)) + 0;
        return this.c ? e + this.d.a(t).g() : e;
    }
}
