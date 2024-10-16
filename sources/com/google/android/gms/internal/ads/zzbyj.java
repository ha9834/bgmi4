package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbyj implements zzdti<zzty> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzbai> f3123a;
    private final zzdtu<String> b;

    public zzbyj(zzdtu<zzbai> zzdtuVar, zzdtu<String> zzdtuVar2) {
        this.f3123a = zzdtuVar;
        this.b = zzdtuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        zzbai zzbaiVar = this.f3123a.get();
        String str = this.b.get();
        zzk.zzlg();
        return (zzty) zzdto.zza(new zzty(zzaxi.zzwb(), zzbaiVar, str, new JSONObject(), false, true), "Cannot return null from a non-@Nullable @Provides method");
    }
}
