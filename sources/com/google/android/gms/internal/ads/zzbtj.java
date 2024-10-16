package com.google.android.gms.internal.ads;

import java.util.Set;

/* loaded from: classes2.dex */
public final class zzbtj implements zzdti<zzbtg> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<Set<zzbuz<zzbtk>>> f3040a;

    private zzbtj(zzdtu<Set<zzbuz<zzbtk>>> zzdtuVar) {
        this.f3040a = zzdtuVar;
    }

    public static zzbtj zzt(zzdtu<Set<zzbuz<zzbtk>>> zzdtuVar) {
        return new zzbtj(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return new zzbtg(this.f3040a.get());
    }
}
