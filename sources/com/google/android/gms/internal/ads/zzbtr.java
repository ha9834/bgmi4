package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbtr implements zzdti<zzbtp> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<AppEventListener>>> f3042a;

    private zzbtr(zzdtu<Set<zzbuz<AppEventListener>>> zzdtuVar) {
        this.f3042a = zzdtuVar;
    }

    public static zzbtr zzv(zzdtu<Set<zzbuz<AppEventListener>>> zzdtuVar) {
        return new zzbtr(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbtp(this.f3042a.get());
    }
}
