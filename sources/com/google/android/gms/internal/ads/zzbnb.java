package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbnb implements zzdti<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final zzdtu<zzcxm> f2946a;

    private zzbnb(zzdtu<zzcxm> zzdtuVar) {
        this.f2946a = zzdtuVar;
    }

    public static zzbnb zzi(zzdtu<zzcxm> zzdtuVar) {
        return new zzbnb(zzdtuVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return zzbna.zza(this.f2946a.get());
    }
}
