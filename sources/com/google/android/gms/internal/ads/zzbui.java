package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbui implements zzdti<Set<zzbuz<AdMetadataListener>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3057a;

    private zzbui(zzbtv zzbtvVar) {
        this.f3057a = zzbtvVar;
    }

    public static zzbui zzp(zzbtv zzbtvVar) {
        return new zzbui(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3057a.zzagp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
