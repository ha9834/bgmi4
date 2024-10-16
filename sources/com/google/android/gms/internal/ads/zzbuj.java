package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbuj implements zzdti<Set<zzbuz<AppEventListener>>> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbtv f3058a;

    private zzbuj(zzbtv zzbtvVar) {
        this.f3058a = zzbtvVar;
    }

    public static zzbuj zzq(zzbtv zzbtvVar) {
        return new zzbuj(zzbtvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (Set) zzdto.zza(this.f3058a.zzagq(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
