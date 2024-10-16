package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbpf<AdT> implements zzbpe<AdT> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, zzcjv<AdT>> f2990a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpf(Map<String, zzcjv<AdT>> map) {
        this.f2990a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final zzcjv<AdT> zze(int i, String str) {
        return this.f2990a.get(str);
    }
}
