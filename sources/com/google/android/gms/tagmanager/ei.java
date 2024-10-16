package com.google.android.gms.tagmanager;

import com.amazonaws.services.s3.internal.Constants;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
/* loaded from: classes2.dex */
final class ei<K, V> {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    private final zzs<K, V> f5138a = new ej(this);

    public static eh<K, V> a(int i, zzs<K, V> zzsVar) {
        return new ax(Constants.MB, zzsVar);
    }
}
