package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdtj<T> implements zzdte<T>, zzdti<T> {

    /* renamed from: a, reason: collision with root package name */
    private static final zzdtj<Object> f3620a = new zzdtj<>(null);
    private final T b;

    public static <T> zzdti<T> zzar(T t) {
        return new zzdtj(zzdto.zza(t, "instance cannot be null"));
    }

    private zzdtj(T t) {
        this.b = t;
    }

    @Override // com.google.android.gms.internal.ads.zzdte, com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        return this.b;
    }
}
