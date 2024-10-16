package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzy<T> {
    public final T result;
    public final zzc zzbh;
    public final zzaf zzbi;
    public boolean zzbj;

    public static <T> zzy<T> zza(T t, zzc zzcVar) {
        return new zzy<>(t, zzcVar);
    }

    public static <T> zzy<T> zzc(zzaf zzafVar) {
        return new zzy<>(zzafVar);
    }

    private zzy(T t, zzc zzcVar) {
        this.zzbj = false;
        this.result = t;
        this.zzbh = zzcVar;
        this.zzbi = null;
    }

    private zzy(zzaf zzafVar) {
        this.zzbj = false;
        this.result = null;
        this.zzbh = null;
        this.zzbi = zzafVar;
    }
}
