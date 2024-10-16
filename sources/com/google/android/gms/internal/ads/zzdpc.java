package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class zzdpc<K, V> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void a(zzdni zzdniVar, age<K, V> ageVar, K k, V v) throws IOException {
        afk.a(zzdniVar, ageVar.f1862a, 1, k);
        afk.a(zzdniVar, ageVar.c, 2, v);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> int a(age<K, V> ageVar, K k, V v) {
        return afk.a(ageVar.f1862a, 1, k) + afk.a(ageVar.c, 2, v);
    }
}
