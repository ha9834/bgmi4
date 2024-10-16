package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzbye implements zzdti<JSONObject> {

    /* renamed from: a, reason: collision with root package name */
    private final zzbyc f3118a;

    public zzbye(zzbyc zzbycVar) {
        this.f3118a = zzbycVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final /* synthetic */ Object get() {
        return (JSONObject) zzdto.zza(this.f3118a.zzaho(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
