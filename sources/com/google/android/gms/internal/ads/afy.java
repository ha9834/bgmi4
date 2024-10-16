package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
final class afy extends afv {
    private afy() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afv
    public final <L> List<L> a(Object obj, long j) {
        zzdoj c = c(obj, j);
        if (c.zzavi()) {
            return c;
        }
        int size = c.size();
        zzdoj zzfl = c.zzfl(size == 0 ? 10 : size << 1);
        ahs.a(obj, j, zzfl);
        return zzfl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afv
    public final void b(Object obj, long j) {
        c(obj, j).zzavj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.afv
    public final <E> void a(Object obj, Object obj2, long j) {
        zzdoj c = c(obj, j);
        zzdoj c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.zzavi()) {
                c = c.zzfl(size2 + size);
            }
            c.addAll(c2);
        }
        if (size > 0) {
            c2 = c;
        }
        ahs.a(obj, j, c2);
    }

    private static <E> zzdoj<E> c(Object obj, long j) {
        return (zzdoj) ahs.f(obj, j);
    }
}
