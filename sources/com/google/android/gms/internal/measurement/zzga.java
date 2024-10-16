package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzga<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzee zzeeVar, cu<K, V> cuVar, K k, V v) throws IOException {
        cb.a(zzeeVar, cuVar.f4510a, 1, k);
        cb.a(zzeeVar, cuVar.c, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(cu<K, V> cuVar, K k, V v) {
        return cb.a(cuVar.f4510a, 1, k) + cb.a(cuVar.c, 2, v);
    }
}
