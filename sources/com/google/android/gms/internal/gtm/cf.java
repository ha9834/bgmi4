package com.google.android.gms.internal.gtm;

import java.util.List;

/* loaded from: classes2.dex */
final class cf extends cc {
    private cf() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cc
    public final <L> List<L> a(Object obj, long j) {
        zzrj c = c(obj, j);
        if (c.zzmy()) {
            return c;
        }
        int size = c.size();
        zzrj zzaj = c.zzaj(size == 0 ? 10 : size << 1);
        dv.a(obj, j, zzaj);
        return zzaj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cc
    public final void b(Object obj, long j) {
        c(obj, j).zzmi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.gtm.cc
    public final <E> void a(Object obj, Object obj2, long j) {
        zzrj c = c(obj, j);
        zzrj c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.zzmy()) {
                c = c.zzaj(size2 + size);
            }
            c.addAll(c2);
        }
        if (size > 0) {
            c2 = c;
        }
        dv.a(obj, j, c2);
    }

    private static <E> zzrj<E> c(Object obj, long j) {
        return (zzrj) dv.f(obj, j);
    }
}
