package com.google.android.gms.internal.firebase_remote_config;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzie<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzgo zzgoVar, ct<K, V> ctVar, K k, V v) throws IOException {
        cd.a(zzgoVar, ctVar.f4068a, 1, k);
        cd.a(zzgoVar, ctVar.c, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(ct<K, V> ctVar, K k, V v) {
        return cd.a(ctVar.f4068a, 1, k) + cd.a(ctVar.c, 2, v);
    }
}
