package com.google.android.gms.internal.firebase_remote_config;

import java.util.List;

/* loaded from: classes2.dex */
final class cp extends cl {
    private cp() {
        super();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.cl
    public final <L> List<L> a(Object obj, long j) {
        zzhn c = c(obj, j);
        if (c.zzet()) {
            return c;
        }
        int size = c.size();
        zzhn zzu = c.zzu(size == 0 ? 10 : size << 1);
        eh.a(obj, j, zzu);
        return zzu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.cl
    public final void b(Object obj, long j) {
        c(obj, j).zzeu();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_remote_config.cl
    public final <E> void a(Object obj, Object obj2, long j) {
        zzhn c = c(obj, j);
        zzhn c2 = c(obj2, j);
        int size = c.size();
        int size2 = c2.size();
        if (size > 0 && size2 > 0) {
            if (!c.zzet()) {
                c = c.zzu(size2 + size);
            }
            c.addAll(c2);
        }
        if (size > 0) {
            c2 = c;
        }
        eh.a(obj, j, c2);
    }

    private static <E> zzhn<E> c(Object obj, long j) {
        return (zzhn) eh.f(obj, j);
    }
}
