package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class cs<T> implements da<T> {

    /* renamed from: a, reason: collision with root package name */
    private final zzsk f4338a;
    private final dr<?, ?> b;
    private final boolean c;
    private final bp<?> d;

    private cs(dr<?, ?> drVar, bp<?> bpVar, zzsk zzskVar) {
        this.b = drVar;
        this.c = bpVar.a(zzskVar);
        this.d = bpVar;
        this.f4338a = zzskVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> cs<T> a(dr<?, ?> drVar, bp<?> bpVar, zzsk zzskVar) {
        return new cs<>(drVar, bpVar, zzskVar);
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final T a() {
        return (T) this.f4338a.zzph().zzpl();
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final boolean a(T t, T t2) {
        if (!this.b.b(t).equals(this.b.b(t2))) {
            return false;
        }
        if (this.c) {
            return this.d.a(t).equals(this.d.a(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final int a(T t) {
        int hashCode = this.b.b(t).hashCode();
        return this.c ? (hashCode * 53) + this.d.a(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final void b(T t, T t2) {
        dc.a(this.b, t, t2);
        if (this.c) {
            dc.a(this.d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final void a(T t, ed edVar) throws IOException {
        Iterator<Map.Entry<?, Object>> d = this.d.a(t).d();
        while (d.hasNext()) {
            Map.Entry<?, Object> next = d.next();
            zzqv zzqvVar = (zzqv) next.getKey();
            if (zzqvVar.zzoy() != zzul.MESSAGE || zzqvVar.zzoz() || zzqvVar.zzpa()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof ca) {
                edVar.a(zzqvVar.zzc(), (Object) ((ca) next).a().zzmv());
            } else {
                edVar.a(zzqvVar.zzc(), next.getValue());
            }
        }
        dr<?, ?> drVar = this.b;
        drVar.b((dr<?, ?>) drVar.b(t), edVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.gtm.da
    public final void a(T t, cz czVar, zzqp zzqpVar) throws IOException {
        boolean z;
        dr<?, ?> drVar = this.b;
        bp<?> bpVar = this.d;
        Object c = drVar.c(t);
        bs<?> b = bpVar.b(t);
        do {
            try {
                if (czVar.a() == Integer.MAX_VALUE) {
                    return;
                }
                int b2 = czVar.b();
                if (b2 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzps zzpsVar = null;
                    while (czVar.a() != Integer.MAX_VALUE) {
                        int b3 = czVar.b();
                        if (b3 == 16) {
                            i = czVar.o();
                            obj = bpVar.a(zzqpVar, this.f4338a, i);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                bpVar.a(czVar, obj, zzqpVar, b);
                            } else {
                                zzpsVar = czVar.n();
                            }
                        } else if (!czVar.c()) {
                            break;
                        }
                    }
                    if (czVar.b() != 12) {
                        throw zzrk.d();
                    }
                    if (zzpsVar != null) {
                        if (obj != null) {
                            bpVar.a(zzpsVar, obj, zzqpVar, b);
                        } else {
                            drVar.a((dr<?, ?>) c, i, zzpsVar);
                        }
                    }
                } else if ((b2 & 7) == 2) {
                    Object a2 = bpVar.a(zzqpVar, this.f4338a, b2 >>> 3);
                    if (a2 != null) {
                        bpVar.a(czVar, a2, zzqpVar, b);
                    } else {
                        z = drVar.a((dr<?, ?>) c, czVar);
                    }
                } else {
                    z = czVar.c();
                }
                z = true;
            } finally {
                drVar.b((Object) t, (T) c);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final void c(T t) {
        this.b.d(t);
        this.d.c(t);
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final boolean d(T t) {
        return this.d.a(t).f();
    }

    @Override // com.google.android.gms.internal.gtm.da
    public final int b(T t) {
        dr<?, ?> drVar = this.b;
        int e = drVar.e(drVar.b(t)) + 0;
        return this.c ? e + this.d.a(t).g() : e;
    }
}
