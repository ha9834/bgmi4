package com.google.android.gms.tagmanager;

import android.util.LruCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
public final class ay<K, V> extends LruCache<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzs f5084a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, int i, zzs zzsVar) {
        super(i);
        this.f5084a = zzsVar;
    }

    @Override // android.util.LruCache
    protected final int sizeOf(K k, V v) {
        return this.f5084a.sizeOf(k, v);
    }
}
