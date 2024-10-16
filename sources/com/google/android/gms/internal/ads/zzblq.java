package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzblq implements zzbal<zzcxu, zzcxu> {

    /* renamed from: a, reason: collision with root package name */
    private Map<String, zzbls> f2916a;

    public zzblq(Map<String, zzbls> map) {
        this.f2916a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<zzcxu> zzf(zzcxu zzcxuVar) throws Exception {
        zzcxu zzcxuVar2 = zzcxuVar;
        for (zzcxt zzcxtVar : zzcxuVar2.zzgky.zzgkv) {
            if (this.f2916a.containsKey(zzcxtVar.name)) {
                this.f2916a.get(zzcxtVar.name).zzk(zzcxtVar.zzgkw);
            }
        }
        return zzbar.zzm(zzcxuVar2);
    }
}
