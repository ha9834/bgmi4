package com.google.android.gms.internal.measurement;

import java.util.List;

/* loaded from: classes2.dex */
final class co extends cn {
    private co() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.cn
    public final <L> List<L> a(Object obj, long j) {
        zzff c = c(obj, j);
        if (c.zzrx()) {
            return c;
        }
        int size = c.size();
        zzff zzap = c.zzap(size == 0 ? 10 : size << 1);
        eg.a(obj, j, zzap);
        return zzap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.cn
    public final void b(Object obj, long j) {
        c(obj, j).zzry();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.cn
    public final <E> void a(Object obj, Object obj2, long j) {
        zzff c = c(obj, j);
        zzff c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.zzrx()) {
                c = c.zzap(size2 + size);
            }
            c.addAll(c2);
        }
        if (size > 0) {
            c2 = c;
        }
        eg.a(obj, j, c2);
    }

    private static <E> zzff<E> c(Object obj, long j) {
        return (zzff) eg.f(obj, j);
    }
}
