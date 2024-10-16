package com.google.android.gms.internal.gtm;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzsc<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzqj zzqjVar, ck<K, V> ckVar, K k, V v) throws IOException {
        bs.a(zzqjVar, ckVar.f4335a, 1, k);
        bs.a(zzqjVar, ckVar.c, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(ck<K, V> ckVar, K k, V v) {
        return bs.a(ckVar.f4335a, 1, k) + bs.a(ckVar.c, 2, v);
    }
}
