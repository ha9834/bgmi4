package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbuh implements zzdti<Set<zzbuz<zzbsr>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3056a;

    private zzbuh(zzbtv zzbtvVar) {
        this.f3056a = zzbtvVar;
    }

    public static zzbuh zzn(zzbtv zzbtvVar) {
        return new zzbuh(zzbtvVar);
    }

    public static Set<zzbuz<zzbsr>> zzo(zzbtv zzbtvVar) {
        return (Set) zzdto.zza(zzbtvVar.zzagm(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzo(this.f3056a);
    }
}
