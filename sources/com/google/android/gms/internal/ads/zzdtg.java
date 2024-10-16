package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzdtg<T> implements zzdti<T> {

    /* renamed from: a, reason: collision with root package name */
    private zzdtu<T> f3618a;

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final T get() {
        zzdtu<T> zzdtuVar = this.f3618a;
        if (zzdtuVar == null) {
            throw new IllegalStateException();
        }
        return zzdtuVar.get();
    }

    public static <T> void zzav(zzdtu<T> zzdtuVar, zzdtu<T> zzdtuVar2) {
        zzdto.checkNotNull(zzdtuVar2);
        zzdtg zzdtgVar = (zzdtg) zzdtuVar;
        if (zzdtgVar.f3618a != null) {
            throw new IllegalStateException();
        }
        zzdtgVar.f3618a = zzdtuVar2;
    }
}
