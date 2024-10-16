package com.google.android.gms.tagmanager;

import android.annotation.TargetApi;
import android.util.LruCache;
import com.amazonaws.services.s3.internal.Constants;

@TargetApi(12)
/* loaded from: classes2.dex */
final class ax<K, V> implements eh<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private LruCache<K, V> f5083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(int i, zzs<K, V> zzsVar) {
        this.f5083a = new ay(this, Constants.MB, zzsVar);
    }

    @Override // com.google.android.gms.tagmanager.eh
    public final void a(K k, V v) {
        this.f5083a.put(k, v);
    }

    @Override // com.google.android.gms.tagmanager.eh
    public final V a(K k) {
        return this.f5083a.get(k);
    }
}
