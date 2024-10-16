package com.google.android.gms.internal.ads;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.zzk;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbmt implements zzdti<zzty> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxm> f2940a;
    private final zzdtu<zzbai> b;
    private final zzdtu<JSONObject> c;
    private final zzdtu<String> d;

    private zzbmt(zzdtu<zzcxm> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3, zzdtu<String> zzdtuVar4) {
        this.f2940a = zzdtuVar;
        this.b = zzdtuVar2;
        this.c = zzdtuVar3;
        this.d = zzdtuVar4;
    }

    public static zzbmt zza(zzdtu<zzcxm> zzdtuVar, zzdtu<zzbai> zzdtuVar2, zzdtu<JSONObject> zzdtuVar3, zzdtu<String> zzdtuVar4) {
        return new zzbmt(zzdtuVar, zzdtuVar2, zzdtuVar3, zzdtuVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        this.f2940a.get();
        zzbai zzbaiVar = this.b.get();
        JSONObject jSONObject = this.c.get();
        String str = this.d.get();
        boolean equals = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(str);
        zzk.zzlg();
        return (zzty) zzdto.zza(new zzty(zzaxi.zzwb(), zzbaiVar, str, jSONObject, false, equals), "Cannot return null from a non-@Nullable @Provides method");
    }
}
