package com.google.android.gms.internal.ads;

import javax.annotation.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
final class hs<T> implements zzban<T> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ zzbbv f2224a;
    private final /* synthetic */ zzbbt b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public hs(zzbbw zzbbwVar, zzbbv zzbbvVar, zzbbt zzbbtVar) {
        this.f2224a = zzbbvVar;
        this.b = zzbbtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzk(@Nullable T t) {
        this.f2224a.zzh(t);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void zzb(Throwable th) {
        this.b.run();
    }
}
